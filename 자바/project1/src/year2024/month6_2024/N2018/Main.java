package year2024.month6_2024.N2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int M = Integer.parseInt(br.readLine());

		int count = 1;
		int start = 1;
		int end = 1;
		int sum = 0;
		while (end <= M) {
			if (sum < M) {
				sum += end;
				end ++;
			} else if (sum > M) {
				sum -= start;
				start ++;
			} else if (sum == M) {
				count ++;
				sum -= start;
				start ++;
			}
		}

		System.out.println(count);

	}
}
