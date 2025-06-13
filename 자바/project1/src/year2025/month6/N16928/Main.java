package year2025.month6.N16928;

import java.util.*;
import java.io.*;

public class Main {

	public static List<List<Integer>> adj = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 사다리의 수
		int M = Integer.parseInt(st.nextToken()); // 뱀의 수

		for (int i = 0; i <= 100; i++) {
			adj.add(new ArrayList<>());
		}

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			adj.get(s).add(e);
		}

		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			adj.get(s).add(e);
		}

		int result = bfs();

		System.out.println(result);
	}

	public static int bfs() {
		Queue<Edge> q = new LinkedList<>();
		q.add(new Edge(1, 0));

		boolean[] visit = new boolean[101];

		int result = 0;

		while (!q.isEmpty()) {
			Edge edge = q.poll();
			int l = edge.l;
			int count = edge.count;

			if (l == 100) {
				result = count;
				break;
			} else if (l > 100) {
				continue;
			}

			if (visit[l]) {
				continue;
			}
			visit[l] = true;

			for (int i = 1; i <= 6; i++) {
				if (l + i > 100) {
					continue;
				}

				if (!adj.get(l + i).isEmpty()) {
					q.add(new Edge(adj.get(l + i).get(0), count + 1));
				} else {
					q.add(new Edge(l + i, count + 1));
				}
			}
		}

		return result;
	}

	public static class Edge {
		int l;
		int count;

		public Edge(int l, int count) {
			this.l = l;
			this.count = count;
		}
	}
}

// 게임판은 10 x 10
// i에서 주사위 -> i + 주사위로 이동
// 도착 : 사다리 -> 위로
// 도착 : 뱀 -> 아래로

// 주사회 최소 횟수