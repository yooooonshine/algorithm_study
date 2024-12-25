package year2024.month12_2024.N2357;

import java.util.*;
import java.io.*;

public class Main {
	public static int[] maxSeg;
	public static int[] minSeg;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int k = 1;
		while (true) {
			if ((int)Math.pow(2, k) > N) {
				break;
			}
			k++;
		}


		maxSeg = new int[(int)Math.pow(2, k + 1)];
		minSeg = new int[(int)Math.pow(2, k + 1)];


		int startSeg = (int) Math.pow(2, k);

		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());

			maxSeg[startSeg + i] = tmp;
			minSeg[startSeg + i] = tmp;
		}

		for (int i = startSeg + N; i < startSeg * 2; i++) {
			maxSeg[i] = 0;
			minSeg[i] = Integer.MAX_VALUE;
		}

		for (int i = startSeg - 1; i >= 1; i--) {
			int tmpMax = maxSeg[2 * i];
			int tmpMin = minSeg[2 * i];

			if (tmpMax < maxSeg[2 * i + 1]) {
				tmpMax = maxSeg[2 * i + 1];
			}
			if (tmpMin > minSeg[2 * i + 1]) {
				tmpMin = minSeg[2 * i + 1];
			}



			maxSeg[i] = tmpMax;
			minSeg[i] = tmpMin;
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			System.out.println(min(s - 1 +  startSeg, e - 1 + startSeg) + " " + max(s - 1 + startSeg, e - 1 + startSeg));
		}

	}

	public static int min(int s, int e) {
		List<Integer> tmp = new ArrayList<>();

		while (s <= e) {
			if (s % 2 == 1) {
				tmp.add(minSeg[s]);
			}
			if (e % 2 == 0) {
				tmp.add(minSeg[e]);
			}

			s = (s + 1) / 2;
			e = (e - 1) / 2;
		}

		Collections.sort(tmp);

		return tmp.get(0);
	}

	public static int max(int s, int e) {
		List<Integer> tmp = new ArrayList<>();

		while (s <= e) {
			if (s % 2 == 1) {
				tmp.add(maxSeg[s]);
			}
			if (e % 2 == 0) {
				tmp.add(maxSeg[e]);
			}

			s = (s + 1) / 2;
			e = (e - 1) / 2;
		}

		Collections.sort(tmp, Collections.reverseOrder());

		return tmp.get(0);
	}
}

// 작은 값, 큰 값을 M 번 찾기 -> 세그먼트 트리

// int 선언 가능
// N, M 이 주어진다.
// N개의 줄 N개의 정수
// M개의 줄 a, b

// 세그먼트 트리
// 2 ^ k > N인 k를 찾는다.
// 2 ^ k + 1인 배열 선언
// 2 ^ k부터 배열 채운다. N 을 0부터 하고, 2 ^ k  + i 에 채운다
// 최소, 최대 두개만든다.
// 2 ^ k - 1부터 값을 채운다. * 2, * 2 + 1 을 비교

// 최대 찾기
// s, e에서
// s > e 까지 계속한다.
// s % 2 == 1 이면 선택하여 넣는다/
// e % 2 == 0 이면 선택하여 넣는다
// (s + 1) / 2 로 이동
// (e - 1) / 2 로 이동

// 값들 중에 최소, 최대 꺼낸다. for 문으로 처리한다.
