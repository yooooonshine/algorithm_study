package august_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14002 {
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] intList = new int[N];
        int[] DP = new int[N];
        int[][] DPList = new int[N][N];  //결과를 담는 리스트
        for (int i = 0; i < N; i++) {
            DP[i] = 1;
        }
        //intList[0]은 공백
        StringTokenizer st = new StringTokenizer(br.readLine()); // br.readLine을 통해 읽은 뭍자열을 쪼개주는 객체
        for (int i = 0; i < N; i++) {
            intList[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            DPList[i][0] = intList[i];
        }

        for (int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(intList[i] > intList[j] && DP[i] < DP[j] + 1 ){
                    DP[i] = DP[j] + 1;
                    int index = 0;
                    while (DPList[j][index] != 0) {
                        DPList[i][index + 1] = DPList[j][index];
                        index++;
                    }
                }
            }
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            if (max < DP[i]) {
                max = DP[i];
                maxIndex = i;
            }
        }
        System.out.println(max);
        int index = 0;
        if (N == 1) {
            System.out.println(DPList[0][0]);
        } else {
            while (DPList[maxIndex][index] != 0) {
                index++;
            }
            for(int i = index - 1; i >= 0; i--){
                System.out.print(DPList[maxIndex][i] + " ");
            }
        }
    }
}
