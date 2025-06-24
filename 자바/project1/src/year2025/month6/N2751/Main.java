package year2025.month6.N2751;

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

		mergeSort(arr, 1, N);

		for (int i = 1; i <= N; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void mergeSort(int[] arr, int s, int e) {
		if (s == e) {
			return;
		}

		int mid = (s + e) / 2;
		mergeSort(arr, s, mid);
		mergeSort(arr, mid + 1, e);

		int index = 0;
		int[] tmp = new int[e - s + 1];

		int s1 = s;
		int s2 = mid + 1;

		while (s1 <= mid && s2 <= e) {
			if (arr[s1] > arr[s2]) {
				tmp[index] = arr[s2];
				s2++;
			} else {
				tmp[index] = arr[s1];
				s1++;
			}
			index++;
		}
		while (s1 <= mid) {
			tmp[index] = arr[s1];
			s1++;
			index++;
		}
		while (s2 <= mid) {
			tmp[index] = arr[s2];
			s2++;
			index++;
		}

		for (int i = s; i <= e; i++) {
			arr[i] = tmp[i - s];
		}
	}
}

