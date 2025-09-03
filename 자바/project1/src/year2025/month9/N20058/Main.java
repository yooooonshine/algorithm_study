package year2025.month9.N20058;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // N
		int Q = Integer.parseInt(st.nextToken()); // Q

		int l = (int)Math.pow(2, N);
		int[][] arr = new int[l + 1][l + 1];
		for (int r = 1; r <= l; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= l; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int q = 1; q <= Q; q++) {
			int L = Integer.parseInt(st.nextToken());
			if (L != 0) {
				arr = rotate(arr, L);
			}
			arr = melt(arr);
		}

		// 결과 출력
		int sum = 0;
		for (int r = 1; r <= l; r++) {
			for (int c = 1; c <= l; c++) {
				sum += arr[r][c];
			}
		}
		System.out.println(sum);


		boolean[][] visit = new boolean[l + 1][l + 1];
		int max = 0;
		for (int r = 1; r <= l; r++) {
			for (int c = 1; c <= l; c++) {
				if (arr[r][c] > 0) {

					int size = bfs(r, c, visit, arr);
					max = Math.max(max, size + 1);
				}
			}
		}
		System.out.println(max);
	}

	public static int bfs(int sr, int sc, boolean[][] visit, int[][] arr) {
		Queue<Node> myQ = new LinkedList<>();
		myQ.add(new Node(sr, sc));
		visit[sr][sc] = true;

		int size = 0;
		int[] rs = {0, 0, 1, -1};
		int[] cs = {1, -1, 0, 0};

		while (!myQ.isEmpty()) {
			Node now = myQ.poll();
			int nowR = now.r;
			int nowC = now.c;

			for (int d = 0; d < 4; d++) {
				int nextR = nowR + rs[d];
				int nextC = nowC + cs[d];

				if (nextR >= 1 && nextR < arr.length && nextC >= 1 && nextC < arr.length) {
					if (!visit[nextR][nextC] && arr[nextR][nextC] > 0) {
						visit[nextR][nextC] = true;
						myQ.add(new Node(nextR, nextC));
						size++;
					}
				}
			}
		}

		return size;
	}

	public static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static int[][] rotate(int[][] arr, int L) {
		int size = (int)Math.pow(2, L);
		int[][] newArr = new int[arr.length][arr.length];

		for (int r = 1; r < arr.length; r += size) {
			for (int c = 1; c < arr.length; c += size) {
				// 부분 배열 회전
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						newArr[r + j][c + size - 1 - i] = arr[r + i][c + j];
					}
				}
			}
		}

		return newArr;
	}

	public static int[][] melt(int[][] arr) {
		int[][] copyArr = new int[arr.length][arr.length];
		for (int r = 1; r < arr.length; r++) {
			for (int c = 1; c < arr.length; c++) {
				copyArr[r][c] = arr[r][c];
			}
		}

		for (int r = 1; r < arr.length; r++) {
			for (int c = 1; c < arr.length; c++) {
				if (arr[r][c] == 0) {
					continue;
				}

				int count = 0;
				if (r - 1 >= 1 && arr[r - 1][c] > 0) {
					count++;
				}
				if (r + 1 < arr.length && arr[r + 1][c] > 0) {
					count++;
				}
				if (c - 1 >= 1 && arr[r][c - 1] > 0) {
					count++;
				}
				if (c + 1 < arr.length && arr[r][c + 1] > 0) {
					count++;
				}

				if (count < 3) {
					if (arr[r][c] > 0) {
						copyArr[r][c]--;

					}
				}
			}
		}

		return copyArr;
	}

}
