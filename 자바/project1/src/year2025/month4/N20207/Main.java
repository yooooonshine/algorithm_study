package year2025.month4.N20207;

import java.util.*;
import java.io.*;

public class Main {

	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		List<Plan> plans = new ArrayList<>();
		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			plans.add(new Plan(s, e));
		}

		Collections.sort(plans);

		int[] countArr = new int[366];// 0일 제외
		for (Plan p : plans) {
			int s = p.s;
			int e = p.e;

			for (int i = s; i <= e; i++) {
				countArr[i]++;
			}
		}

		int depth = 0;
		int length = 0;

		int result = 0;
		for (int i = 1; i <= 365; i++) {
			if (countArr[i] == 0) {
				result += depth * length;
				depth = 0;
				length = 0;
				continue;
			}
			length++;
			if (depth < countArr[i]) {
				depth = countArr[i];
			}
		}
		result += depth * length;

		System.out.println(result);
	}

	public static class Plan implements Comparable<Plan> {
		int s;
		int e;

		public Plan(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Plan p) {
			return this.s - p.s;
		}
	}
}


// 일정(시작일, 종료일)
// 같은 시작일 -> 일정이 긴거부터
// 시작일 앞선것부터


// 전부 배치한 후에 두께x길이

// 시작순으로 정렬
// 2 4
// 4 5
// 5 6
// 5 7
// 7 9
// 11 12
// 12 12

// 숫자배열
// 2 ~ 4 카운트 ++
//

// 1 2 3 4 5 6 7 8 9 10 11 12
// 0 1 1 2 3 2 2 1 1 0  1  2

// 이렇게 구한 후
// 0이면 리셋
// 끝이면 리셋
