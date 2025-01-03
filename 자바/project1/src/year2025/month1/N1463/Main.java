package year2025.month1.N1463;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 3];
		arr[0] = 0;
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;

		for (int n = 4; n <= N; n++) {
			boolean two = false;
			boolean three = false;

			if (n % 2 == 0) {
				two = true;
			}
			if (n % 3 == 0) {
				three = true;
			}

			if (two && three) {
				int tmp = Math.min(arr[n / 2] + 1, arr[n / 3] + 1);
				tmp = Math.min(tmp, arr[n - 1] + 1);
				arr[n] = tmp;
			} else if (two && !three) {
				int tmp = Math.min(arr[n / 2] + 1, arr[n - 1] + 1);
				arr[n] = tmp;
			} else if (!two && three) {
				int tmp = Math.min(arr[n / 3] + 1, arr[n - 1] + 1);
				arr[n] = tmp;
			} else {
				arr[n] = arr[n - 1] + 1;
			}
		}

		System.out.println(arr[N]);
	}
}


// 3으로 나눠지면 3으로
// 2로 나눠지면 2로 나눈다
// 1을 뺀다 -> 더한다

// 연산 최소 횟수

// 이거 규칙이 있다.

// 10 9 3 1
// 3의 배수는 계속 3으로

// 역연산이 맞을 거 같은데?

// 일반적인 알고리즘이 아니다.
// 그리디?

// 2의 배수를 모두 채운다?

// 2 4 8 16 32 64 128
//  3 9 27 81
// 15라면?
// 5 4 2 1


// 1 2 3 4 5 6 7 8 9 10
// 0 1 1 2 3 2 3 3 2 3


// D[n] = Math.min(D[n - 1] + 1, D[n / 2] + 1, D[ n / 3] + 1);