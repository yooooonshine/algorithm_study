package year2024.month12_2024.N3273;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Integer[] arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

		Arrays.sort(arr);

		int x = Integer.parseInt(br.readLine());
		int sum = 0;
		int s = 0;
		int e = n - 1;
		while (s < e) {
			if (arr[s] + arr[e] == x) {
				sum++;
				e--;
			} else if (arr[s] + arr[e] < x) {
				s++;
			} else {
				e--;
			}
		}

		System.out.println(sum);
	}

	// n
	// n개의 수
	// x

	// 1 정렬을 한다
	// 2 투포인터?
	// 양 끝에서 시작, x보다 크면 오른쪽을 내린다.
	// x보다 작으면 왼쪽을 키운다.
	// 같으면 오른쪽을 내린다.
}