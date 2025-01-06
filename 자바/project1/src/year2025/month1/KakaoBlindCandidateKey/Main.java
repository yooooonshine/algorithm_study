package year2025.month1.KakaoBlindCandidateKey;

import java.util.*;
import java.io.*;

public class Main {
	public boolean[] key;
	public int r;
	public int c;
	public int result = 0;

	public void main(String[][] relation) {
		r = relation.length;
		c = relation[0].length;
		key = new boolean[c];

		for (int i = 1; i <= c; i++) {
			List<Integer> cs = new ArrayList<>();
			boolean[] tmpKey = new boolean[c];
			for (int j = 0; j < c; j++) {
				tmpKey[j] = key[j];
			}

			func(i, relation, cs, tmpKey);

			for (int j = 0; j < c; j++) {
				if (tmpKey[j]) {
					key[j] = true;
				}
			}
		}

		System.out.println(result);
	}

	public void func(int index, String[][] relation, List<Integer> cs, boolean[] tmpKey) {
		if (index == cs.size()) {
			Map<String, String> myM = new HashMap<>();

			for (int i = 0; i <= r - 1; i++) {
				String tmpS = "";
				for (int tmp : cs) {
					tmpS += relation[i][tmp];
				}
				if (myM.containsKey(tmpS)) {
					return;
				}
				myM.put(tmpS,tmpS);
			}

			for (int tmp : cs) {
				tmpKey[tmp] = true;
			}
			result++;
			return;
		}
		if (cs.size() == 0) {
			for (int i = 0; i <= c - 1; i++) {
				if (key[i]) {
					continue;
				}
				cs.add(i);
				func(index, relation, cs, tmpKey);
				cs.remove(0);
			}
		} else {
			int tmpIndex = cs.get(cs.size() - 1) + 1;
			for (int i = tmpIndex; i <= c - 1; i++) {
				if (key[i]) {
					continue;
				}
				cs.add(i);
				func(index, relation, cs, tmpKey);
				cs.remove(cs.size() - 1);
			}
		}
	}
}
// 후보키?
// 유일성
// 최소성

// 후보키의 개수
// r c = 8 * 20

// 구현 문제다.

// 1 각 필드가 후보키인지 체크 -> 제외
// 2. 필드 두 개의 합이 후보키인지 체크 -> 제외
// 3. 남은 필드의 수가 2의 수 이하면 끝

// Map을 사용한다?

// 중복되는 row 값을 찾아 다른 필드에서 다른지 체크?

// 각 필드에 대해 Map을 생성한다.

// 아니면 모두 Map을 생성해?

// 재귀 사용?

// 이미 후보키인 경우 제외하는 필드 하나 boolean

// 1. index 1 시작, 1
// 모든 필드 중복 체크 -> 제외

// 2. index 2 재귀를 통해 1번 필드, 2번필드
// 재귀를 통해 두 c를 선택한다.
// 3. index 3 재귀를 통해 3필드를 선택한다.
// 즉 재귀는 1~n 호출해야됨. n개를 선택했으면 그에 대해 Map에 넣어본다.
