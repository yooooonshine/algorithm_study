package year2025.month4.N14503;

import java.util.*;
import java.io.*;

public class Main {

	public static int N, M;
	public static int[][] room;
	public static int count = 0;

	public static int[] rs = {-1, 0, 1, 0};
	public static int[] cs = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); //r
		M = Integer.parseInt(st.nextToken()); //c

		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		room = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		clean(R, C, D);

		System.out.println(count);
	}

	// 청소하면 2
	public static void clean(int r, int c, int d) {
		if (room[r][c] == 0) {
			room[r][c] = 2;
			count++;
		}

		int nextD = d;
		for (int i = 0; i <= 3; i++) {
			nextD = getNextD(nextD);
			int tmpR = r + rs[nextD];
			int tmpC = c + cs[nextD];

			boolean isDirty = false;
			if (room[tmpR][tmpC] == 0) {
				isDirty = true;
			}

			if (isDirty) {
				clean(tmpR, tmpC, nextD);
				return;
			}
		}

		// 전부 dirty 아님
		int backD = getNextD(getNextD(d));
		int tmpR = r + rs[backD];
		int tmpC = c + cs[backD];

		if (room[tmpR][tmpC] == 1) {
			return;
		} else {
			clean(tmpR, tmpC, d);
		}
	}

	public static int getNextD(int d) {
		return (d + 3) % 4;
	}
}

// N X M 방
// 방은 벽 or 빈 칸
// 청소기 방향
// 0,0 -> N - 1, M - 1

// 1. 칸 청소
// 2. 4칸 중 청소되지 않은 칸 없으면,
// 2.1 방향 유지 후진, 1번
// 2.2 뒤쪽 칸이 벽이면, 작동 끝
// 3. 주위 4칸 중 청소 x 칸 있으면
// 3.1 반시계 90도 회전
// 3.2 앞쪽 칸이 청소 x, 전진, 1번

// if dirty 청소
// 상하좌우 청소 or 벽 체크, 청소 x 있으면 밑에 패스
// 없으면 뒤쪽 벽 체크, 벽이면 끝
// 벽 x 뒤로 이동, 다시 재귀
// while, 빈 칸 dirty까지 반시계 회전
// 찾으면 전진, 다시 재귀

// 재귀 해야 겠구나

// N, M
// r, c, d -> 처음
// 0북, 1동, 2남, 3서
// N 개의 줄
// 상테 M개

// 반시계 회전은 (x - 1 + 4) % 4
