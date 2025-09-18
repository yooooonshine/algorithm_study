package year2025.month9.N11562;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 건물의 수
		int M = Integer.parseInt(st.nextToken()); // 길의 수

		int[][] arr = new int[N + 1][N + 1];
		for (int n = 1; n <= N; n++) {
			Arrays.fill(arr[n], 1000000);
			arr[n][n] = 0;
		}

		for (int m = 1; m <= M; m++) {


			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int type = Integer.parseInt(st.nextToken()); //0은 일반, 1은 양방향

			if (type == 0) {
				arr[s][e] = 0;
				arr[e][s] = 1;
			} else {
				arr[s][e] = 0;
				arr[e][s] = 0;
			}
		}

		for (int m = 1; m <= N; m++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					if (arr[s][e] > arr[s][m] + arr[m][e]) {
						arr[s][e] = arr[s][m] + arr[m][e];
					}
				}
			}
		}

		int K = Integer.parseInt(br.readLine()); // 학생들의 질문 수
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int k = 1; k <= K; k++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			bw.write(arr[s][e] + "\n");
		}

		bw.flush();
	}
}

// 일반통행
// 반드시 양방향으로 바꿔야 하는 길 찾기
// 몇 개의 길을 양방향으로?

//
