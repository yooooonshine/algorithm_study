package year2025.Month7.N7662;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine()); // Q에 적용할 연산 개수

			int index = 0;
			Set<Integer> dSet = new HashSet<>();
			PriorityQueue<Node> maxQ = new PriorityQueue<>((a, b) -> {
				return b.v - a.v;

			});
			PriorityQueue<Node> minQ = new PriorityQueue<>((a, b) -> {
				return a.v - b.v;

			});

			for (int k = 1; k <= K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String calcType = st.nextToken(); // 연산 타입 I면 삽입, D는 삭제(D 1 최대, D -1 최소)
				int n = Integer.parseInt(st.nextToken());


				if (calcType.equals("I")) {
					// 삽입
					Node node = new Node(index, n);
					maxQ.add(node);
					minQ.add(node);
					index++;

				} else  {
					if (n == 1) {
						// 최대 삭제
						while (!maxQ.isEmpty()) {
							Node next = maxQ.poll();

							if (dSet.contains(next.i)) {
								continue;
							} else {
								dSet.add(next.i);
								break;
							}
						}

					} else {
						// 최소 삭제
						while (!minQ.isEmpty()) {
							Node next = minQ.poll();

							if (dSet.contains(next.i)) {
								continue;
							} else {
								dSet.add(next.i);
								break;
							}
						}
					}
				}
			}
			boolean isEmpty = false;
			while (true) {
				if (maxQ.isEmpty()) {
					isEmpty = true;
					break;
				}

				Node next = maxQ.poll();

				if (dSet.contains(next.i)) {
					continue;
				} else {
					bw.write(next.v + " ");
					break;
				}
			}
			if (isEmpty) {
				bw.write("EMPTY \n");
				continue;
			}

			while (true) {
				if (minQ.isEmpty()) {
					bw.write("EMPTY \n");
					break;
				}

				Node next = minQ.poll();

				if (dSet.contains(next.i)) {
					continue;
				} else {
					bw.write(next.v + "\n");
					break;
				}
			}
		}

		bw.flush();
	}

	public static class Node {
		int i;
		int v;

		public Node(int i, int v) {
			this.i = i;
			this.v = v;
		}
	}
}


// 삽입, 삭제
// 우선순위 가장 높은 것 OR 낮은 것

// q에 최댓 최소