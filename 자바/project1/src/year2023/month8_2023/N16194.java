package year2023.month8_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class N16194 {
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
                int temporaryMin = 100000000;
                for (int j = i / 2; j <= i; j++) {
                    if (temporaryMin > dynamicList[j] + dynamicList[i - j]) {
                        temporaryMin = dynamicList[j] + dynamicList[i - j];
                    }
                }
                dynamicList[i] = temporaryMin;
//                System.out.println(i + "번째맥스는 " + dynamicList[i]);
            }

        }
        System.out.println(dynamicList[N]);
    }
}