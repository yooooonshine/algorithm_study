package year2025.month10.N2015;

import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); //  N개의 수
		int K = Integer.parseInt(st.nextToken()); // K개 되는 것

		Map<Integer, List<Integer>> map = new HashMap<>();

		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}

		int[] sum = new int[N + 1];
		for (int n = 1; n <= N; n++) {
			sum[n] = sum[n - 1] + arr[n];
		}

		Set<Integer> set = new HashSet<>();
		for (int n = 0; n <= N; n++) {
			set.add(sum[n]);

			if (map.containsKey(sum[n])) {
				map.get(sum[n]).add(n);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(n);
				map.put(sum[n], list);
			}
		}

		List<Integer> sortedList = new ArrayList<>(set);

		Collections.sort(sortedList);


		long count = 0;


		// 개수 세기
		int i1 = 0;
		int i2 = 0;
		while (i2 < sortedList.size() && i1 < sortedList.size()) {
			int diff = sortedList.get(i2) - sortedList.get(i1);
			if (diff < K) {
				i2++;
			} else if (diff > K) {
				i1++;
			} else {
				// diff == K
				if (K == 0) {
					List<Integer> list = map.get(sortedList.get(i1));

					int size = list.size();
					count += (size * (size - 1)) / 2;

				} else {
					List<Integer> list1 = map.get(sortedList.get(i1));
					List<Integer> list2 = map.get(sortedList.get(i2));

					for (int index1 : list1) {
						for (int index2 : list2) {
							if (index2 > index1) {
								count++;
							}
						}
					}


				}
				i2++;
			}
		}

		System.out.println(count);
	}
}


// 음수 가능