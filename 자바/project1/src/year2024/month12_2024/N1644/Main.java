package year2024.month12_2024.N1644;

import java.util.*;
import java.io.*;

public class Main {

	public static int[] sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] sosu = new boolean[N + 1];
		Arrays.fill(sosu, true);
		sosu[0] = false;
		sosu[1] = false;

		for (int i = 2; i <= N; i++) {
			int index = 2;


			while (index * i <= N) {
				sosu[index * i] = false;

				index++;
			}
		}

		List<Integer> mySosu = new ArrayList<>();
		mySosu.add(0);
		for (int i = 1; i <= N; i++) {
			if (sosu[i]) {
				mySosu.add(i);
			}
		}

		mySosu.replaceAll((n) -> n * 2);

		sum = new int[mySosu.size()];
		for (int i = 1; i < mySosu.size(); i++) {
			sum[i] = mySosu.get(i) + sum[i - 1];
		}

		int count = 0;
		int s = 1;
		int e = 1;
		while(s <= e && e <= sum.length - 1) {
			if (sum(s, e) == N) {
				count ++;
				e++;
			}else if (sum(s, e) < N) {
				e++;
			}else if (sum(s, e) > N) {
				s++;
			}
		}

		System.out.println(count);
	}

	public static int sum(int s, int e) {
		return sum[e] - sum[s - 1];
	}
}


// 자연수를 연속된 소수의 합으로 나타낼 수 있는 경우의 수
// 소수? 아리스토체레스의 체?
// N
//

// 1. N이하의 소수를 모두 구한다.
// 연속된 -> 투표인터?
// 구간합?

// 1. N이하의 소수
// 아리스토 N
// 배열 for 2부터 for문 돌면서
// 각 수의 배수는 모두 소수 아님 처리
// 2. 구간합 배열을 만든다
// N
// 3. 투포인터를 이용해 이를 만족시키는 소수를 모두 구한다.

// 왼쪽 1에서 모두 시작. 곂쳐도 되니까
// s <= e이면서 , e <= N
// 작으면 e ++
// 크면 s++