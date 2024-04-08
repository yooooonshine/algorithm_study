package year2023.month10_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1300 {
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long k = Long.parseLong(br.readLine());
        long[] longList = new long[N * N];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                longList[(i - 1) * N + j - 1] = i * j;
            }
        }
        Arrays.sort(longList);
        System.out.println(longList[(int) k]);
    }
}
