package year2024.month6_2024.N2023;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i < 10; i++) {
			dfs(i, N);
		}
	}

	public static void dfs(int num, int N) {
		if (!isPrime(num) || !isDigit(num, N)) {
			return;
		}
		if (isBiggerThanN(num, N)) {
			System.out.println(num);
		}
		for (int i = 0; i < 10; i++) {
			dfs(num * 10 + i, N);
		}
	}

	public static boolean isPrime(int num) {
		if (num == 1) {
			return false;
		}
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isDigit(int num, int N) {
		int digit = 1;
		for (int i = 0; i < N; i++) {
			digit *= 10;
		}
		return num < digit;
	}

	public static boolean isBiggerThanN(int num,int N) {
		int digit = 1;
		for (int i = 0; i < N - 1; i++) {
			digit *= 10;
		}
		return num >= digit;
	}
}

