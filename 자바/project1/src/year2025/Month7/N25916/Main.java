package year2025.Month7.N25916;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 구멍 수
		int M = Integer.parseInt(st.nextToken()); // 부피

		int[] A = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			A[n] = Integer.parseInt(st.nextToken());
		}

		int s = 1;
		int e = 1;
		int sum = A[s];

		int max = 0;

		while (e <= N) {
			if (sum <= M && max < sum) {
				max = sum;
			}

			if (sum >= M) {
				sum -= A[s];
				s++;
			} else {
				e++;
				if (e > N) {
					break;
				}
				sum += A[e];
			}

			if (e < s) {
				if (s > N) {
					break;
				}
				sum = A[s];
				e = s;
			}
		}

		System.out.println(max);
	}
}

// 햄스터 부피 M
// N개의 구멍이 일렬로
// i번째 구멍의 크기는 Ai  -> 정확히 이 크기만큼 부피 소모
