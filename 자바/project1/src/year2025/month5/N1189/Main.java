package year2025.month5.N1189;

import java.util.*;
import java.io.*;

public class Main {

	public static int R;
	public static int C;
	public static int K;

	public static int[] rs = {1, -1, 0, 0};
	public static int[] cs = {0, 0, 1, -1};
	public static boolean[][] visit;

	public static int result = 0;

	public static int[][] road;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		road = new int[R + 2][C + 2];
		for (int r = 1; r <= R; r++) {
			String[] arr = Arrays.stream(br.readLine().split("")).toArray(String[]::new);
			for (int c = 1; c <= C; c++) {
				String tmpS = arr[c - 1];

				int tmp = 0;
				if (tmpS.equals("T")) {
					tmp = 1;
				}

				road[r][c] = tmp;
			}
		}

		visit = new boolean[R + 2][C + 2];

		dfs(R, 1, 1);
		System.out.println(result);
	}

	public static void dfs(int nowR, int nowC, int nowCount) {
		if (visit[nowR][nowC]) {
			return;
		}
		visit[nowR][nowC] = true;

		if (nowCount == K) {
			if (nowR == 1 && nowC == C) {
				result++;
			}
			visit[nowR][nowC] = false;
			return;
		}

		for (int i = 0; i <= 3; i++) {
			int nextR = nowR + rs[i];
			int nextC = nowC + cs[i];

			if (nextR < 1 || nextR > R || nextC < 1 || nextC > C) {
				continue;
			}
			if (road[nextR][nextC] == 1) {
				continue;
			}

			dfs(nextR, nextC, nowCount + 1);
		}
		visit[nowR][nowC] = false;
	}
}

// dfs 활용
// Stack으로 상하좌우 방문 x 들어가기
// 들어갔단 나오면 되돌리기
//