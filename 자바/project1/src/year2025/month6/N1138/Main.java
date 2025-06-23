package year2025.month6.N1138;

import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static int[] left;
	public static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		left = new int[N + 1]; // 왼쪽 몇명 있는지
		arr = new int[N + 1]; // 결과 함수

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			left[i] = Integer.parseInt(st.nextToken());
		}

		boolean[] use = new boolean[N + 1]; // 사용체크
		recursion(0, 1, use);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= N; i++) {
			bw.write(arr[i] + " ");
		}
		bw.flush();
	}

	public static boolean recursion(int count, int index, boolean[] use) {
		if (count == N) {
			return check();
		}

		for (int i = 1; i <= N; i++) {
			if (!use[i]) {
				use[i] = true;
				arr[index] = i;

				boolean result = recursion(count + 1, index + 1, use);
				if (result) {
					return true;
				}
				use[i] = false;
			}
		}

		return false;
	}

	// 1. 스택 1 체크, 자기보다 크면 아닐 때까지 s2로 이동
	// 2. 스택 2 체크, 자기보다 작으면 아닐 때까지 s1으로 이동
	// 2. 스택 2 개수로 업데이트
	// 3. 스택 1에 넣기
	public static boolean check() {
		int[] tmp = new int[N + 1];

		Stack<Integer> s1 = new Stack();
		Stack<Integer> s2 = new Stack();

		for (int i = 1; i <= N; i++) {
			while (!s1.isEmpty() && s1.peek() > arr[i]) {
				s2.add(s1.pop());
			}
			while (!s2.isEmpty() && s2.peek() < arr[i]) {
				s1.add(s2.pop());
			}

			tmp[arr[i]] = s2.size();
			s1.add(arr[i]);
		}


		for (int i = 1; i <= N; i++) {
			if (tmp[i] != left[i]) {
				return false;
			}
		}

		return true;
	}
}

// N명
// 각자 자기보다 큰 사람이 왼쪽 몇명
//

// 토폴로지 소트같다?

// 근데 10!해도 되겠는데
// 배치를 한다.
// 각 인원 앞에 키큰이 몇명있는지 확인한다.

// 이거 스택으로 되나.


// 스택 두걔?
// 3 4 2 1 5

// pq : 3, 4
// 1. 3 없음 -> 0,
// 2. 스택 맨 앞보다 큼 -> 0, 넣기
// 3. 2 -> 가장 작은 것보다


// 스택 두개
// 스택1 : 1, 2, 3, 4
// 스택2 :

// 3 넣기, 0
// 4 넣기, 0
// 2 -> 스택2로 이동, 2넣기, 스택2 사이즈 2
// 1 -> 스택2로 이동, 1넣기, 스택2 사이즈 3
// 5 -> 스택1로 이동, 5넣기, 스택2 사이즈 0

// 스택2 유무
// 스택1 유무

