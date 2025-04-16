package year2025.month4.N5052;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			boolean result = true;
			Num start = new Num(false);
			String[] arr = new String[N];
			for (int n = 0; n < N; n++) {
				arr[n] = br.readLine();
			}
			Arrays.sort(arr, (a, b) -> {
				return a.length() - b.length();
			});
			for (int n = 0; n < N; n++) {
				int[] pn = Arrays.stream(String.valueOf(arr[n]).split("")).mapToInt(Integer::parseInt).toArray();

				boolean tmpR = start.add(pn, 0);
				if (!tmpR) {
					result = false;
					break;
				}
			}

			if (result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static class Num {
		Num[] arr = new Num[10];

		boolean exist;

		public Num(boolean exist) {
			this.exist = exist;
		}

		public boolean add(int[] pn, int index) {
			if (index  >= pn.length) {
				if (this.exist) {
					return false;
				}
				this.exist = true;
				return true;
			}

			if (this.exist) {
				return false;
			}

			if (arr[pn[index]] == null) {
				arr[pn[index]] = new Num(false);
			}

			return arr[pn[index]].add(pn, index + 1);
		}
	}
}

// 잇으면 들어간다.
// 툭정 값이 null이면 생성하고 넣는다.
// 마지막이면 생성하고 true 넣는다.

// 12345
// 123

// 한 번호가 다른 번호의 접두어x
// 즉 앞부분이 겹치면 안된다.
//
// 전화번호의 수 n

// 숫자를 정렬시키면?
// 큰순서대로
//911
//98346
//91125426
//97625999

// Map을 사용할까?
// Map에 하나씩 넣는데
// 대신 equals를 변경
// 글자 크기를 맞추고 같은지

//5
//12345
//123440
//12340
//113

// 가장 짧은 번호가 다른 번호들 앞에 있다면?
// 크기가 10000
// n, logn
// 투포인터
// 이진탐색
// 그리디
// dp
//
// 앞부분부터 트리로 구성하면
// 짧은 순서대로 숫자를 넣는다.
// 마지막에 true라고 해놓는다.
// 특정번호를 들어가면서 true이면 안됌

// 공간이 문제될 거 같다.
