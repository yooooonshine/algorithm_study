package year2025.month2.N1780;

import java.util.*;
import java.io.*;

public class Main {
	public static int[] parent;
	public static int[][] arr;
	public static int fResult[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		fResult = new int[3];


		int result = recursion(N, 1, 1);

		if (result == -1) {
			fResult[0]++;
		} else if (result == 0) {
			fResult[1]++;
		} else if (result == 1) {
			fResult[2]++;
		}

		System.out.println(fResult[0]);
		System.out.println(fResult[1]);
		System.out.println(fResult[2]);
	}

	public static int recursion(int n, int R, int C) {
		if (n == 1) {
			return arr[R][C];
		}

		int part = n / 3;

		int count = 9;

		int[] result = new int[4]; // -1 0 1 2
		for (int r = R; r < R + n; r+=part) {
			for (int c = C; c < C + n; c+=part) {
				int re = recursion(part, r, c);

				if (re == -1) {
					result[0]++;
				} else if (re == 0) {
					result[1]++;
				} else if (re == 1) {
					result[2]++;
				} else {
					result[3]++;
				}
			}
		}

		if (result[0] == count) {
			return -1;
		} else if (result[1] == count) {
			return 0;
		} else if (result[2] == count) {
			return 1;
		} else {
			for (int i = 0; i <= 2; i++) {
				fResult[i] += result[i];
			}
			return 2;
		}
	}
}


// 각 종이 칸은 -1 , 0, 1
// 같은 수 아니면 종이 9등분
// -1 종이 수, 0 종이수, 1종이 수

// 123 456 789

// 1 0 -1 그리고 2 -> 종이가 아니다.

// 현상황에서 1칸씩 분리 -> 특정 색이야 -> 색 리턴
// 아니야 -> 각 1 0 -1 반영하고 X 리턴

// 현상황 3칸씩 분리 -> 특정 색이야 -> 색리턴
// 하나라도 X거나 1 0 -1이야 각각 반영  X리턴

// 현재 길이 / 3이 한칸 길이