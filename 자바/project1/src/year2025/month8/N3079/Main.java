package year2025.month8.N3079;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 입국 심사대 개수
		int M = Integer.parseInt(st.nextToken()); // 친구 수

		long[] T = new long[N + 1];
		for (int n = 1; n <= N; n++) {
			T[n] = Long.parseLong(br.readLine());
		}

		long s = 1;
		long e = 1000000000L * M;

		long min = e;
		while (s <= e) {
			long m = (s + e) / 2;

			long sum = 0;
			for (int n = 1; n <= N; n++) {
				sum += m / T[n];

				if (sum >= M) { // 오버플로우/불필요 누적 방지
					break;
				}
			}

			if (sum >= (long)M) {
				e = m - 1;
				min = Math.min(min, m);
			} else {
				s = m + 1;
			}
		}

		System.out.println(min);
	}
}

// 사람 M명
// 입국심사대는 N개
// k번 심사관이 심사 시간 Tk
// 심사 최소 시간
// 심사 걸리는 시간의 최솟값

// n이 안되는구나 log 시간?
// 이분탐색, 정렬x

// Tk로 이분탐색
// Tk 안의 시간에 모두 가능한지
// 각 심사 인원이 몇명이 가능한지 체크 하여 더하기
