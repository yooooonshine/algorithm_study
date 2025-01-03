package year2025.month1.N14501;

import java.util.*;
import java.io.*;

public class Main {
	public static int[] T;
	public static int[] P;
	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N + 1];
		P = new int[N + 1];

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		int result = calc(1);
		System.out.println(result);
	}

	public static int calc(int index) {
		if (index > N) {
			return 0;
		}

		int a = 0;
		if (index + T[index] - 1 <= N) {
			a = calc(index + T[index]) + P[index];
		}
		int b = calc(index + 1);

		return Math.max(a, b);
	}
}

// 역순으로 그리디 하면 되는 거아닌가?

// N + 1일날 퇴사
// N일동안 최대의 상담
// 그리디 인가?

// 최대 수익?

// N이 15?

// N
// Ti Pi 1일부터 N까지

// N * 2 ^ N으로 풀면 될 거 같은데
// 모든 케이스 on

// 재귀?

// 넘었으면 0 리턴
// 재귀는 최대를 리턴한다.

// 내일 꺼를 선택하냐
// 현재꺼를 선택하냐네
// 이 중의 맥스잖아

// D[i] = Math.max(D[i + T[i]] + P[i], D[i + 1])

// 왜 이게 dp 였을까?
// 규칙이 있었어서? 안보이면 모르잖아.
// d