package year2025.month4.N14226;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int S = Integer.parseInt(br.readLine());

		System.out.println(bfs(S));
	}

	public static int bfs(int S) {

		Queue<Now> q = new LinkedList<>();
		q.add(new Now(0, 0, 1));
		boolean[][] visited = new boolean[2001][2001];

		while (!q.isEmpty()) {
			Now now = q.poll();

			int count = now.count;
			int clip = now.clip;
			int imo = now.imo;

			if (imo == S) {
				return count;
			} else if (imo > S) {
				continue;
			} else if (imo < 1) {
				continue;
			}
			if (visited[imo][clip]) {
				continue;
			}
			visited[imo][clip] = true;

			q.add(new Now(count + 1, clip, imo - 1));
			q.add(new Now(count + 1, clip, imo + clip));
			q.add(new Now(count + 1, imo, imo));
		}

		return 0;
	}

	public static class Now {
		int count;
		int clip;
		int imo;

		public Now(int count, int clip, int imo) {
			this.count = count;
			this.clip = clip;
			this.imo = imo;
		}
	}
}

// 스마일 이모티콘 S개
// 지금 이모티콘 1개 입력 상황
// 화면 이모티콘 모두 복사
// 클립코드 이모티콘 복붙
// 화면 이모티콘 하나 삭제

// 1
// 복사
// 붙여넣기
// 2
// 붙여넣기
// 3
// 붙여넣기
// 4
// 붙여넣기
// 5

// 그렇구나
// 그럼 현재 클립 수
// 행동은
// 복사 붙여넣기 삭제