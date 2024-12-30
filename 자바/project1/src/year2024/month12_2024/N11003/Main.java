package year2024.month12_2024.N11003;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int s = -L + 2;
		int e = 1;

		Deque<Num> dq = new ArrayDeque<>();

		while (e <= N) {

			while (!dq.isEmpty() && dq.peekLast().v >= arr[e]) {
				dq.pollLast();
			}
			dq.offerLast(new Num(e, arr[e]));

			while (dq.peekFirst().i < s) {
				dq.pollFirst();
			}

			sb.append(dq.peekFirst().v).append(" ");

			s++;
			e++;
		}

		System.out.println(sb.toString());
	}

	public static class Num {
		int i;
		int v;

		public Num(int i, int v) {
			this.i = i;
			this.v = v;
		}
	}
}

// i 3
// l 2
// Di는 l개 중 최속값
// 연속에서네? 슬라이드 윈도우?
// 아 L때문에 Ai가 음수가 될 수 있다. 음수를 그냥 고려하자
// i <= 0 조심!!


// N L
// N 개의 수

// Deque는 index와 값을 갖는다.

// 각 원소를 1부터 Deque에 넣는다.
// 넣을 떄 오른쪽에서 크기가 자신보다 크거나 같으면 뺀다.
// 맨 앞에서 인덱스가 지났으면 뺀다.
// 맨 앞을 출력하낟.