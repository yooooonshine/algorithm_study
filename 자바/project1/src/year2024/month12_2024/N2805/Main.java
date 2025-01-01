package year2024.month12_2024.N2805;

import java.util.*;
import java.io.*;

public class Main {
	public static long[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 나무 수
		long M = Long.parseLong(st.nextToken()); // 나무 길이

		arr = new long[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		long max = 0;
		for (int i = 1; i <= N; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int s = 0;
		int e = (int)max;
		int m = (int)max / 2;

		int result = 0;

		while (s <= e) {
			long tmp = cut(m);

			if (tmp < M) {
				e = m - 1;
				m = (s + e) / 2;
			} else {

				if (result <= m) {
					result = m;
				}

				s = m + 1;
				m = (s + e) / 2;

			}
		}

		System.out.println(result);
	}

	public static long cut(long h) {
		long sum = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - h > 0) {
				sum = sum + arr[i] - h;
			}
		}

		return sum;
	}
}


// 나무 M미터
// 높이 H -> 톨날이 H로 이동
// 나무를 모두 절단
// M을 가져가기 위한 높이의 최댓값?

// 최대 최소? -> 이분탐색"

// N, M (나무의 수, 나무의 길이)
// 나무 높이 N 개

// long으로 하자.

// H를 결정하는 게 중요. 최대 높이에 따라 H반복하면 10^9 1초를 넘는다
// log가 필요 이분 탐색?
// H에 대해? 최대로 했을
// H를 이분 탐색하면서 나무를 잘라본다.
// 만약 M보다 크면 H를 높인다.
// 만약 M보다 작으면 H를 낮춘다.
// 가능한 최대 H를 저장해둔다.
// M이랑 같으면 멈춘다.

// N * long H 10^6 *

// 이분 탐색
// while s <= e
// s, e, ma
// if (합 > M)
// s = m + 1
// m = (s + e) / 2
// else if (합 < M)
// e = m - 1
// m = (s + e) / 2
// else if (합 = M) 종료
//