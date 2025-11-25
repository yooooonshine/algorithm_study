package year2025.month11.N20117;

import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static List<List<Integer>> adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int s = 0;
		int e = N - 1;

		long sum = 0L;
		while (s <= e) {
			if (s == e) {
				sum += (long)arr[e];
			} else {
				sum += (long)(arr[e] * 2);
			}
			s++;
			e--;
		}

		System.out.println(sum);
	}
}

// N개의 호반우
// 묶음 팔기(부분지합)
// 풀질만큼의 가격
// 묶음의 중앙값으로 팔기
// 짝수면 (묶음 개수/2 + 1)를 중앙값
// 홀수면 (묶음 개수 + 1)/2

// 얻을 수 있는 최대 이익

// 중앙 갚을 크게 해야 해나.

// 이진탐색
// 그리디
// 완전탐색

// 2개인경우 큰거랑 작은 거 합치는게 무조건 이득이야
// 근데 최대이득임을 보장할 수는 없나

// 중앙값이 평균보다 낮으면 합치면 안된다.

// 1 3 4 5 6

 // 12, 10, 4
// 1 3 4
//  9,