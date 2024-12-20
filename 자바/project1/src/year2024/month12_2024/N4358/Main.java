package year2024.month12_2024.N4358;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		System.out.println(Math.round(2999.99 * 10000));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String tmp = br.readLine();

		int count = 0;
		Map<String, Integer> myM = new HashMap<>();

		while (tmp != null) {
			count++;
			if (!myM.containsKey(tmp)) {
				myM.put(tmp, 1);
			} else {
				myM.replace(tmp, myM.get(tmp) + 1); // 맞나
			}

			tmp = br.readLine();
		}

		Set<String> myS = myM.keySet();
		List<String> keys = new ArrayList<>(myS);
		Collections.sort(keys);

		for (String s : keys) {

			float result = 100f * (float)myM.get(s) / (float)count;

			System.out.println(s + " " + String.format("%.4f", result));
		}
	}
}

// 이름 사전순 출력?
// 차지하는 비율
// Map 사용하여, 각 이름 당 개수 체크

// 입력을 받고, 이를 Map에 넣는다. 숫자 ++
// 4째자리에서 반올림(round)