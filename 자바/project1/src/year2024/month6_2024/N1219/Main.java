package year2024.month6_2024.N1219;

import java.util.*;
import java.io.*;

class Main {
	public static long inf = -99999999999L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());
		int endNode = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Edge> adj = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long dist = -Long.parseLong(st.nextToken());

			adj.add(new Edge(start, end, dist));
		}

		long[] money = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			money[i] = Long.parseLong(st.nextToken());
		}

		long [] distance = new long[N];
		Arrays.fill(distance, inf);
		distance[startNode] = money[startNode];

		for (int i = 1; i <= N - 1; i++) {
			bellmanFord(adj, distance, money);
		}

		long [] tmpDistance = new long[N];
		for (int i = 0; i < N; i++) {
			tmpDistance[i] = distance[i];
		}

		bellmanFord(adj, distance, money);

		if (distance[endNode] != tmpDistance[endNode]) {
			System.out.println("Gee");
		} else if (distance[endNode] == inf) {
			System.out.println("gg");
		} else {
			System.out.println(distance[endNode]);
		}
	}

	public static void bellmanFord(List<Edge> adj, long[] distance, long[] money) {
		for (Edge edge : adj) {
			int start = edge.getStart();
			int end = edge.getEnd();
			long dist = edge.getDist();

			if (distance[start] == inf) {
				continue;
			}
			if (distance[end] < dist + distance[start] + money[end]) {
				distance[end] = dist + distance[start] + money[end];
			}
		}
	}
}

class Edge {
	private int start;
	private int end;
	private long dist;

	public Edge(int start, int end, long dist) {
		this.start = start;
		this.end = end;
		this.dist = dist;
	}

	public int getStart() {
		return this.start;
	}

	public int getEnd() {
		return this.end;
	}

	public long getDist() {
		return this.dist;
	}
}
