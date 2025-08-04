package year2025.month8.N3055;

import java.util.*;
import java.io.*;

public class Main {

	public static int R;
	public static int C;

	public static int[] rs = {0, 0, -1, 1};
	public static int[] cs = {1, -1, 0, 0};

	public static int MIN = 100000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int sR = 0;
		int sC = 0;

		int eR = 0;
		int eC = 0;

		String[][] map = new String[R + 2][C + 2];
		for (int r = 1; r <= R; r++) {
			String[] row = br.readLine().split("");

			for (int c = 1; c <= C; c++) {
				map[r][c] = row[c - 1];

				if (map[r][c].equals("S")) {
					sR = r;
					sC = c;
				}

				if (map[r][c].equals("D")) {
					eR = r;
					eC = c;
				}
			}
		}

		int min = bfs(sR, sC, eR, eC, map);

		if (min == MIN) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(min + "");
		}
	}

	public static int bfs(int sR, int sC, int eR, int eC, String[][] map) {
		Queue<Next> q = new LinkedList<>();
		boolean[][] visit = new boolean[R + 2][C + 2];

		q.add(new Next(sR, sC, map, visit, 0));

		int min = MIN;

		while (!q.isEmpty()) {
			Next now = q.poll();
			int nowR = now.r;
			int nowC = now.c;
			String[][] nowMap = rain(now.map);
			boolean[][] nowVisit = copy(now.visit);
			int count = now.count;


			if (nowMap[nowR][nowC].equals("D")) {
				min = count;
				break;
			}

			if (nowVisit[nowR][nowC]) {
				continue;
			}
			nowVisit[nowR][nowC] = true;

			for (int i = 0; i <= 3; i++) {
				int nextR = nowR + rs[i];
				int nextC = nowC + cs[i];

				if (nextR < 1 || nextR > R || nextC < 1 || nextC > C) {
					continue;
				}

				if (!nowMap[nextR][nextC].equals("*") && !nowVisit[nextR][nextC]) {
					q.add(new Next(nextR, nextC, nowMap, nowVisit, count + 1));
				}
			}
		}

		return min;
	}

	public static boolean[][] copy(boolean[][] map) {
		boolean[][] newMap = new boolean[R + 2][C + 2];
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				newMap[r][c] = map[r][c];
			}
		}

		return newMap;
	}

	public static String[][] rain(String[][] map) {
		String[][] newMap = new String[R + 2][C + 2];

		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				newMap[r][c] = map[r][c];
			}
		}

		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (map[r][c].equals("*")) {
					for (int i = 0; i <= 3; i++) {
						int nextR = r + rs[i];
						int nextC = c + cs[i];

						if (nextR < 1 || nextR > R || nextC < 1 || nextC > C) {
							continue;
						}

						if (newMap[nextR][nextC].equals(".")) {
							// 물이 들어갈 수 있는 곳
							newMap[nextR][nextC] = "*";
						}
					}
				}
			}
		}

		return newMap;
	}

	public static class Next {
		int r;
		int c;

		String[][] map;
		boolean[][] visit;

		int count;

		public Next(int r, int c, String[][] map, boolean[][] visit, int count) {
			this.r = r;
			this.c = c;
			this.map = map;
			this.visit = visit;
			this.count = count;
		}
	}
}

// 고슴도치는 비버의 굴로 이동

// R행 C열
// 비어있는 곳은 .
// 물 *
// 돌 X
// 비버의 굴 D
// 고슴도치 위치 S

// 고슴도치 상하좌우 이동
// 물 비어있는칸 확장

// 이동 최소시간
// 다음 시간에 물이 찰 예정 이동 x


// 주의
// 이동 불가시 KAKTUS


// BFS 활용
// 이동할 곳의 옆이 D면 이동 x
// 이동할 수 있는 곳이 없으면 끝
// 방문 체크
// 배열 저장