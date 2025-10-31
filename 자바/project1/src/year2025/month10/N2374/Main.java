package year2025.month10.N2374;

import java.util.*;
import java.io.*;

public class Main {

	public static long[] A;
	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		long max = Long.MIN_VALUE;

		A = new long[N + 1];
		for (int n = 1; n <= N; n++) {
			A[n] = Long.parseLong(br.readLine());

			if (max < A[n]) {
				max = A[n];
			}
		}

		System.out.println(recursion(1, N, max));
	}

	public static long recursion(int s, int e, long beforeMax) {

		boolean flat = true;

		long max = Long.MIN_VALUE;
		for (int n = s; n <= e; n++) {
			if (max < A[n]) {
				max = A[n];
			}
		}

		// 평평
		for (int n = s; n < e; n++) {
			if (A[n] != A[n + 1]) {
				flat = false;
			}
		}

		// 평평하면
		if (flat) {
			return beforeMax - max;
		}

		// 평평하지 않으면

		// 이전과 같으면 ++
		// 이전과 다르면
		// 재귀, ms, me 초ㄱ화
		// 다른 지점 찾기

		long result = beforeMax - max;

		for (int n = s; n <= e; n++) {
			if (A[n] == max) {
				continue;
			} else {

				int ts = n;
				int te = n;

				for (int t = n + 1; t <= e; t++) {
					if (A[t] == max) {
						break;
					}
					te++;
				}

				result += recursion(ts, te, max);
				n = te;
			}
		}

		return result;
	}
}
// 각 구간이 몇회인지가 중요하네
// 모든 구간이 플랫하면 MAX로 리턴
// 플랫하지 않으면 MAX 말고 모두 RECURSION


// n(1000까지)개의 자연수 A[i]
// Add(i) -> A[i]가 1증가
// 좌우 같은 수의 그룹도 1씩 증가

// 모든 A[i]가 같도록 하는 최소 연산

// 최대 연산수가 10^9승이네

// 이분탐색, 투포인트, dp, 그리디,

// 이분탐색

// 1 5 10

// 무조건 최대 높이겠는데?

// 일정 수가 들어오고, 최대 높이를 주어진다.
// 같은 구간으로 나누기
// 단일 구간이 나오면, 그 최대 높이를 만드는데 드는 비용리턴
// 두개이면 각 리턴 값 구하고, 지금 최대에서 주어진 최대만들기
// 그걸 다시 함수로 넣기

//



// 1 3 5 3

// 출력값은 long 써야 겠다.

