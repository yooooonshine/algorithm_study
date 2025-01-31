package year2025.month1.N1504;

import java.util.*;
import java.io.*;

public class Main {
	public static final int MAX = 10000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = MAX;
			}
			arr[i][i] = 0;
		}

		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			arr[a][b] = c;
			arr[b][a] = c;
		}

		for (int n = 1; n <= N; n++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					if (arr[s][e] > arr[s][n] + arr[n][e]) {
						arr[s][e] = arr[s][n] + arr[n][e];
					}
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		if (arr[1][v1] == MAX || arr[v1][v2] == MAX || arr[v2][N] == MAX) {
			System.out.println(-1);
			return;
		}

		System.out.println(Math.min(arr[1][v2] + arr[v2][v1] + arr[v1][N],arr[1][v1] + arr[v1][v2] + arr[v2][N]));
	}
}

// 그래프
// 최단거리 -> 다익스트라,벨만 포트,
// 임의의 두 정점은 반드시 통과
// 각 경로가 최단이면 되겠네
// 다익스트라 O(log(V)E)
// 플로이드 워셜(O(V^3))
// 벨만포드O(VE) -> 시간 넘는다.

// 정점 N
// 간선 E
// a, b, c (a -> b는 양방향, 거리가 c)
// v1 v2
// 1에서 N번으로 이동

// 경로가 없으면 -1 출력!!

// 플로이드 워셜
// 모든 노드 n에 대해
// 모든 시작점 s에 대해
// 모든 끝점 e에 대해
// if (d[s][e] > d[s][n] + d[n][e] 면 업데이트

// 2차원 배열
// 자기자신은 모두 0
// 나머지는 모두 무한대
//
