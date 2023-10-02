package september_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class N1920 {
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] NList = new int[N];
        String[] temporaryStringList = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
            NList[j] = Integer.parseInt(temporaryStringList[j]);
        }

        int M = Integer.parseInt(br.readLine());
        int[] MList= new int[M];
        temporaryStringList = br.readLine().split(" ");
        for (int j = 0; j < M; j++) {
            MList[j] = Integer.parseInt(temporaryStringList[j]);
        }


        Arrays.sort(NList);
        for (int i = 0; i < M; i++) {
            binarySearch2(MList[i], 0, N - 1, NList);
        }
    }

    public static int binarySearch2(int key, int low, int high, int[] NList) {
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;

            if(key == NList[mid]) {
                System.out.println(1);
                return mid;
            } else if(key < NList[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(0);
        return -1; // 탐색 실패
    }
}

