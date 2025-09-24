package year2025.month9.N2668;

import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		for (int n = 1; n <= N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}

		boolean[] visit = new boolean[N + 1];
		// dfs
		for (int n = 1; n <= N; n++) {
			Result tmp = dfs(n);

			// 못돈경우
			if (tmp.c == 0) {
				continue;
			}

			for (int i = 1; i <= N; i++) {
				if (tmp.visit[i]) {
					visit[i] = true;
				}
			}
		}

		int result = 0;
		for (int n = 1; n <= N; n++) {
			if (visit[n]) {
				result++;
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(result + "\n");
		for (int n = 1; n <= N; n++) {
			if (visit[n]) {
				bw.write(n + "\n");
			}
		}

		bw.flush();
	}

	public static Result dfs(int s) {
		boolean[] visit= new boolean[N + 1];
		int now = s;

		int count = 0;

		while (true) {

			// 방문했으면, 원형 반복 -> 끝
			if (visit[now]) {
				break;
			}
			visit[now] = true;
			count++;

			// 원점 갈 때
			if (arr[now] == s) {
				return new Result(count, visit);
			}

			now = arr[now];
		}

		// 끝까지 돌아오지 못했을 경우
		return new Result(0, visit);
	}

	public static class Result {
		int c;
		boolean[] visit;

		Result(int c, boolean[] visit) {
			this.c = c;
			this.visit = visit;
		}
	}
}

// 1~N의 정수가 첫째 줄
// 2째 줄 1이상 N이하 정수

// 여러 줄을 뽑았을 떄, 첫 줄과, 둘 줄의 집합이 일치하게
// 최대한 많이


// 일반적으로는 2^100 승 절대 아노딘다.

// (1, 3)이면 3이 있어야 돼
// (3, 1)이니 성공

// 탐색이다.

// 1. 자기 자신을 가리키는 set을 찾는다. 결과에 반영한다.
// 2. 각 원소를 돌면서 자신을 마주칠 때까지 들어간다. 다 방문하면 나온다.