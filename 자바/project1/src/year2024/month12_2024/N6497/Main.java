package year2024.month12_2024.N6497;

import java.util.*;
import java.io.*;

public class Main {

	public static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String tc = br.readLine();

		while (!tc.equals( "0 0")) {
			st = new StringTokenizer(tc);
			int m = Integer.parseInt(st.nextToken()); // 집의 수
			int n = Integer.parseInt(st.nextToken()); // 길의 수

			PriorityQueue<Edge> adj = new PriorityQueue<>();
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				adj.add(new Edge(s, e, w));
				sum += w;
			}

			parent = new int[m + 1];
			for (int i = 1; i <= m; i++) {
				parent[i] = i;
			}

			int road = 0;
			int tmpSum = 0;
			while (road != m - 1 && !adj.isEmpty()) {
				Edge edge = adj.poll();
				int s = edge.s;
				int e = edge.e;
				int w = edge.w;

				if (find(s) != find(e)) {
					union(s, e);
					tmpSum += w;
					road++;
				}
			}

			tc = br.readLine();
			System.out.println(sum - tmpSum);
		}
	}


	public static class Edge implements Comparable<Edge> {
		int s;
		int e;
		int w;

		public Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		public int compareTo(Edge e) {
			return this.w - e.w;
		}
	}

	public static void union(int a, int b) {
		int ar = find(a);
		int br = find(b);

		if (ar < br) {
			parent[ar] = br;
		} else if (ar > br) {
			parent[br] = ar;
		}
	}

	public static int find(int a) {
		if (parent[a] == a) {
			return a;
		}

		return parent[a] = find(parent[a]);
	}
}

// 하루 길의 미터수만큼 비용
// 소등?
// 주의 절약할 수 있는 최대 액수


// 최소 비용
// 왕래 가능?
// 다 연결 -> 최소 신장트리

// m n( 집의 수, 길의 수)
// n 개의 줄
// x, y, z (거릭 z) 양방향 주의!
// 입력 끝이면 0 0
// 여러개의 테스트 케이스!
// while(00일때까지)
// 정렬
// union, find 구현
// 브랜치가 n - 1개까지
// find가 다르면 union
// 비용 더하기
// 전체 비용은 처음 계산