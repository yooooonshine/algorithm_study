package july_2023;
// 골드바흐 파티션

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N17103 {

    static boolean prime[];
    public void func() throws IOException {
        //공백 포함하지 않는 int
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> intList = new ArrayList<>();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
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
        int totalCount = 0;
        for(int i = 0; i < prime.length; i++){
            if(i > x / 2){
                break;
            }
            if(prime[i]){
                if(prime[x - i]){
//                    System.out.println(String.valueOf(x) + " = " + String.valueOf(i) + " + " + String.valueOf(x - i));
                    totalCount++;
                }
            }
        }
        System.out.println(totalCount);
    }
}