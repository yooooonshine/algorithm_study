package year2025.month5.N1756;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int D = Integer.parseInt(st.nextToken()); // 깊이
		int N = Integer.parseInt(st.nextToken()); // 반죽의 수

		int[] depth = new int[D + 1]; // 1부터
		int[] dows = new int[N + 1]; // 1부터

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= D; i++) {
			depth[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			dows[i] = Integer.parseInt(st.nextToken());
		}

		int[] minArr = new int[D + 1];
		int min = depth[1];
		minArr[1] = min;
		for (int i = 2; i <= D; i++) {
			if (min > depth[i]) {
				min = depth[i];
			}
			minArr[i] = min;
		}

		int pos = D; // 최종 값
		for (int i = 1; i <= N; i++) {
			int dow = dows[i];

			while (pos > 0 && dow > minArr[pos]) {
				pos--;
			}
			if (pos == 0) {
				System.out.println(0);
				break;
			}

			pos--;
		}

		System.out.println(pos + 1);
	}
}


// 시작 end는 배열끝 + 1
// 이분탐색으로 새 것의 위치 찾기(항상 end - 1까지)
// 현재 값 > 방문 값 -> start = mid + 1
// 핸재 값 < 방문 값 -> end = mid - 1
// 만약 end가 1보다 작으면 0출력
// 새 것의 위치가 end
// 만약

// N개의 피자 반죽
// 피자 반죽 지름이 제각각

// 오븐의 깊이 D, 반죽의 개수 N
// 위에서 아래로 오븐의 지름 차례대로
// 피자 반죽이 완성되는 순서대로 지름

// 마지막 피자 반죽 위치(시작이 1)
// 모두 들어가지 않으면 0

// 정렬은 아무도움이 안돼
// 지금까지 들어왔을 때의 최소를 구한다
// 5 6 4 3 6 2 3
// 5 5 4 3 3 2 2
// 이분탐색을 통해 위치를 찾는다.
// 맨 오른쪽을 찾는다.
// end는 갱신된다.
