package year2025.month8.N2836;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // N명
		int M = Integer.parseInt(st.nextToken()); // M번 집

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			if (s < e) {
				continue;
			} else {
				// 역순 처리
				pq.add(new Edge(e, s));
			}
		}

		// 역순이 없으면
		if (pq.isEmpty()) {
			// 역순이 없다면 그냥 M까지 가는 거리
			System.out.println(M);
			return;
		}

		// 나머지 더하기
		long sum = (long)M;

		// 1. 들어왔을 때 이전 앞 보다 현재 뒤가 더 작으면 앞을 현재 앞으로 갱신
		// 들어왔을 때 현재 뒤가 이전 앞보다 크면 초기화
		Edge tmpE = pq.poll();

		int front = tmpE.s;
		int end = tmpE.e;

		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int nowF = edge.s;
			int nowE = edge.e;

			if (end >= nowF) {
				end = (int)Math.max(nowE, end);
			} else {
				sum += (long)2 * (end - front);
				front = nowF;
				end = nowE;
			}
		}
		sum += (long)(end - front) * 2;

		System.out.println(sum);
	}

	public static class Edge implements Comparable<Edge> {
		int s;
		int e;

		public Edge(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Edge e) {
			if (this.s != e.s) {
				return this.s - e.s;
			} else {
				return this.e - e.e;
			}
		}
	}
}


// 집은 0번부터 m번까지 번호
// 집 사이 거리는 1
// 상근이 0번집

// N명의 고객
// 탑승, 목적 위치
// N명 모두 태울 수 있다.

// M번 집으로 가기 위해 이동하는 거리 최솟값

// 순방향은 그냥 M까지 가는 길에 처리된다.
// 문제는 역방향
// 15 + 4  + 4 + 2 + 6 + 2
// 15 + 6 + 6

// 그리디
// DP
// 이분탐색

// 겹치는 것은 시작 -> 끝까지 한번에 가는게 유리

// 핵심은 어떻게 겹치는 부분들을 통합할지


// 3 1
// 4 2
// 12 11
// 14 11
// 14 13

/// 1 3
/// 2 4
/// 11 12
/// 11 14
/// 13 14
