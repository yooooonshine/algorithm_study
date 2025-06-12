package year2025.month6.N17406;

import java.util.*;
import java.io.*;

public class Main {

	public static int N; //세로
	public static int M; //가로
	public static int K; //회전

	public static int[][] A; // 배열
	public static int[][] input;
	public static boolean[] inputUse;

	public static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N + 1][M + 1];
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= M; c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		input = new int[K + 1][3];
		for (int k = 1; k <= K; k++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			input[k][0] = r;
			input[k][1] = c;
			input[k][2] = s;
		}

		inputUse = new boolean[K + 1];

		recursion(0);

		System.out.println(result);
	}

	// 회전 함수
	public static void rotate(int R, int C, int S) {
		for (int d = 0; d <= S; d++) {
			int rStart = R - S + d;
			int rEnd = R + S - d;
			int cStart = C - S + d;
			int cEnd = C + S - d;

			// 정 가운데 홀로 있는 지점
			if (rStart == rEnd) {
				continue;
			}

			int tmp= A[rStart][cStart];
			int tmp2;

			for (int c = cStart + 1;  c <= cEnd; c++) {
				tmp2 = A[rStart][c];
				A[rStart][c] = tmp;
				tmp = tmp2;
			}

			for (int r = rStart + 1; r <= rEnd; r++) {
				tmp2 = A[r][cEnd];
				A[r][cEnd] = tmp;
				tmp = tmp2;
			}

			for (int c = cEnd - 1;  c >= cStart; c--) {
				tmp2 = A[rEnd][c];
				A[rEnd][c] = tmp;
				tmp = tmp2;
			}

			for (int r = rEnd - 1; r >= rStart; r--) {
				tmp2 = A[r][cStart];
				A[r][cStart] = tmp;
				tmp = tmp2;
			}
		}
	}

	// 회전 롤백
	public static void rollback(int R, int C, int S) {
		for (int d = 0; d <= S; d++) {
			int rStart = R - S + d;
			int rEnd = R + S - d;
			int cStart = C - S + d;
			int cEnd = C + S - d;

			// 정 가운데 홀로 있는 지점
			if (rStart == rEnd) {
				continue;
			}

			int tmp = A[rStart][cStart];
			for (int c = cStart + 1; c <= cEnd; c++) {
				A[rStart][c - 1] = A[rStart][c];
			}
			for (int r = rStart + 1; r <= rEnd; r++) {
				A[r - 1][cEnd] = A[r][cEnd];
			}
			for (int c = cEnd - 1; c >= cStart; c--) {
				A[rEnd][c + 1] = A[rEnd][c];
			}
			for (int r = rEnd - 1; r >= rStart; r--) {
				A[r + 1][cStart] = A[r][cStart];
			}

			A[rStart + 1][cStart] = tmp; // 마지막에 넣어주기
		}
	}

	// 재귀 함수
	public static void recursion(int count) {
		if (count >= K) {
			int tmp = min();

			if (tmp < result) {
				result = tmp;
			}
			return;
		}

		for (int k = 1; k <= K; k++) {
			if (inputUse[k]) {
				continue;
			}

			// 사용
			inputUse[k] = true;
			rotate(input[k][0], input[k][1], input[k][2]);
			recursion(count + 1);
			inputUse[k] = false;
			rollback(input[k][0], input[k][1], input[k][2]);
		}
	}

	// 행 카운트 함수
	public static int min() {
		int min = Integer.MAX_VALUE;

		for (int r = 1; r <= N; r++) {
			int tmp = 0;
			for (int c = 1; c <= M; c++) {
				tmp += A[r][c];
			}

			if (tmp < min) {
				min = tmp;
			}
		}

		return min;
	}
}

// R = N, C = M
// 각 행 모든 수의 합  중 최소값 = 배열 A의 값

// 회전 (r,c,s)
// (r - s, c - s) ~ (r + s, c + s)
// 시계 방향

// 배열 A에 연산들을 적용하여 최솟값을 구하자

// 모든 경우의 수 다 체크

//

// 회전
// 겉부터 -> 속까지 r + i ~ c - i
