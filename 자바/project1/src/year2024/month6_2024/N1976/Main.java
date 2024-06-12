package year2024.month6_2024.N1976;

import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 도시의 수
		int M = Integer.parseInt(br.readLine()); // 여행 도시 수

		int[][] adj = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (adj[i][j] == 1) {
					union(A, i, j);
				}
			}
		}

		int[] paths = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


		for (int i = 0; i < paths.length - 1; i++) {
			int node1 = paths[i];
			int node2 = paths[i + 1];

			int p1 = find(A, node1);
			int p2 = find(A, node2);

			if (p1 == p2) {
				continue;
			} else {
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");
	}

	public static int find(int[] A, int node) {
		if (node == A[node]) {
			return node;
		} else {
			return A[node] = find(A, A[node]);
		}
	}

	public static void union(int[] A, int node1, int node2) {
		int p1 = find(A, node1);
		int p2 = find(A, node2);

		if (p1 > p2) {
			A[p1] = p2;
		} else {
			A[p2] = p1;
		}
	}

}
