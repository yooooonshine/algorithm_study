package year2025.month1.N13168;

import java.util.*;
import java.io.*;

public class Main {
	public static int MAX = 90000000;
	public static int nodeSize;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 한국 도시 수
		int R = Integer.parseInt(st.nextToken()); // 내일로 가격

		Map<String, Integer> sti = new HashMap<>();
		Map<Integer, String> its = new HashMap<>();

		int index = 1;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			String name = st.nextToken();

			if (!sti.containsKey(name)) {
				sti.put(name, index);
				its.put(index, name);
				index++;
			}
		}

		nodeSize = sti.size();

		int M = Integer.parseInt(br.readLine()); // 도시 수

		List<Integer> visitCity = new ArrayList<>(); // 방문할 도시
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			visitCity.add(sti.get(st.nextToken()));
		}

		int K = Integer.parseInt(br.readLine()); // 교통수단 수
		List<Edge> edges = new ArrayList<>();

		// 거리 배열 초기화
		int[][] dist = new int[nodeSize + 1][nodeSize + 1];
		for (int i = 1; i <= nodeSize; i++) {
			for (int j = 1; j <= nodeSize; j++) {
				dist[i][j] = MAX;
			}
		}
		for (int i = 1; i <= nodeSize; i++) {
			dist[i][i] = 0;
		}

		// 교통수단 초기화
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());

			String type = st.nextToken();
			int s = sti.get(st.nextToken());
			int e = sti.get(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edges.add(new Edge(s, e, w, type));

			if (dist[s][e] > w) {
				dist[s][e] = w;
				dist[e][s] = w;
			}
		}

		// 내일로 적용 후를 위한 배열
		int[][] dist2 = new int[nodeSize + 1][nodeSize + 1];
		for (int i = 1; i <= nodeSize; i++) {
			for (int j = 1; j <= nodeSize; j++) {
				dist2[i][j] = dist[i][j];
			}
		}
		for (Edge edge : edges) {
			int price = discount(edge.w, edge.type);
			if (dist2[edge.s][edge.e] > price) {
				dist2[edge.s][edge.e] = price;
				dist2[edge.e][edge.s] = price;
			}
		}

		fw(dist);

		int beforePrice = 0;
		int beforeVisit = visitCity.get(0);
		for (int i = 1; i <= visitCity.size() - 1; i++) {
			beforePrice += dist[beforeVisit][visitCity.get(i)];

			beforeVisit = visitCity.get(i);
		}

		fw(dist2);
		int afterPrice = 0;
		beforeVisit = visitCity.get(0);
		for (int i = 1; i <= visitCity.size() - 1; i++) {

			afterPrice += dist2[beforeVisit][visitCity.get(i)];

			beforeVisit = visitCity.get(i);
		}

		if (beforePrice > afterPrice + R) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	public static int discount(int price, String type) {
		if (type.equals("Mugunghwa") || type.equals("ITX-Saemaeul") || type.equals("ITX-Cheongchun")) {
			return 0;
		} else if (type.equals("S-Train") || type.equals("V-Train")) {
			return price / 2;
		}
		return price;
	}

	public static void fw(int[][] dist) {
		for (int v= 1; v <= nodeSize; v++) {
			for (int s = 1; s <= nodeSize; s++) {
				for (int e = 1; e <= nodeSize; e++) {
					if (dist[s][e] > dist[s][v] + dist[v][e]) {
						dist[s][e] = dist[s][v] + dist[v][e];
					}
				}
			}
		}
	}

	public static class Edge {
		int s;
		int e;
		int w;
		String type;

		public Edge(int s, int e, int w, String type) {
			this.s = s;
			this.e = e;
			this.w = w;
			this.type = type;
		}
	}
}
// N개의 도시
// 여행할 도시 M개
// 같은 도시 여러번 방문 가능
// 시작도시, 끝도시는 같다.
// M개의 도시 최소비용
// R원 내일로 무궁화, itx-새마을, itx-청춘은 무료
// s-train, v-train은 50프로 할인\

// N R (한국 도시 수, 내일로 티켓 가격)
// N개의 도시이름
// 여행할 도시의 수 M
// M개의 도시 이름
// 교통 수단 수 K
// 교통 수단 정보 K개의 줄
// 교통 수단 Type, S E Cost 왕복
// N개중에 같은 도시 이름이 있을 수 있다, -> 같은 도시라 생각 Map 사용

// 내일로 Yes No 출력. 비용이 같으면 No

// 도시 이름과 숫자를 Map으로 저장시켜둔다.
// 1. 내일로 티켓 구매 전 후에 대해 각각 알고리즘을 돌려야 한다.

// 플로이드 워셜 -> V^3
// 서울에서

// 서울에서 모든 목적지까지 최단 탐색 비용?
// 최소 신장 트리?

// 수단은 따로 저장해둔다.
// Edge에는 s, e 비용, 수단
// 이는 단순 리스트로 들고 있는다.

// 플로이드 워셜을 통해 각 위치별 거리 구한다.
// 행렬 생성 i,i 는 0 빈곳은 무한대
// v에 대해 워셜 돌린다.
// 다시 행렬을 업데이트 한다.
// 플로이드 워셜 돌린다.