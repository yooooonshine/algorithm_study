package year2025.month1.N1915;

import java.util.*;
import java.io.*;

public class Main {
	public static int[][] arr;
	public static int N;
	public static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로

		arr = new int[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			String[] tmp = str.split("");

			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(tmp[j - 1]);
			}
		}

		Queue<Edge> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (arr[i][j] == 1) {
					q.add(new Edge(i, j, 1));
				}
			}
		}

		int max = 0;

		while (!q.isEmpty()) {
			Edge edge = q.poll();
			int i = edge.i;
			int j = edge.j;
			int m = edge.m;

			if (max < edge.m) {
				max = edge.m;
			}

			// 미래
			if (i + m >= N + 1 || j + m >= M + 1) { // 마지막이 m - 1이고 추가 1
				continue;
			}

			boolean flag1 = true;
			for (int c = j; c <= j + m; c++) {
				if (arr[i + m][c] == 0) {
					flag1 = false;
					break;
				}
			}
			if (!flag1) {
				continue;
			}

			boolean flag2 = true;
			for (int r = i; r <= i + m; r++) {
				if (arr[r][j + m] == 0) {
					flag2 = false;
					break;
				}
			}
			if (!flag2) {
				continue;
			}

			q.add(new Edge(i, j, m + 1));
		}

		System.out.println(max * max);
	}

	public static class Edge {
		int i;
		int j;
		int m;

		public Edge(int i, int j, int m) {
			this.i = i;
			this.j = j;
			this.m = m;
		}
	}
}
