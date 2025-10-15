package year2025.month10.N13164;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 원생의 수
		int K = Integer.parseInt(st.nextToken()); // 조

		st = new StringTokenizer(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int[] arr = new int[N + 1];

		for (int n = 1; n <= N; n++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr[n] = tmp;
		}

		long distSum = 0L;
		for (int n = 1; n < N; n++) {
			pq.add(arr[n + 1] - arr[n]);
			distSum += (long)(arr[n + 1] - arr[n]);
		}

		for (int k = 1; k <= K - 1; k++) {
			distSum -= (long)pq.poll();
		}

		System.out.println(distSum + " ");
	}
}

// N명의 원생
// K개의 조(같은 조 인접, 최소 1명, 인원수 같지 않아도 됨)
// 조마다 티셔츠(비묭 가장 키 큰 - 가장 키 작은)
// 티셔츠 비용 최소
