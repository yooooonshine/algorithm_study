package October_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2473 {
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long finalAns1 = 0L;
        long finalAns2 = 0L;
        long finalAns3 = 0L;
        long resultSumAbs = 3000000003L;

        //미리 두 숫자를 정해두고 그 사이에서 이분 탐색하면 된다. 왼쪽부터 하나씩 제외하면서 투포인터 사용하면 되지않을까
        for (int k = 0; k < N; k++) {

            long readyValue = arr[k];
            int i = k + 1;
            int j = arr.length - 1;

            long gap = Long.MAX_VALUE;
            long ans1 = 0L;
            long ans2 = 0L;

            long temp = 0L;
            long sum = 0L;
            if (k >= N - 2) {
                break;
            }
            while (i < j) {
                sum = arr[i] + arr[j] + readyValue;
                temp = Math.abs(sum);
                if (temp < gap) {
                    gap = temp;
                    ans1 = arr[i];
                    ans2 = arr[j];
                }
                if (sum > 0)
                    j--;
                else
                    i++;
            }
            System.out.println("temporaryResult = " + readyValue + " " + ans1 + " " + ans2 + ",gap " + gap);
            if (resultSumAbs > gap) {
                finalAns1 = readyValue;
                finalAns2 = ans1;
                finalAns3 = ans2;
                resultSumAbs =gap;
            }
        }
        System.out.println(finalAns1 + " " + finalAns2 + " " + finalAns3);
    }
}
