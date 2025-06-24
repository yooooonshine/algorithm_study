package year2025.month6.N1253;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			A[n] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		int count = 0;
		for (int n = 0; n < N; n++) {
			int s = 0;
			int e = N - 1;

			while (s < e) {
				if (s == n) {
					s++;
					continue;
				}
				if (e == n) {
					e--;
					continue;
				}

				if (A[n] < A[s] + A[e]) {
					e--;
				} else if (A[n] > A[s] + A[e]) {
					s++;
				} else {
					count++;
					break;
				}
			}
		}

		System.out.println(count);
	}
}