package year2025.month10.N1022;

import java.util.*;
import java.io.*;

public class Main {

	public static int[] rs = {0, -1, 0, 1};
	public static int[] cs = {1, 0, -1, 0};

	public static int rM;
	public static int cM;

	public static int[][] arr2;

	public static int changeR1;
	public static int changeC1;
	public static int changeR2;
	public static int changeC2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());

		rM = Math.max(Math.abs(r1), Math.abs(r2)) * 2 + 1;
		cM = Math.max(Math.abs(c1), Math.abs(c2)) * 2 + 1;

		rM = Math.max(rM, cM);
		cM = Math.max(rM, cM);

		changeR1 = r1 + rM / 2;
		changeC1 = c1 + cM / 2;
		changeR2 = r2 + rM / 2;
		changeC2 = c2 + cM / 2;

		arr2 = new int[Math.abs(r2 - r1 + 1)][Math.abs(c2 - c1 + 1)];

		getArr();


		// 각자리 최대
		int maxD = 0;
		for (int c = 0; c < arr2[0].length; c++) {

			for (int r = 0; r < arr2.length; r++) {
				int d = getDigit(arr2[r][c]);
				if (maxD < d) {
					maxD = d;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < arr2.length; r++) {
			for (int c = 0; c < arr2[0].length; c++) {
				int digit = getDigit(arr2[r][c]);
				for (int s = 0; s < maxD - digit; s++) {
					sb.append(" ");
				}
				sb.append(arr2[r][c]);
				if (c != arr2[0].length - 1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	public static int getDigit(int v) {
		return Integer.toString(v).length();
	}

	public static void getArr() {
		int nowR = rM / 2;
		int nowC = cM / 2;

		if (changeR1 <= nowR && nowR <= changeR2 && changeC1 <= nowC && nowC <= changeC2) {
			arr2[nowR - changeR1][nowC - changeC1] = 1;
		}

		int nowN = 2;
		int count = 0; // 움직일 거리
		while (true) {
			if (nowR < 0 || nowR > rM - 1 || nowC < 0 || nowC > cM - 1) {
				return;
			}

			count++;
			// 우
			for (int w = 1; w <= count; w++) {
				nowR += rs[0];
				nowC += cs[0];

				if (nowR < 0 || nowR > rM - 1 || nowC < 0 || nowC > cM - 1) {
					return;
				}

				if (changeR1 <= nowR && nowR <= changeR2 && changeC1 <= nowC && nowC <= changeC2) {
					arr2[nowR - changeR1][nowC - changeC1] = nowN;
				}

				nowN++;
			}

			// 상
			for (int w = 1; w <= count; w++) {

				nowR += rs[1];
				nowC += cs[1];

				if (nowR < 0 || nowR > rM - 1 || nowC < 0 || nowC > cM - 1) {
					return;
				}

				if (changeR1 <= nowR && nowR <= changeR2 && changeC1 <= nowC && nowC <= changeC2) {
					arr2[nowR - changeR1][nowC - changeC1] = nowN;
				}

				nowN++;
			}

			count++;
			// 좌
			for (int w = 1; w <= count; w++) {

				nowR += rs[2];
				nowC += cs[2];

				if (nowR < 0 || nowR > rM - 1 || nowC < 0 || nowC > cM- 1) {
					return;
				}

				if (changeR1 <= nowR && nowR <= changeR2 && changeC1 <= nowC && nowC <= changeC2) {
					arr2[nowR - changeR1][nowC - changeC1] = nowN;
				}

				nowN++;
			}

			// 하
			for (int w = 1; w <= count; w++) {

				nowR += rs[3];
				nowC += cs[3];

				if (nowR < 0 || nowR > rM - 1 || nowC < 0 || nowC > cM - 1) {
					return;
				}

				if (changeR1 <= nowR && nowR <= changeR2 && changeC1 <= nowC && nowC <= changeC2) {
					arr2[nowR - changeR1][nowC - changeC1] = nowN;
				}

				nowN++;
			}
		}
	}
}

// 모눈종이 크기 ㅇ무한
// 모눈종이의 각 정사각형은 행,열쌍
// 양의 정수 소용돌이

// 예쁘게 출력
// (r1, c1)(r2, c2) 일 때, r1행부터 r2행까지
// 공백으로 구분, 같은 행은 같은 길이

// 배열 25 x 10^6
// 한개당 10^8B

// 11, 22, 33, 44 반복