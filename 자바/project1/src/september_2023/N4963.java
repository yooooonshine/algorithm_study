package september_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N4963 {
    private static int V;


    static void addEdge (int v, int w,LinkedList<Integer>[] adj) { // v번째 LinkedList 에 w를 삽입
        adj[v].add(w);
        adj[w].add(v);
    }
    // DFS 함수
    static void DFS(int v, boolean[] visited, LinkedList<Integer>[] adj) { // v를 시작노드로!

        DFSUtil(v, visited, adj);
    }
    // DFS에서 호출되는 함수
    static void DFSUtil(int v, boolean visited[], LinkedList<Integer>[] adj)  {
        // 현재 노드를 방문한 것으로 체크 (visited의 v번째 요소를 true로)
        visited[v] = true;

        // 방문한 노드와 인접한 모든 노드를 가지고 온다
        Iterator<Integer> it = adj[v].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            // 방문하지 않은 노드면 해당 노드를 다시 시작 노드로하여 DFSUtil을 호출
            if (!visited[n])
                DFSUtil(n, visited, adj); // 재귀호출!
        }
    }

    public static void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String temporaryString = br.readLine();
            StringTokenizer st = new StringTokenizer(temporaryString);
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {

                return;
            }

            int[][] islandList = new int[h + 2][w + 2]; //0행 0열 제외 및 테두리 작업

            for (int i = 1; i <= h; i++) {
                String temporaryTestString = br.readLine();
                String[] stringList= temporaryTestString.split(" ");
                for (int j = 1; j <= w; j++) {
                    islandList[i][j] = Integer.parseInt(stringList[j - 1]);
                }
            }

            V = w * h;
            LinkedList<Integer> adj[] = new LinkedList[V + 1];//1 부터 V까지
            boolean[] visited = new boolean[V + 1]; // 각 노드이 방문 여부를 저장하기 위해
            // v개의 LinkedList 선언 및 생성
            for (int i = 1; i <= V; ++i) {
                adj[i] = new LinkedList();
            }

            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    int weight = i - 1;
//                    System.out.println("x=" + i + ", y=" + j);
                    if (islandList[i][j] == 1 && islandList[i][j + 1] == 1) {
//                        System.out.println("case1");
                        addEdge(weight * w + j, weight * w + j + 1, adj);
                    }
                    if (islandList[i][j] == 1 && islandList[i + 1][j] == 1) {
//                        System.out.println("case2");
                        addEdge(weight * w + j, (weight + 1) * w + j, adj);
                    }
                    if (islandList[i][j] == 1 && islandList[i + 1][j + 1] == 1) {
//                        System.out.println("case3");
                        addEdge(weight * w + j, (weight + 1)* w + j + 1, adj);
                    }
                    if (islandList[i][j] == 1 && islandList[i + 1][j - 1] == 1) {
//                        System.out.println("case4");
                        addEdge(weight * w + j, (weight + 1) * w + j - 1, adj);
                    }
                }
            }
            int counter = 0;
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    int index = (i - 1) * w + j;
                    if (islandList[i][j] == 1 && visited[index] == false) {
                        DFS(index, visited, adj);
                        counter++;
                    }
                }
            }
            System.out.println(counter);

        }
    }
}

//기본 형태

