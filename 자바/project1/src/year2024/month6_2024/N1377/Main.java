package year2024.month6_2024.N1377;

import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<Integer> L = new ArrayList<>();
		L.add(0);
		for (int i = 1; i <= N; i++) {
			L.add(Integer.parseInt(br.readLine()));
		}


		int count = 1;
		for (int i = 1; i < N; i++) {
			if (L.get(i) > L.get(i + 1)) {
				L.remove(i);
				N--;
				i -= 2;
				count++;
			}
		}
		System.out.println(count);
	}
}
