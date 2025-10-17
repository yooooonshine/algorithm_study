package year2025.month10.N9466;

import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static int[] team;
	public static int[] next;
	public static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			count = 0;

			team = new int[N + 1];
			next = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int n = 1; n <= N; n++) {
				next[n] = Integer.parseInt(st.nextToken());
			}

			for (int n = 1; n <= N; n++) {
				if (team[n] == 0) {
					dfs(n);
				}
			}

			System.out.println(N - count);
		}

	}

	public static void dfs(int s) {

		boolean[] visit = new boolean[N + 1];
		Stack<Integer> stack = new Stack<>();
		stack.add(s);

		while(!stack.isEmpty()) {
			int now = stack.pop();

			if (visit[now]) {
				continue;
			}
			visit[now] = true;

			stack.add(next[now]);

			// 싸이클
			if (visit[next[now]]) {
				int cycleStart = next[now];
				while (true) {
					if (team[cycleStart] != 1) {
						team[cycleStart] = 1;
						count++;
					}

					cycleStart = next[cycleStart];

					if (cycleStart == next[now]) {
						break;
					}
				}

				return;
			}
		}
	}

}


// 팀원 수 제한 없다.
// 학생들은 함꼐 하고 싶은 학생 선택(자기 자신 선택 가능, 한 명만 선택)
// 싸이클 형성되어야 팀

// 어느 팀에도 속하지 않는 학생 수

// 탐색 유니온파인드
// 유니온파인드 안됨

// n에 대하여 모두 bfs 한다면?

// 200000 * 100000
// 줄여야 하는데..