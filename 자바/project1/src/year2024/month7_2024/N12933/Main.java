package year2024.month7_2024.N12933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<String> sound = Arrays.stream(br.readLine().split("")).collect(Collectors.toList());

		if (sound.size() % 5 != 0) {
			System.out.println(-1);
			return;
		}

		int count = sound.size() / 5;

		List<Integer> q = new ArrayList<>();
		List<Integer> u = new ArrayList<>();
		List<Integer> a = new ArrayList<>();
		List<Integer> c = new ArrayList<>();
		List<Integer> k = new ArrayList<>();

		for (int i = 0; i < sound.size(); i++) {
			if (Objects.equals(sound.get(i), "q")) {
				q.add(i);
			} else if (Objects.equals(sound.get(i), "u")) {
				u.add(i);
			} else if (Objects.equals(sound.get(i), "a")) {
				a.add(i);
			} else if (Objects.equals(sound.get(i), "c")) {
				c.add(i);
			} else if (Objects.equals(sound.get(i), "k")) {
				k.add(i);
			} else {
				System.out.println(-1);
				return;
			}
		}

		if (q.size() != count
			|| u.size() != count
			|| a.size() != count
			|| c.size() != count
			|| k.size() != count) {
			System.out.println(-1);
			return;
		}

		int max = 0;
		for (int i = 0; i < count; i++) {
			int tmp = 1;
			if (!(q.get(i) < u.get(i)
				&& u.get(i) < a.get(i)
				&& a.get(i) < c.get(i)
				&& c.get(i) < k.get(i))) {

				System.out.println(-1);
				return;
			} else {
				for (int j = i + 1; j < count; j++) {
					if (k.get(i) > q.get(j)) {
						tmp++;
					}
				}

				if (max < tmp) {
					max = tmp;
				}
			}
		}

		System.out.println(max);
	}

}

// 접근1. q와 k 사이에 몇개의 q가 있는 지
// 모두 quack를 이루는지 체크
// q k를 찾아서 그 사이에 q가 몇개 있는 지 파악
// 다음 q