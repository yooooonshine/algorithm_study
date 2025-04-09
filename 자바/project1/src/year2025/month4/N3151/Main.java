package year2025.month4.N3151;

import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[] A;
	public static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // N명
		A = new int[N]; // 0부터

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);

		for (int i = 0; i < N; i++) {
			twoPointer(i, i + 1, N - 1);
		}
		System.out.println(count);
	}

	// 합이 0보다 작음면, m ++
	// 합이 0보다 크면 e--
	// 같으면 개수찾기

	public static void twoPointer(int s,int m, int e) {
		while (m < e) {
			int sum = A[s] + A[m] + A[e];

			if (sum < 0) {
				m++;
			} else if (sum > 0) {
				e--;
			} else {
				int lv = A[m];
				int rv = A[e];

				if (lv == rv) {
					// A[m] == A[e] 이면 (e - m + 1)개 중에서 2개를 고름
					int len = e - m + 1;
					count += len * (len - 1) / 2;
					break;
				}

				int lc = 0;
				int rc = 0;

				int tmpM = m;
				while (tmpM < e && lv == A[tmpM]) {
					lc++;
					tmpM++;
				}
				int tmpE = e;
				while (tmpE > m && rv == A[tmpE]) {
					rc++;
					tmpE--;
				}

				count += lc * rc;

				m = tmpM;
				e = tmpE;
			}
		}
	}
}
