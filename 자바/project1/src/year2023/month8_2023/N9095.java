package year2023.month8_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9095 {
    public int[] intList = new int[11];
    public void func() throws IOException {
        intList[0] = 0;
        intList[1] = 1;
        intList[2] = 2;
        intList[3] = 4;
        for(int j = 4; j <= 10; j++){
            intList[j] = intList[j - 1] + intList[j - 2] + intList[j - 3];
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            System.out.println(intList[x]);
        }


    }

}
