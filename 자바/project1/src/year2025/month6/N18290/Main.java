package year2025.month6.N18290;

import java.util.*;
import java.io.*;

public class Main {

	public static int K;
	public static int N;
	public static int M;
	public static int max = Integer.MIN_VALUE;
	public static List<Node> choice = new ArrayList<>();
	public static int[][] arr;

	public static int[] rs = {0, 0, 1, -1};
	public static int[] cs = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); //r
		M = Integer.parseInt(st.nextToken()); //c
		K = Integer.parseInt(st.nextToken()); //k개 선택

		arr = new int[N + 1][M + 1];
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		recursion(0, 1);

		System.out.println(max);
	}

	public static void recursion(int count, int index) {
		// K개 선택 완
		if (count == K) {
			if (!can()) {
				return;
			}

			int sum = 0;
			for (Node node : choice) {
				sum += node.v;
			}

			if (sum > max) {
				max = sum;
			}
		}

		if (index > N * M) {
			return;
		}

		for (int i = index; i <= N * M; i++) {
			int r = i / M + 1;
			if (i % M == 0) {
				r--;
			}
			int c = i % M;
			if (i % M == 0) {
				c++;
			}

			choice.add(new Node(r, c, arr[r][c]));
			recursion(count + 1, i + 1);
			choice.remove(choice.size() - 1);
		}
	}

	public static boolean can() {
		boolean[][] tmp = new boolean[N + 1][M + 1];
		for (Node node : choice) {
			tmp[node.r][node.c] = true;
		}

		for (Node node : choice) {
			for (int i = 0; i <= 3; i++) {
				int nextR = node.r + rs[i];
				int nextC = node.c + cs[i];

				if (nextR < 1 || nextR > N || nextC < 1 || nextC > M) {
					continue;
				}

				if (tmp[nextR][nextC]) {
					return false;
				}
			}
		}

		return true;
	}

	public static class Node {
		int r;
		int c;
		int v;

		public Node(int r, int c, int v) {
			this.r = r;
			this.c = c;
			this.v = v;
		}
	}
}


// N x M 격자판에서
// K개 선택 -> 모두 더한 최댓값
// 칸 입접 x(상하좌우)

// 완전 탐색?
// dfs

// 그리디한가? x

// 재귀?
