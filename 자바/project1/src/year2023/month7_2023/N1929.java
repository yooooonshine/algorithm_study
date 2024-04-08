package year2023.month7_2023;
import java.util.*;

public class N1929 {
    public void func(){
        Scanner sc = new Scanner(System.in);
        int intValue1 = sc.nextInt();
        int intValue2 = sc.nextInt();
        Set<Integer> myIntSet = new HashSet<>();
        ArrayList<Integer> decimalList = new ArrayList<>();
        for(int i = 2; i <= intValue2; i++){ //2부터 끝수까지 리스트 형성
            myIntSet.add(i);
        }
        for(int i = 2; i <= intValue2; i++){ //2부터 끝수까지 리스트 형성
            if(!myIntSet.contains(i)){
                continue;
            }else{
                myIntSet.remove(i);// i 제거
                if( i >= intValue1){
                    decimalList.add(i);// 소수에 i 추가
                }
                int multiplyNumber = 2; //곱하는 수
                while(true){ // 배수가 존재할떄까지 제거
                    if(i * multiplyNumber <= intValue2){
                        myIntSet.remove(i * multiplyNumber);
                        multiplyNumber += 1; // 곱하는수 1증가
                    }else{
                        break;
                    }
                }
            }
        }
        for(int i: decimalList){
            System.out.println(i);
        }
    }
}
