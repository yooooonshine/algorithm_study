package year2023.month8_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class N11052 {
    public int[] intList = new int[1001];

    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 리스트 초기화
        StringTokenizer st = new StringTokenizer(br.readLine()); // br.readLine을 통해 읽은 뭍자열을 쪼개주는 객체
        for (int i = 0; i <= N; i++) {
            if (i == 0) {
                intList[0] = 0;
            } else {
                intList[i] = Integer.parseInt(st.nextToken());
            }
        }
        //다이나믹프로그래밍을 위한 리스트
        int[] dynamicList = intList;
        for (int i = 0; i <= N; i++) {
            if (i == 0) {
                dynamicList[0] = 0;
            } else if (i == 1) {
                dynamicList[1] = intList[1];
            } else{
                int temporaryMax = 0;
                for (int j = i / 2; j <= i; j++) {
                    if (temporaryMax < dynamicList[j] + dynamicList[i - j]) {
                        temporaryMax = dynamicList[j] + dynamicList[i - j];
                    }
                }
                dynamicList[i] = temporaryMax;
//                System.out.println(i + "번째맥스는 " + dynamicList[i]);
            }

        }
        System.out.println(dynamicList[N]);
    }
}


// 백트래킹 및 재귀 이용
//public class    N11052 {
//    public int[] intList = new int[1001];
//    public void func() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        // 리스트 초기화
//        StringTokenizer st = new StringTokenizer(br.readLine()); // br.readLine을 통해 읽은 뭍자열을 쪼개주는 객체
//        for(int i = 0; i <= N; i++){
//            if(i == 0){
//                intList[0] = 0;
//            } else{
//                intList[i] = Integer.parseInt(st.nextToken());
//            }
//        }
//        System.out.println(recursion(N,N));
//
//    }
//
//    public int recursion(int beforeN, int N){
//        int max = 0;
//        if(N == 0) {
//            max = 0;
//            return 0; // 0반환
//        } else if (N == 1) {
//            max = intList[1];
//            return max;
//        } else{
//            for(int i = 1; i <= N; i++){
//                if(i > beforeN){
//                    return max;
//                }
//                int temporaryMax = recursion(i,N - i);
//                if(max < intList[i] + temporaryMax){
//                    max = intList[i] + temporaryMax;
//                }
//            }
//
//            return max;
//        }
//
//    }
//}