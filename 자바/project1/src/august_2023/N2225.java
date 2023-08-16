package august_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2225 {
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // br.readLine을 통해 읽은 뭍자열을 쪼개주는 객체
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[][] intList = new long[K + 1][N + 1];
        for (int i = 0; i <= N; i++) { //한칸은 모두 경우의 수가 1
            intList[1][i] = 1L;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k <= j; k++) {
                    intList[i][j] += intList[i - 1][k] % 1000000000L;
                }
            }
        }

        System.out.println(intList[K][N] % 1000000000L);


    }
}
