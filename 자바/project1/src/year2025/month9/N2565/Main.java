package year2025.month9.N2565;

import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 전봇대 사이의 전깃줄 수

		List<Edge> edges = new ArrayList<>();
		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges.add(new Edge(a, b));
		}

		Collections.sort(edges);

		int[] dp = new int[N];
		Arrays.fill(dp, 1);

		for (int i = 0; i < edges.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[i] < dp[j] + 1 && edges.get(i).e > edges.get(j).e) {

					dp[i] = dp[j] + 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			if (max < dp[i]) {
				max = dp[i];
			}
		}

		System.out.println(N - max);
	}

	public static class Edge implements Comparable<Edge> {
		int s;
		int e;

		public Edge(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Edge edge) {
			return this.s - edge.s;
		}
	}
}

// 언제 겹칠까
// a1, a2
// b1, b2 일때
// a1 > b1 & a2 < b2 혹은 a1 < b1 & a2 > b2

// 그리디 한가?

// 각 줄이 겹치는 A 모두 구하기 각각 Set으로
// 모두 0이 될 때까지 Set이 가장 많은 A 제거 및 다른 Set 반영 -> 100번
