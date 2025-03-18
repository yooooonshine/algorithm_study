package year2025.month3.N2428;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 솔루션 수
		long[] F = new long[N]; // 파일 크기

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			F[i] = Long.parseLong(st.nextToken()) * 10L;
		}

		// 오름차순 정렬
		Arrays.sort(F);

		int e = 1;
		long count = 0L;
		for (int s = 0; s < N; s++) {
			while (e < N && F[s] >= F[e] * 9L / 10L) {
				e++;
			}

			count += (long)(e - s - 1);
			e--;
		}
		System.out.println(count);
	}
}
// 18 20

// N명의 참석자
// 솔루션 파일 F1~Fn
// 두 파일을 비교해서 비슷한지 판별
// 파일 크기가 다른 경우는 쌍 검사 x
// 작은 파일 < 큰 파일 * 0.9 - 이건 검사 x
// size(Fi) ≤ size(Fj)이면서, size(Fi) ≥ 0.9 × size(Fj)

// 몇 개의 쌍을 검사?

// O(n)만가능하네. O(nlogn)도 가능하다.

// 이분탐색 x
// dp, 투포인트, 그리디
// dpx

// 투포인트로 잡았을 때
// 정렬해서 오름차순하고
// 시작은 왼쪽에서
// Fi >= 0.9 Fj 이면 카운터에 넣고
// 만약 이거 성립하지 않으면 i를 증가
// 성립하면 j를 증가

// 반대로 해야겠군
// 작은 파일 < 큰 파일 * 0.9 - 이건 검사 x
// 성립하면 검사 x, 작은 파일 ++
// 성립하지 않으면 큰 파일 ++, 카운트 증가
// 만약 같아졌는데 끝이아니면 큰파일 ++