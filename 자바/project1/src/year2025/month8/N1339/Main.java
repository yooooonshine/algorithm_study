package year2025.month8.N1339;

import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] nums = new int[26];
		List<String> wordList = new ArrayList<>();

		for (int n = 1; n <= N; n++) {
			String tmp = br.readLine();
			wordList.add(tmp);
		}


		// 결과 도출
		for (String tmp : wordList) {

			for (int i = 0; i < tmp.length(); i++) {
				char c = tmp.charAt(i);
				int index = c - 'A'; // A는 0, B는 1, ..., Z는 25
				nums[index] += (int)Math.pow(10, tmp.length() - i - 1); // 자리수에 따라 가중치 부여
			}
		}


		// 결과 도출
		int sum = 0;
		int num = 9;

		Arrays.sort(nums);
		for (int i = 25; i >= 0; i--) {
			if (nums[i] == 0) {
				continue; // 사용되지 않는 알파벳은 무시
			}
			sum += nums[i] * num; // 가중치와 숫자 곱하기
			num--; // 다음 숫자는 1 감소
		}


		System.out.println(sum);
	}
}

// N개의 단어
// 오직 대문자
// 대문자를 0 - 9로 바꿔 N개의 수를 합하기
// 각 숫자는 한 알파벳에만 사용

// 그리디로 보인다?

// 경우의수는 10! = 6 * 20 * 42 * 72 = 120 * 2800 = 300000

// 683
// 98754
// 99437

// 그리디
// 숫자 9부터 ->
// 우선순위큐 (자리수)
// 딕셔너리 -> 알파벳 -> 숫자
// 우선순위 큐에서 뽑아 그 자리의 알파벳이 딕셔너리에 없으면 9부터 채운다.
// 딕셔너리에 넣는다.
// 우선순위 큐에 1감소시켜 넣는다.
