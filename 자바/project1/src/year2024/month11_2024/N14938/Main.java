package year2024.month11_2024.N14938;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 지역 개수
		int m = Integer.parseInt(st.nextToken()); // 수색 범위
		int r = Integer.parseInt(st.nextToken()); // 길의 개수

		int[] items = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		List<List<Edge>> adj = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 1; i <= r; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			adj.get(s).add(new Edge(s, e, p));
			adj.get(e).add(new Edge(e, s, p));
		}

		int maxS = 0;
		int index = 0;

		for (int i = 1; i <= n; i++) {
			int[] w = new int[n + 1];
			for (int j = 0; j <= n; j++) {
				w[j] = Integer.MAX_VALUE;
			}
			w[i] = 0;

			ds(adj, w, i, n);

			int sum = 0;
			for (int j = 1; j <= n; j++) {
				if (w[j] <= m) {
					sum += items[j];
				}
			}

			if (sum >= maxS) {
				maxS = sum;
				index = i;
			}
		}


		System.out.println(maxS);
	}


	public static void ds(List<List<Edge>> adj, int[] w, int s, int n) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[n + 1];

		pq.add(new Edge(s, s, 0));

		while(!pq.isEmpty()) {
			Edge e = pq.poll();

			int start = e.s;
			int end = e.e;
			int price = e.p;

			if (visit[end]) {
				continue;
			}
			visit[end] = true;

			for (Edge tmp : adj.get(end)) {
				if (w[tmp.e] > price + tmp.p) {
					w[tmp.e] = price + tmp.p;
					pq.add(new Edge(tmp.e, tmp.e, w[tmp.e]));
				}
			}
		}
	}

	public static class Edge implements Comparable<Edge> {
		int s;
		int e;
		int p;

		public Edge(int s, int e, int p) {
			this.s = s;
			this.e = e;
			this.p = p;
		}

		public int compareTo(Edge e) {
			return this.p - e.p;
		}
	}
}


// 낙하한 지역 주위 수색 범위 m 이내의 모든 아이템 습득 가능
// 아이템 최대 개수

// 특정 점 부터 다른 점들까지의 최단 거리를 구해야 돼
// 이 중에 최단 거리가 15m 이내이면 된다.
// 음수 없다.
// 양방향
// 다익스트라를 사용하자

// 인접 리스트 필요
