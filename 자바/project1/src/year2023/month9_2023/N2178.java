package year2023.month9_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2178 {
    private static int V;
    private static int destination;

    private static int min = 10000;
    private static int counter = 0;


    static void addEdge(int v, int w, LinkedList<Integer>[] adj) { // v번째 LinkedList 에 w를 삽입
        adj[v].add(w);
        adj[w].add(v);
    }




    public static void bfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited, int[] depth) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[v] = true;
        depth[v] = 1;
        queue.add(v);

        while(queue.size() != 0) {
            v = queue.poll();

            Iterator<Integer> iter = adjList[v].listIterator();
            while(iter.hasNext()) {
                int w = iter.next();
                if(!visited[w]) {
                    visited[w] = true;
                    depth[w] = depth[v] + 1;
                    if (w == V) {
                        System.out.println(depth[w]);
                        return;
                    }
                    queue.add(w);

                }
            }
        }
    }

    public static void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //세로
        int M = Integer.parseInt(st.nextToken()); //가로
        int[][] islandList = new int[N + 2][M + 2]; //0행 0열 제외 및 테두리 작업

        for (int i = 1; i <= N; i++) {
            String temporaryTestString = br.readLine();
            String[] stringList = temporaryTestString.split("");
            for (int j = 1; j <= M; j++) {
                islandList[i][j] = Integer.parseInt(stringList[j - 1]);
            }
        }

        V = N * M;

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
                if (islandList[i][j] == 1 && islandList[i][j + 1] == 1) {
//                        System.out.println("case1");
                    addEdge(weight * M + j, weight * M + j + 1, adj);
                }
                if (islandList[i][j] == 1 && islandList[i + 1][j] == 1) {
//                        System.out.println("case2");
                    addEdge(weight * M + j, (weight + 1) * M + j, adj);
                }
            }
        }
        bfs_list(1, adj, visited, depth);

    }

}
