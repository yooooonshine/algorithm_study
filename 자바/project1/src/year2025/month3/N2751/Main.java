package year2025.month3.N2751;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Queue<Integer> minus = new LinkedList<>();
		Queue<Integer> plus = new LinkedList<>();

		int minusMaxD = 0;
		int plusMaxD = 0;

		for (int i = 1; i <= N; i++) {
			if (arr[i] < 0) {
				if (Integer.toString((int)Math.abs(arr[i])).length() > minusMaxD) {
					minusMaxD = Integer.toString((int)Math.abs(arr[i])).length();
				}

				minus.add(Math.abs(arr[i]));
			} else {
				if (Integer.toString(arr[i]).length() > plusMaxD) {
					plusMaxD = Integer.toString(arr[i]).length();
				}

				plus.add(arr[i]);
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 음수
		radixSort(minus, minusMaxD);
		Stack<Integer> stack = new Stack<>();
		while (!minus.isEmpty()) {
			stack.add(minus.poll());
		}
		while (!stack.isEmpty()) {
			bw.write("-" + stack.pop() + "\n");
		}

		// 양수
		radixSort(plus, plusMaxD);

		while (!plus.isEmpty()) {
			bw.write(plus.poll() + "\n");
		}

		bw.flush();
	}

	public static void radixSort(Queue<Integer> arr, int maxD) {
		Queue<Integer>[] qs = new LinkedList[10];//0~9
		for (int i = 0; i <= 9; i++) {
			qs[i] = new LinkedList<>();
		}

		for (int i = 1; i <= maxD; i++) {
			while(!arr.isEmpty()) {
				int num = arr.poll();

				int digit = getDigitN(num, i);

				qs[digit].add(num);
			}

			for (int j = 0; j <= 9; j++) {
				while (!qs[j].isEmpty()) {
					arr.add(qs[j].poll());
				}
			}
		}
	}

	public static int getDigitN(int v, int d) {
		v %= (int)Math.pow(10, d);

		return v / (int)Math.pow(10, d - 1);
	}
}


// 음수, 양수 존재
