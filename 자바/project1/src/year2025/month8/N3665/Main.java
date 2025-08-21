package year2025.month8.N3665;

import java.util.*;
import java.io.*;

public class Main {

	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); // 팀의 수

			Map<Integer, Integer> rate = new HashMap<>();
			int[] lastYear = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int n = 1; n <= N; n++) {
				lastYear[n] = Integer.parseInt(st.nextToken());
				rate.put(lastYear[n], n);
			}

			int M = Integer.parseInt(br.readLine()); // 순위 바뀐 쌍의 수

			// 인접 배열
			boolean[] unfixed = new boolean[N + 1];
			List<List<Integer>> adj = new ArrayList<>();
			for (int n = 0; n <= N; n++) {
				adj.add(new ArrayList<>());
			}



			// 바뀐 순서 받기
			for (int m = 1; m <= M; m++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				unfixed[a] = true;
				unfixed[b] = true;

				int s;
				int e;

				if (rate.get(a) < rate.get(b)) {
					s = b;
					e = a;
				} else {
					s = a;
					e = b;
				}

				adj.get(s).add(e);
			}

			// 결과 순서 고정된 것 채우기
			int[] result = new int[N + 1];
			for (int n = 1; n <= N; n++) {
				if (!unfixed[lastYear[n]]) {
					result[n] = lastYear[n];
				}
			}


			int index = 1;
			while (index < N) {
				// 고정된 순서
				if (result[index] != 0 && result[index + 1] != 0) {
					adj.get(result[index]).add(result[index + 1]);
					index++;
				} else if (result[index] != 0 && result[index + 1] == 0) {
					int s = index;
					int e = 0;
					boolean eX = true;

					// 미지정인 위치들 찾기
					int i = index + 1;
					while (true) {
						if (i > N) {
							eX = false;
							break;
						}
						if (result[i] == 0) {
							i++;
						} else {
							e = i;
							break;
						}
					}

					int v1 = result[s];
					int v2 = 0;
					if (eX) {
						v2 = result[e];
					}

					for (int w = s + 1; w < e; w++) {
						adj.get(v1).add(lastYear[w]);

						if (eX) {
							adj.get(lastYear[w]).add(v2);
						}
					}

					index = e;
				}
			}


			topologySort(adj);

		}
	}

	public static void topologySort(List<List<Integer>> adj) {
		// 진입 차수 배열
		int[] teamIn = new int[N + 1];

		for (int s = 1; s < adj.size(); s++) {
			for (Integer e : adj.get(s)) {
				teamIn[e]++;
			}
		}

		Queue<Integer> resultQ = new LinkedList<>();
		Queue<Integer> myQ = new LinkedList<>();

		for (int n = 1; n <= N; n++) {
			if (teamIn[n] == 0) {
				myQ.add(n);
			}
		}

		while (!myQ.isEmpty()) {
			if (myQ.size() > 1) {
				System.out.println("?");
				return;
			}

			int node = myQ.poll();
			resultQ.add(node);

			for (Integer next : adj.get(node)) {
				teamIn[next]--;

				if (teamIn[next] == 0) {
					myQ.add(next);
				}
			}
		}

		while (!resultQ.isEmpty()) {
			System.out.print(resultQ.poll() + " ");
		}
	}
}

// n개의 팀(1번부터)
// 작년에 비해 순위가 바뀐 팀 목록만 발표
// 토폴로지 소트?

// 확실한 순서를 찾을 수 없으면 -> ?
// 데이터에 일관성이 없어서 순위 x -> IMPOSSIBLE (싸이클)

// 등수에 대해 모든 간선을 넣는다.

// 없으면 -> 순서를 유지해야 한다.


// 경우의 수
// A B
// A C

// A B
// C B

// A B
// B C

// 2 -> 4
// 3 -> 4
