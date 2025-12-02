package year2025.month11.N17090;

import java.util.*;
import java.io.*;

public class Main {

	public static String[][] arr;

	public static int R;
	public static int C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		arr = new String[R + 1][C + 1];
		for (int r = 1; r <= R; r++) {
			String[] tmp = br.readLine().split("");

			for (int c = 1; c <= C; c++) {
				arr[r][c] = tmp[c - 1];
			}
		}

		boolean[][] canExit = new boolean[R + 1][C + 1];

		Queue<Node> exitNs = new LinkedList<>();
		for (int r = 1; r <= R; r++) {
			Node node1 = move(new Node(r, 1));
			if (node1.r < 1 || node1.r > R || node1.c < 1 || node1.c > C) {
				exitNs.add(new Node(r, 1));
			}

			node1 = move(new Node(r, C));
			if (node1.r < 1 || node1.r > R || node1.c < 1 || node1.c > C) {
				exitNs.add(new Node(r, C));
			}
		}

		for (int c = 1; c <= C; c++) {
			Node node1 = move(new Node(1, c));
			if (node1.r < 1 || node1.r > R || node1.c < 1 || node1.c > C) {
				exitNs.add(new Node(1, c));
			}

			node1 = move(new Node(R, c));
			if (node1.r < 1 || node1.r > R || node1.c < 1 || node1.c > C) {
				exitNs.add(new Node(R, c));
			}
		}

		while (!exitNs.isEmpty()) {
			Node now = exitNs.poll();

			if (canExit[now.r][now.c]) {
				continue;
			}
			canExit[now.r][now.c] = true;

			for (int i = 0; i <= 3; i++) {
				int nextR = now.r + rs[i];
				int nextC = now.c + cs[i];


				if (nextR < 1 || nextR > R || nextC < 1 || nextC > C) {
					continue;
				}

				if (rev[i].equals(arr[nextR][nextC])) {
					exitNs.add(new Node(nextR, nextC));
				}
			}
		}

		int count = 0;
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (canExit[r][c]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	public static int[] rs = {1 , -1, 0, 0};
	public static int[] cs = {0, 0, 1, -1};
	public static String[] rev = {"U", "D", "L", "R"};

	public static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static Node move(Node n) {
		if (arr[n.r][n.c].equals("U")) {
			return new Node(n.r - 1, n.c);
		}
		if (arr[n.r][n.c].equals("R")) {
			return new Node(n.r, n.c + 1);
		}
		if (arr[n.r][n.c].equals("D")) {
			return new Node(n.r + 1, n.c);
		}
		return new Node(n.r, n.c - 1);
	}

	public static Node revMove(Node n) {
		if (arr[n.r][n.c].equals("U")) {
			return new Node(n.r + 1, n.c);
		}
		if (arr[n.r][n.c].equals("R")) {
			return new Node(n.r, n.c - 1);
		}
		if (arr[n.r][n.c].equals("D")) {
			return new Node(n.r - 1, n.c);
		}
		return new Node(n.r, n.c + 1);
	}
}

// 각 칸에서 나가지는지 체크해도 돼
// 근데 특정 이동한 칸이 탈출가능하면 평생 탈출 가능해

// 그렇게 따지면
// 테두리부터 탈출 가능한지본다.
// 탈출가능한 곳에서 이동하며 모든 곳을 다 탈출가능하다고 한다.

// 겉 테두리에서 탈출 가능한 것을 찾는다.
// 거기서부터 리버스로 이동하면서 방문한 곳들 모두 true 처리
// 이미 true면 끝