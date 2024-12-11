package year2024.month12_2024.N9694;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int j = 1; j <= T; j++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 관계 수
			int M = Integer.parseInt(st.nextToken()); // 정치인 수

			List<List<Edge>> adj = new ArrayList<>();
			for (int i = 0; i < M; i++) {
				adj.add(new ArrayList<>());
			}

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());

				adj.get(x).add(new Edge(x, y, z));
				adj.get(y).add(new Edge(y, x, z));
			}

			ds(adj, M, j);
		}
	}

	public static void ds(List<List<Edge>> adj, int M, int round) {
		boolean[] visit = new boolean[M];

		List<Integer> result = new ArrayList<>();

		int[] dist = new int[M];
		for (int i = 0; i < M; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[0] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		List<Integer> sq = new ArrayList<>();
		sq.add(0);
		pq.add(new Edge(0, 0, 0, sq));

		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int x = edge.x;
			int z = edge.z;

			if (visit[x]) {
				continue;
			}

			visit[x] = true;

			for (Edge tmp : adj.get(x)) {

				if (!visit[tmp.y] && dist[tmp.y] > tmp.z + z) {
					dist[tmp.y] = tmp.z + z;

					List<Integer> tmpArr = new ArrayList<>();
					for (Integer tmpE : edge.sq) {
						tmpArr.add(tmpE);
					}
					tmpArr.add(tmp.y);

					pq.add(new Edge(tmp.y, tmp.y, dist[tmp.y], tmpArr));

					if (tmp.y == M - 1) {
						result = new ArrayList<>(tmpArr);
					}
				}
			}
		}

		if (result.isEmpty() || dist[M - 1] == Integer.MAX_VALUE) {
			System.out.println("Case #" + round  + ": -1");
		} else {
			System.out.print("Case #" + round + ": ");

			for (Integer tmpE : result) {
				System.out.print(tmpE + " ");
			}
			System.out.println();
		}
	}

	public static class Edge implements Comparable<Edge> {
		int x;
		int y;
		int z;
		List<Integer> sq = new ArrayList<>();

		public Edge(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public Edge(int x, int y, int z, List<Integer> sq) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.sq = new ArrayList<>(sq);
		}

		@Override
		public int compareTo(Edge e) {
			return this.z - e.z;
		}
	}
}

//