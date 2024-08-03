package year2024.month7_2024.N21939;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 문제의 개수


		HashMap<Integer, Integer> pl = new HashMap<>();

		int maxP = 0;
		int maxL = 0;
		int minP = 0;
		int minL = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			pl.put(P, L);

			if (L > maxL) {
				maxL = L;
				maxP = P;
			} else if (minL > L) {
				minL = L;
				minP = P;
			}
		}

		int M = Integer.parseInt(br.readLine()); // 명령문의 개수

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			String type = st.nextToken();
			if (Objects.equals(type, "recommend")) {
				int option = Integer.parseInt(st.nextToken());
				recommend(option, maxP, minP);
			} else if (Objects.equals(type, "add")) {
				int P = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());

				pl.put(P, L);

				if (L > maxL) {
					maxL = L;
					maxP = P;
				} else if (minL > L) {
					minL = L;
					minP = P;
				}
			} else {
				int P = Integer.parseInt(st.nextToken());
				int L = pl.get(P);

				pl.remove(P);
			}
		}

		// 문제 번호 P, 난이도 L (N 번)
		// 입력될 명령문의 개수 M
		// 명령문 M번

	}

	public static void recommend(int option, int maxP, int minP) {

		if (option == 1) {
			System.out.println(maxP);
		} else {
			System.out.println(minP);
		}
	}
}


// recommend x -> 1:가장 어려운 문제, 같으면 문제 번호 큰 것, -1 : 가장 쉬운, 문제 번호 작은 것
// add P L -> 난이도 L인 문제 번호 P 추가, 이미 있는 문제 번호면 난이도 증가
// solved P -> 추천 문제 리스트에서 제거


// recommend가 오면 정렬을 한다.
// 트리?
//