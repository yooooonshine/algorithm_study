package year2025.month2.N11779;

import java.util.*;
import java.io.*;

public class Main {
	public static int Max = 10000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		List<List<Edge>> adj = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}

		StringTokenizer st;
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adj.get(a).add(new Edge(b, c));
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		int[] before = new int[n + 1];
		int[] dist = new int[n + 1];

		// 다익스트라
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			dist[i] = Max;
		}
		dist[s] = 0;

		pq.add(new Edge(s, 0));
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			int eE = edge.e;

			if (dist[eE] < edge.w) {
				continue;
			}

			for (Edge tmp : adj.get(eE)) {
				if (dist[tmp.e] > dist[eE] + tmp.w) {
					dist[tmp.e] = dist[eE] + tmp.w;
					before[tmp.e] = eE;
					pq.add(new Edge(tmp.e, dist[tmp.e]));
				}
			}
		}

		System.out.println(dist[e]);
		int count = 1;

		int tmpE = e;
		Stack<Integer> myS = new Stack<>();
		myS.add(e);

		while (tmpE != s) {
			tmpE = before[tmpE];
			myS.add(tmpE);
			count++;
		}

		System.out.println(count);

		while (!myS.isEmpty()) {
			System.out.print(myS.pop() + " ");
		}
	}

	public static class Edge implements Comparable<Edge> {
		int e;
		int w;

		public Edge(int e, int w) {
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Edge edge) {
			return this.w - edge.w;
		}
	}
}

// n개의 도시 1000
// m 개의 버스 100000

// 경로 항상 존재
// 도시 n
// 버스 m
// m줄동안 버스정보
// 출발도시번호, 도착도시번호, 버스 비용

// 최소 비용
// 도시의 개수
// 도시 경로 순서

// 다익스트라 O(ElogV)
// 이전노드 저장배열