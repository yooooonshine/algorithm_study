package year2024.month6_2024.N10989;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}



		radixSort(A);

		for (int num : A) {
			bw.write(num + "\n");
		}
		bw.flush();
		bw.close();
	}

	public static void radixSort(int[] A) {
		Map<Integer, Queue<Integer>> numMap = new HashMap<>();
		for (int i = 0; i <= 9; i++) {
			Queue<Integer> tmp = new LinkedList<>();
			numMap.put(i, tmp);
		}

		int maxRadix = 0;
		for (int i = 0; i < A.length; i++) {
			int radix = calcRadix(A[i]);

			if (radix > maxRadix) {
				maxRadix = radix;
			}
		}

		for (int i = 1; i <= maxRadix; i++) {
			for (int j = 0; j < A.length; j++) {
				int nthNumber = calcNthNumber(A[j], i);
				numMap.get(nthNumber).add(A[j]);
			}
			int index = 0;
			for (int j = 0; j <= 9; j++) {
				Queue<Integer> tmp = numMap.get(j);
				while(!tmp.isEmpty()) {
					A[index] = tmp.poll();
					System.out.println(A[index]);
					index++;
				}
			}
		}
	}

	public static int calcRadix(int num) {
		return Integer.toString(num).length();
	}

	public static int calcNthNumber(int num, int n) {
		String numStr = Integer.toString(num);
		if (n > numStr.length()) {
			return 0;
		}

		return Integer.parseInt(String.valueOf(numStr.charAt(numStr.length() - n)));
	}
}
