package year2025.month3.N1405;

import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class Main {
	public static double per = 0F;
	public static boolean[][] visit = new boolean[30][30];

	public static int[] mR = {0, 0, -1, 1};
	public static int[] mC = {1, -1, 0, 0};
	public static double[] mP;
	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		double EP = Float.parseFloat(st.nextToken()) / 100.0;
		double WP = Float.parseFloat(st.nextToken()) / 100.0;
		double SP = Float.parseFloat(st.nextToken()) / 100.0;
		double NP = Float.parseFloat(st.nextToken()) / 100.0;

		mP = new double[] {EP, WP, SP, NP}; // 각 이동별 확률 저장

		recursion(0, 15, 15, 1.0);

		System.out.printf("%.9f\n", per);
	}

	public static void recursion(int index, int r, int c, double nowP) {
		if (visit[r][c]) {
			return;
		}

		if (index == N) {
			per += nowP;
			return;
		}

		visit[r][c] = true;
		for (int i = 0; i <= 3; i++) {
			int nowR = r + mR[i];
			int nowC = c + mC[i];

			recursion(index + 1, nowR, nowC, mP[i] * nowP);
		}

		visit[r][c] = false;
	}
}

// N번의 행동 (EWNS 중 이동)
// 같은 곳은 한번만 이동할 활률?

// 수가 되게 작다. 완전탐색? 구현

// 모든 이동에 대해 각 퍼센트를 곱한다. 문제 없으면 넣는다.

// 재귀로 탐색한다.
// index가 N일 때 확률을 더한다.
// 이미 방문했으면 되돌아간다.