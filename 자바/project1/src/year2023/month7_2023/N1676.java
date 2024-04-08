package year2023.month7_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1676 { // 뒤의 0의 개수는 나온 5의 개수와 동일하다.
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Number5Counter = 0;
        String s = br.readLine();
        int intValue = Integer.parseInt(s);
        for(int i = 0; i <= intValue; i++){
            int temporaryIntValue = i;
            while(temporaryIntValue % 5 == 0 && temporaryIntValue != 0){
                temporaryIntValue = temporaryIntValue / 5;
                Number5Counter++;
            }
        }
        System.out.println(Number5Counter);
    }
}
