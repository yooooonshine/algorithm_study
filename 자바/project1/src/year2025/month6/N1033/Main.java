package year2025.month6.N1033;

import java.util.*;
import java.io.*;

public class Main {

	public static List<List<Node>> list;
	public static int[] result;
	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		result = new int[N];

		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 1; i <= N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			list.get(a).add(new Node(a, b, p, q));
			list.get(b).add(new Node(b, a, q, p));
		}

		search(0);

		for (int i = 0; i < N; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static void merge(int a, int b, int p, int q) {
		int gcdNum = gcd(p, q);
		p /= gcdNum;
		q /= gcdNum;

		if (result[a] == 0 && result[b] == 0) {
			result[a] = p;
			result[b] = q;
		} else if (result[a] != 0) {
			int lcmNum = lcm(result[a], p);

			int mul = lcmNum / result[a]; // 기존 배열에 곱할 수
			int newMul = lcmNum / p; // 주어진 p q에 곱할 수

			for (int n = 0; n < N; n++) {
				result[n] = result[n] * mul;
			}
			result[b] = q * newMul;
		} else if (result[b] != 0) {
			int lcmNum = lcm(result[b], q);

			int mul = lcmNum / result[b]; // 기존 배열에 곱할 수
			int newMul = lcmNum / q; // 주어진 p q에 곱할 수

			for (int n = 0; n < N; n++) {
				result[n] = result[n] * mul;
			}
			result[a] = p * newMul;
		}
	}

	public static void search(int s) {
		boolean[] visit = new boolean[N];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);

		while (!queue.isEmpty()) {
			int a = queue.poll();

			if (visit[a]) {
				continue;
			}
			visit[a] = true;

			for (Node node : list.get(a)) {
				if (!visit[node.b]) {
					queue.add(node.b);
					merge(a, node.b, node.p, node.q);
				}
			}
		}
	}

	public static int gcd(int a, int b) {
		int big = (int)Math.max(a, b);
		int small = (int)Math.min(a, b);
		while (true) {
			if (big % small == 0) {
				return small;
			} else {
				int tmp = big % small;
				big = small;
				small = tmp;
			}
		}
	}

	public static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	public static class Node {
		int a;
		int b;
		int p;
		int q;

		public Node(int a, int b, int p, int q) {
			this.a = a;
			this.b = b;
			this.p = p;
			this.q = q;
		}
	}
}
