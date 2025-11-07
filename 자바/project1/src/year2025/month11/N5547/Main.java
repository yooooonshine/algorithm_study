package year2025.month11.N5547;

import java.util.*;
import java.io.*;

public class Main {

	public static int[][] arr;
	public static int W;
	public static int H;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		arr = new int[H + 2][W + 2];
		for (int h = 1; h <= H; h++) {
			st = new StringTokenizer(br.readLine());
			for (int w = 1; w <= W; w++) {
				arr[h][w] = Integer.parseInt(st.nextToken());
			}
		}

		int result = bfs(0, 0);
		System.out.println(result);
	}

	// (x, y)면 x+1,y x,y-1, x-1,y-1, x-1,y, x-1,y+1, x,y+1
	public static int[] oddHs = {-1, -1, 0, 1, 1, 0};
	public static int[] oddWs = {-1, 0, 1, 0, -1, -1};
	public static int[] evenHs = {-1, -1, 0, 1, 1, 0};
	public static int[] evenWs = {0, 1, 1, 1, 0, -1};

	public static int bfs(int w, int h) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(h, w));

		int result = 0;

		boolean[][] visit = new boolean[H + 2][W + 2];
		while (!q.isEmpty()) {
			Node now = q.poll();
			int nowH = now.h;
			int nowW = now.w;

			if (visit[nowH][nowW]) {
				continue;
			}
			visit[nowH][nowW] = true;

			for (int i = 0; i < 6; i++) {
				int nextH;
				int nextW;

				if (nowH % 2 == 0) {
					// 짝수행
					nextH = nowH + oddHs[i];
					nextW = nowW + oddWs[i];
				} else {
					// 홀수행
					nextH = nowH + evenHs[i];
					nextW = nowW + evenWs[i];
				}

				if (nextH < 0 || nextH > H + 1 || nextW < 0 || nextW > W + 1) {
					continue;
				}

				if (arr[nextH][nextW] == 1) {
					result++;
				} else {
					q.add(new Node(nextH, nextW));
				}
			}
		}

		return result;
	}

	public static class Node {
		int h;
		int w;

		public Node(int h, int w) {
			this.h = h;
			this.w = w;
		}
	}
}


// 1미터 정육각형
// 벽면을 조명으로
// 밖에서 보이는 부분만
// 회색 -> 건물 위치,

// 장시갛ㄹ 벽면의 길이의합
// 바깥면을 어떻게 구하지?
// bfs하면 될거같은데
// 겉에서 마주친 흑의 수