package year2024.month7_2024.N20291;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); //파일 개수
		Map<String, Integer> extensions = new HashMap<>();
		List<String> extensionStrings = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("\\.");
			String extension = split[1];

			if (extensions.get(extension) == null) {
				extensionStrings.add(extension);
				extensions.put(extension, 1);
			} else {
				extensions.put(extension, extensions.get(extension) + 1);
			}
		}

		Collections.sort(extensionStrings);

		extensionStrings.stream()
			.forEach(s -> System.out.println(s + " " +extensions.get(s)));
	}
}

// 끝 전이 같으면
// 끝 전이 다르면