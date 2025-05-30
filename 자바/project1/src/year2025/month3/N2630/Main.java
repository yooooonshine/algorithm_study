package year2025.month3.N2630;

import java.util.*;
import java.io.*;

public class Main {

	public static int[][] paper;

	public static int wC = 0; // 흰 0
	public static int bC = 0; // 파 1

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		paper = new int[N + 1][N + 1]; // 0번 인덱스는 사용  x

		for (int r = 1; r <= N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		recursion(1, 1, N);

		System.out.println(wC);
		System.out.println(bC);
	}

	public static void recursion(int r, int c, int l) {
		if (l == 1) {
			if (paper[r][c] == 0) {
				wC++;
			} else {
				bC++;
			}
			return;
		}

		int first = paper[r][c];
		for (int R = r; R <= r + l - 1; R++) {
			for (int C = c; C <= c + l - 1; C++) {
				if (first != paper[R][C]) {
					int L = l / 2;

					recursion(r, c, L);
					recursion(r + L, c, L);
					recursion(r, c + L, L);
					recursion(r + L, c + L, L);

					return;
				}
			}
		}

		// 모두 같으면
		if (paper[r][c] == 0) {
			wC++;
		} else {
			bC++;
		}
	}
}

// 정사각형의 하얀색 or 파란색
// N x N
// 가로, 세로 중간을 잘라

// 하얀색, 파란색 색종이 개수

// 재귀
// r,c가 주어졌을 때 사각형이 모두 같은 색이면 count ++;
// 다른 색이면 나누기
// 나눈것 재귀 돌리기
