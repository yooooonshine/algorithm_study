package year2024.month12_2024.N11725;

import java.util.*;
import java.io.*;

public class Main {

	public static List<List<Integer>> adj;
	public static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		adj = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 1; i <= N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			adj.get(s).add(e);
			adj.get(e).add(s);
		}

		parent = new int[N + 1];

		dfs(N);

		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}

	public static void dfs(int N) {
		Stack<Integer> myS = new Stack<>();
		boolean[] visit = new boolean[N + 1];

		myS.add(1);

		while (!myS.isEmpty()) {
			int p = myS.pop();

			if (visit[p]) {
				continue;
			}
			visit[p] = true;

			for (int k : adj.get(p)) {
				if (visit[k]) {
					continue;
				}
				myS.add(k);
				parent[k] = p;
			}
		}
	}
}

// 노드의 개수
// N - 1 개의 연결 두 지점


// 1. adj로 저장한다.
// 2 dfs나 bfs로 순회하면서 부모노드를 저장한다.