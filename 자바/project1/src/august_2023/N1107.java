package august_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class N1107 {
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //이동할 채널
        int M = Integer.parseInt(br.readLine()); // 개수
        int[] brokenButtonList = new int[M]; //망가진 버튼 리스트
        StringTokenizer st = new StringTokenizer(br.readLine()); // br.readLine을 통해 읽은 뭍자열을 쪼개주는 객체
        for (int i = 0; i < M; i++) { //망가진버튼리스트 초기화
            brokenButtonList[i] = Integer.parseInt(st.nextToken());
        }
        if (M == 0) {
            int min = Math.abs(N - 100);
            if (N != 0) {
                int temporaryValue = (int) (Math.log10(N) + 1);
                if (temporaryValue < min) {
                    min = temporaryValue;
                    System.out.println(min);
                } else {
                    System.out.println(1);
                }
            }
        } else {
            System.out.println(FindMin(100, N, brokenButtonList));
        }


    }

    public int FindMin(int nowChannel, int N, int[] brokenButtonList) {
        int counter = 0;
        int min = 500000;
        if (nowChannel == N) {
            return 0;
        }
        counter = Math.abs(nowChannel - N);
        if (min > counter) {
            min = counter;
        }

        for (int i = 0; i < 1000000; i++) {
            if (CheckValue(i, brokenButtonList)) { //고장난 버튼이랑 곂친게 없으면 확인
                int value = Math.abs(N - i);
                if (i != 0) {
                    value += (int) (Math.log10(i) + 1);
                } else{
                    value += 1;
                }

                if (value < min) {
                    min = value;
                }
            }
        }


        return min;
    }

    public boolean CheckValue(int num, int[] brokenButtonList) {
        int[] arrNum = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        for (int i : arrNum) {
            if (IntStream.of(brokenButtonList).anyMatch(x -> x == i)) {
                return false;
            }
        }
        return true; //고장난 버튼과 겹치는게 없으면 트루

    }
}
