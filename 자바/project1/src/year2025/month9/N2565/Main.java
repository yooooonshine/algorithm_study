package year2025.month9.N2565;

import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 전봇대 사이의 전깃줄 수

		List<Edge> edges = new ArrayList<>();
		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges.add(new Edge(a, b));
		}

		Collections.sort(edges);

		// 각 줄의 Set 구하기
		Map<Integer, Set<Integer>> myM = new HashMap<>();
		for (Edge e : edges) {
			myM.put(e.s, new HashSet<>());
		}

		for (int i = 0; i < edges.size(); i++) {
			Edge now = edges.get(i);

			for (int j = i + 1; j < edges.size(); j++) {
				Edge another = edges.get(j);
				if (now.e > another.e) {
					myM.get(now.s).add(another.s);
					myM.get(another.s).add(now.s);
				}
			}
		}

		int count = 0;
		while (true) {
			// 모두 set 개수 0인지 확인
			boolean allZero = true;

			for (Set<Integer> s : myM.values()) {
				if (s.size() != 0) {
					allZero = false;
				}

			}

			if (allZero) {
				break;
			}

			// 줄 자르기
			count++;

			// 최대 찾기
			int maxKey = -1;
			int max = -1;
			for (int key : myM.keySet()) {
				if (myM.get(key).size() > max) {
					max = myM.get(key).size();
					maxKey = key;
				}
			}

			// 해당 줄 자르기
			Set<Integer> lines = myM.get(maxKey);
			for (int line : lines) {
				myM.get(line).remove(maxKey);
			}
			myM.get(maxKey).clear();
		}

		System.out.println(count);
	}

	public static class Edge implements Comparable<Edge> {
		int s;
		int e;

		public Edge(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Edge edge) {
			return this.s - edge.s;
		}
	}
}

// 언제 겹칠까
// a1, a2
// b1, b2 일때
// a1 > b1 & a2 < b2 혹은 a1 < b1 & a2 > b2

// 그리디 한가?

// 각 줄이 겹치는 A 모두 구하기 각각 Set으로
// 모두 0이 될 때까지 Set이 가장 많은 A 제거 및 다른 Set 반영 -> 100번
