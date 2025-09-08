package year2025.month9.N14284;

import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static int M;

	public static List<List<Edge>> adj = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선 수

		for (int n = 0; n <= N; n++) {
			adj.add(new ArrayList<>());
		}

		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adj.get(a).add(new Edge(b, c));
			adj.get(b).add(new Edge(a, c));
		}

		st = new StringTokenizer(br.readLine());

		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		System.out.println(djk(s, t));
	}

	public static int djk(int s, int t) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, 100000000);
		dist[s] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(s, 0));

		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			int nowE = now.e;

			for (Edge next : adj.get(nowE)) {
				if (dist[next.e] > dist[nowE] + next.d) {
					dist[next.e] = dist[nowE] + next.d;
					pq.add(new Edge(next.e, dist[next.e]));
				}
			}


		}

		return dist[t];
	}

	public static class Edge implements Comparable<Edge> {

		int e;
		int d;

		public Edge(int e, int d) {
			this.e = e;
			this.d = d;
		}

		@Override
		public int compareTo(Edge edge) {
			return this.d - edge.d;
		}
	}
}

