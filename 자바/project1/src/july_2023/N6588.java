package july_2023;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//백트래킹을 사용하면 될거라 생각했다. 시간초과가 났고 문제는 초기 소수리스트를 구할때, 매번 구하면 시간초과 났다. 그거를 해결하니 맞았다.ㄴ




//public class N6588 {
//    public void func() throws IOException {
//        //공백 포함하지 않는 int
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        ArrayList<Integer> intList = new ArrayList<>();
//        while (true) {  // 받는 정수 값들 저장.
//            String s = br.readLine();
//            int temporaryIntValue = Integer.parseInt(s);
//            if (temporaryIntValue == 0) {
//                break;
//            } else {
//                intList.add(temporaryIntValue);
//            }
//        }
//
//
//        ArrayList<Integer> decimalList = new ArrayList<>();
//
//        for(int i: intList){
//            decimalList = findingDecimal(i);
//            showResult(i, decimalList);
//        }
//    }
//
//    public ArrayList<Integer> findingDecimal(int findingNumber) { // 특정 수보다 작은 모든 소수 찾기.
//        Set<Integer> myIntSet = new HashSet<>();
//        ArrayList<Integer> decimalList = new ArrayList<>();
//        for (int i = 2; i <= findingNumber; i++) { //2부터 끝수까지 리스트 형성
//            myIntSet.add(i);
//        }
//        for (int i = 2; i <= findingNumber; i++) { //2부터 끝수까지 리스트 형성
//            if (!myIntSet.contains(i)) {
//                continue;
//            } else {
//                myIntSet.remove(i);// i 제거
//                decimalList.add(i);// 소수에 i 추가
//                int multiplyNumber = 2; //곱하는 수
//                while (true) { // 배수가 존재할떄까지 제거
//                    if (i * multiplyNumber <= findingNumber) {
//                        myIntSet.remove(i * multiplyNumber);
//                        multiplyNumber += 1; // 곱하는수 1증가
//                    } else {
//                        break;
//                    }
//                }
//            }
//        }
//        return decimalList;
//    }
//
//    public void showResult(int x,ArrayList<Integer> decimalList) throws IOException {
//        for (int i: decimalList){
//            if (x / 2 < i){ // 절반을 넘어가면 해당하는 값이 존재하지 않으므로 종료
//                System.out.println("Goldbach\'s conjecture is wrong.");
//                return;
//            } else{
//                for(int j = decimalList.size() - 1; j >= 0; j--){
//                    if(i + decimalList.get(j) > x){
//                        continue;
//                    } else if (i + decimalList.get(j) == x) {
//                        System.out.println(String.valueOf(x) + " = " + String.valueOf(i) + " + " + String.valueOf(decimalList.get(j)));
//                        return;
//                    } else{
//                        break;
//                    }
//                }
//            }
//        }
//
//    }
//}


public class N6588 {
    static boolean prime[];
    public void func() throws IOException {
        //공백 포함하지 않는 int
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> intList = new ArrayList<>();
        while (true) {  // 받는 정수 값들 저장.
            String s = br.readLine();
            int temporaryIntValue = Integer.parseInt(s);
            if (temporaryIntValue == 0) {
                break;
            } else {
                intList.add(temporaryIntValue);
            }
        }
        findingDecimal(1000001);

        for(int i: intList){
            showResult(i);
        }
    }

    public void findingDecimal(int N) { // 특정 수보다 작은 모든 소수 찾기.
        // 구하고자 하는 숫자 범위
        prime = new boolean[N+1]; // N번째의 수 까지 받기위해 N+1까지 동적할당
        for(int i = 0; i < prime.length; i++){
            prime[i] = true; // boolean배열의 default값은 false이므로 true로 바꿔주기
        }

        prime[0] = prime[1] = false; // 0과 1은 소수가 아니니깐 false

        for(int i = 2; i <= Math.sqrt(N); i++){ // 2부터 n의 제곱근까지의 모든 수를 확인
            if(prime[i]){ // 해당수가 소수라면, 해당수를 제외한 배수들을 모두 false 처리하기
                for(int j = i*i; j<= N; j += i){//그 이하의 수는 모두 검사했으므로 i*i부터 시작
                    prime[j] = false;
                }
            }
        }

    }

    public void showResult(int x) throws IOException {
        for(int i = 0; i < prime.length; i++){
            if(i > x / 2){
                System.out.println("Goldbach\'s conjecture is wrong.");
                return;
            }
            if(prime[i]){
                if(prime[x - i]){
                    System.out.println(String.valueOf(x) + " = " + String.valueOf(i) + " + " + String.valueOf(x - i));
                    return;
                }
            }
        }
    }
}