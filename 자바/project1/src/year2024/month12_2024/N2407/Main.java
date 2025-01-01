package year2024.month12_2024.N2407;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		BigInteger[][] arr = new BigInteger[n + 1][n + 1]; // n은 1부터
		for (int i = 1; i <= n; i++) {
			arr[i][0] = new BigInteger("1");
			arr[i][1] = new BigInteger("" + i);
		}
		for (int i = 2; i <= n; i++) {
			arr[i][i] = new BigInteger("1");
		}

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, m); j++) {
				if (j == 0 || j == i) {
					arr[i][j] = new BigInteger("1");
				} else {
					arr[i][j] = arr[i - 1][j - 1].add(arr[i - 1][j]);
				}
			}
		}

		System.out.println(arr[n][m]);
	}
}



// nCr = n-1Cr + n-1Cr-1
// nCn = 1
// nC1 = n
// nC0 = 1
