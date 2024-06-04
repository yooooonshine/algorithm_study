package year2024.month6_2024.N2750;

import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		for (int i = N - 1; i >= 1; i--) {
			boolean isSwapped = false;
			for (int j = 0; j < i; j++) {
				if (A[j] > A[j + 1]) {
					swap(A, j, j + 1);
					isSwapped = true;
				}
			}
			if (!isSwapped) {
				break;
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(A[i] + " ");
		}
	}

	public static void swap(int[] A, final int element1, final int element2) {
		int tmp = A[element1];

		A[element1] = A[element2];
		A[element2] = tmp;
	}
}