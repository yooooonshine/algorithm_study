package year2025.month9.N1949;

import java.util.*;
import java.io.*;

public class Main {

	public static int[][] dpArr;

	public static List<List<Integer>> adj;

	public static Set<Integer> leafs = new HashSet<>();

	public static int N;

	public static int[] neighborCount;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 마을 수

		// 주민 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		neighborCount = new int[N + 1];
		for (int n = 1; n <= N; n++) {
			neighborCount[n] = Integer.parseInt(st.nextToken());
		}

		// 이웃 노드
		adj = new ArrayList<>();
		for (int n = 0; n <= N; n++) {
			adj.add(new ArrayList());
		}
		for (int n = 1; n <= N - 1; n++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			adj.get(s).add(e);
			adj.get(e).add(s);
		}

		// 리프노드 찾기
		findLeafs(1);

		// Dp 값 초기화
		dpArr = new int[N + 1][2]; // 0은 우수x, 1은 우수
		for (int n =0; n <= N; n++) {
			Arrays.fill(dpArr[n], -1);
		}

		int max = 0;
		max = Math.max(max, dp(1, 0, 0));
		max = Math.max(dp(1, 0, 1), max);
		System.out.println(max);
	}

	public static void findLeafs(int s) {
		Stack<Integer> myS = new Stack<>();
		myS.add(s);

		boolean[] visit = new boolean[N + 1];

		while (!myS.isEmpty()) {
			int now = myS.pop();

			if (visit[now]) {
				continue;
			}
			visit[now] = true;

			boolean hasNext = false;
			for (Integer next : adj.get(now)) {
				if (!visit[next]) {
					hasNext = true;
				}
			}

			if (!hasNext) {
				leafs.add(now);
			}

			for (Integer next : adj.get(now)) {
				myS.add(next);
			}
		}
	}


	public static int dp(int node, int before, int excellence) {
		if (dpArr[node][excellence] != -1) {
			return dpArr[node][excellence];
		}

		if (leafs.contains(node)) {
			if (excellence == 1) {
				dpArr[node][excellence] = neighborCount[node];
				return neighborCount[node];
			} else {
				dpArr[node][excellence] = 0;
				return 0;
			}
		}

		int result = 0;

		if (excellence == 1) { // 부모가 우수
			result += neighborCount[node];
			for (Integer next : adj.get(node)) {
				if (next == before) {
					continue;
				}

				result += dp(next, node, 0);
			}
		} else { // 부모가 우수 x
			int[][] tmp;
			if (node == 1) {
				tmp = new int[adj.get(node).size()][2];
			} else {
				tmp = new int[adj.get(node).size() - 1][2];
			}


			int index = 0;
			for (Integer next : adj.get(node)) {
				if (next == before) {
					continue;
				}

				tmp[index][0] = dp(next, node, 0);
				tmp[index][1] = dp(next, node, 1);
				index++;
			}

			// 자식 최대들이 모두 비우수인지 확인
			boolean all0 = true;
			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i][0] <= tmp[i][1]) {
					all0 = false;
					break;
				}
			}

			// 최대 더하기
			for (int i = 0; i < tmp.length; i++) {
				result += Math.max(tmp[i][0], tmp[i][1]);
			}

			if (all0) {
				// 간격 제일 작은 것 찾아서 바꾸기
				int min = Integer.MAX_VALUE;
				int minI = 0;

				for (int i = 0; i < tmp.length; i++) {
					int abs = Math.abs(tmp[i][0] - tmp[i][1]);

					if (abs < min) {
						min = abs;
						minI = i;
					}
				}

				result -= min;

			}
		}


		dpArr[node][excellence] = result;

		return result;
	}
}

// 직접 길 = 인접

// 마을 주민 수의 합 최대
// 우수마을끼리는 입접불가
// 우수마을 x -> 우수마을과 인접

