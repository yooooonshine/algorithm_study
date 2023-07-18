package july_2023;

import java.util.Scanner;

public class N2609 {
    public int min(int x, int y){
        if (x < y){
            return x;
        }else{
            return y;
        }
    }
    public void func(){

        int greatestCommonDivisor = 1; //최대 공약수
        int leastCommonMultiple = 1; // 최소 공배수
        Scanner sc = new Scanner(System.in);
        String myString = sc.nextLine();
        String[] integerArray = myString.split(" ");
        int intValue1 = Integer.parseInt(integerArray[0]);
        int intValue2 = Integer.parseInt(integerArray[1]);
        while(true){
            int i = 0;
            for(i = 2; i <= min(intValue1, intValue2); i++){
                if(intValue1 % i == 0 && intValue2 % i == 0){
                    greatestCommonDivisor = greatestCommonDivisor * i;
                    intValue1 = intValue1 / i;
                    intValue2 = intValue2 / i;
                    break;
                }
            }
            if( i == min(intValue1, intValue2) + 1){
                break;
            }
        }
        leastCommonMultiple = intValue1 * intValue2 * greatestCommonDivisor;
        System.out.println(greatestCommonDivisor);
        System.out.println(leastCommonMultiple);

    }
}


//		Scanner sc = new Scanner(System.in); // 스캐너에서 문자열을 다 받는다.
//		int n1 = sc.nextInt(); //여기서 띄어쓰기 단위로 받은것을 읽어들이는것.
//		int n2 = sc.nextInt();