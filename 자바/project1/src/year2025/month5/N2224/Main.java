package year2025.month5.N2224;

import java.util.*;
import java.io.*;

public class Main {

	public static List<List<Node>> adj = new ArrayList<>();
	public static List<Node> result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i <= 51; i++) {
			adj.add(new ArrayList<>());
		}

		Set<String> set = new HashSet<>();

		for (int n = 1; n <= N; n++) {
			String tmpS = br.readLine();

			if (set.contains(tmpS)) {
				continue;
			}
			set.add(tmpS);

			String[] tmp = tmpS.split(" => ");
			String s = tmp[0];
			String e = tmp[1];

			if (s.equals(e)) {
				continue;
			}

			int intS = StringToInt(s);
			int intE = StringToInt(e);

			adj.get(intS).add(new Node(intS, intE));
		}


		result = new ArrayList<>();

		for (int n = 0; n <= 51; n++) {
			dfs(n);
		}

		Collections.sort(result);

		System.out.println(result.size());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (Node node : result) {
			String a = intToString(node.s);
			String b = intToString(node.e);
			bw.write(a + " => " + b + "\n");
		}
		bw.flush();
	}

	public static void dfs(int s) {
		Queue<Node> myQ = new LinkedList<>();
		myQ.add(new Node(s, s));

		boolean[] visit = new boolean[52];

		while(!myQ.isEmpty()) {
			Node node = myQ.poll();
			int now = node.e;

			if (visit[now]) {
				continue;
			}
			visit[now] = true;

			for (Node next : adj.get(now)) {
				if (s != next.e) {
					result.add(new Node(s, next.e));
				}

				myQ.add(new Node(now, next.e));
			}
		}
	}

	public static class Node implements Comparable<Node> {
		int s;
		int e;

		public Node(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Node n) {
			int resultS = compare(this.s, n.s);
			if (resultS == 0) {
				return compare(this.e, n.e);
			} else {
				return resultS;
			}
		}
	}

	public static int compare(int a, int b) {
		if (a < 26 && b < 26) {
			return a - b;
		} else if (a < 26 && b >= 26) {
			return 1;
		} else if (a >= 26 && b < 26) {
			return -1;
		} else {
			return a - b;
		}
	}

	public static int StringToInt(String s) {
		char tmp = s.toCharArray()[0];
		if (tmp - 'a' < 26 && tmp - 'a' >= 0) {
			return tmp - 'a';
		} else {
			return tmp - 'A' + 26; // 26~51
		}
	}

	public static String intToString(int i) {
		if (0 <= i && i < 26) {
			char tmp  = (char)(i + 'a');
			return String.valueOf(tmp);
		} else {
			char tmp = (char)(i - 26 + 'A');
			return String.valueOf(tmp);
		}
	}
}