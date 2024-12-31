package year2024.month12_2024.N2230;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // N개의 줄
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int min = Integer.MAX_VALUE;

		Arrays.sort(arr);

		int s = 0;
		int e = 0;


		while (s <= e && e <= N - 1) {
			if (arr[e] - arr[s] >= M) {
				if (min > arr[e] - arr[s]) {
					min = arr[e] - arr[s];
				}
			}
			if (arr[e] - arr[s] >= M) {
				s++;
			} else {
				e++;
			}
		}

		System.out.println(min);
	}
}


// N, M (n개의 정수, 차이가 M이상)
// N 개의 줄 A

//1 정렬을 한다.

// 2. 투포인터로 이동한다.
// 시작은 모두 1에서
// s <= e 이고  e <= N 까지 반복한다
// 최소 갱신한다
// M보다 크거나 같으면 s를 키운다.
// M보다 작으면 e를 늘린다