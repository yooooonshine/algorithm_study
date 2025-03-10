package year2025.month3.N17396;

import java.util.*;
import java.io.*;

public class Main {
	public static long MAX = 10000000000L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());//분기점 수
		int M = Integer.parseInt(st.nextToken());//길의 수
		int[] Ns = new int[N]; // 0~N-1
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Ns[i] = Integer.parseInt(st.nextToken()); //1은 못감
		}

		List<List<Edge>> adj = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long t = Integer.parseInt(st.nextToken());

			adj.get(a).add(new Edge(b, t));
			adj.get(b).add(new Edge(a, t));
		}

		// 다익스트라
		long[] dist = new long[N];
		for (int i = 0; i < N; i++) {
			dist[i] = MAX;
		}
		dist[0] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0));

		while (!pq.isEmpty()) {
			Edge nEdge = pq.poll();
			int nE = nEdge.e;

			if (dist[nE] < nEdge.w) continue;

			for (Edge vEdge : adj.get(nE)) {

				if (Ns[vEdge.e] == 1 && vEdge.e != N - 1) {
					continue;
				}

				if (dist[vEdge.e] > dist[nE] + vEdge.w) {
					dist[vEdge.e] = dist[nE] + vEdge.w;
					pq.add(new Edge(vEdge.e, dist[vEdge.e]));
				}
			}


		}


		if (dist[N - 1] == MAX) {
			System.out.println(-1);
		} else {
			System.out.println(dist[N - 1]);
		}
		// 못가면 -1
	}

	public static class Edge implements Comparable<Edge> {
		int e;
		long w;

		public Edge(int e, long w) {
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge edge) {

			return Long.compare(this.w, edge.w);
		}
	}
}
// N개의 분기점
// 0이 시작점, N - 1 이 상대편

// N, M (분기점의 수, 분기점 길의 수)
// N개의 정수(적의 시야 보이는 지)
// M개의 줄
// a, b, t (a분기점, b분기점 사이 t시간)
// 양방향

// 다익스트라
// 만약 방문하려는 곳이 1이면 패스
