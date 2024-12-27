package year2024.month12_2024.N11437;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 1; i <= N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj.get(a).add(b);
			adj.get(b).add(a);
		}

		int[][] tree = new int[2][N + 1]; // 0번은 부모노드, 1번은 깊이

		// bfs
		Stack<Edge> myS = new Stack<>();
		boolean[] visit = new boolean[N + 1];

		myS.add(new Edge(1, 0));

		while (!myS.isEmpty()) {
			Edge edge = myS.pop();

			// 뱡문 체크
			if (visit[edge.e]) {
				continue;
			}
			visit[edge.e] = true;

			for (int tmp : adj.get(edge.e)) {
				if (!visit[tmp]) {

					myS.add(new Edge(tmp, edge.d + 1));

					tree[0][tmp] = edge.e;
					tree[1][tmp] = edge.d + 1;
				}
			}
		}

		// 높이 맞추기
		// 같이 올라가기

		int M = Integer.parseInt(br.readLine()); // 쌍 ㄱ수

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int high;
			int low;
			if (tree[1][a] >= tree[1][b]) {
				high = b;
				low = a;
			} else {
				high = a;
				low = b;
			}

			while (tree[1][high] != tree[1][low]) {
				low = tree[0][low];
			}

			while (high != low) {
				high = tree[0][high];
				low = tree[0][low];
			}

			System.out.println(high);
		}
	}


	public static class Edge {
		int e;
		int d;

		public Edge(int e, int d) {
			this.e = e;
			this.d = d;
		}
	}
}


// 공통 조상


// N (N개의 점)
// N - 1번 반복
// 두 정점 a, b
// M (알고싶은 쌍의 개수)
// M개의 줄
// 정점 쌍

// 최대 50000 * 10000 = 5 * 10^8 => 5초?

// 2^N 없이 간다면?

// 트리를 생성한다
// 인덱스, 깊이, 부모노드를 저장하는 배열을 만든다.
// bfs를 활용한다.
// stack 생성
// 탐사하며, Edge에는 다음 노드와 깊이를 저장한다.
// 방문시 깊이, 부모노드를 저장한다.

// 최소 공통 조상 찾기
// 높이를 맞춘다
// 두 높이 차를 구한다.
// 더 적은 쪽을 그만큼 올린다. 높이가 같아지면 멈춘다.
// 같이 올라간다.
// 두 값이 같아질떄까지 올라간다.
