package year2024.month12_2024.N1377;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Num> nums = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			nums.add(new Num(i, Integer.parseInt(br.readLine())));
		}

		List<Num> newNums = new ArrayList<>(nums);
		Collections.sort(newNums, (a, b) -> a.v - b.v);

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, newNums.get(i).i - i);
		}

		System.out.println(max + 1);


	}

	public static class Num {
		int i;
		int v;

		public Num(int i, int v) {
			this.i = i;
			this.v = v;
		}
	}
}