package year2025.month6.N10989;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int maxDigit = 0;
		int[] arr = new int[N + 1];
		for (int n = 1; n <= N; n++) {
			arr[n] = Integer.parseInt(br.readLine());

			maxDigit = Math.max(maxDigit, digit(arr[n]));
		}

		List<Queue<Integer>> buckets = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			buckets.add(new LinkedList<>());
		}

		for (int d = 0; d < maxDigit; d++) {
			for (int n = 1; n <= N; n++) {
				int digit = getDigit(arr[n], d);
				buckets.get(digit).add(arr[n]);
			}

			int index = 1;
			for (int i = 0; i < 10; i++) {
				while (!buckets.get(i).isEmpty()) {
					arr[index++] = buckets.get(i).poll();
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(arr[i]);
		}
	}

	public static int digit (int a) {
		return String.valueOf(a).length();
	}

	public static int getDigit(int a, int d) {
		return a / (int)Math.pow(10, d) % 10;
	}
}

