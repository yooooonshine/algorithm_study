package year2023.month7_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N17087 {
    static void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        String my_string = br.readLine();
        int[] brotherLocationIntList = new int[N];


        // 스트링을 받아서 문자열을 정수로 바꿔준다.
        int listIndex = 0;
        for(String i : my_string.split(" ")){
            brotherLocationIntList[listIndex++] = Integer.parseInt(i);
        }

        // 언니와의 거리 구한다.
        listIndex = 0;
        int[] relativePositionList = new int[N];
        for(int i: brotherLocationIntList){
            relativePositionList[listIndex++] = Math.abs(S - i);
        }

        //거리중 최소값을 구한다.
        int minDistance = 1000000000;
        for(int i : relativePositionList){
            if(minDistance > i){
                minDistance = i;
            }
        }



        Loop1:
        for(int i = 1; i <= minDistance; i++){
            if(minDistance % i == 0){
                int temporaryMinDistance = minDistance / i; // 몫은 예상되는 최소거리
                for(int j = 0; j < relativePositionList.length; j++){
                    if(relativePositionList[j] % temporaryMinDistance != 0){
                        System.out.println("매칭 실패");
                        break;
                    }else{
                        if(j == relativePositionList.length - 1){ //배열에 원소 모두 i로 나눠진다면 성공
                            System.out.println(temporaryMinDistance); // 결과 출력
                            break Loop1;
                        }
                        continue;
                    }
                }
            }else{
                continue;
            }
        }


    }
}
