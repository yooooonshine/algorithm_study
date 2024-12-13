package year2024.month12_2024.N4386;

import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Map<Node, Node> parent = new HashMap<>(); //유니온파인ㅌ트 배열

		double[][] tmps = new double[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			double x = Float.parseFloat(st.nextToken()); // x좌표
			double y = Float.parseFloat(st.nextToken()); // y 좌표

			tmps[i][0] = x;
			tmps[i][1] = y;
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 1; i <= n - 1; i++) {
			for (int j = 2; j <= n; j++) {
				double x1 = tmps[i][0];
				double y1 = tmps[i][1];
				double x2 = tmps[j][0];
				double y2 = tmps[j][1];

				if (x1 == x2 && y1 == y2) {
					continue;
				}
				double d = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

				Node node1 = new Node(x1, y1);
				Node node2 = new Node(x2, y2);

				Edge edge = new Edge(node1, node2, d);

				if (!parent.containsKey(node1)) {  // 유니온 파인드용
					parent.put(node1, node1);
				}
				if (!parent.containsKey(node2)) {
					parent.put(node2, node2);
				}

				pq.add(edge); // 최소 신장 트리
			}
		}


		// 두개 추출하여 Edge 만들기
		// Edge를 순서대로 정렬
		// Edge리스트에서 하나씩 뽑아서 union find

		int nodeCount = 0;
		double sum = 0;
		while (nodeCount < n - 1 && !pq.isEmpty()) {
			Edge edge = pq.poll();
			if (find(parent, edge.node1) != find(parent, edge.node2)) {
				union(parent, edge.node1, edge.node2);
				nodeCount++;
				sum += edge.d;
			}
		}

		System.out.println(Math.floor(sum * 100) / 100);
	}

	public static void union(Map<Node, Node> map, Node node1, Node node2) {
		Node node1r = find(map, node1);
		Node node2r = find(map, node2);

		if (node1r.getSize() < node2r.getSize()) {
			map.replace(node1r, node2r);
		} else if (node1r.getSize() > node2r.getSize()) {
			map.replace(node2r, node1r);
		}
	}

	public static Node find(Map<Node, Node> map, Node node) {
		if (map.get(node) == node) {
			return node;
		}

		Node result = find(map, map.get(node));

		map.replace(node, result);

		return result;
	}

	public static class Edge implements Comparable<Edge> {
		Node node1;
		Node node2;

		double d;

		public Edge(Node node1, Node node2, double d) {
			this.node1 = node1;
			this.node2 = node2;
			this.d = d;
		}

		@Override
		public int compareTo(Edge e) {
			double result = this.d - e.d;

			if (result > 0) {
				return 1;
			} else if (result < 0) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public static class Node {
		double x;
		double y;

		public Node(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public double getSize() {
			return Math.pow(x, 2) + Math.pow(y, 2);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null || getClass() != obj.getClass()) return false;
			Node node = (Node) obj;
			return Double.compare(node.x, x) == 0 && Double.compare(node.y, y) == 0;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}


}

// n개의 별로 별자리
// 모든 별이 서로 이어져있어야 한다. 유니온 파인드? 최소신장?
// 최소 비용, 연결 -> 최소 신장 트리

// n (별 개수)
// n개의 줄에 x, y좌표
// 거리

// 점과 점
// 점이 Map에 들어가야 함
// 점과 점으로 uniion find

// 점 리스트에서 어떻게 두 개 선택해서 선분을 만들지?