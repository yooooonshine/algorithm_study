package year2024.month6_2024.N2164;

import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> myQueue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			myQueue.add(i);
		}


		while (true) {
			myQueue.poll();
			if (myQueue.size() <= 1) {
				break;
			}
			Integer num = myQueue.poll();
			myQueue.add(num);
		}

		System.out.println(myQueue.poll());
	}

}
