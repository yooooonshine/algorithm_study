package year2024.month12_2024.N1911;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		List<Node> nodes = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken()) - 1;
			nodes.add(new Node(s, e));
		}

		Collections.sort(nodes);

		int max = nodes.get(nodes.size() - 1).e;

		int count = 0;
		int index = 0;
		for (Node node : nodes) {

			if (node.s > index) {
				index = node.s;
			}

			while (node.s <= index && node.e >= index) {
				index += L;
				count++;
			}
		}

		System.out.println(count);
	}

	public static class Node implements Comparable<Node> {
		int s;
		int e;

		public Node(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Node o) {
			return this.s - o.s;
		}
	}
}

// s, e
// 현