package year2025.month11.N1082;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); //

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] P = new int[N + 1];
		for (int n = 0; n < N; n++) {
			P[n] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine()); // 돈

		String[] dp = new String[M + 1];
		dp[0] = "";

		for (int m = 1; m <= M; m++) {
			String max = "";
			boolean change = false;
			for (int n = 0; n < N; n++) {
				if (m - P[n] >= 0) {
					if (n != 0 && bigger(max, n + "" + dp[m - P[n]]) != max) {
						max = n + "" + dp[m - P[n]];
						change = true;
					}

					if (bigger(max, dp[m - P[n]] + "" + n) != max) {
						if (n == 0 && dp[m - P[n]].equals("0")) {{
							continue;
						}}

						max = dp[m - P[n]] + "" + n;
						change = true;
					}
				}
			}

			if (change) {
				dp[m] = max + "";
			} else {
				dp[m] = dp[m - 1];
			}
		}

		System.out.println(dp[M]);
	}

	public static String bigger(String v1, String v2) {
		if (v1.length() > v2.length()) {
			return v1;
		} else if (v1.length() < v2.length()) {
			return v2;
		} else {
			for (int i = 0; i < v1.length(); i++) {
				if (v1.charAt(i) > v2.charAt(i)) {
					return v1;
				} else if (v1.charAt(i) < v2.charAt(i)) {
					return v2;
				}
			}
		}

		return v1;
	}
}


// dp?
// N원 내에서 만들 수 있는 최대 수?
// 기존 vs 기존 + 새로운 것
// 새로운 것이 기존 맨 앞보다 크면 앞에, 아니면 뒤에
//

// 방번호 정하기
// 1층 문방구에서 수자 구매 ->
// 현재 m원 존재

// 숫자는 0부터 N - 1
// 각각 가격 Pi
// 같은 숫자 여러개 구매 가능
// 0 시작 불가(숫자가 0이 아니라면)\

// 가장 큰 방번호

// 그리디한데
// DP?

// 최대한 많이 사는게 이득인데?


// 샀을 때는 큰수부터
// 그럼 모든 사는 경우의 수를 찾ㅇ아야 하나
