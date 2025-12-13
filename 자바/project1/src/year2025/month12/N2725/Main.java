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

		// 퀵정렬
		quickSort(arr, 0, N - 1);


		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int n = 0; n < N; n++) {
			bw.write(arr[n] + "\n");
		}
		bw.flush();
	}

	public static void quickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}

		int pivot = partition(arr, left, right);

		quickSort(arr, left, pivot - 1);
		quickSort(arr, pivot + 1, right);
	}

	public static int partition(int[] arr, int left, int right) {
		int pivot = left;

		int s = left + 1;
		int e = right;

		while (s <= e) {
			if (arr[s] < arr[pivot]) {
				s++;
			} else if (arr[e] > arr[pivot]) {
				e--;
			} else {
				int temp = arr[s];
				arr[s] = arr[e];
				arr[e] = temp;
				s++;
				e--;
			}
		}

		pivot = e;
		int tmp = arr[left];
		for (int i = left; i < pivot; i++) {
			arr[i] = arr[i + 1];
		}
		arr[pivot] = tmp;

		return pivot;
	}
}

// 1 3 5 7