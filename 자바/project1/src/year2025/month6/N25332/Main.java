package year2025.month6.N25332;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {

			A[n] = Integer.parseInt(st.nextToken());
		}

		int[] Asum = new int[N + 1];
		for (int n = 1; n <= N; n++) {
			Asum[n] = Asum[n - 1] + A[n];
		}


		int[] B = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {

			B[n] = Integer.parseInt(st.nextToken());
		}

		int[] Bsum = new int[N + 1];
		for (int n = 1; n <= N; n++) {
			Bsum[n] = Bsum[n - 1] + B[n];
		}

		long count = 0L;

		for (int n = 0; n <= N; n++) {
			if (Asum[n] == Bsum[n]) {
				count++;
			}
		}

		long result = 0;
		for (int n = 2; n <= N; n++) {
			if (A[n] == B[n] && Asum[n - 1] != Bsum[n - 1]) {
				result++;
			}
		}

		result += count * (count - 1L) / 2L;

		System.out.println(result);
	}
}
// 부분합?

// dp?

// 새로들어오는 게 같은 경우
// 새로 들어오는 게 다른 경우?
// 안되네

// 이분탐색.
// 투포인트
//

// 1 3 6
// 1 4 6

// 같은 게 있구나
// 낱개 n
// n C 2

// 둘의 합

// 1 3 6 10 15
// 4 9 15 22 30

// 23 36 67 84 113 132
// 23 36 67 84 113 132
// 6 + 6C2 =
// 1 3 4
// 1 2 3

//  0 1 3 6
//  0 1 4 6