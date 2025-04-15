package year2025.month4.N1477;

import java.util.*;
import java.io.*;

public class Main {

	public static int N, M, L;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 현재 휴게소 수
		int M = Integer.parseInt(st.nextToken()); // 추가 휴게소
		int L = Integer.parseInt(st.nextToken()); // 고속도로 길이

		int[] nowRest = new int[N + 2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nowRest[i] = Integer.parseInt(st.nextToken());
		}
		nowRest[N + 1] = L;
		Arrays.sort(nowRest);

		int s = 1;
		int e = L;
		while (s <= e) {
			int m = (s + e) / 2; // 최대 길이
			int remainRest = M;
			int madeCount = 0;

			for (int i = 0; i <= N; i++) {
				int length = nowRest[i + 1] - nowRest[i];
				int cut = length / m;

				madeCount += cut;

				if (length % m == 0) {
					cut -= 1;
				}
				remainRest -= cut;
			}

			if (remainRest == 0) {
				if (min > m) {
					min = m;
				}
				e = m - 1;
			} else if (remainRest < 0) {

				s = m + 1;
			} else {
				if (madeCount > remainRest) {
					min = Math.min(min, m);
					e = m - 1;
				} else {
					e = m - 1;
				}
			}
		}

		System.out.println(min);
	}
}

// 유료 고속도로
// 현재 휴게소 N개 + 추가 M개
// (있는 곳 x, 고속도로 끝 x, 정수위치)
// 휴게소 없는 구간의 길이의 최댓값을 최소


// 그리디 아닌가?

// 휴개소 N개 50
// 지을 휴게소 M개 100
// 고속도로 길이 L 1000


// 그리디 안되는 듯 길이 3에 대해 2번 짓는다면 1,2가 되어야 함.
// dp? 이분탐색?

// 최대 길이를 통해 이분 탐색(길이 Max로)

// s <= e
//
