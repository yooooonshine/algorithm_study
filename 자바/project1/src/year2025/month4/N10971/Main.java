package year2025.month4.N10971;

import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static int[][] arr;
	public static long MIN = Long.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i  = 2; i <= N; i++) {
			boolean visited[] = new boolean[N + 1];
			if (arr[1][i] == 0) {
				continue;
			}
			dfs(visited, i, (long)arr[1][i]);
		}

		System.out.println(MIN);
	}

	public static void dfs (boolean visited[], int start, long length) {
		if (start == 1) {
			if (visited[1]) {
				return;
			}

			boolean allVisited = true;

			for (int i = 2; i <= N; i++) {
				if (!visited[i]) {
					allVisited = false;
					break;
				}
			}
			if (allVisited) {
				if (length < MIN) {
					MIN = length;
				}
			}
			return;
		}

		if (visited[start]) {
			return;
		}
		visited[start] = true;

		for (int i = 1; i <= N; i++) {
			if (i != start && !visited[i] && arr[start][i] != 0) {

				dfs(visited, i, (long)length + (long)arr[start][i]);
			}
		}

		visited[start] = false;
	}
}

// 적은 비용
// 다익스트라?

// 한번 갔던 도시는 못간다.
// bfs, dfs
// dfs에서 첫 시작점은 visited에 처음에는 넣지 않고, 다음 시작점 도착했을 대 모두 방문했으면


//