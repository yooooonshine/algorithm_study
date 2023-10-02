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

    public static void binarySearch(int[] NList,int x) {
        int mid;
        int low = 0;
        int high = NList.length;
        while (low + 1 < high) {
            mid = (low + high) / 2;
            if (NList[mid] == x) {
                System.out.println(1);
                return;
            } else if (NList[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(0);
    }

}
