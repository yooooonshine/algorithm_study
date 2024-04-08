package year2023.month8_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N15988 {
    public void func() throws IOException {

        long[] intList = new long[1000001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] caseList = new int[T];
        for (int i = 0; i < T; i++) {
            caseList[i] = Integer.parseInt(br.readLine());
        }
        Integer max = Arrays.stream(caseList) //최대 수 찾기
                .max()
                .getAsInt();

        intList[1] = 1L;
        intList[2] = 2L;
        intList[3] = 4L;
        for (int i = 4; i <= max; i++) {
            intList[i] = (intList[i - 1] + intList[i - 2] + intList[i - 3]) % 1000000009;
        }

        for (int i : caseList) {
            System.out.println(intList[i]);
        }
    }
}
