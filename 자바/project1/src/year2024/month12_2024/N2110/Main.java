package year2024.month12_2024.N2110;

import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int C;
	public static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (max < tmp) {
				max = tmp;
			}
			arr[i] = tmp;
		}
		Arrays.sort(arr);

		int s = 1;
		int e = max;
		int m = (s + e) / 2;

		int result = 0;
		while (s <= e) {
			if (canPut(m)) {
				result = m;
				s = m + 1;
				m = (s + e) / 2;
			} else {
				e = m - 1;
				m = (s + e) / 2;
			}
		}

		System.out.println(result);
	}


	public static boolean canPut(int d) {
		int count = 1;

		int before = arr[0];
		for (int i = 1; i < N; i++) {
			if (arr[i] - before >= d) {
				count ++;
				before = arr[i];
			}
		}

		if (count >= C) {
			return true;
		} else {
			return false;
		}
	}
}


// N개
// 집의 좌표 x1 ~ xn
// 공유기 C개
// 가장 가까운 공유기 사이 거리를 가장 크게?
// 각각 최대한 멀리?

// 그리디?
// 거리를 기준으로? 이진 탐색?
// C에 대해 N은 안되네 이진 탐색으로 해야하나

// N, C
// N개의 집의 좌표

// 1간격으로 심는다. 124,
// 설치 간격을 최대한 크게?
// 5간격으로 심는다
// 1 8 설치 불가
// 4 간격이상으로 심는다
// 1 8 설치 불가
// 3 간격 이상으로 심는다/
// 1, 4, 8 설치 가능

// 설치 가능하면 k를 늘리고
// 설치 불가능하면 좁힌다.

// 2간격 이상으로 심는다
// 1 4 8 이 때 최대는 계속 계산해야 하나?
// 이분탐색이니까 k를 늘려 최대 k를 구하면 자동으로 되겠구나.