package year2024.month11_2024.N14940;

import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Integer n = Integer.parseInt(st.nextToken());
		Integer m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n + 2][m + 2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int startR = 0;
		int startC = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 2) {
					startR = i;
					startC = j;
				}
			}
		}

		int[][] p = new int[n + 2][m + 2];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i == startR && j == startC) {
					continue;
				}

				p[i][j] = Integer.MAX_VALUE;
			}
		}

		ds(map, p, startR, startC, n, m);

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (p[i][j] == Integer.MAX_VALUE && map[i][j] == 0) {
					System.out.print(0 + " ");
					continue;
				}

				if (p[i][j] == Integer.MAX_VALUE) {
					System.out.print(-1 + " ");
					continue;
				}

				System.out.print(p[i][j] + " ");
			}

			System.out.println("");
		}
	}

	public static void ds(int[][] map, int[][] p, int sr, int sc, int n, int m) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[][] visit = new boolean[n + 2][m + 2];

		pq.add(new Edge(sr, sc, 0));

		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			int ex = e.x;
			int ey = e.y;
			int ep = e.p;

			if (visit[ex][ey] == true) {
				continue;
			}

			visit[ex][ey] = true;

			if (map[ex - 1][ey] == 1 && p[ex - 1][ey] > ep + 1) {
				p[ex - 1][ey] = p[ex][ey] + 1;

				pq.add(new Edge(ex - 1, ey, p[ex - 1][ey]));
			}
			if (map[ex + 1][ey] == 1&& p[ex + 1][ey] > ep + 1) {
				p[ex + 1][ey] = p[ex][ey] + 1;

				pq.add(new Edge(ex + 1, ey, p[ex + 1][ey]));
			}

			if (map[ex][ey - 1] == 1 && p[ex][ey - 1] > ep + 1) {
				p[ex][ey - 1] = p[ex][ey] + 1;

				pq.add(new Edge(ex, ey - 1, p[ex][ey - 1]));

			}

			if (map[ex][ey + 1] == 1 && p[ex][ey + 1] >ep + 1) {
				p[ex][ey + 1] = p[ex][ey] + 1;

				pq.add(new Edge(ex, ey + 1, p[ex][ey + 1]));
			}
		}
	}

	public static class Edge implements Comparable<Edge> {
		int x;
		int y;
		int p;

		public Edge(int x, int y, int p) {
			this.x = x;
			this.y = y;
			this.p = p;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.p, o.p);
		}
	}
}


// n 세로의 크기
// m 가로의 크기


// 음수x 다익스트라, 한 지점에서 모든

// 다익스트라?
// 거리는 시점점 말고 무한대
// 우선순위 큐에 시작점을 넣는다.
// 우선 순위 큐가 빌 때 까지
// 뺀다.
// 방문했으면 넘어간다.
// 방문하지 않았으면 방문 체크
// 방문 지점의 주위 탐색
// 방문하지 않았으면서, 거리가 단축되면 pq에 넣기
// 거리 업데이트
