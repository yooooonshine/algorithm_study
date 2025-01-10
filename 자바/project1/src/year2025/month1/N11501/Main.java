package year2025.month1.N11501;
import java.util.*;
import java.io.*;

public class Main {
	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			long[] arr = new long[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[j] = Long.parseLong(st.nextToken());
			}

			long result = stock(arr);
			bw.write(result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static long stock(long[] arr) {

		long max = 0;
		int maxIndex = 0;
		for (int i = 1; i <= N; i++) {
			if (max < arr[i]) {
				max = arr[i];
				maxIndex = i;
			}
		}

		int startI = 1;

		long sum = 0L;

		while (true) {
			if (maxIndex > N) {
				break;
			}

			for (int i = startI; i <= maxIndex; i++) {

				sum = sum + max - arr[i];
			}

			maxIndex++;
			startI = maxIndex;
			max = 0;
			for (int i = maxIndex; i <= N; i++) {
				if (max < arr[i]) {
					max = arr[i];
					maxIndex = i;
				}
			}
		}
		return sum;
	}

	public static class Point implements Comparable<Point> {
		long p;
		int index;

		public Point(long p, int index) {
			this.p = p;
			this.index = index;
		}

		@Override
		public int compareTo(Point p) {
			if (p.p - this.p > 0) {
				return 1;
			} else if (p.p - this.p < 0) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}

// 주식 사기
// 팔기
// 가만히
// 최대 이익?
// dp?

// 10 7 6

// 최고점을 파악?
// 최고점이 올 때까진 사야된다.
// 높은 순으로 sort한다.
// 높은 순 이전까지는 산다.
// 높은 순에 판다
// 이렇게 소모된 날들은 visit 체크
// 정답 출력
