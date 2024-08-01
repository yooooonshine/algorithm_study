package year2024.month6_2024.N1920;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			binarySearch(A, N, Integer.parseInt(st.nextToken()));
		}

	}

	public static void binarySearch(int[] A, int N, int ans) {
		int s = 0;
		int e = N - 1;
		int mid;
		while (s <= e) {
			mid = (s + e) / 2;

			if (A[mid] == ans) {
				System.out.println(1);
				return;
			} else if (A[mid] < ans) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		System.out.println(0);
	}

	public static void dikstra(List<List<Edge>> adj, boolean[] visit, int[] distances, int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();

			int node = edge.n;
			int weight = edge.w;

			if (visit[node]) {
				continue;
			}

			visit[node] = true;

			List<Edge> adjNodes = adj.get(node);
			for (Edge adjNode : adjNodes) {
				int adjN = adjNode.n;
				int adjW = adjNode.w;
				
				if (distances[adjN] > distances[node] + weight) {
					distances[adjN] = distances[node] + weight;
					pq.add(new Edge(adjN, distances[adjN]));
				}
			}
		}
	}
}

class Edge implements Comparable<Edge> {
	int n;
	int w;

	public Edge(int n, int w) {
		this.n = n;
		this.w = w;
	}

	@Override
	public int compareTo(Edge edge) {
		int w1 = this.w;
		int w2 = edge.w;

		return w1 - w2;
	}
}