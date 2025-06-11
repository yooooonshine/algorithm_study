package year2025.month6.N10986;

import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) % M;
		}

		long count = 0L;

		// 부분합
		int[] counts = new int[M + 1];
		int[] s = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			s[i] = (arr[i] + s[i - 1]) % M;
			counts[s[i]]++;
		}

		counts[0]++; // S(0) = 0, 즉 부분합이 0인 경우도 포함

		for (int i = 0; i < M; i++) {
			int num = counts[i];
			if (num >= 2) {
				count += (long)num * (num - 1) / 2;
			}
		}

		System.out.println(count);
	}

}

// 부분합 계산한다.
// N이 10^6
//
// 1 3 6 7 9
// An ~ Ak = S(k) - S(n - 1)

// 투포인트 불가능해
// dp
// 합이 1인 경우, 2인 경우, 3인 경우
// 1 2 -> 1개
// 1 2 3 -> 1(기존) + 1(단독) + 1(추가)
// 1 2 3 1 -> \

// dp x
// n 아니면, 2n인데
// 투포인트 아닌


// 자신이 0인것
// 같은 것 COUNT해서
// 각각 nC2

// 0 1 2 0 1 2
// 0 1 0 0 1 0
// 1 + 3 + 1

// (S(i) - S(j - 1)) % M == 0
// S(i) % M == S(j - 1) % M
//