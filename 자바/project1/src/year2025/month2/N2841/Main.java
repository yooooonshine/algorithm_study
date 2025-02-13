package year2025.month2.N2841;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer>[] pqs = new PriorityQueue[7];
		for (int i = 1; i <= 6; i++) {
			pqs[i] = new PriorityQueue<>((a, b) -> b - a);
		}

		int count = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int line = Integer.parseInt(st.nextToken());
			int pret = Integer.parseInt(st.nextToken());

			while (!pqs[line].isEmpty() && pqs[line].peek() > pret) {
				pqs[line].poll();
				count++;
			}

			if (!pqs[line].isEmpty() && pqs[line].peek() == pret) {
				continue;
			}

			pqs[line].add(pret);
			count++;
		}

		System.out.println(count);
	}
}

// pq 비어있지 않고, 더 높으면 계속 빼기
// pq 비어있지 않고, 같으면 끝내기
// 넣기

// 기타는 6개의 줄
// 각 줄은 P개의 프렛 1~P
// 프렛을 여러 개 누르면 가장 높은 숫자의 프렛 적용
// 손가락으로 프렛을 한번 누르거나 하나만 때기
// 손가락 가장 적게 움직이는 횟수

// 그리디?
// dp?

// 음의 수 N 한줄의 프렛수 P

// N개의 줄동안 두 정수
// 줄의 번호, 프렛번호

// 2, 8
// 2, 10
// 2, 12
// 2, 12 때기
// 2, 10 때기
// 2, 8 때기
// 2, 5

// 1, 5
// 2, 3
// 2, 5
// 2, 7
// 2, 7때기
// 2, 5 때기
// 2, 4
// 1, 5 때기
// 1, 3


// 주어진 값보다 높은 프렛들만 때면 된다.
// 이미 최상위가 있으면 그대로

// 6개의 우선순위 큐
