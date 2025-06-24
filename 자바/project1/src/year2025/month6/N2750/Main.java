package year2025.month6.N2750;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];
		for (int n = 1; n <= N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= N; i++) {
			int index = i;
			for (int j = 1; j <= i - 1; j++) {
				if (arr[j] > arr[i]) {
					index = j;
					break;
				}
			}

			int temp = arr[i];
			for (int j = i; j > index; j--) {
				arr[j] = arr[j - 1];
			}
			arr[index] = temp;
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(arr[i]);
		}
	}
}