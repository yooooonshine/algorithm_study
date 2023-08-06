package july_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10844 {
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] intList = new int[101];
        intList[0] = 0;
        intList[1] = 9;
        intList[2] = 17;
        for(int i = 3; i <= N; i++){
            intList[i] = (intList[i - 1] - (i - 2)) * 2 + (int)Math.pow(2, i - 2) - (i - 1);
        }
        System.out.println(intList[N]);
    }
}
