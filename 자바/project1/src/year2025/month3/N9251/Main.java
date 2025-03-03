package year2025.month3.N9251;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str1 = br.readLine().split("");
		String[] str2 = br.readLine().split("");

		int s1L = str1.length;
		int s2L = str2.length;

		int[][] dp = new int[s1L + 1][s2L + 1];

		for (int r = 1; r <= s1L; r++) {
			for (int c = 1; c <= s2L; c++) {

				int l = dp[r][c - 1];
				int u = dp[r - 1][c];
				if (str1[r - 1].equals(str2[c - 1])) {
					dp[r][c] = Math.max(l, u) + 1;
				} else {
					dp[r][c] = Math.max(l, u);
				}

			}
		}

		System.out.println(dp[s1L][s2L]);
	}
}
