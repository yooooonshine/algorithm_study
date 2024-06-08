package year2024.month6_2024.N1167;

import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());

		List<Map<Integer, Integer>> adj = new ArrayList<>();
		adj.add(null);
		for (int i = 1; i <= V; i++) {
			Map<Integer, Integer> tmpMap = new HashMap<>();
			adj.add(tmpMap);
		}

		StringTokenizer st;
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());

			while (true) {
				int node1 = Integer.parseInt(st.nextToken());
				if (node1 == -1) {
					break;
				}
				int distance = Integer.parseInt(st.nextToken());

				adj.get(node).put(node1, distance);
				adj.get(node1).put(node, distance);
			}
		}

		int max = 0;
		for (int i = 1; i <= V; i++) {
			int distance = bfs(V, adj, i);
			if(max < distance) {
				max = distance;
			}
		}

		System.out.println(max);
	}

	public static int bfs(int N, List<Map<Integer, Integer>> adj, int node) {
		boolean[] visit = new boolean[N + 1];

		int max = 0;
		Queue<Integer[]> myQueue = new LinkedList<>();
		Integer[] tmpA = {node, 0};
		myQueue.add(tmpA);

		while(!myQueue.isEmpty()) {
			Integer[] visitNodeInfo = myQueue.poll();
			int visitNode = visitNodeInfo[0];
			int distance = visitNodeInfo[1];

			if (visit[visitNode]) {
				continue;
			}
			if (max < distance) {
				max = distance;
			}
			visit[visitNode] = true;

			Map<Integer, Integer> visitNodeAdj = adj.get(visitNode);
			Set<Integer> keyValues = visitNodeAdj.keySet();
			for (int i : keyValues) {
				if (!visit[i]) {
					myQueue.add(new Integer[] {i, distance + visitNodeAdj.get(i)});
				}
			}
		}
		return max;
	}
}

