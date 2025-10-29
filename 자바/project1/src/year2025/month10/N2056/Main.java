package year2025.month10.N2056;

import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 작업 수

		List<List<Edge>> adj = new ArrayList<>();
		for (int n = 0; n <= N; n++) {
			adj.add(new ArrayList<>());
		}

		// 진입 차수
		int[] inDegree = new int[N + 1];

		// 작업 비용
		int[] expense = new int[N + 1];

		// 연관 작업 받기
		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int t = Integer.parseInt(st.nextToken()); // 걸리는 시간
			int count = Integer.parseInt(st.nextToken()); // 선행 관계의 작업 수

			expense[n] = t;

			for (int c = 1; c <= count; c++) {
				int v = Integer.parseInt(st.nextToken());

				adj.get(v).add(new Edge(n, t));
				inDegree[n]++;
			}
		}

		int min = 0;

		Queue<Edge> myQ = new LinkedList<>();

		for (int n = 1; n <= N; n++) {
			if (inDegree[n] == 0) {
				myQ.add(new Edge(n, expense[n]));
			}
		}

		while (!myQ.isEmpty()) {
			Edge now = myQ.poll();
			int nowE = now.e;
			int t = now.t;

			if (adj.get(nowE).size() == 0) {
				if (min < t) {
					min = t;
				}
			}

			for (Edge next : adj.get(nowE)) {
				inDegree[next.e]--;


				myQ.add(new Edge(next.e, t + next.t));
			}
		}

		System.out.println(min);
	}

	public static class Edge {
		int e;
		int t;

		public Edge(int e, int t) {
			this.e = e;
			this.t = t;
		}
	}
}

// N개의 수행 작업. 시간이 1~100
// 선행관계 K번의 선행 작업들은 1 ~ K - 1
// 선행 관계가 없는 작업이 반드시 하나 이상 존재
// 선행 관계가 없는 작업은 동시 수행 가능

// 모든 작업 최소 시간

// 토폴로지 소트

