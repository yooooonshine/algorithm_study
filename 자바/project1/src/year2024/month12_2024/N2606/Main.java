package year2024.month12_2024.N2606;

import java.util.*;
import java.io.*;

public class Main {
	public static List<List<Integer>> adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); // 컴퓨터 수
		int k = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수

		adj = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			adj.get(s).add(e);
			adj.get(e).add(s);
		}

		int count = dfs(n, 1);

		System.out.println(count - 1);
	}

	public static int dfs(int n, int start) {
		Stack<Integer> s = new Stack<>();
		boolean[] visit = new boolean[n + 1];

		s.add(start);

		int count = 0;
		while (!s.isEmpty()) {
			Integer tmp = s.pop();

			if (visit[tmp]) {
				continue;
			}
			visit[tmp] = true;
			count++;

			for (Integer i : adj.get(tmp)) {
				s.add(i);
			}
		}

		return count;
	}
}
