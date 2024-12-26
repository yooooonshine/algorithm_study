package year2024.month12_2024.N2623;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 가수 수
		int M = Integer.parseInt(st.nextToken());	// 보조 pd 수

		List<List<Integer>> adj = new ArrayList<>();
		int[] in = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int tmpN = Integer.parseInt(st.nextToken());

			int before = Integer.parseInt(st.nextToken());
			for (int j = 2; j <= tmpN; j++) {
				int tmp = Integer.parseInt(st.nextToken());

				boolean exist = false;
				for (int k : adj.get(before)) {
					if (k == tmp) {
						exist = true;
					}
				}

				if (!exist) {
					adj.get(before).add(tmp);
					in[tmp]++;
				}

				before = tmp;
			}
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>((Integer a, Integer b) -> {
			return a - b;
		});
		for (int i = 1; i <= N; i++) {
			if (in[i] == 0) {
				pq.add(i);
			}
		}

		List<Integer> result = new ArrayList<>();

		while (!pq.isEmpty()) {
			Integer edge = pq.poll();

			result.add(edge);

			for (int t : adj.get(edge)) {
				in[t]--;

				if (in[t] == 0) {
					pq.add(t);

				}
			}
		}

		boolean can = true;

		for (int i = 1; i <= N; i++) {
			if (in[i] != 0) {
				can = false;
			}
		}

		if (can) {
			for (int i : result) {
				System.out.println(i);
			}
		} else {
			System.out.println(0);
		}
	}
}

// 1 4 3이면 1번 먼저
// 순서가 다를 수 있다? 토폴로지소트

// N M (가수의 수, 보조 pd 수)
// M번 반복,
// 가수의 수,  정한 순서
// 출력 N개
// 출력 불가능하면 0 출력 -> 중요

// 토폴로지 소트?
// adj 리스트를 생성
// 진입차수 배열 생성
// 진입차수를 구한다.
// 진입 차수가 적은 순으로 정렬하는 pq 사용
// 인접리스트 순회하며, 진입 차수 뺀다,진입 차수가 0이면,  pq에 넣는다.

// NlogN 3000

// 만들어질 수 없음을 어떻게 알지?

// 토폴로지소트를 했는데 진입차수가 0이 아닌게 남아있다
