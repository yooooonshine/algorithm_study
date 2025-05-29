package year2025.month5.N6137;

import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static char[] S;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		S = new char[N + 1]; // 기존 문자열
		for (int n = 1; n <= N; n++) {
			S[n] = br.readLine().toCharArray()[0];
		}

		result = new char[N + 1]; //최종 결과 배열
		tmp = new char[N + 1]; // 임시 배열
		for (int i = 1; i <= N; i++) {
			result[i] = 'Z'; // 초기값을 가장 큰 문자로 설정
		}

		recursion(1, N, 1); // 재귀 호출 시작 (1부터 N까지)

		// 80글자마다 새줄문자 출력!
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= N; i++) {
			bw.write(String.valueOf(result[i]));
			if (i % 80 == 0) {
				bw.write("\n");
			}
		}
		bw.flush();
	}

	public static char[] result;
	public static char[] tmp;

	public static void recursion(int s, int e, int index) {
		if (index > N) {
			if (isFast(tmp, result)) {
				replace(result, tmp);
			}

			return;
		}

		if (S[s] - S[e] > 0) {
			tmp[index] = S[e];
			recursion(s, e - 1, index + 1);

		} else if (S[s] - S[e] == 0) {
			tmp[index] = S[s];
			recursion(s + 1, e, index + 1);

			tmp[index] = S[e];
			recursion(s, e - 1, index + 1);
		} else {
			tmp[index] = S[s];
			recursion(s + 1, e, index + 1);
		}
	}
	// ABCBCD
	// ABCCBD
	public static boolean isFast(char[] a, char[] b) {
		for (int i = 1; i < a.length; i++) {
			if (a[i] > b[i]) {
				return false;
			}
			if (a[i] < b[i]) {
				return true;
			}
		}
		return true;
	}

	public static void replace(char[] a, char[] b) {
		for (int i = 1; i < a.length; i++) {
			a[i] = b[i];
		}
	}
}

// N개의 문자로 이뤄진 문자열 S

// 1. S의 가장 앞문자를 T의 마지막에 추가
// 2. S의 가장 뒤의 문자하나를T의 마지막에 추가

// 같은 경우 두 가지로 나눠서 진행하면 안되나?
//
