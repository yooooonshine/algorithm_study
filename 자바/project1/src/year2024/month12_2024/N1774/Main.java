package year2024.month12_2024.N1774;

import java.util.*;
import java.io.*;

public class Main {
	public static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		double[][] point = new double[N + 1][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			double X = Float.parseFloat(st.nextToken());
			double Y = Float.parseFloat(st.nextToken());

			point[i][0] = X;
			point[i][1] = Y;
		}

		PriorityQueue<Edge> edges = new PriorityQueue<>();

		for (int i = 1; i <= N - 1; i++) {
			for (int j = i + 1; j <= N; j++) {
				edges.add(new Edge(i, j, calcD(point[i][0], point[i][1], point[j][0], point[j][1])));
			}
		}

		parent = new int[N + 1];
		for (int i = 1; i<= N; i++) {
			parent[i] = i;
		}

		for (int i = 1; i<= M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());

			union(a, b);
		}

		double sum = 0d;
		while (!edges.isEmpty()) {
			Edge e = edges.poll();

			if (find(e.a) != find(e.b)) {
				union(e.a, e.b);
				sum += e.dist;
			}
		}

		System.out.println(String.format("%.2f", sum));
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

	public static double calcD(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	public static class Edge implements Comparable<Edge> {
		int a;
		int b;
		double dist;

		public Edge(int a, int b, double dist) {
			this.a = a;
			this.b = b;
			this.dist = dist;
		}

		public int compareTo(Edge e) {
			double result = this.dist - e.dist;
			if (result > 0d) {
				return 1;
			} else if (result < 0d) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}

// 2차원좌표계상의 거리
// 우주신 연결
// 통로의 길이 합이 최소 -> 최소 신장 트리

// N, M 우주신들의 개수, 연결된 통로 개수
// N개의 줄
// 우주신 좌표 X, Y // 이 순서가 번호 1번부터
// M 개의 줄
// 연결된 통로
// 소수점 둘째 자리까지 반올림 %0.2f

// 1 엣지들 최소 길이 순으로 정렬
// 2. 만약 find가 다르면 union, 비용 추가

// 2차원 배열 만들기, 1번부터 채우기
// 별개로 유니온 파인드 배열만들기

// 팀에 있는 모든 좌표랑 비교해서 최소를 찾아야 한다?


// O(M * N)