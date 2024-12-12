package year2024.month12_2024.N2610;

import java.util.*;
import java.io.*;

public class Main {
	public static int INF = 10000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[][] dist = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dist[i][j] = INF;
			}
		}

		for (int i = 1; i <= N; i++) {
			dist[i][i] = 0;
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			dist[s][e] = 1;
			dist[e][s] = 1;
		}

		for (int i = 1; i <= N; i++) {
			for (int s = 1;s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					if (dist[s][e] >= dist[s][i] + dist[i][e]) {
						dist[s][e] = dist[s][i] + dist[i][e];
					}
				}
			}
		}

		boolean[] visit = new boolean[N + 1];
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (visit[i]) {
				continue;
			}
			visit[i] = true;
			count++;

			Queue<Integer> q = new LinkedList<>();
			q.add(i);

			int max = 0;
			int maxNode = i;

			for (int j = 1; j <= N; j++) {
				if (dist[j][i] != INF && dist[j][i] != 0) {

					q.add(j);

					if (max < dist[j][i]) {
						max = dist[j][i];
					}
				}
			}

			while (!q.isEmpty()) {
				Integer poll = q.poll();
				visit[poll] = true;

				int maxTmp = 0;
				for (int j = 1; j <= N; j++) {
					if (dist[j][poll] != INF && dist[j][poll] != 0) {

						if (maxTmp < dist[j][poll]) {
							maxTmp = dist[j][poll];
						}
					}
				}

				if (maxTmp < max) {
					max = maxTmp;
					maxNode = poll;
				}
			}



			pq.add(maxNode);
		}

		System.out.println(count);
		while(!pq.isEmpty()) {
			Integer n = pq.poll();

			System.out.println(n);
		}
	}
}

// 알고 있는 사람은 같은 위원회 -> 유니온 파인드?
// 위원회의 수가 최대?
// 적은 사람, 거치느 사람의 수가 의사전달 시간
// 의사전달시간 최댓값이 최소가 되는 대표

// 1 2 3
// 1번 그룹을 나눈다 -> 유니온 파인드
// 그룹 별로 플로이드 워셔을 한다.
// dist[s][e]에서 e가 대표라고 생각하면, 각 행의 최댓값이 최소가 되면 된다.

// 유니온 파인드 시간복잡도
// 플로이드워셜 O(V^3)

// 사람의 수 N
// 알고있는 관계 M
// M 줄 서로 아는 사이

// 한 사람을 찾아보고, 그 안에서 INF가 아닌 사람들은 QUEUE에 넣어서 최소 확인, 모두 visit 처리
// 그 다음 visit 안 한 사람 방문
// 이렇게 sum 이 위원회 수

// 하나씩 방문
// INF가 아닌 것들은 큐에 넣는다.
// 방문했을 때 최댓값 구해야 함
// 최댓값이 최소가 되어야 함