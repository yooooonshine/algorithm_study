package year2024.month6_2024.N1717;

import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //원소 개수
		int m = Integer.parseInt(st.nextToken()); //질의 개수

		int[] A = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			A[i] = i;
		}


		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int calc = Integer.parseInt(st.nextToken());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			if (calc == 0) {
				union(A, node1, node2);
			} else {
				int p1 = find(A, node1);
				int p2 = find(A, node2);

				if (p1 == p2) {
					bw.write("YES\n");
				} else {
					bw.write("NO\n");
				}
			}
		}

		bw.flush();
		bw.close();

	}

	public static void union(int[] A, int node1, int node2) {
		int p1 = find(A, node1);
		int p2 = find(A, node2);


		if (p1 == p2) {
			return;
		} else if (p1 > p2) {
			A[p1] = p2;
		}	else {
			A[p2] = p1;
		}
	}

	public static int find(int[] A, int node) {
		if (node == A[node]) {
			return node;
		} else {
			int p = find(A, A[node]);
			A[A[node]] = p;
			return p;
		}
	}
}