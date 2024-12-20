package year2024.month12_2024.N1991;
import java.util.*;
import java.io.*;

public class Main {
	public static Tree[] adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		adj = new Tree[26];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			String a = st.nextToken();
			String b = st.nextToken();
			String c = st.nextToken();

			adj[getInt(a)] = new Tree(getInt(b), getInt(c));
		}

		pre(0);
		System.out.println();
		mid(0);
		System.out.println();
		post(0);
	}

	public static Integer getInt(String a) {
		if (Objects.equals(a, ".")) {
			return null;
		}

		return a.charAt(0) - 'A';
	}

	public static String getString(Integer a) {
		return String.valueOf((char)(a + 'A'));
	}

	// 루트, 좌, 우
	public static void pre(int start) {
		System.out.print(getString(start));

		Tree tree = adj[start];

		if (tree.left != null) {
			pre(tree.left);
		}

		if (tree.right != null) {
			pre(tree.right);
		}
	}

	// 좌, 루트, 우
	public static void mid(int start) {
		Tree tree = adj[start];

		if (tree.left != null) {
			mid(tree.left);
		}

		System.out.print(getString(start));

		if (tree.right != null) {
			mid(tree.right);
		}
	}

	// 좌, 우, 루트
	public static void post(int start) {

		Tree tree = adj[start];

		if (tree.left != null) {
			post(tree.left);
		}
		if (tree.right != null) {
			post(tree.right);
		}
		System.out.print(getString(start));
	}

	public static class Tree {
		Integer left;
		Integer right;

		public Tree(Integer left, Integer right) {
			this.left = left;
			this.right = right;
		}
	}
}

// 리스트로 표현한다.

// 알파벳은 숫자로 변환한다.
// 26개의 리스트

