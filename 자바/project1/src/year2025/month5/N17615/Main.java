package year2025.month5.N17615;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] arr = br.readLine().split("");
		int rCount = 0;
		int bCount = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("R")) {
				rCount++;
			} else {
				bCount++;
			}
		}

		int bMax = 0;
		int rMax = 0;

		int bTemp = 0;
		int index = 0;
		while(true) {
			if (index >= arr.length) {
				break;
			}

			if (arr[index].equals("B")) {
				bTemp++;
				index++;
			} else {
				break;
			}
		}
		bMax = bTemp;

		int rTemp = 0;
		index = 0;
		while(true) {
			if (index >= arr.length) {
				break;
			}

			if (arr[index].equals("R")) {
				rTemp++;
				index++;
			} else {
				break;
			}
		}
		rMax = rTemp;

		bTemp = 0;
		index = arr.length - 1;
		while(true) {
			if (index < 0) {
				break;
			}

			if (arr[index].equals("B")) {
				bTemp++;
				index--;
			} else {
				break;
			}
		}

		bMax = (int)Math.max(bTemp, bMax);

		rTemp = 0;
		index = arr.length - 1;
		while(true) {
			if (index < 0) {
				break;
			}

			if (arr[index].equals("R")) {
				rTemp++;
				index--;
			} else {
				break;
			}
		}
		rMax = (int)Math.max(rTemp, rMax);


		System.out.println(Math.min(bCount - bMax, rCount - rMax));
	}
}

// 처음부터 끝까지 같은 색 볼만 이동
// 다른 색 볼은 같은 색 볼들을 모두 뛰어넘을 수 있다


// 최소 이동 횟수

// 1. 파란색 옮김
// 2. 양끝이 빨간색 -> 아무쪽이나 파란색 개수 만큼
// 2. 한끝이 파란색 -> 파란색 - 1
// 3. 양 끝이 파란색 -> 파란색개수 - 파란색 연속 개수(큰)
// 파란색 연속 개수