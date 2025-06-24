package year2025.month6.N1138;

import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static int[] left;
	public static int[] tmp;

	public static int[] result;

	public static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		left = new int[N + 1]; // 왼쪽 몇명 있는지
		tmp = new int[N + 1]; //
		result = new int[N + 1];
		visit = new boolean[N + 1]; // 방문 여부

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			left[i] = Integer.parseInt(st.nextToken());
		}

		recursion(1);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= N; i++) {
			bw.write(result[i] + " ");
		}
		bw.flush();
	}

	public static boolean recursion(int count) {
		if (count > N) {
			return true;
		}

		for (int i = 1; i <= N; i++) {
			if (left[i] < tmp[i]) {
				return false;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (left[i] == tmp[i] && !visit[i]) {
				for (int j = 1; j < i; j++) {
					if (visit[j]) {
						continue;
					}
					tmp[j]++;
				}
				result[count] = i;
				visit[i] = true;
				boolean tmpR = recursion(count + 1);
				if (tmpR) {
					return true;
				}
				visit[i] = false;
				for (int j = 1; j < i; j++) {
					tmp[j]--;
				}
			}
		}

		return false;
	}
}


// count를 모두 0으로 초기화
// 재귀로 left와 같은 거 있으면 재귀
// 하나라도 넘어가면 끝
//
