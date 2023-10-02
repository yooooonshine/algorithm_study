package september_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1654 {
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] intArray = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long K = intArray[0]; //이미 가지고 있는 랜선의 개수
        long N = intArray[1]; // 필요한 랜선의 개수
        long[] lanList = new long[(int) K];
        for (int i = 0; i < K; i++) {
            lanList[i] = Integer.parseInt(br.readLine());
        }

        long max = Arrays.stream(lanList).max().getAsLong(); // 랜선중 가장 긴 랜선
//        System.out.println("maxLan = " + max);
        binarySearch(lanList, N,1L, max);
    }

    public static boolean cutLan(long[] lanList, long x, long N) {
        long count = 0L;
        for (int i = 0; i < lanList.length; i++) {
            count += lanList[i] / x;
        }
        if (count >= N) {
            return true; // 개수 이상으로 잘라졌으면 true
        } else {
            return false;
        }
    }

    public static  void binarySearch(long[] lanList,long N, long low, long high) {
        long temporaryMax= 0;
        while (low <= high) {
            long mid = (low + high) / 2;
//            System.out.println(mid);
            if(cutLan(lanList, mid, N)) {
                temporaryMax = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(temporaryMax);
    }
}
