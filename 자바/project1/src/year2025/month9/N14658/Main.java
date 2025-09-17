package year2025.month9.N14658;

import java.util.*;
import java.io.*;

public class Main {

	static class Star {
		int x, y;
		Star(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 가로
		int M = Integer.parseInt(st.nextToken()); // 세로
		int L = Integer.parseInt(st.nextToken()); // 트램펄린 변
		int K = Integer.parseInt(st.nextToken()); // 별똥별 수

		Star[] stars = new Star[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			stars[i] = new Star(x, y);
		}

		int max = 0;
		// 별의 x좌표, y좌표를 기준으로 트램펄린 왼쪽 아래 좌표 후보 설정
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < K; j++) {
				int x1 = stars[i].x;
				int y1 = stars[j].y;

				int count = 0;
				for (int s = 0; s < K; s++) {
					if (x1 <= stars[s].x && stars[s].x <= x1 + L &&
						y1 <= stars[s].y && stars[s].y <= y1 + L) {
						count++;
					}
				}
				max = Math.max(max, count);
			}
		}

		System.out.println(K - max);
	}
}
