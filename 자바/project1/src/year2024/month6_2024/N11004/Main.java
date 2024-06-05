package year2024.month6_2024.N11004;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		quickSort(A, 0, N - 1);

		bw.write(A[K - 1] + " ");
		bw.flush();
		bw.close();
	}

	public static void quickSort(int[] A, int start, int end) {
		if (start >= end) {
			return;
		} else if (start + 1 == end) {
			if (A[start] > A[end]) {
				swap(A, start, end);
			}
			return;
		}
		swap(A, start, (start + end) / 2);
		int pivotIndex = start;
		int startIndex = start + 1;
		int endIndex = end;

		while (startIndex < endIndex) {
			if (A[startIndex] > A[pivotIndex] && A[pivotIndex] > A[endIndex]) {
				swap(A, startIndex, endIndex);
			} else if (A[startIndex] <= A[pivotIndex]) {
				startIndex++;
			} else {
				endIndex--;
			}
		}
		if (A[startIndex] > A[pivotIndex]) {
			swap(A, pivotIndex, startIndex - 1);
			pivotIndex = startIndex - 1;
		} else {
			swap(A, pivotIndex, startIndex);
			pivotIndex = startIndex;
		}

		quickSort(A, start, pivotIndex - 1);
		quickSort(A, pivotIndex + 1, end);
	}


	public static void swap(int[] A, int start, int end) {
		int tmp = A[start];
		A[start] = A[end];
		A[end] = tmp;
	}
}

