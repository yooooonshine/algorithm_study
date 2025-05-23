package year2025.month3.N14719;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken()); // 세로
		int W = Integer.parseInt(st.nextToken()); // 가로

		int[][] world = new int[H + 1][W + 1]; // r,c
		// 건물 세팅하기
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= W; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= tmp; j++) {
				world[j][i] = 1;
			}
			world[0][i] = 1;
		}

		int count = 0; // 결과 값, 고인 량

		// 물채우기
		for (int h = 1; h <= H; h++) {
			int s = 0;
			boolean change = false;
			boolean can = true;

			for (int w = 1; w <= W; w++) {
				if (world[h][w - 1] == 0 && world[h][w] == 1) {
					// 처음 1일 때
					if (s == 0) {
						s = w;
						can = true;
						continue;
					}

					// 물 안 샐 때
					if (can) {
						// 사이 채우기
						change = true;
						for (int tw = s + 1; tw <= w - 1; tw++) {
							world[h][tw] = 2;
							count++;
						}
					}

					// 물 안새면 따로 변경x

					// 값 초기화
					can = true;
					s = w;
				} else if (world[h][w - 1] == 1 && world[h][w] == 1) {
					s = w;
				} else {
					if (world[h - 1][w] == 0) {
						can = false;
					}
				}
			}
		}

		// 고이지 않았으면 0 출력
		System.out.println(count);
	}
}


// 1채워져있음. 0비워져있음 2 물로채움



// change = false
// can = true
// 처음 만난 1이면 s 갱신 -> 케이스 이전 0에서 가능
// 이전이 1이었는데, 현재도 1이면 s++
// 이전이 1이었는데 현재가 0이면
// w순회하다가 밑이 0이면 can = false;
// 이전이 0이었는데 현재가 1이면 고인 곳 끝
// 이 때 can이 true면 사이를 2로 채우기 및 change = true, false면 그대로
// start 갱신, can true, count도 올리기