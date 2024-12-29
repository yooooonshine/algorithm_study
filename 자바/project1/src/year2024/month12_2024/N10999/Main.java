package year2024.month12_2024.N10999;

import java.util.*;
import java.io.*;

public class Main {

	public static long[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Long N = Long.parseLong(st.nextToken());
		Long M = Long.parseLong(st.nextToken());
		Long K = Long.parseLong(st.nextToken());

		int k = 0;
		while (Math.pow(2, k) < N) {
			k++;
		}

		tree = new long[(int) Math.pow(2, k + 1)];
		int start = (int)Math.pow(2, k);

		for (int i = 0; i < N; i++) {
			long tmp = Long.parseLong(br.readLine());
			tree[start + i] = tmp;
		}

		for (int i = start - 1; i >= 1; i--) {
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}

		for (int i = 1; i <= M + K; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());

			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long d = Long.parseLong(st.nextToken());

				update(start + b - 1,start + c - 1, d);

			} else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				System.out.println(see(start + b - 1,start + c - 1));
			}
		}
	}

	public static void update(int s, int e, long p) {

		for (int i = s; i <= e; i++) {
			int index = i;

			tree[index] = tree[index] + p;

			while (index != 1) {
				tree[index / 2] = tree[index / 2] + p;

				index = index / 2;
			}
		}
	}

	public static long see(int s, int e) {
		long sum = 0;

		while (s <= e) {
			if (s % 2 == 1) {
				sum += tree[s];
			}
			if (e % 2 == 0) {
				sum += tree[e];
			}
			s = (s + 1) / 2;
			e = (e - 1) / 2;
		}

		return sum;
	}
}

// N개의 수
// 수의 변경? 합 ?세그먼트 트리?
// N M K 숫자, 수의 변경 수, 구간 합을 구하는 횟수
// n번 반복 N개의 수
// M + K 번
// a b c a가 2인 경우 b~c합 구하기
// a b c d a가 1인 경우 b~c에 d 더하기

// int 4바이트 ->  32 비트
// long이 8바이트 -> 64비트


// 세그먼트 트리이다.

// 구성
// 2 ^ k > n인 k를 찾는다
// 2 ^ (k + 1) 배열 사용. 1번부터 사용
// 2 ^ k + 1부터 배열 채우기
// 2 ^ k부터 앞으로 채우기
// 2, 2 + 1

// 업데이트
// 현재 값과, 매 부모노드의 값을 더하고 뺀다.

// 조회
// 만약 s % 2 == 1이면 배열에 더한다
// 만약 e % 2 == 0이면 배열에 더한다
// (s + 1) / 2로 s 이동
// (e - 1_ / 2로 e 이동

// 인덱스 조심!!

// 변경 최악의 경우가 10^11승이다.
// N번 업데이트 하면 안된다.
// 한번에 업데이트 가능한가

// 더해지는 값의 구간합을 따로 구해 저장해둔다?
// 최소 공통 조상을 구한다? 아닌데 양 끝이 문제잖아.

// 비슷한 문제 봤었잖아
// 그 떄 어떻게 처리했지?