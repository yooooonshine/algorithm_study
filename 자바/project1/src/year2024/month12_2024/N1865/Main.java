package year2024.month12_2024.N1865;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int i = 1; i <= TC; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 지점의 수
			int M = Integer.parseInt(st.nextToken()); // 도로의 수
			int W = Integer.parseInt(st.nextToken()); // 웜홀의 수

			List<Edge> adj = new ArrayList<>();

			for (int j = 1; j <= M; j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());

				adj.add(new Edge(s, e, t));
				adj.add(new Edge(e, s, t));
			}

			for (int j = 1; j <= W; j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());

				adj.add(new Edge(s, e, -t));
			}

			for (int j = 1; j <= N; j++) {

				adj.add(new Edge(0, j, 0));
			}

			boolean result = bf(N, M, adj, 0);

			if (result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static boolean bf(int N, int M, List<Edge> adj, int start) {
		int[] dist = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;

		for (int i = 0; i <= M - 1; i++) {
			for (Edge edge : adj) {
				int s = edge.s;
				int e = edge.e;
				int t = edge.t;

				if (dist[s] == Integer.MAX_VALUE) {
					continue;
				}

				if (dist[e] > dist[s] + t) {
					dist[e] = dist[s] + t;
				}
			}
		}

		// 한번더
		int[] dist1 = new int[N + 1];
		for (int i = 0; i<= N; i++) {
			dist1[i] = dist[i];
		}
		boolean change = false;

		for (Edge edge : adj) {
			int s = edge.s;
			int e = edge.e;
			int t = edge.t;

			if (dist[s] == Integer.MAX_VALUE) {
				continue;
			}

			if (dist[e] > dist[s] + t) {
				dist[e] = dist[s] + t;
				change = true;
			}
		}

		if (!change) {
			return false;
		}

		for (int i = 0; i<= N; i++) {
			if (dist1[i] != dist[i]) {
				return true;
			}
		}
		return false;
	}

	public static class Edge {
		int s;
		int e;
		int t;

		public Edge(int s, int e, int t) {
			this.s = s;
			this.e = e;
			this.t = t;
		}
	}
}

// M개의 도로는 무방향
// W개의 웜홀은 방향 (음의 간선)
// 벨만 포드

// 도로가 끊겨져 있을 수 있다.
// 각 V 별로 돌려야 한다
// 음의 싸이클 딱 하나만 찾으면 된다.
