package year2023.month9_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N7562 {
    public static void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseNumber; i++) {
            int I = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] startPoint = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int[] endPoint = {Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())};



        }

    }

    public static void bfs() {

    }

}
