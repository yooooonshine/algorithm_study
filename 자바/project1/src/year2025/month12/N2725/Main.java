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

		// 정렬
		for (int n = N - 2; n >= 0; n--) {
			for (int s = 0; s <= n; s++) {
				if (arr[s] > arr[s + 1]) {
					int tmp = arr[s + 1];
					arr[s + 1] = arr[s];
					arr[s] = tmp;
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int n = 0; n < N; n++) {
			bw.write(arr[n] + "\n");
		}
		bw.flush();
	}
}
