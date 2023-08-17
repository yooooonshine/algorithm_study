package august_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N3085 {
    public int N;
    public String[][] stringList = new String[51][51];
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String word = br.readLine();
            String[] arrayWord = word.split(""); // 한문자씩 쪼개기
            for (int j = 1; j <= N; j++) {
                stringList[i][j] = arrayWord[j - 1];
            }
        }
        int max = 0;
        int temporaryInt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == N && j == N) {
                    continue;
                } else if (i == N) {
                    //세팅
                    String tempString1 = stringList[i][j];
                    String tempString2 = stringList[i][j + 1];
                    stringList[i][j] = tempString2;
                    stringList[i][j + 1] = tempString1;
                    temporaryInt = Count();
                    if (max < temporaryInt) {
                        max = temporaryInt;
                    }
                    //되돌림
                    stringList[i][j] = tempString1;
                    stringList[i][j + 1] = tempString2;
                } else if (j == N) {
                    //세팅
                    String tempString1 = stringList[i][j];
                    String tempString2 = stringList[i + 1][j];
                    stringList[i][j] = tempString2;
                    stringList[i + 1][j] = tempString1;
                    temporaryInt = Count();
                    if (max < temporaryInt) {
                        max = temporaryInt;
                    }
                    //되돌림
                    stringList[i][j] = tempString1;
                    stringList[i + 1][j] = tempString2;
                } else {
                    //좌우교환
                    //세팅
                    String tempString1 = stringList[i][j];
                    String tempString2 = stringList[i][j + 1];
                    stringList[i][j] = tempString2;
                    stringList[i][j + 1] = tempString1;
                    temporaryInt = Count();
                    if (max < temporaryInt) {
                        max = temporaryInt;
                    }
                    //되돌림
                    stringList[i][j] = tempString1;
                    stringList[i][j + 1] = tempString2;

                    //상하교환
                    //세팅
                    tempString1 = stringList[i][j];
                    tempString2 = stringList[i + 1][j];
                    stringList[i][j] = tempString2;
                    stringList[i + 1][j] = tempString1;
                    temporaryInt = Count();
                    if (max < temporaryInt) {
                        max = temporaryInt;
                    }
                    //되돌림
                    stringList[i][j] = tempString1;
                    stringList[i + 1][j] = tempString2;
                }
            }
        }
        System.out.println(max);
    }

    public int Count() {
        int max = 0;
        for (int i = 1; i <= N; i++) { //행
            int count = 1;
            for (int j = 2; j <= N; j++) {
                if (stringList[i][j].equals(stringList[i][j - 1])) {
                    count++;
                } else {
                    if (max < count) {
                        max= count;
                    }
                    count = 1;
                }
            }
            if (max < count) { //마지막 확인
                max = count;
            }
        }
        for (int i = 1; i <= N; i++) { //열
            int count = 1;
            for (int j = 2; j <= N; j++) {
                if (stringList[j][i].equals(stringList[j - 1][i])) {
                    count++;
                } else {
                    if (max < count) {
                        max= count;
                    }
                    count = 1;
                }
            }
            if (max < count) { //마지막 확인
                max = count;
            }
        }
        return max;
    }
}
