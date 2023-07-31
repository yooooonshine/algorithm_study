package july_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class N11726 {
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] intList = new int[1001];
        intList[1] = 1;
        intList[2] = 2;
        for(int i = 3; i <= n; i++){
            intList[i] = (intList[i - 1] + intList[i - 2]) % 10007;
        }
        System.out.println(intList[n]);
    }
}


//public class N11726 {
//    public static int caseCount = 0;
//    Queue<Integer> my_queue = new LinkedList<>();
//    public void func() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        if(n == 1){
//            System.out.println(1);
//            return;
//        }else{
//            my_queue.add(1);
//            my_queue.add(2);
//            while(my_queue.size() != 0){
//                adder(my_queue.poll(),n);
//            }
//            System.out.println(caseCount);
//        }
//
//    }
//    public void adder (int x, int n){
//        if(x == n) {
//            caseCount++;
//            if(caseCount > 10007){
//                caseCount = caseCount % 10007;
//            }
//            return;
//        } else if (x > n) {
//            return;
//        } else{
//            my_queue.add(x + 1);
//            my_queue.add(x + 2);
//        }
//    }
//
//}