package year2024.month12_2024.N1766;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 문제
		int M = Integer.parseInt(st.nextToken()); // 관계

		int[] count = new int[N + 1];

		List<List<Edge>> adj = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); //먼저 풀 문제
			int B = Integer.parseInt(st.nextToken()); // e
			count[B]++;

			adj.get(A).add(new Edge(B));
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			if (count[i] == 0) {
				pq.add(new Edge(i));
			}
		}

		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int e = edge.e;

			System.out.print(e + " ");

			for (Edge tmp : adj.get(e)) {
				count[tmp.e]--;

				if (count[tmp.e] == 0) {
					pq.add(new Edge(tmp.e));
				}
			}
		}


	}

	public static class Edge implements Comparable<Edge> {

		int e;

		public Edge(int e) {
			this.e = e;
		}

		@Override
		public int compareTo(Edge e) {
			return this.e - e.e;
		}
	}
}