package year2025.month8.N1854;

import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static int M;
	public static int K;

	public static List<List<Edge>> adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 도시 수
		M = Integer.parseInt(st.nextToken()); // 도로 수
		K = Integer.parseInt(st.nextToken()); // k번째 도로

		adj = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}

		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			adj.get(s).add(new Edge(e, d));
			adj.get(e).add(new Edge(s, d)); // 양방향 도로
		}

		djk(1);
	}

	public static void djk(int s) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(s,0));

		PriorityQueue<Integer>[] dist = new PriorityQueue[N + 1];
		for (int i = 1; i <= N; i++) {
			dist[i] = new PriorityQueue<>(Collections.reverseOrder());
		}

		while(!pq.isEmpty()) {
			Edge nowEdge = pq.poll();
			int nowE = nowEdge.e;
			int nowD = nowEdge.d;

			System.out.println(nowE);

			for (Edge next : adj.get(nowE)) {
				int nextE = next.e;
				int nextD = next.d;

				if (dist[nextE].size() < K) {
					dist[nextE].add(nowD + nextD);
					pq.add(new Edge(nextE, nowD + nextD));
				} else {
					if (dist[nextE].peek() > nowD  + nextD) {
						dist[nextE].poll();
						dist[nextE].add(nowD + nextD);
						pq.add(new Edge(nextE, nowD	 + nextD));
					}
				}
			}

			for (int i = 1; i <= N; i++) {
				if (dist[i].size() == K) {
					for (int k = 1; k <= K - 1; k++) {
						dist[i].poll();
					}

					System.out.println(dist[i].poll());
				} else {
					System.out.println(-1);
				}
			}
		}
	}

	public static class Edge implements Comparable<Edge> {
		int e;
		int d;

		public Edge (int e, int d) {
			this.e = e;
			this.d = d;
		}

		@Override
		public int compareTo(Edge e) {
			return this.d - e.d;
		}
	}
}