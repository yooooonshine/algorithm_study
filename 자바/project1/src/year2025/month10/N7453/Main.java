package year2025.month10.N7453;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] a1 = new int[N];
		int[] a2 = new int[N];
		int[] a3 = new int[N];
		int[] a4 = new int[N];

		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			a1[n] = Integer.parseInt(st.nextToken());
			a2[n] = Integer.parseInt(st.nextToken());
			a3[n] = Integer.parseInt(st.nextToken());
			a4[n] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a1);
		Arrays.sort(a2);
		Arrays.sort(a3);
		Arrays.sort(a4);

		int[] a34 = new int[N * N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a34[i * N + j] = a3[i] + a4[j];
			}
		}
		Arrays.sort(a34);

		int[] a12 = new int[N * N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a12[i * N + j] = a1[i] + a2[j];
			}
		}
		Arrays.sort(a12);

		int count = 0;




		for (int i1 = 0; i1 < N; i1++) {
			for (int i2 = 0; i2 < N; i2++) {
				int sum = a1[i1] + a2[i2];

				int left = 0;
				int right = N * N - 1;
				while (left <= right) {
					int mid = (left + right) / 2;
					int v = a34[mid];

					if (v + sum == 0) {
						int l = mid;
						int r = mid;

						while (l - 1 >= 0 && a34[l - 1] == v) {
							l--;
						}
						while (r + 1 < N * N && a34[r + 1] == v) {
							r++;
						}

						count += (r - l + 1);
						break;
					} else if (v + sum < 0) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}
			}
		}

		System.out.println(count);
	}
}

// 배열이 4개
// 2개의 배열에 대해서는 이중 for문
// 나머지 배여렝 대해서
