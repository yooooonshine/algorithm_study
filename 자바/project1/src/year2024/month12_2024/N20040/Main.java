package year2024.month12_2024.N20040;

import java.util.*;
import java.io.*;

public class Main {
	public static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (find(a) == find(b)) {
				System.out.println(i);
				return;
			}

			union(a, b);
		}
		System.out.println(0);
	}

	public static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);

		if (parentA < parentB) {
			parent[parentA] = parentB;
		} else if (parentA > parentB) {
			parent[parentB] = parentA;
		}
	}

	public static int find(int a) {
		if (a == parent[a]) {
			return a;
		}

		return parent[a] = find(parent[a]);
	}
}

// 선 플레이어가 홀수차례
// 후 플레이러가 짝수, 돌아가면서

// 싸이클 생성하면 끝 a에서 출발해 한번씩만 지나 출발점으로
// 싸이클이 형성됐는 지, 게임이 진행되는 지
// n 점의 개수
// m 번째 차례까지

// 싸이클 형성은 어떻게 판단하지?
// 집합에서 하나의 선분이 빼도 같은 집합인지?