package year2023.month8_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10844 {
    static final long MOD = 1_000_000_000L;
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] intList = new long[N + 1][10];

        for(int i = 1; i <= 9; i++){
            intList[1][i] = 1L;
        }
        for(int i = 2; i <= N; i++){
            intList[i][0] = intList[i - 1][1];
            intList[i][9] = intList[i - 1][8];

            for(int j = 1; j <= 8; j++){
                intList[i][j] = (intList[i -1][j - 1] + intList[i - 1][j + 1]) % MOD;
            }

        }
        long total = 0;
        for(int i = 0; i <= 9; i++){
            total += intList[N][i] % MOD;
        }
        System.out.print(total % MOD);
    }
}
