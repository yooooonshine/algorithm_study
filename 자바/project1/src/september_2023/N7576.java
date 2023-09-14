package september_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N7576 {
    private static int V;
    private static int finalDepth;
    static void addEdge(int v, int w, LinkedList<Integer>[] adj) { // v번째 LinkedList 에 w를 삽입
        adj[v].add(w);
        adj[w].add(v);
    }




    public static void bfs_list(LinkedList<Integer>[] adjList, boolean[] visited, int[] depth, int[] tomatoList) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i <= V; i++) {
            if (tomatoList[i] == 1) {
                visited[i] = true;
                queue.add(i);
                depth[i] = 0;
            }
        }

        while(queue.size() != 0) {
            int v = queue.poll();

            Iterator<Integer> iter = adjList[v].listIterator();
            while(iter.hasNext()) {
                int w = iter.next();
                if(!visited[w]) {
                    visited[w] = true;
                    depth[w] = depth[v] + 1;
                    finalDepth  = depth[w];
                    queue.add(w);

                }
            }
        }
    }

    public static void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); //가로
        int N = Integer.parseInt(st.nextToken()); //세로
        int[][] islandList = new int[N + 2][M + 2]; //0행 0열 제외 및 테두리 작업

        for (int i = 0; i < N + 2; i++) { //배열 모두 -1로 초기화
            Arrays.fill(islandList[i],-1);

        }

        for (int i = 1; i <= N; i++) {
            String temporaryTestString = br.readLine();
            String[] stringList = temporaryTestString.split(" ");
            for (int j = 1; j <= M; j++) {
                islandList[i][j] = Integer.parseInt(stringList[j - 1]);
            }
        }


        V = N * M;

        int[] tomatoList = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                tomatoList[(i - 1) * M + j] = islandList[i][j];
            }
        }

        LinkedList<Integer> adj[] = new LinkedList[V + 1];//1 부터 V까지
        boolean[] visited = new boolean[V + 1]; // 각 노드이 방문 여부를 저장하기 위해
        int[] depth = new int[V + 1];
        // v개의 LinkedList 선언 및 생성
        for (int i = 1; i <= V; ++i) {
            adj[i] = new LinkedList();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int weight = i - 1;
//                    System.out.println("x=" + i + ", y=" + j);
                if ((islandList[i][j] == 1 || islandList[i][j] == 0) && (islandList[i][j + 1] == 1 || islandList[i][j + 1] == 0)) {
//                        System.out.println("case1");
                    addEdge(weight * M + j, weight * M + j + 1, adj);
                }
                if ((islandList[i][j] == 1 || islandList[i][j] == 0) && (islandList[i + 1][j] == 1 || islandList[i + 1][j] == 0)) {
//                        System.out.println("case2");
                    addEdge(weight * M + j, (weight + 1) * M + j, adj);
                }
                if (islandList[i][j] == -1){
                    visited[weight * M + j] = true;
                }
            }
        }
        bfs_list(adj, visited, depth, tomatoList);

        boolean result = true;
        for (int i = 1; i <= V; i++) {
            if (visited[i] == false) {
                result = false;
            }
        }

        if (result == true) {
            System.out.println(finalDepth);
        } else {
            System.out.println(-1);
        }
    }
}
