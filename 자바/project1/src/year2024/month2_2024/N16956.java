package year2024.month2_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N16956 {

	public void func() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		//행
		int R = Integer.parseInt(s[0]);
		//열
		int C = Integer.parseInt(s[1]);

		String[][] farm = new String[R + 2][C + 2];

		for (int i = 0; i <= R + 1; i++) {
			Arrays.fill(farm[i], ".");
		}

		for (int i = 1; i <= R; i++) {
			String[] tempArr = br.readLine().split("");

			for (int j = 1; j <= C; j++) {
				farm[i][j] = tempArr[j - 1];
			}
		}



		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (isDangerous(farm, r, c)) {
					System.out.println(0);
					return;
				} else {
					if (farm[r][c].equals(".")) {
						farm[r][c] = "D";
					}
				}
			}
		}

		System.out.println(1);

		printArr(farm, R, C);

	}

	private Boolean isDangerous(String[][] farm, int r, int c) {
		if (farm[r][c].equals("S")) {
			if (farm[r - 1][c].equals("W")
				|| farm[r][c + 1].equals("W")
				|| farm[r + 1][c].equals("W")
				|| farm[r][c - 1].equals("W")
			) {
				return true;
			}
		}
		return false;
	}

	private void printArr(String[][] farm, int maxR, int maxC) {
		for (int r = 1; r <= maxR; r++) {
			for (int c = 1; c <= maxC; c++) {
				System.out.print(farm[r][c]);
			}
			System.out.println();
		}
	}
}
