package year2024.month12_2024.N1613;

import java.util.*;
import java.io.*;

public class Main {
	public static int INF = 10000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] dist = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dist[i][j] = INF;
			}
		}
		for (int i = 1; i <= n; i++) {
			dist[i][i] = 0;
		}


		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			dist[s][e] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int s = 1; s <= n; s++) {
				for (int e = 1; e <= n; e++) {
					if (dist[s][e] >= dist[s][i] + dist[i][e]) {
						dist[s][e] = dist[s][i] + dist[i][e];
					}
				}
			}
		}

		int m = Integer.parseInt(br.readLine());

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			if (dist[s][e] != INF) {
				System.out.println(-1);
			} else if (dist[s][e] == INF && dist[e][s] != INF) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}

// 사건 개수 n, 사건의 전후 관계 k
// k줄, 두 사건의 번호, 앞이 먼저 일어남
// 알고싶은 사건 전후 s
// s줄에 대해 앞이 먼저 일어났으면 -1, 뒤가 먼저 일어났으면 1, 모르면 0


// 모든 노드 사이에 길이 있는 지 알아야 돼
// 플로이드 워셜
// 워셜은 최단거리 알고리즘
// 나는 길이 있는지만 알면돼

// 토폴로지 소트?
// 소트한 것을 저장시켜둔다?
