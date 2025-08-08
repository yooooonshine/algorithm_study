package year2025.month8.N17472;

import java.util.*;
import java.io.*;

public class Main {

	public static int N; // 세로
	public static int M; // 가로

	public static int[][] road;
	public static int[] team;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		road = new int[N + 2][M + 2];
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= M; c++) {
				road[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬의 유니온 파인드 배열
		team = new int[N * M + 1];
		for (int i = 1; i <= N * M; i++) {
			team[i] = i; // 자기 자신으로 초기화
		}


		// 전체 섬 개수
		int islandCount = 0;

		// 섬구역표시
		boolean[][] visit = new boolean[N + 2][M + 2];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				if (road[r][c] == 1 && !visit[r][c]) {
					// 섬의 시작점에서 DFS로 연결된 모든 섬을 찾는다.
					dfs(r, c, visit);
					islandCount++; // 섬 개수 증가
				}
			}
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				if (road[r][c] == 1) {
					// 상하좌우로 이동하면서 연결된 섬을 찾는다.
					for (int d = 0; d < 4; d++) {
						int nextR = r + rs[d];
						int nextC = c + cs[d];

						if (nextR < 1 || nextR > N || nextC < 1 || nextC > M) continue; // 범위 체크


						// 앞이 0이면 쭉 이동하여 1찾기
						if (road[nextR][nextC] == 0) {
							int dist = 0;
							while (nextR >= 1 && nextR <= N && nextC >= 1 && nextC <= M && road[nextR][nextC] == 0) {
								nextR += rs[d];
								nextC += cs[d];
								dist++;
							}

							// 이동 후 다음 위치가 범위 내에 있고, 1인 경우
							if (nextR >= 1 && nextR <= N && nextC >= 1 && nextC <= M && road[nextR][nextC] == 1 && dist >= 2) {
								// 경로 추가
								pq.add(new Edge(toIndex(r, c), toIndex(nextR, nextC), dist));
							}
						}
					}
				}
			}
		}



		// 최소신장트리로 다리 잇기
		int totalCost = 0;
		int edgeCount = 0;

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			int rootS = find(edge.s, team);
			int rootE = find(edge.e, team);

			if (rootS != rootE) { // 서로 다른 섬이면

				union(rootS, rootE, team);
				totalCost += edge.d;
				edgeCount++;
			}
		}

		if (islandCount != edgeCount + 1) {
			System.out.println(-1); // 모든 섬을 연결할 수 없는 경우
		} else {
			System.out.println(totalCost); // 최소 비용 출력
		}
	}

	public static class Edge implements Comparable<Edge> {
		int s;
		int e;
		int d;

		public Edge(int s, int e, int d) {
			this.s = s;
			this.e = e;
			this.d = d;
		}

		@Override
		public int compareTo(Edge other) {
			return this.d - other.d; // 비용 기준으로 오름차순 정렬
		}
	}

	public static int[] rs = {1, -1, 0, 0};
	public static int[] cs = {0, 0, -1, 1};
	public static void dfs(int sr, int sc, boolean[][] visit) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(sr, sc));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int r = node.r;
			int c = node.c;

			if (visit[r][c]) continue; // 이미 방문한 곳은 건너뛴다.
			visit[r][c] = true; // 현재 위치 방문 처리

			for (int d = 0; d < 4; d++) {
				int nr = r + rs[d];
				int nc = c + cs[d];

				if (nr < 1 || nr > N || nc < 1 || nc > M) continue; // 범위 체크

				if (road[nr][nc] == 1 && !visit[nr][nc]) {
					queue.add(new Node(nr, nc));
					union(toIndex(sr, sc), toIndex(nr, nc), team); // 유니온 파인드로 연결
				}
			}
		}
	}
	public static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static int toIndex(int r, int c) {
		return (r - 1) * M + c;
	}

	public static int find(int x, int[] arr) {
		if (arr[x] == x) {
			return x;
		} else {
			return arr[x] = find(arr[x], arr); // 경로 압축
		}
	}

	public static void union(int a, int b, int[] arr) {
		int rootA = find(a, arr);
		int rootB = find(b, arr);

		if (rootA > rootB) {
			arr[rootA] = rootB; // 작은 값으로 합침
		} else if (rootA < rootB) {
			arr[rootB] = rootA;
		}
	}
}

// rc for문을 찾는다.
// 1을 찾는다.
// dfs로 모두 union find 해준다.
// 해당 1에서 상하좌우로 0있는지 체크해서 쭉이동.
// 끝이 1이면 해당 1과 다른 섬을 Edge에 넣는다.

// 최소신장트리