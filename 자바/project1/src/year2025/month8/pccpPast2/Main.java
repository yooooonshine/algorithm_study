package year2025.month8.pccpPast2;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Main {

	public int R;
	public int C;

	public int[][] team;

	public int solution(int[][] land) throws Exception {
		R = land.length; // 세로
		C = land[0].length; // 가로

		// 유니온파인드 배열 초기화
		team = new int[R * C][2];
		for (int i = 0; i <= team.length - 1; i++) {
			team[i][0] = i;
			team[i][1] = 1;
		}

		// 석유찾기
		boolean[][] visit = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (land[r][c] == 1 && !visit[r][c]) {
					dfs(land, visit, r, c);
				}
			}
		}

		int max = 0;
		for (int c = 0; c < C; c++) {
			int count = 0;
			Set<Integer> oils = new HashSet<>();

			for (int r = 0; r < R; r++) {

				int index = find(getIndex(r, c));
				if (land[r][c] == 1
					&& !oils.contains(index)) {
					count += team[index][1];
					oils.add(index);
				}
			}

			if (count > max) {
				max = count;
			}
		}

		return max;
	}

	public int[] rs = {0, 0, 1, -1};
	public int[] cs = {1, -1, 0, 0};

	public void dfs(int[][] land, boolean[][] visit, int sR, int sC) {
		Stack<Node> s = new Stack<>();
		s.add(new Node(sR, sC));

		int start = getIndex(sR, sC);

		while (!s.isEmpty()) {
			Node now = s.pop();
			int nR = now.r;
			int nC = now.c;

			if (visit[nR][nC]) {
				continue;
			}
			visit[nR][nC] = true;
			union(start, getIndex(nR, nC)); // 합치기

			for (int i = 0; i <= 3; i++) {
				int nextR = nR + rs[i];
				int nextC = nC + cs[i];

				if (nextR < 0 || nextR > R - 1 || nextC < 0 || nextC > C - 1) {
					continue;
				}

				if (land[nextR][nextC] == 1) {
					s.add(new Node(nextR, nextC));
				}
			}
		}
	}

	public class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public void union(int a, int b) {
		int aR = find(a);
		int bR = find(b);

		if (aR > bR) {
			team[bR][0] = aR;
			team[aR][1] += team[bR][1];
		} else if (aR < bR) {
			team[aR][0] = bR;
			team[bR][1] += team[aR][1];
		}
	}

	public int find(int v) {
		if (team[v][0] == v) {
			return v;
		}

		return team[v][0] = find(team[v][0]);
	}

	public int getIndex(int r, int c) {
		return r * C + c;
	}
}

// 세로 n, 가로 m
// 시추는 열하나를 관통
// 가장 많은 석유량

// 1이면 석유 있는 땅

// 칸 총 250000

// 유니온 파인드
// 개수를 포함한 2차원 배열
// 둘이 합친다면? 숫자 전수
// 2차원은 0부터 rc - 1
