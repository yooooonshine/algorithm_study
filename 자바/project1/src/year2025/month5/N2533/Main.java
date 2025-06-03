package year2025.month5.N2533;

import java.util.*;
import java.io.*;

public class Main {

	public static List<List<Edge>> adj;
	public static List<List<Edge>> reverseAdj;
	public static boolean[] early;

	public static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 노드 개수

		adj = new ArrayList<>();
		reverseAdj = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
			reverseAdj.add(new ArrayList<>());
		}

		for (int n = 1; n <= N - 1; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adj.get(s).add(new Edge(s, e));
			reverseAdj.get(e).add(new Edge(s, e)); // 역방향 그래프도 저장
		}

		// 루트노드 찾기
		int root = 0;
		for (int i = 1; i <= N; i++) {
			if (reverseAdj.get(i).size() == 0) {
				root = i;
				break;
			}
		}

		count = 0; // 결과 카운트
		early = new boolean[N + 1];

		do {
			Stack<Edge> myS = new Stack<>();
			myS.push(new Edge(0, root));


			while (!myS.isEmpty()) {
				Edge nowEdge = myS.pop();
				int nowS = nowEdge.s;
				int nowE = nowEdge.e;


				boolean allEarly = true;
				for (Edge nextEdge : adj.get(nowE)) {

					// 자식이 리프면
					if (adj.get(nextEdge.e).size() == 0 && !early[nowE]) {
						early[nowE] = true;
						count++;
					}

					// 자식이 얼리면 패스
					if (early[nextEdge.e]) {
						continue;
					}
					allEarly = false; // 자식이 얼리 아니면 false
					myS.add(new Edge(nowE, nextEdge.e));
				}

				if (allEarly) {
					if (nowS != 0) {
						if (early[nowS]) {
							early[nowE] = true;
						} else {
							if (!early[nowE]) {
								early[nowE] = true;
								count++;
							}
						}
					} else {
						// 자식이 모두 얼리고 부모가 없으면 자동얼리
						early[nowE] = true;
					}
				}
			}
		} while (!early[root]);



		System.out.println(count);
	}


	public static class Edge {
		int s;
		int e;

		public Edge(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}
}

// 얼리 압터터가 아니면, 모든 친구가 얼리아텁터일 때 아이디어 받아들임
// 최소의 수의 얼리아덥터 확보
// 트리 가정