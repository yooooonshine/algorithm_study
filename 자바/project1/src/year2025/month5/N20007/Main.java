package year2025.month5.N20007;

import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static int M;
	public static int X;
	public static int Y;

	public static int[] dist;
	public static int MAX  = 1000000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 집수
		M = Integer.parseInt(st.nextToken()); // 도로 수
		X = Integer.parseInt(st.nextToken()); // 하루 X거리
		Y = Integer.parseInt(st.nextToken()); // 상현이집

		List<List<Node>> adj = new ArrayList<>();
		for (int i = 0; i <= N - 1; i++) {
			adj.add(new ArrayList<>());
		}

		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adj.get(a).add(new Node(b, c));
			adj.get(b).add(new Node(a, c));
		}

		dist = new int[N];
		for (int n = 1; n < N; n++) {
			dist[n] = MAX;
		}

		dk(Y, adj);
		Arrays.sort(dist);

		int result = 0;
		int count = 0;

		for (int i = 1; i < N; i++) {
			int roundTrip = dist[i] * 2;

			if (roundTrip > X) {
				System.out.println(-1);
				return;
			}

			if (count + roundTrip > X) {
				result++;
				count = 0;
			}

			count += roundTrip;
		}
		if (count > 0) result++;

		System.out.println(result);
	}

	public static void dk(int start, List<List<Node>> adj) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[N];

		pq.add(new Node(start, 0));
		dist[start] = 0;

		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int e = node.e;

			if (visit[e]) {
				continue;
			}
			visit[e] = true;

			for (Node next : adj.get(e)) {
				if (dist[next.e] > dist[e] + next.d) {
					dist[next.e] = dist[e] + next.d;
					pq.add(new Node(next.e, dist[next.e]));
				}
			}
		}
	}

	public static class Node implements Comparable<Node> {
		int e;
		int d;

		public Node(int e, int d) {
			this.e = e;
			this.d = d;
		}

		@Override
		public int compareTo(Node node) {
			return this.d - node.d;
		}
	}
}

// 떡 하나씩만
// M개의 양방향 도로
// 하루 X보다 먼 거리 x(왕복)
// 며칠?

// PQ
// 방문 체크
// 거리

// pq 빌떄까지
// 방문 체크
// 근처 노드에 대해 업데이트 되면 노드 추가

// 가까운 집부터..