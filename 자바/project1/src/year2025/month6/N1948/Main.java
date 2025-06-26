package year2025.month6.N1948;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N; // 도시의 수
	public static int M; // 도로의 수

	public static List<List<Edge>> adj;

	public static List<Edge2> result = new ArrayList<>();


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		adj = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList());
		}

		for (int m = 1; m <= M; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			adj.get(s).add(new Edge(s, e, d));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		bfs(S, E);

		int max = 0;
		for (Edge2 edge2 : result) {
			if (edge2.d > max) {
				max = edge2.d;
			}
		}

		boolean[][] lastRoads = new boolean[N + 1][N + 1];
		for (Edge2 edge2 : result) {
			int[] past = Arrays.stream(edge2.past.split("-")).mapToInt(Integer::parseInt).toArray();

			if (edge2.d == max) {
				for (int i = 0; i < past.length - 1; i++) {
					int from = past[i];
					int to = past[i + 1];
					lastRoads[from][to] = true; // 마지막 도로 표시
				}
			}
		}

		int roadCount = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (lastRoads[i][j]) {
					roadCount++;
				}
			}
		}

		System.out.println(max);
		System.out.println(roadCount);
	}

	public static void bfs(int S, int E) {
		Queue<Edge2> q = new LinkedList<>();
		q.add(new Edge2(S, S + "", 0));

		while (!q.isEmpty()) {
			Edge2 edge2 = q.poll();
			int e = edge2.e;
			int d = edge2.d;
			String past = edge2.past;

			if (E == e) {


				result.add(edge2);
				continue;
			}

			for (Edge edge : adj.get(e)) {
				q.add(new Edge2(edge.e, past + "-" + edge.e, d + edge.d));
			}
		}
	}

	public static class Edge {
		int s;
		int e;
		int d;

		public Edge(int s, int e, int d) {
			this.s = s;
			this.e = e;
			this.d = d;
		}
	}

	public static class Edge2 {
		int e;
		String past;
		int d;

		public Edge2(int e, String past, int d) {
			this.e = e;
			this.past = past;
			this.d = d;
		}
	}
}
