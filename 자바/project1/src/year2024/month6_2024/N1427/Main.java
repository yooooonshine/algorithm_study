package year2024.month6_2024.N1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] A = Arrays.stream(br.readLine().split("")).mapToLong(Long::parseLong).toArray();

		int index = 0;
		while (index < A.length) {
			long min = 1000000001L;
			int minIndex = index;
			for (int i = index; i < A.length; i++) {
				if (min > A[i]) {
					min = A[i];
					minIndex = i;
				}
			}
			swap(A, index, minIndex);
			index++;
		}

		for (long num : A) {
			System.out.print(num);
		}
	}
	public static void swap(long[] A, int index1, int index2) {
		long tmp = A[index1];
		A[index1] = A[index2];
		A[index2] = tmp;
	}
}

