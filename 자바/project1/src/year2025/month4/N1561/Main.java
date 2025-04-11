package year2025.month4.N1561;

import java.util.*;
import java.io.*;

public class Main {

	public static int N, M; // N명, 놀이기구 1~M
	public static int[] runTime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // N명
		M = Integer.parseInt(st.nextToken());	 // 놀이기구 M

		runTime = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			runTime[i] = Integer.parseInt(st.nextToken());
		}

		long maxT = 60000000000L;
		long s = 0;
		long e = maxT;

		while (s <= e) {
			long m = (s + e) / 2;

			int tmp = calc(m);
			if (tmp == - 1) {
				e = m - 1;
			} else if (tmp == -2) {
				s = m + 1;
			} else {
				System.out.println(tmp);
				break;
			}
		}
	}
	public static int calc(long m) {
		// System.out.println(m);
		long sumMin = 0L;
		long sumMax = 0L;

		List<Integer> list = new ArrayList<>();

		for (int i  = 1; i < runTime.length; i++) {
			if (m % (long)runTime[i] == 0L) {
				sumMin += m / (long)runTime[i];
				list.add(i);
			} else {
				sumMin += m / (long)runTime[i] + 1L;
			}

			sumMax += m / (long)runTime[i] + 1L;
		}

		if (sumMin < N && N <= sumMax) {
			int index = (int)(N - sumMin) - 1; // 0번부터
			return list.get(index);
		} else if(N <= sumMin) {
			return -1;
		} else {
			// sumMax보다 많을 때 -> 시간 늘려야 함.
			return -2;
		}
	}
}

// 아 그니까 특정 초에 총 지금까지 탄인원과 각각에 1 을 더했을 때 이 사이에 N이 있으면 되는 구나
// 탄 인원  -> 몫과 나머지가 있는 쪽은 1씩 더하기
// 사이면 o에 해당하는 쪽에 1씩 더해가다가. N명과 동일해지면 그 인덱스
// 구한 합이 인원보다 많으면
// 같으면 -> 최대한 왼쪽을 찾아내야 되나



// logN만 가능하네...이분탐색.
// N에 대한 이분탐색인가

// 시간이 중요하지는 않네.

// 최소 공배수 6 -> 2 3명 총 5명
// 7 % 5 = 2

// 60

// 60, 30, 20,15, 12

// 시간을 기준으로 이분탐색?

// 5초면 몇명? -> 5 2 1, 1 1

// 3초면 몇명? 3 1 1 1 1
// 8초면? 8 4 2 2 1
// 10초면?
// 여기서 나눠지는 숫자에 차례대로
// 9초면 9 4 3 2 1 => 끝난 숫자.
//       o x o x x
// 9초에 10명, 5명, 4명, 3명, 2명
// 8초에 8 4 2 2 1 = 17
// o o x o x
// 19명

// 9명 5명, 3명 3명, 2명
// 10c초면 10 5 3 2 2
//         o  o x x o



// 30 * 2 ^ 10^9 = 6 * 10^10
// log -> 10 ^ 3 = 1000정도
// 1000 * 10000 => 10^7 가능