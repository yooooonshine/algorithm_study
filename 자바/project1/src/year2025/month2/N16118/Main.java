package year2025.month2.N16118;

import java.util.*;
import java.io.*;

public class Main {
	public static float[][] wDist;
	public static float[] aDist;

	public static List<List<Edge>> adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());// V수
		int M = Integer.parseInt(st.nextToken()); // 오솔길 수

		adj = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			float d = Float.parseFloat(st.nextToken());

			adj.get(s).add(new Edge(e, d));
			adj.get(e).add(new Edge(s, d));
		}

		wDist = new float[N + 1][2];
		aDist = new float[N + 1];
		for (int i = 1; i <= N; i++) {
			wDist[i][0] = 10000000000F;
			wDist[i][1] = 10000000000F;
		}

		Arrays.fill(aDist, 10000000000F);
		wDist[1][0] = 0F; // 느린 상태로 도착, 다음 빠름
		aDist[1] = 0F;

		wD();
		aD();

		int count = 0;
		for (int i = 2; i <= N; i++) {
			if (wDist[i][0] > aDist[i] && wDist[i][1] > aDist[i]) {
				count++;
			}
		}

		System.out.println(count);
	}

	// 늑대 다익스트라
	// n차원 배열을 사용해야 할 거 같은데
	// 최단 거리가 아니여도 방문 후 다음 노드를 갱신할 수 있다.

	// 방법으로 모든 경로를 체크?

	// 늑대는 항상  빠름, 느림 세트로 움직인다.
	//

	public static void wD() {
		PriorityQueue<Wolf> pq = new PriorityQueue<>();
		pq.add(new Wolf(1, 0));

		while (!pq.isEmpty()) {
			Wolf wolf = pq.poll();

			int nE = wolf.e;

			for (Edge edge : adj.get(nE)) {
				if (wDist[nE][0] != 10000000000F) {
					if (wDist[edge.e][1] > wDist[nE][0] + edge.d / 2F) {
						wDist[edge.e][1] = wDist[nE][0] + edge.d / 2F;
						pq.add(new Wolf(edge.e, wDist[edge.e][1]));
					}
				}
				if (wDist[nE][1] != 10000000000F) {
					if (wDist[edge.e][0] > wDist[nE][1] + 2F * edge.d) {
						wDist[edge.e][0] = wDist[nE][1] + 2F * edge.d;
						pq.add(new Wolf(edge.e, wDist[edge.e][0]));
					}
				}

			}
		}
	}

	// 여우 다익스트라
	public static void aD() {
		PriorityQueue<Ari> pq = new PriorityQueue<>();
		pq.add(new Ari(1,0));

		while (!pq.isEmpty()) {
			Ari ari = pq.poll();

			int nE = ari.e;

			for (Edge edge : adj.get(nE)) {
				if (aDist[edge.e] > aDist[nE] + edge.d) {
					aDist[edge.e] = aDist[nE] + edge.d;
					pq.add(new Ari(edge.e, aDist[edge.e]));
				}
			}
		}
	}

	public static class Edge {
		int e;
		float d;

		public Edge(int e, float d) {
			this.e = e;
			this.d = d;
		}
	}

	public static class Wolf implements Comparable<Wolf> {
		int e;
		float d;

		public Wolf(int e, float d) {
			this.e = e;
			this.d = d;
		}

		@Override
		public int compareTo(Wolf wolf) {
			return (int)(this.d - wolf.d);
		}
	}

	public static class Ari implements Comparable<Ari> {
		int e;
		float d;

		public Ari(int e, float d) {
			this.e = e;
			this.d = d;
		}

		@Override
		public int compareTo(Ari ari) {
			return (int)(this.d - ari.d);
		}
	}
}

// N개의 나무 그루터기
// M개의 오솔길 양방향
// 1번에 삼
// 달빛 늑대 2배 1/2배

// 달빛 여우가 먼저가는 그루터기 수

// 다익스트라
// ElogE

// 벨만 포드 or 다익스트라
// 다익스트라

// 인접리스트
// 우선순위큐
// 방문 체크 후 방문했으면 끝
// 방문안했으면
// 최신화


// 문제가 되는건 그냥 갔을 때하고
// 세트로 갔을 때 다를 수 있다는거야