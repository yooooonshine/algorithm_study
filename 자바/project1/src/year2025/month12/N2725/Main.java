package year2025.month12.N2725;

import java.util.*;
import java.io.*;

public class Main {

	BufferedWriter bw;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}

		// 선택 정렬
		for (int i = N - 1; i >= 0; i--) {
			int max = arr[0];
			int maxIndex = 0;

			for (int j = 1; j <= i; j++) {
				if (arr[j] > max) {
					max = arr[j];
					maxIndex = j;
				}
			}

			int temp = arr[i];
			arr[i] = arr[maxIndex];
			arr[maxIndex] = temp;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int n = 0; n < N; n++) {
			bw.write(arr[n] + "\n");
		}
		bw.flush();
	}
}

// 1 3 5 7