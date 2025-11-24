package year2025.month11.N1011;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			bw.write(bfs(x, y) + "\n");
		}
		
		bw.flush();
	}

	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, 0, 0));

		while (!q.isEmpty()) {
			Node now = q.poll();
			int nowN = now.n;
			int nowC = now.c;
			int nowV = now.v;

			if (nowN == y && nowV == 1) {
				return nowC;
			}
			if (nowN > y) {
				continue;
			}

			if (nowV - 1 >= 1) {
				q.add(new Node(nowN + nowV - 1, nowC + 1, nowV - 1));
			}

			if (nowV >= 1) {
				q.add(new Node(nowN + nowV, nowC + 1, nowV));
			}

			if (nowV + 1 >= 1) {
				q.add(new Node(nowN + nowV + 1, nowC + 1, nowV + 1));
			}
		}
		
		return 0;
	}

	public static class Node {
		int n;
		int c; // 횟수
		int v; // 속도

		public Node(int n, int c, int v) {
			this.n = n;
			this.c = c;
			this.v = v;
		}
	}
}

// k광년이동시 k   1, k, k + 1 만 이동 기능
// 탐색이네
// 시작은 -1 0 1

// 최소한으로 이동
// x -> y로
// 도착이전의 이동거리는 1
