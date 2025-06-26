package year2025.month6.N2251;

import java.util.*;
import java.io.*;

public class Main {

	public static List<Case> cases = new ArrayList<>();
	public static int A;
	public static int B;
	public static int C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		recursion(0, 0, C);

		List<Integer> result = new ArrayList<>();

		for (Case case1 : cases) {
			int a = case1.a;
			int b = case1.b;
			int c = case1.c;

			if (a == 0) {
				result.add(c);
			}
		}

		Collections.sort(result);
		for (int a : result) {
			System.out.print(a + " ");
		}
	}

	public static void recursion(int a, int b, int c) {
		if (existCase(a, b, c)) {
			return;
		}
		cases.add(new Case(a, b, c));

		if (a != 0) {
			if (B - b - a < 0) {
				recursion(b + a - B, B, c);
			} else {
				recursion(0, b + a, c);
			}
			if (C - c - a < 0) {
				recursion(c + a - C, b, C);
			} else {
				recursion(0, b, c + a);
			}
		} if (b != 0) {
			if (A - a - b < 0) {
				recursion(A, a + b - A, c);
			} else {
				recursion(b + a, 0, c);
			}
			if (C - c - b < 0) {
				recursion(a, c + b - C, C);
			} else {
				recursion(a, 0, b + c);
			}
		} else {
			if (A - c - a < 0) {
				recursion(A, b, c + a - A);
			} else {
				recursion(a + c, b, 0);
			}
			if (B - c - b < 0) {
				recursion(a, B, c + b - B);
			} else {
				recursion(a, b + c, 0);
			}
		}
	}

	public static boolean existCase(int a, int b, int c) {
		for (Case case1 : cases) {
			if (case1.a == a && case1.b == b && case1.c == c) {
				return true;
			}
		}

		return false;
	}

	public static class Case {
		int a;
		int b;
		int c;

		public Case(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
}

