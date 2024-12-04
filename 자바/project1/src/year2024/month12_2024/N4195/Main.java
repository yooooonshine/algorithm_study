package year2024.month12_2024.N4195;

import java.util.*;
import java.io.*;

public class Main {
	public static int sum = 0;
	public static String me = "";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int count = Integer.parseInt(br.readLine());

		for (int i = 1; i <= count; i++) {
			int F = Integer.parseInt(br.readLine());

			Map<String, String> f = new HashMap<>();
			Map<String, Integer> depth = new HashMap<>();

			for (int j = 1; j <= F; j++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();

				if (!f.containsKey(a)) {
					f.put(a, a);
					depth.put(a, 1);
				}
				if (!f.containsKey(b)) {
					f.put(b, b);
					depth.put(b, 1);
				}

				union(f, a, b, depth);

				String tmp = find(f, a);
				System.out.println(depth.get(tmp));
			}
		}
	}

	public static void union(Map<String, String> f, String a, String b, Map<String, Integer> depth) {
		String teamA = find(f, a);
		String teamB = find(f, b);

		int r = teamA.compareTo(teamB);
		if (r == 0) {
			return;
		} else if (r > 0) {
			f.replace(teamA, teamB);
			depth.replace(teamB, depth.get(teamA) + depth.get(teamB));
		} else {
			f.replace(teamB, teamA);
			depth.replace(teamA, depth.get(teamA) + depth.get(teamB));
		}
	}

	public static String find(Map<String, String> f, String a) {
		if (f.get(a).equals(a)) {
			return a;
		}

		String result = find(f, f.get(a));

		f.replace(a, result);
		return result;
	}
}

// 친구 네트워크 수 -> 유니온 파인드
// 사전순 String 비교
// Map 사용?
