package year2025.month11.N20182;

import java.util.*;
import java.io.*;

public class Main {

	public static List<List<Edge>> adj;
	public static int N;
	public static int M;
	public static int A;
	public static int B;
	public static int C;

	public static int min = 100000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 교차로 수
		M = Integer.parseInt(st.nextToken()); // 골목 수
		A = Integer.parseInt(st.nextToken()); // 시작
		B = Integer.parseInt(st.nextToken()); // 끝
		C = Integer.parseInt(st.nextToken()); // 돈

		adj = new ArrayList<>();
		for (int n = 0; n <= N; n++) {
			adj.add(new ArrayList<>());
		}

		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adj.get(v1).add(new Edge(v2, c));
			adj.get(v2).add(new Edge(v1, c));
		}

		boolean[] visit = new boolean[N + 1];
		dfs(visit, A, 0, 0);

		System.out.println(min == 100000000 ? -1 : min);
	}

	public static void dfs(boolean[] visit, int now, int max, int sum) {
		if (visit[now]) {
			return;
		}

		if (sum > C) {
			return;
		}

		if (now == B) {
			if (max < min) {
				min = max;
			}
			return;
		}

		visit[now] = true;

		for (Edge next : adj.get(now)) {
			int nextE = next.e;
			int nextC = next.c;

			dfs(visit, nextE, Math.max(max, nextC), sum + nextC);
		}

		visit[now] = false;
	}

	public static class Edge {
		int e;
		int c;

		public Edge(int e, int c) {
			this.e = e;
			this.c = c;
		}
	}
}

// N개의 교차로 (1 ~ N), 비용존재
// M 개의 골목, 양방향, 하나만 존재

// A -> B로 C원으로

// 가장 많이 낸 돈을 적게

// 한 골목의 최대 요금의 최솟값
// 갈수 없으면 -1

// 갈 수 있는 경로 중에서 -> 그 경로의 최댓값이 최소인 값

// dfs일거가은데
// 백트래킹

// 다익스트라로 비용을 모두 저장하며
// 다익스트라 거리배열에너는 최대를 저장?