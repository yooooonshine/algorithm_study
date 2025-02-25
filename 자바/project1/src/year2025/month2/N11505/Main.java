package year2025.month2.N11505;

import java.util.*;
import java.io.*;

public class Main {
	public static long[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int k = 0;
		while ((int)Math.pow((long)2, k) < N) {
			k++;
		}

		int size = (int)Math.pow((long)2, k + 1);
		int index = size / 2;

		tree = new long[size];
		Arrays.fill(tree, 1L);

		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			tree[index + i] = num;
		}

		for (int i = index - 1; i >= 1; i--) {
			tree[i] = tree[i * 2] * tree[i * 2 + 1] % 1000000007L;
		}

		for (int i = 1; i <= M + K; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());

			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());

				replace(index + b - 1, c);
			} else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				calc(index + b - 1, index + c - 1);
			}
		}
	}

	public static void calc(int s, int e) {
		Stack<Long> myS = new Stack<>();

		while (s <= e) {
			if (s % 2 == 1) {
				myS.add(tree[s]);
				s++;
			}

			if (e % 2 == 0) {
				myS.add(tree[e]);
				e--;
			}

			s /= 2;
			e /= 2;
		}

		long result = 1L;
		while (!myS.isEmpty()) {
			result *= myS.pop();
			result %= 1000000007L;
		}

		System.out.println(result);
	}

	public static void replace(int index, long value) {
		tree[index] = value;
		index /= 2;

		while (index >= 1) {
			tree[index] = tree[index * 2] * tree[index * 2 + 1] % 1000000007L;
			index /= 2;
		}
	}
}

// N개의 수
// 수의 변경
// 부분?
// 투포인트, 구간합, 세그먼트 트리

// N M K (수의 개수, 변경횟수, 구간의 곲 횟수)
// N번 동안 N개의 수
// M + K번, a b c
// a가 1이면 b -> c로
// a가 2이면 b부터 c까지의 곱



// 세그먼트 트리
// 트리의 깊이 측정
// 깊이는 2^n > N인 n 구하고
// 2^(n + 1)만큼
// 인덱스 2^(n) 부터 채우기
// 0번은 사용x

// 채우기
// 2^(n) - 1부터 2배 및 2배  + 1

// 세그먼트 트리 변경
// 올라가면서 tmp로 나누고 새 값 곱하기
// 혹은 밑 바꾸고 올라가면서 새로 갱신
//

// 세그먼트 트리 구간 곱 구하기
// while (s <= e)
// s가 홀수면 리스트에 더하고 + 1
// e가 짝수면 리스트에 더하고 - 1
// s / 2
// e / 2