package year2024.month7_2024.N20291;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); //파일 개수
		List<String> extensions = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("\\.");
			String extension = split[1];

			extensions.add(extension);
		}

		Collections.sort(extensions);

		if (N == 1) {
			System.out.println(extensions.get(0) + " 1");
			return;
		}

		int count = 1;
		for (int i = 0; i < N - 1; i++) {
			String now = extensions.get(i);
			String next = extensions.get(i + 1);

			if (Objects.equals(now, next)) { //다음이랑 같을 경우
				count++;

				if (i == N - 2) { //다를 경우 마지막
					System.out.println(now + " " + count);
				}
			} else {
				System.out.println(now + " " + count); //다를 경우
				count = 1;

				if (i == N - 2) { //다를 경우 마지막
					System.out.println(next + " " + count);
				}
			}


		}
	}
}

// 끝 전이 같으면
// 끝 전이 다르면