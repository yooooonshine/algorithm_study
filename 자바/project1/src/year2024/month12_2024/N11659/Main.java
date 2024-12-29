package year2024.month12_2024.N11659;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] sum = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + arr[i];
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			System.out.println(sum[e] - sum[s - 1]);
		}
	}
}
