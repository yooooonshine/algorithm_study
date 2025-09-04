package year2025.month9.N1092;

import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Integer[] crains = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			crains[n] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(crains, Collections.reverseOrder());

		int M = Integer.parseInt(br.readLine()); // 박스의 수
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			return b - a;
		});
		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}

		// 만약 박스를 못 옮기면 -1
		if (crains[0] < pq.peek()) {
			System.out.println(-1 + "");
		}

		Stack<Integer> stack = new Stack<>();

		int count = 0;
		while(true) {
			count++;


			int index = 0;

			while (index < N && !pq.isEmpty()) {
				if (crains[index] >= pq.peek()) {
					pq.poll();
					index++;
				} else {
					stack.add(pq.poll());
				}
			}


			// 잠시 담아뒀던 것 넣기
			while (!stack.isEmpty()) {
				pq.add(stack.pop());
			}

			if (pq.isEmpty()) {
				break;
			}
		}


		System.out.println(count);
	}
}


// 그리디인가
// dp는 아니야
// 일단 정렬부터 해야할거같아

// 32 28 25 23
// 32 27 24 20 18 16 15 10 7 5

// 단순 PQ다. PQ에서 하나씩 빼면서 채운다.
// 크기가 맞지 않는다면 이건 잠시 두고, 나중에 다시 PQ에 넣는다.