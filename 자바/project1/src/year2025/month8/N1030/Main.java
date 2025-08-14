package year2025.month8.N1030;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken()); // 시간
		int N = Integer.parseInt(st.nextToken()); // N x N으로 변함
		int K = Integer.parseInt(st.nextToken()); // 가운데 K x K가 검정
		int R1 = Integer.parseInt(st.nextToken()); // R1행 C1열, 0포함
		int R2 = Integer.parseInt(st.nextToken()); // R2행 C2열
		int C1 = Integer.parseInt(st.nextToken());
		int C2 = Integer.parseInt(st.nextToken());

		// 모양 만들기
		int[][] shape = new int[N][N];
		int start = (N - K) / 2;
		int end = N - 1 - start;
		for (int r = start; r <= end; r++) {
			for (int c = start; c <= end; c++) {
				shape[r][c] = 1;
			}
		}

		int width = (int)Math.pow(N, S);
		int[][] arr = new int[width][width];
		int[][] tmpArr = new int[width][width];
		int nowWidth = 1;

		for (int s = 1; s <= S; s++) {
			for (int r = 0; r < nowWidth; r++) {
				for (int c = 0; c < nowWidth; c++) {

					for (int tr = 0; tr < N; tr++) {
						for (int tc = 0; tc < N; tc++) {
							if (arr[r][c] == 1) {
								tmpArr[r * N + tr][c * N + tc] = 1;
							} else {
								tmpArr[r * N + tr][c * N + tc] = shape[tr][tc];
							}
						}
					}

				}
			}

			int[][] tmpArr2 = arr;
			arr = tmpArr;
			tmpArr = tmpArr2;

			nowWidth *= N;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int r = R1; r <= R2; r++) {
			for (int c = C1; c <= C2; c++) {
				if (arr[r][c] == 1) {
					bw.write("1");
				} else {
					bw.write("0");
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}
}

// 흰색 -> 가운데가 흰색인 3x3
// 검은색 -> 검정색

// 총 N ^ 시간의 크기가 필요하다.

// N,K 사각형을 만들어둔다.
// 배열을 돌면서 이에 맞게 각 칸을 늘린다.


// 5 - 3 = 2 / 2 = 1
// 1 <= x <= 5 - 1 - 1


// 4 - 2 = 2 / 2 = 1
// 1 <= x <= 4 - 1 - 1
