package year2025.month4.N21610;

import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static int M;

	public static int[][] buckets;

	// 1번부터 8번 이동방향
	public static int[] rs = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	public static int[] cs = {0, -1, -1, 0, 1, 1, 1, 0, -1};

	public static int[] wrs = {1, 1, -1, -1};
	public static int[] wcs = {1, -1, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 격자 칸수
		M = Integer.parseInt(st.nextToken()); // M번 요청

		buckets = new int[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				buckets[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int[] D = new int[M + 1]; // 방향
		int[] S = new int[M + 1]; // 이동횟수

		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			D[m] = Integer.parseInt(st.nextToken());
			S[m] = Integer.parseInt(st.nextToken());
		}

		List<Cloud> clouds = new ArrayList<>();
		clouds.add(new Cloud(N, 1));
		clouds.add(new Cloud(N, 2));
		clouds.add(new Cloud(N - 1, 1));
		clouds.add(new Cloud(N - 1, 2));

		for (int m = 1; m <= M; m++) {
			int d = D[m];
			int s = S[m];

			boolean[][] visit = new boolean[N + 1][N + 1];
			for (Cloud cloud : clouds) {
				move(cloud, d, s);
				buckets[cloud.r][cloud.c]++;
				visit[cloud.r][cloud.c] = true;
			}

			for (Cloud cloud : clouds) {
				waterCopy(cloud);
			}

			clouds.clear();

			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if (visit[r][c]) {
						continue;
					}

					if (buckets[r][c] >= 2) {
						clouds.add(new Cloud(r, c));
						buckets[r][c] -= 2;
					}
				}
			}
		}

		int sum = 0;
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				sum += buckets[r][c];
			}
		}

		System.out.println(sum);
	}

	public static void move(Cloud cloud, int d, int s) {
		int rd = rs[d];
		int cd = cs[d];
		for (int i = 1; i <= s; i++) {
			if (cloud.r + rd > N) {
				cloud.r = (cloud.r + rd) % N;
			} else if (cloud.r + rd < 1) {
				cloud.r = (cloud.r + rd + N);
			} else {
				cloud.r = cloud.r + rd;
			}

			if (cloud.c + cd > N) {
				cloud.c = (cloud.c + cd) % N;
			} else if (cloud.c + cd < 1) {
				cloud.c = (cloud.c + cd + N);
			} else {
				cloud.c = cloud.c + cd;
			}
		}
	}

	public static void waterCopy(Cloud cloud) {
		int count = 0;
		for (int i = 0; i <= 3; i++) {
			int r = cloud.r + wrs[i];
			int c = cloud.c + wcs[i];

			if (r >= 1 && r <= N && c >= 1 && c <= N && buckets[r][c] > 0) {
				count++;
			}
		}

		buckets[cloud.r][cloud.c] += count;
	}

	public static class Cloud {
		int r;
		int c;

		public Cloud(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}

// if (x > N) -> x % N
// if (x < 1) -> (x + N - 1)

// 처음 구름 4개 위치 저장
// 각 구름 move(s, d) 메서드 호출
// 각 구름 위치별로 물 증가
// 각 구름 위치별로 물복사 마법(대각선)

// 기존 구름 제거
// 구름 생성 물감소

// 비구름
// N x N 격자
// 각 바구니 저장 물의 양 제한 x
// A[r][c] = 물의 양
// 1번행 N번행 연결

// (x + N) % N  + 1

// 비바리기 시전
// N-1,1 N-1,2
// N,1 N,2

// 이동 M번
// 모든 구름 di, si(방향, 거리)
// 이동 후, 각 칸에 물 + 1
// 구름 제거
// 물 증가한 칸에 물복사마법, -> 대각선 거리 칸, 물이 있는 수만큼 물증가(경계넘기x)
// 물의 양 2 이상인 칸 구름 생성 & 물감소, 구름이 사라진 칸은 x

// 1 - 8이면
// 1에서 -2칸
// 0 -1
//

