package year2024.month12_2024.N9372;

import java.util.*;
import java.io.*;

public class Main {

	public static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 태스트케이스

		for (int i = 1; i <= T; i++) {
			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);
			int M = Integer.parseInt(tmp[1]);

			List<Edge> list = new ArrayList<>();
			for (int j = 1; j <= M; j++) {
				String[] tmp1 = br.readLine().split(" ");
				int a = Integer.parseInt(tmp1[0]);
				int b = Integer.parseInt(tmp1[1]);

				list.add(new Edge(a, b));
			}

			parent = new int[N + 1];
			for (int j = 1; j <= N; j++) {
				parent[j] = j;
			}

			int sum = 0;
			for (Edge edge : list) {

				if (find(edge.s) != find(edge.e)) {
					union(edge.s, edge.e);

					sum++;

				}
			}

			System.out.println(sum);
		}

	}

	public static void union(int a, int b) {
		int ar = find(a);
		int br = find(b);

		if (ar > br) {
			parent[br] = ar;
		} else if (ar < br) {
			parent[ar] = br;
		}
	}

	public static int find(int s) {
		if (parent[s] == s) {
			return s;
		}

		return parent[s] = find(parent[s]);
	}

	public static class Edge {
		int s;
		int e;

		public Edge(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}
}

// N개 국을 여행
// 적은 종류?
// 모든 국가 여행, 가장 적은 종류 비행기
// 중복 방문 가능


// 테스트 케이스 T
// 국가의 수 N, 비행기 종류 M
// M개의 줄 동안 a, b (방향 x)
//

// 주의
// 방향 없음!

// 시작 국가가 없다??

// 비행기는 여러번 타도 된다.
// 종류가 적다.
// 그럼 싸이클 x, -> 최소 신장 트리



// 엣지들을 리스트에 저장
// 방향 무관 하나씩만
// 리스트를 순회한다.
// find가 같지 않으면 union 및 sum추가
// 엣지는 s, e만
