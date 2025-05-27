package year2025.month5.N2469;

import java.util.*;
import java.io.*;

public class Main {

	public static int K; // 참가자수
	public static int N; // 가로줄의 수

	public static int[] endIndexs;
	public static int questionIndex;

	public static boolean[][] isRoad;

	public static boolean[] resultArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());

		char[] endStrings = br.readLine().toCharArray();
		endIndexs = new int[K + 1]; // 결과 순서 배열, 1부터
		for (int i = 1; i <= K; i++) {
			endIndexs[i] = CharToInt(endStrings[i - 1]);
		}


		questionIndex = 0;
		isRoad = new boolean[N + 1][K]; // 세로는1부터, 가로 1~k-1
		for (int n = 1; n <= N; n++) {
			String[] tmp = br.readLine().split("");

			if (tmp[0].equals("?")) {
				questionIndex = n;
				continue;
			}

			for (int k = 1; k <= K - 1; k++) {
				if (tmp[k - 1].equals("-")) {
					isRoad[n][k] = true;
				}
			}
		}

		boolean result = recursion(1);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if (result) {
			for (int k = 1; k <= K - 1; k++) {
				if (resultArr[k]) {
					bw.write("-");
				} else {
					bw.write("*");
				}
			}
		} else {
			for (int k = 1; k <= K - 1; k++) {
				bw.write("x");
			}

		}
		bw.flush();
		bw.close();
	}

	public static int CharToInt(Character c) {
		return c - 'A' + 1;
	}


	// 1부터 시작
	public static boolean recursion(int index) throws Exception {
		if (index > K - 1) {
			if (isCorrect()) {
				resultArr = new boolean[K];
				for (int k = 1; k <= K - 1; k++) {
					resultArr[k] = isRoad[questionIndex][k];
				}
				return true;
			}
			return false;
		}

		isRoad[questionIndex][index] = true;
		boolean result1 = recursion(index + 1);
		if (result1) {
			return true;
		}

		isRoad[questionIndex][index] = false;
		boolean result2 = recursion(index + 1);
		if (result2) {
			return true;
		}

		return false;
	}

	public static void print() throws Exception {

		for (int k = 1; k <= K - 1; k++) {
			if (isRoad[questionIndex][k]) {
				System.out.print("-");
			} else {
				System.out.print("*");
			}
		}
		System.out.println();
	}


	public static boolean isCorrect() {

		for (int person = 1; person <= K; person++) {
			int index = person;

			for (int n = 1; n <= N; n++) {
				if (index == 1) {
					if (isRoad[n][index]) {
						index++;
					}
				} else if (index == K) {
					if (isRoad[n][index - 1]) {
						index--;
					}

				} else {
					if (isRoad[n][index - 1]) {
						index--;
						continue;
					}

					if (isRoad[n][index]) {
						index++;
						continue;
					}
				}
			}
			if (person != endIndexs[index]) {
				return false;
			}
		}

		return true;
	}
}


// 사다리를 돌려본다.
// 1부터 N까지 for문을 돌린다.
// 인덱스 -1, 인덱스에 대해 -가 있으면
// 현재 인덱스를 -1 or 인덱스를 +1 한다.
// 양 끝 체크
// 마지막에 n이 끝나고 위치를 알아낸다.
// 만약 일치하지 않으면 break
// 일치하면 계쏙
// 마지막까지 일치하면 true리턴


// K(참가수), N(가로줄의 수)
// 최종순서 길이 K인 대문자 문자열
// N개의 줄동안 *, -로 k - 1인문자열
// 감추어진 가로줄은 ?

// 못얻는 경우 x로 구성된 k-1개


// 방법 1
// 1. 재귀로 모든 경우의 수를 구한다.
// 2. 사다리를 돌려본다.
// 3.일치하는지 판별한다.
// 4. 없으먼 xxxx를 출력한다.

// 재귀
// 인덱스가 k - 1보다 크면 체크
// 아니면 *, or -로 재귀

// A부터 해서K개
// 가로 막대가 없는 경우 *
// 있는 경우 -

// 가로 줄 감춘다.
// ??로(k - 1)개
// 여기에 가로 막대를 넣어 조절한다.