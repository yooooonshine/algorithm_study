package year2023.month8_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1912 {
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] intList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()); // br.readLine을 통해 읽은 뭍자열을 쪼개주는 객체
        for (int i = 0; i < N; i++) {
            intList[i] = Integer.parseInt(st.nextToken());
        }

        int[] DP = new int[N];


        DP[0] = intList[0]; // 초기세팅
        int max = intList[0]; // 초기세팅
        for (int i = 1; i < N; i++) {
            if (DP[i - 1] + intList[i] < intList[i]) {
                DP[i] = intList[i];
            } else {
                DP[i] = DP[i - 1] + intList[i];
            }
            if (max < DP[i]) {
                max = DP[i];
            }
        }

        System.out.println(max);
    }
}
