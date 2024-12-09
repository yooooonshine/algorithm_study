package year2024.month12_2024.N1005;

import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[] D;
	public static List<List<Integer>> adj;
	public static int[] in;
	public static int w;
	public static int[] price;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;


		int T = Integer.parseInt(br.readLine());

		for (int j = 0; j < T; j++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); // 건물 개수
			int K = Integer.parseInt(st.nextToken()); // 규칙 개수

			D = new int [N + 1]; // 건물 건설 시간.
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
			}

			adj = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				adj.add(new ArrayList<>());
			}

			in = new int[N + 1];
			for (int i = 1; i <= K; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());

				adj.get(s).add(e);

				in[e]++;
			}

			w = Integer.parseInt(br.readLine());
			price = new int[N + 1];

			topologySort();

			System.out.println(price[w]);
		}
	}

	public static void topologySort() {
		Queue<Edge> pq = new LinkedList<>(); // 타입

		for (int i = 1; i <= N; i++) {
			if (in[i] == 0) {
				pq.add(new Edge(i, D[i]));
				price[i] = D[i];
			}
		}

		int sum = 0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			int p = e.p;
			int depth = e.depth;


			for (Integer tmp : adj.get(p)) {
				in[tmp]--;

				price[tmp] = Math.max(price[tmp], price[p] + D[tmp]);

				if (in[tmp] == 0) {
					pq.add(new Edge(tmp, depth + D[tmp]));
				}
			}
		}

	}

	public static class Edge {
		int p;
		int depth;

		public Edge(int p, int depth) {
			this.p = p;
			this.depth = depth;
		}
	}
}

// 건물 짓는 순서가 없다.
// 건문 짓는 순서 주어진다.
// 완성시까지 Delay 존재


// 특정 건물 짓는 최단 시간

// 순서 정하기 -토폴로지 소트?
// 토폴로지 소트에서 최소를 선택해야 한다.
// 시간을 측정해야 하는데.

// 조건상 상위 노드는 무조건 탐색
// depth를 들고 있으면 된다.

// 우선순위 큐, 진입이 0인거
// 각 depth별 최고를 기억해둔다.
// 추후 더한다.
// 만약 완전 가지가 다르면 안된다.