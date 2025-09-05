package year2025.month9.N23843;

import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static int M;
	public static Integer[] T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 전자기기 수
		M = Integer.parseInt(st.nextToken()); // 콘센트 수

		st = new StringTokenizer(br.readLine());
		T = new Integer[N];
		int sum = 0;
		for (int n = 0; n < N; n++) {
			T[n] = Integer.parseInt(st.nextToken());
			sum += T[n];
		}
		Arrays.sort(T, (a, b) -> {
			return b - a;
		});

		int start = 1;
		int end = sum;

		int result = Integer.MAX_VALUE;
		while (start <= end) {
			int mid = (start + end) / 2;

			if (can(mid)) {
				if (result > mid) {
					result = mid;
				}

				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(result);
	}

	public static boolean can(int v) {
		int index = 0;
		int conI = 0;
		int[] cons = new int[M];
		while (index < N) {
			if (cons[conI] + T[index] <= v) {
				cons[conI] += T[index];

				index++;
			} else {
				conI++;
				if (conI == M) {
					conI = 0;
				}

				boolean canDo = false;
				for (int m = 0; m < M; m++) {
					if (cons[m] + T[index] <= v) {
						canDo = true;
						break;
					}
				}

				if (!canDo) {
					return false;
				}
			}
		}

		return true;
	}
}

// N개의 전자기기 충전
// M개의 콘센트
// 충전시간은 2^k

// 전자기기 충전 최소 시간

// 느낌이 이분탐색

// 그리디
// 이분탐색

// 그리디 하지 않다?
// 이분탐색을 쓴다고하면 이 시간 안에 되는지를 어떻게 알지.

// 큰 것부터 채우다가 넘치면, 다른 곳 가고, 계속 끝까지가면 다시 앞부터해서 채워보기?
