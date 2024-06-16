package year2024.month6_2024.N10868;

import java.util.*;
import java.io.*;

class Main {
	public static long inf = 10000000000L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] data = new long[N + 1]; //0번 사용 x
		for (int i = 1; i <= N; i++) {
			data[i] = Long.parseLong(br.readLine());
		}

		int r = 0;
		while (true) {
			if ((int)Math.pow(2, r) > N) {
				break;
			}
			r++;
		}

		long[] tree = new long[(int)Math.pow(2, r + 1)];
		Arrays.fill(tree, inf);

		makeTree(tree, data, r, N);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			System.out.println(getAnswer(tree, (int)Math.pow(2, r) + start - 1, (int)Math.pow(2, r) + end- 1));
		}
	}

	public static void makeTree(long[] tree, long[] data, int r, int N) {
		int start = (int)Math.pow(2, r);
		for (int i = 1; i <= N; i++) {
			tree[start + i - 1] = data[i];
		}

		//나머지 값 구하기
		for (int i = start - 1; i >= 1; i--) {
			if (tree[2 * i] > tree[2 * i + 1]) {
				tree[i] = tree[2 * i + 1];
			} else {
				tree[i] = tree[2 * i];
			}
		}
	}

	public static long getAnswer(long[] tree, int start, int end) { //리프노드 시작, 끝 값
		List<Long> results = new ArrayList<>();
		while (start <= end) {
			if (start % 2 == 1) {
				results.add(tree[start]);
			}
			if (end % 2 == 0) {
				results.add(tree[end]);
			}

			start = (start + 1) / 2;
			end = (end - 1) / 2;
		}


		long min = inf;
		for (long v : results) {
			if (min > v) {
				min = v;
			}
		}
		return min;
	}
}

// 세그먼트 트리
// 트리 배열 인덱스 이용
// 초기화
// 크기 2^(k + 1)
// 아래에
// 답 구히기

// 최솟 값이므로 나머지는 max로
