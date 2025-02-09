package year2025.month2.N2589;

import java.util.*;
import java.io.*;

public class Main {

	public static String LAND = "L";
	public static String SEA = "W";

	public static int[] Rs = {0, 0, 1, -1};
	public static int[] Cs = {1, -1, 0, 0};

	public static int MAX = 0;
	public static String[][] arr;

	public static int r;
	public static int c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new String[r + 2][c + 2];
		for (int i = 0; i <= c + 1; i++) {
			arr[0][i] = SEA;
			arr[r + 1][i] = SEA;
		}
		for (int i = 0; i <= r + 1; i++) {
			arr[i][0] = SEA;
			arr[i][c + 1] = SEA;
		}
		for (int i = 1; i <= r; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 1; j <= c; j++) {
				arr[i][j] = tmp[j - 1];
			}
		}

		// 탐색
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if (arr[i][j].equals(LAND)) {
					seek(i, j);
				}
			}
		}

		System.out.println(MAX);
	}

	public static void seek(int rt, int ct) {
		int far = 0;
		int farR = 0;
		int farC = 0;

		// 복제
		// String[][] tmpA = new String[r + 2][c + 2];
		// for (int i = 0; i <= r + 1; i++) {
		// 	tmpA[i] = Arrays.copyOf(arr[i], arr[i].length); // ✅ 깊은 복사
		// }
		boolean[][] visited = new boolean[r + 2][c + 2];

		// 멀리 찾기
		Queue<Edge> q = new LinkedList<>();
		q.add(new Edge(rt, ct, 0));

		while (!q.isEmpty()) {
			Edge edge = q.poll();

			if (visited[edge.r][edge.c]) {
				continue;
			}
			visited[edge.r][edge.c] = true;

			if (far < edge.d) {
				far = edge.d;
				farR = edge.r;
				farC = edge.c;
			}

			for (int i = 0; i <= 3; i++) {
				int tmpR = edge.r + Rs[i];
				int tmpC = edge.c + Cs[i];

				if (tmpR <= 0 || tmpC <= 0 || tmpR >= r + 1 || tmpC >= c + 1) {
					continue;
				}

				if (arr[tmpR][tmpC].equals(LAND) && !visited[tmpR][tmpC]) {
					q.add(new Edge(tmpR, tmpC, edge.d + 1));
				}
			}
		}

		// 결과
		visited = new boolean[r + 2][c + 2];
		q.add(new Edge(farR, farC, 0));

		while (!q.isEmpty()) {
			Edge edge = q.poll();

			if (visited[edge.r][edge.c]) {
				continue;
			}
			visited[edge.r][edge.c] = true;


			if (MAX < edge.d) {
				MAX = edge.d;
			}

			for (int i = 0; i <= 3; i++) {
				int tmpR = edge.r + Rs[i];
				int tmpC = edge.c + Cs[i];

				if (tmpR <= 0 || tmpC <= 0 || tmpR >= r + 1 || tmpC >= c + 1) {
					continue;
				}

				if (arr[tmpR][tmpC].equals(LAND) && !visited[tmpR][tmpC]) {
					q.add(new Edge(tmpR, tmpC, edge.d + 1));
				}
			}
		}
	}

	public static class Edge {
		int r;
		int c;
		int d;

		public Edge(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
}
//육지 L
// 바다 W
// 한칸 1시간 -> bfs? bfs 두번

//  세로 가로 크기(r c)
//  세로만큼 반복

// 가로 세로 for문 돌려서 육지찾기

// 한번의 bfs를 통해 가장 먼 지점 찾기
// 다시 거기서 bfs를 통해 가장 먼 거리 찾기
// 첫번째는 복사해서 사용하고
// 두번째는 간곳은 W로 체크하기