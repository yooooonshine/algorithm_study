package year2024.month6_2024.N11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Map<Integer, PriorityQueue<Integer>> myMap = new HashMap<>();
		PriorityQueue<Integer> myPQ = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			int absNum = Math.abs(num);

			if (num == 0) {
				if (myPQ.isEmpty()) {
					System.out.println(0);
					continue;
				}
				Integer peek = myPQ.peek();
				Integer poll = myMap.get(peek).poll();
				System.out.println(poll);

				if (myMap.get(peek).isEmpty()) {
					myMap.remove(peek);
					myPQ.poll();
				}
			} else {
				if (myMap.containsKey(absNum)) {
					PriorityQueue<Integer> integers = myMap.get(absNum);
					integers.add(num);
					myMap.replace(absNum, integers);
				} else {
					PriorityQueue<Integer> integers = new PriorityQueue<>();
					integers.add(num);
					myPQ.add(absNum);
					myMap.put(absNum, integers);
				}
			}

		}
	}
}
