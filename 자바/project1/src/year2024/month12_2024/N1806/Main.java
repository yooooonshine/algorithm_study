package year2024.month12_2024.N1806;

import java.util.*;
import java.io.*;

public class Main {
	public static long[] sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		long[] arr = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		sum = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			sum[i] = arr[i] + sum[i - 1];
		}

		int s = 1;
		int e = 1;

		int length = Integer.MAX_VALUE;
		while (s <= e && e <= N) {
			if (calcSum(s, e) < S) {
				e++;
			} else if (calcSum(s, e) >= S) {
				if (e - s + 1 < length) {
					length = e - s + 1;
				}
				s++;
			}
		}

		if (length != Integer.MAX_VALUE) {
			System.out.println(length);
		} else {
			System.out.println(0);
		}

	}

	public static long calcSum(int s, int e) {
		return sum[e] - sum[s - 1];
	}
}

	// 부분합?
	// 부분합 배열
	// 세그먼트 트리
	// 가장 짧은 것?

	// S이상이 된다...이거 세그먼트 아니야. 변경도 없어. 부분합 배열로 하면 여전히 N^2

	// 투포인터인가

	// 1정렬을 한다. nlonn =
	// 2. 양옆에서
	// 둘다 오른쪽에서,
	// 왼쪽을 내린다.
	// 그래도 S 이하이면 다시 왼쪽을 내린다.
	// S이상이면 오른쪽을 내린다.

	// 왼쪽 두개
	// 오른쪽 꺼리를 늘린다.
	// s이상이 될 때까지
	// s이상이면 왼쪽을 늘린다.
	// 만약 하나가 넘으면 2출력
	// 만약 e가 넘어가면 끝
	// 만약 s = e가 되면 끝

	// N, S N짜리 수열, 부분합이 S이상
	// N개

	// 2개 이상

	// 불가능하면 0출력

	// 부분합 배열에 투포인트를 해야 하는구나
