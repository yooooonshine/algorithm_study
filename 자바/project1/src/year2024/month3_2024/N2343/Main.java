package year2024.month3_2024.N2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 강의의 수
		int N = Integer.parseInt(st.nextToken());
		//블루레이 개수
		int M = Integer.parseInt(st.nextToken());

		List<Integer> inputList = new ArrayList<Integer>();

		for (String input : br.readLine().split(" ")) {
			inputList.add(Integer.parseInt(input));
		}

		Integer sum = 0;
		Integer start = 0;
		for (Integer i : inputList) {
			sum += i;

			if (start < i) {
				start = i;
			}
		}

		System.out.println(binarySearch(inputList, start, sum, M));
	}

	public static int binarySearch(List<Integer> arr, int start, int end, int M) {
		int min = end;

		while (start <= end) {
			int mid = (start + end) / 2;

			// System.out.println("중간값 :" + mid);



			int count = 1;
			int sum = 0;
			for (Integer num : arr) {

				if (num + sum <= mid) {
					sum += num;
				} else {
					sum = num;
					count++;
				}
			}

			// System.out.println("카운트" + count);
			if (count <= M) {
				if (min > mid) {
					min = mid;
				}

				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}


		return min;
	}
}
