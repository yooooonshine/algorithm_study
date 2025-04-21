package year2025.month4.N2293;

import java.util.*;
import java.io.*;

public class Main {
	public static int[] arr;
	public static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 동전 수
		int k = Integer.parseInt(st.nextToken()); // k원

		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		dp = new int[k + 1][n];
		for (int r = 1; r <= k; r++) {
			for (int c = 0; c < n; c++) {
				dp[r][c] = -1;
			}
		}

		for (int c = 0; c < n; c++) {
			dp[0][c] = 1;
		}

		System.out.println(recursion(k, n - 1)); // 최대 금액
	}

	public static int recursion(int p, int index) {
		if (index == 0) {
			if (p % arr[index] == 0) {
				return 1;
			} else {
				return 0;
			}
		}

		if (dp[p][index] != -1) {
			return dp[p][index];
		}

		int pTemp = arr[index];

		int nowIndex = 0;

		int sum = 0;
		while (p - pTemp * nowIndex > 0) {
			sum += recursion(p - pTemp * nowIndex, index - 1);
			nowIndex++;
		}
		if (p - pTemp * nowIndex == 0) {
			sum++;
		}

		dp[p][index] = sum;
		return sum;
	}
}

// 각 재귀는 가장 큰 금액부터 x


// n가지 종류 동전(가치 다다름)
// 가치합 k원
// 경우의 수
// 몇개라도 사용가능

// 1정렬


// 이분탐색 같은데
// 최대 금액 잡아서 k가 되게끔?


// 3 10
// 1 x 10
// 1 x 2, 2 x 4
// 1 x 4, 2 x 3
// 1 x 6, 2 x 2
// 1 x 8, 2 x 1
// 2 x 5
// 5 x 2
// 5 x 1, 1 x 5
// 5 x 1, 1 x 3, 2 x 1
// 5 x 1, 1 x 1, 2 x 2


// 완탐 x
// 투포인터
// 이분탐색
// 그리디 x
// dp o?
// x원을 만드는 가지의 수
// 10원을 만드는 가지의 수
// 5원 0, 1, 2
// 1. -> 5제외 10원 만드는 가지의수
// 2. -> 5제외 5원 만드는 가자의수
// 3. -> 5제외 0원 만드는 가지의 수 -> 1

// 금액

// 최대를 잡고 그 왼쪽으로?

// 5 x 2 -> pass
// 5 x 1 -> 남은

// 재귀?