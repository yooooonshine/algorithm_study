package year2023.month7_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2004 { // 뒤의 0의 개수는 나온 5의 개수와 동일하다.
    public int[] Counter(int start, int end) {
        int Number5Counter = 0;
        int Number2Counter = 0;
        for(int i = start; i <= end; i++){
            int temporaryIntValue = i;
            while(temporaryIntValue % 5 == 0 && temporaryIntValue != 0){
                temporaryIntValue = temporaryIntValue / 5;
                Number5Counter++;

            }
            temporaryIntValue = i;
            while(temporaryIntValue % 2 == 0 && temporaryIntValue != 0){
                temporaryIntValue = temporaryIntValue / 2;
                Number2Counter++;

            }
        }

        int[] array = {Number2Counter, Number5Counter};
        return array;
    }
//    public int[] Counter1(int end) throws IOException {
//        int Number5Counter = 0;
//        int Number2Counter = 0;
//        for(int i = 1; i*5 <= end; i++) {
//            Number5Counter += (i - 1) * 5;
//        }
//            temporaryIntValue = i;
//            while(temporaryIntValue % 2 == 0 && temporaryIntValue != 0){
//                temporaryIntValue = temporaryIntValue / 2;
//                Number2Counter++;
//
//            }
//        }
//
//        int[] array = {Number2Counter, Number5Counter};
//        return array;
//    }
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int total2Count = 0;
        int total5Count = 0;
        int[] temporaryIntList1;
        int[] temporaryIntList2;

        if(a - b + 1 < b + 1){
            temporaryIntList1 = Counter(b + 1, a);
            temporaryIntList2 = Counter(0, a - b);
        }else{
            temporaryIntList1 = Counter(a - b + 1, a);
            temporaryIntList2 = Counter(0, b);
        }
        total2Count += temporaryIntList1[0];
        total5Count += temporaryIntList1[1];
        total2Count -= temporaryIntList2[0];
        total5Count -= temporaryIntList2[1];
        if(total2Count > total5Count){
            System.out.println(total5Count);
        }else{
            System.out.println(total2Count);
        }
    }

}

// 시간초과가 났다.
// 1. 만약 2000000000의 수에서 미리 2, 5를 뽑아 놓는다면?
// 2. for문을 점프하면서?
// 3. 아 2 * 1 까지는 0개 2 * 2까지는 1개 2*3까지는 2개겠구나