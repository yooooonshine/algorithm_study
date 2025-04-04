package year2025.month4.N2458;

import java.util.*;
import java.io.*;

public class Main {

	public static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 학생 수
		M = Integer.parseInt(st.nextToken()); // 비교

		boolean[][] arr1 = new boolean[N + 1][N + 1];	// 키 커지는 방향
		boolean[][] arr2 = new boolean[N + 1][N + 1]; // 키 작아지는 방향
		for (int i = 1; i <= N; i++) {
			arr1[i][i] = true;
			arr2[i][i] = true;
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			arr1[s][e] = true;
			arr2[e][s] = true;
		}

		fw(arr1);
		fw(arr2);

		int count = 0;
		for (int i = 1; i <= N; i++) {
			boolean can = true;
			for (int k = 1; k <= N; k++) {
				if (i == k) {
					continue;
				}

				if (!arr1[i][k] && !arr2[i][k]) {
					can = false;
					break;
				}
			}

			if (can) {
				count++;
			}
		}

		System.out.println(count);
	}

	public static void fw(boolean[][] arr) {
		for (int v = 1; v <= N; v++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					if (arr[s][v] && arr[v][e]) {
						arr[s][e] = true;
					}
				}
			}
		}
	}
}

// 자신의 키가 몇번째인지 알 수 있는 학생?
// 토폴로지 소트인가?

// N = 500
// M = 12500
// 특정 점 기준으로 도달 불가능한 곳.
// 들어오는 방향으로 탐색했을 때
// 나가는 방향으로 탐색했을 때

// 방법1. 각 노드에 대해 탐색
// N * O(N + E) * 2 =

// 각 방향으로 플로이드 워셜 두 번한다.
// for문을 통해 둘 중 하나라도 길이 있으면 pass, 모두 pass 면 count
