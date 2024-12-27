package year2024.month12_2024.N11438;

import java.util.*;
import java.io.*;

public class Main {
	public static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 노드의 수

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}

		int[][] tree = new int[2][N + 1]; // 0번은 부모, 1번은 깊이

		for (int i = 1; i <= N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj.get(a).add(b);
			adj.get(b).add(a);
		}

		//bfs
		boolean[] visit = new boolean[N + 1];
		Stack<Edge> myS = new Stack<>();

		myS.add(new Edge(1, 0));

		while (!myS.isEmpty()) {
			Edge e = myS.pop();

			if (visit[e.e]) {
				continue;
			}
			visit[e.e] = true;

			for (Integer tmp : adj.get(e.e)) {
				if (!visit[tmp]) {
					myS.add(new Edge(tmp, e.d + 1));
					tree[0][tmp] = e.e;
					tree[1][tmp] = e.d + 1;
				}

			}
		}

		int maxD = 0;
		for (int i = 1; i <= N; i++) {
			if (tree[1][i] > maxD) {
				maxD = tree[1][i];
			}
		}

		// dp 배열 채우기
		int k = maxK(maxD);
		int K = k;

		dp = new int[k + 1][N + 1]; //0이면 2^0승

		for (int i = 1; i <= N; i++) {
			dp[0][i] = tree[0][i];
		}

		for (int j = 1; j <= k; j++) {
			for (int i = 1; i <= N; i++) {
				dp[j][i] = dp[j - 1][dp[j - 1][i]];
			}
		}

		// 높이 맞추기
		int M = Integer.parseInt(br.readLine());
		for (int i = 1; i <= M; i++) {


			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int big;
			int small;

			if (tree[1][a] < tree[1][b]) { // 깊이 크면 small
				big = a;
				small = b;
			} else {
				big = b;
				small = a;
			}

			// 높이 맞추기
			while (tree[1][big] < tree[1][small]) {
				int cha = (int)Math.abs(tree[1][small] - tree[1][big]);

				int tmpK = maxK(cha);

				small = dp[tmpK][small];
			}

			k = K;
			// 공통 조상

			for (int p = k; p >= 0; p--) {
				if (dp[p][small] == 0) {
					continue;
				}

				if (dp[p][small] != dp[p][big]) {
					small = dp[p][small];
					big = dp[p][big];
				}
			}

			if (small != big) {
				System.out.println(tree[0][small]);
			} else {
				System.out.println(big);
			}
		}
	}

	public static int maxK(int maxD) {
		// dp 배열 채우기
		int k = 0;
		while (Math.pow(2, k) <= maxD) {
			k++;
		}
		k--; // maxD보다 작은 k

		return k;
	}

	public static class Edge {
		int e;
		int d;

		public Edge(int e, int d) {
			this.e = e;
			this.d = d;
		}
	}
}

// N개의 노드로 이루어진 트리
// 1번부터 N번
// M번의 두 노드의 쌍
// 두 노드의 가까운 공통 조상


// 노드의 수 N
// N - 1 개 줄
// 연결된 두 노드
// M
// M개의 줄 노드 쌍


// 인덱스에 따른 부모노드, 깊이를 저장하는 배열을 만든다.

// bfs를 통해 순회한다.
// bfs에 사용하는 스택에는 깊이를 저장한다
// 방문할 때 visit 체크 하고, 깊이 배열 업데이트 한다.

// 두 노드의 깊이차를 구한다.
// 깊이차 > 2 ^ k인 k를 구한다.
// N * k 만큼의 배열을 선언한다.
// DP를 통해 배열을 업데이트 한다. 이 떄 안의 값은 D[k][N]
// 대략 K루프 안의 N루프로 D[K][N] = D[K-1][D[K-1][N]]으로 구한다.

// 높이를 맞춰준다.
// 두 높이차를 구해 n > 2 ^ k 인 k를 구해 k를 1씩 줄이면서 올라간다. 이건 반복문

// 높이가 같아지면 k를 1씩 줄이면서 공통 조상이 달라지는 k를 찾는다. 그만큼 올라간다. 반복하여 k = 0일떄까지
// 두 노드 값이 다르면 올라가고 같으면 출력
