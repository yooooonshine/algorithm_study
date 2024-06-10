package year2024.month6_2024.N1707;

import java.util.*;
import java.io.*;

class Main {
	public static int[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine());

		for (int j = 0; j < K; j++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			visit = new int[V + 1];

			List<List<Integer>> adj = new ArrayList();
			for (int i = 0; i <= V; i++) {
				adj.add(new ArrayList<Integer>());
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				adj.get(start).add(end);
				adj.get(end).add(start);
			}
			for (int i = 1; i <= V; i++) {
				if (visit[i] == 0) {
					bfs(adj, i);
				}
			}
			boolean result = true;
			for (int i = 1; i < adj.size(); i++) {
				for (int k : adj.get(i)) {
					if (visit[i] == visit[k]) {
						result = false;
					}
				}
			}
			if (result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}


	// 0은 방문x
	// 1은 검정색
	// 2는 흰색
	public static void bfs(List<List<Integer>> adj, int start) {
		Queue<Integer> myQ = new LinkedList<>();

		myQ.add(start);
		visit[start] = 1;

		while (!myQ.isEmpty()) {
			int visitNode = myQ.poll();
			int color = visit[visitNode];

			List<Integer> adjNodes = adj.get(visitNode);
			for (int i = 0; i < adjNodes.size(); i++) {
				if (visit[adjNodes.get(i)] == 0) {
					if (color == 1) {
						visit[adjNodes.get(i)] = 2;
					} else {
						visit[adjNodes.get(i)] = 1;
					}
					myQ.add(adjNodes.get(i));
				}
			}
		}
	}


}