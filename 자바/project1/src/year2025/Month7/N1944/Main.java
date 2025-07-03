package year2025.Month7.N1944;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 미로의 크기
		int M = Integer.parseInt(st.nextToken()); // 열쇠의 개수

		int[] location = new int[M + 1];
		int mCount = 1;

		String[][] road = new String[N][N];
		for (int r = 0; r < N; r++) {
			String[] tmp = br.readLine().split("");
			for (int c = 0; c < N; c++) {
				road[r][c] = tmp[c];
				if (road[r][c].equals("S")) {
					location[0] = (r - 1) * (N - 2) + c; // 시작 위치
				} else if (road[r][c].equals("K")) {
					location[mCount] = (r - 1) * (N - 2) + c; // 열쇠 위치
					mCount++;
				}
			}
		}


		int total = (N - 2) * (N - 2);
		int layerS = N - 2;

		int[][] adj = new int[total + 1][total + 1];
		for (int i = 0; i <= total; i++) {
			Arrays.fill(adj[i], 100000000);
			adj[i][i] = 0; // 자기 자신과의 거리는 0
		}

		for (int n = 1; n <= total; n++) {
			int r = (n - 1) / (N - 2) + 1;
			int c = (n - 1) % (N - 2) + 1;

			if (!road[r][c].equals("1")) {
				if (!road[r][c + 1].equals("1")) {
					adj[n][n + 1] = 1; // 오른쪽
					adj[n + 1][n] = 1;
				}
				if (!road[r + 1][c].equals("1")) {
					adj[n][n + layerS] = 1; // 아래쪽
					adj[n + layerS][n] = 1;
				}
			}
		}



		for (int m = 1; m <= total; m++) {
			for (int s = 1; s <= total; s++) {
				for (int e = 1; e <= total; e++) {
					if (adj[s][m] + adj[m][e] < adj[s][e]) {
						adj[s][e] = adj[s][m] + adj[m][e];
					}
				}
			}
		}


		// 최소 신장 트리
		int sum = 0;

		int[] parent = new int[total + 1];
		for (int i = 1; i <= total; i++) {
			parent[i] = i; // 초기화
		}

		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i <= M; i++) {
			for (int j = i + 1; j <= M; j++) {
				if (i == j) continue; // 자기 자신과의 거리는 제외
				if (adj[location[i]][location[j]] < 100000000) { // 연결된 경우
					edges.add(new Edge(location[i], location[j], adj[location[i]][location[j]]));
				} else {
					System.out.println("-1");
					return;
				}
			}
		}
		Collections.sort(edges); // 거리 기준으로 오름차순 정렬

		for (Edge edge : edges) {
			int s = edge.s;
			int e = edge.e;
			int d = edge.d;

			if (find(parent, s) != find(parent, e)) { // 사이클이 발생하지 않는 경우
				union(parent, s, e);
				sum += d; // 거리 합산
			}
		}

		System.out.println(sum);
	}

	public static class Edge implements Comparable<Edge> {
		int s; // 시작 노드
		int e; // 도착 노드
		int d; // 거리

		public Edge(int s, int e, int d) {
			this.s = s;
			this.e = e;
			this.d = d;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.d, o.d); // 거리 기준으로 오름차순 정렬
		}
	}

	public static void union(int[] parent, int a, int b) {
		int rootA = find(parent, a);
		int rootB = find(parent, b);

		if (rootA > rootB) {
			parent[rootB] = rootA; // b가 루트 노드가 됨
		} else if (rootA < rootB) {
			parent[rootA] = rootB; // a가 루트 노드가 됨
		}
	}

	public static int find(int[] parent, int a) {
		if (parent[a] == a) {
			return a; // a가 루트 노드인 경우
		}
		return parent[a] = find(parent, parent[a]); // 경로 압축
	}
}

// 복제 로봇, 원하는 수만큼 복제 가능
// 열쇠 찾기
// 열쇠 위치, 로봇 출발 위치 -> 복제 장치
// M개의 흩어진 열쇠
// 로봇 움직이는 횟수의 합 최소


// 주의 도착 못하면 -1

