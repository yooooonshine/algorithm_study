package year2023.month9_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


//풀이 1. 백트래킹과, visited 리스트를 통해 좌 우 밑 으로 체크하고 visited 면 방문x 아니면 방문
// 1이면서,vistied false면 함수 실행 0 혹은 vistied true이면 넘어감
public class N2677 {
    public static int temporaryVillageNumber;
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] twoDimensionArray = new int[N + 2][N + 2]; //테두리 0으로
        boolean[][] visited = new boolean[N + 2][N + 2];
        ArrayList<Integer> NOfVillage = new ArrayList<Integer>();

        for (int i = 1; i <= N; i++) {
            String temporaryString = br.readLine();
            String[] strArray = temporaryString.split("");
            for (int j = 1; j <= N; j++) {
                twoDimensionArray[i][j] = Integer.parseInt(strArray[j - 1]);

            }
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (twoDimensionArray[i][j] == 1 && visited[i][j] == false) {
                    temporaryVillageNumber = 0;

                    //함수 실행
//                    System.out.println("recursion start");
                    recursion(i, j, twoDimensionArray, visited);

                    NOfVillage.add(temporaryVillageNumber);

                }
            }
        }
        Collections.sort(NOfVillage);
        System.out.println(NOfVillage.size());
        for (Integer integer : NOfVillage) {
            System.out.println(integer);
        }
    }

    public void recursion(int x, int y, int[][] twoDimensionArray, boolean[][] visited) {
        temporaryVillageNumber++; //카운터 증가
        visited[x][y] = true;
//        System.out.println("x:" + x + ", y:" + y);

        if (twoDimensionArray[x][y - 1] == 1 && visited[x][y - 1] == false) {
            recursion(x , y - 1, twoDimensionArray, visited);
        }
        if (twoDimensionArray[x][y + 1] == 1 && visited[x][y + 1] == false) {
            recursion(x, y + 1, twoDimensionArray, visited);
        }
        if (twoDimensionArray[x + 1][y] == 1 && visited[x + 1][y] == false) {
            recursion(x + 1, y, twoDimensionArray, visited);
        }
        if (twoDimensionArray[x - 1][y] == 1 && visited[x - 1][y] == false) {
            recursion(x - 1, y, twoDimensionArray, visited);
        }

    }
}


//풀이 2 dfs bfs 를이용하여 각 위치를 노드로 보고, 두 인접노드가 1 , 1 이면 간선존재 즉 인접행렬로 dfs