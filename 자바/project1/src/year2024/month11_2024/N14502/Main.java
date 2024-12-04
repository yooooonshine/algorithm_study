package year2024.month11_2024.N14502;

import java.util.*;
import java.io.*;

public class Main {
	public static int MIN = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 2][M + 2];

		//초기화
		for (int i =  1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i <= M + 1; i++) {
			map[0][i] = 1;
			map[N + 1][i] = 1;
		}

		for (int i = 0; i <= N + 1; i++) {
			map[i][0] = 1;
			map[i][M + 1] = 1;
		}


		// 바이러스
		List<Edge> p = new ArrayList<>(); //rc

		for (int i =  1; i <= N; i++) {

			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 2) {
					p.add(new Edge(i, j));
				}
			}
		}

		// 벽 3개 고르기
		dfs(0, p, N, M, map);

		int wall = 3;
		for (int i =  1; i <= N; i++) {

			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 1) {
					wall++;
				}
			}
		}

		System.out.println(N * M - wall - MIN);
	}

	public static void dfs(int depth, List<Edge> p, int N, int M, int[][] map) {
		if (depth == 3) {
			int sum = bfs(p, N, M, map);
			if (sum < MIN) {
				MIN = sum;
			}

			return;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(depth + 1, p, N, M, map);
					map[i][j] = 0;
				}
			}
		}
	}

	public static int bfs(List<Edge> p, int N, int M, int[][] map) {
		boolean[][] visit = new boolean[N + 2][M + 2];

		int sum = 0;

		for (Edge virus : p) {
			int sr = virus.r;
			int sc = virus.c;

			Queue<Edge> edges = new LinkedList<>();
			edges.add(new Edge(sr, sc));

			while (!edges.isEmpty()) {
				Edge tmp = edges.poll();
				int r = tmp.r;
				int c = tmp.c;

				if (visit[r][c]) {
					continue;
				}
				visit[tmp.r][tmp.c] = true;
				sum++;

				if (map[r + 1][c] == 0) {
					edges.add(new Edge(r + 1, c));
				}
				if (map[r - 1][c] == 0) {
					edges.add(new Edge(r - 1, c));
				}
				if (map[r][c + 1] == 0) {
					edges.add(new Edge(r, c + 1));
				}
				if (map[r][c - 1] == 0) {
					edges.add(new Edge(r, c - 1));
				}
			}

		}
		return sum;
	}

	public static class Edge {
		int r;
		int c;

		public Edge(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}


// 연구소 N X M 크기
// 벽 3개 세우기
// 무조건

// 0 빈칸, 1 벽, 2 바이러스


// 벽 3개로 안전영역 최댓값

// 2인 지점에서 bfs 탐색을 한다.

// 토폴로지 소트?

//24C3 = 4 23 22 = 3000이 안된다.

// 모든 3 점의 위치를 사용하고
// 3000의 bfs로 접근 가능한 모든 점
// 한번에 bfs를 3개 동시에 돌린다?
// 방문한 점만 공유