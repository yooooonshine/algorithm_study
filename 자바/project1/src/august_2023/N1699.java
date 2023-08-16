package august_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1699 {
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[100000 + 1];
        Arrays.fill(DP, 1);

        DP[0] = 0;
        for (int i = 1; i <= N; i++) {
            int min = 100000;
            for (int j = 1; j * j <= i; j++) {
                if (DP[j * j] + DP[i - j * j] < min) {
                    min = DP[j * j] + DP[i - j * j];
                }
            }
            DP[i] = min;
        }
        System.out.println(DP[N]);
    }
}
