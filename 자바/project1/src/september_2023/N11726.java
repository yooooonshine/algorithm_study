package september_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N11726 {
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //정점의 개수
        int M = Integer.parseInt(st.nextToken()); //간선의 개수

        int counter = 0;

        adj = new LinkedList[N + 1];
        // v개의 LinkedList 선언 및 생성
        for (int i = 1; i <= N; ++i) {
            adj[i] = new LinkedList();
        }


        for (int i = 0; i < M; i++) {
            String[] temporaryStringList = br.readLine().split(" ");
            addEdge(Integer.parseInt(temporaryStringList[0]),Integer.parseInt(temporaryStringList[1])); //간선 넣기
            addEdge(Integer.parseInt(temporaryStringList[1]),Integer.parseInt(temporaryStringList[0]));
        }


        for (int i = 1; i <= N; i++) {
            if (visited[i] == false) {
                DFS(i);
                counter++;
            }
        }

        System.out.println(counter);

    }


    private static int V; //정점 개수
    private static LinkedList<Integer> adj[]; // 링크드리스트의 배열

    static boolean[] visited = new boolean[1001];


    static void addEdge (int v, int w) { // v번째 LinkedList 에 w를 삽입
        adj[v].add(w);
    }
    // DFS 함수
    static void DFS(int v) { // v를 시작노드로!
//        visited = new boolean[V + 1]; // 각 노드이 방문 여부를 저장하기 위해, 인덱스는 1이상 V이하
        DFSUtil(v);
    }
    // DFS에서 호출되는 함수
    static void DFSUtil(int v)  {
        // 현재 노드를 방문한 것으로 체크 (visited의 v번째 요소를 true로)
        visited[v] = true;

        // 방문한 노드와 인접한 모든 노드를 가지고 온다
        Iterator<Integer> it = adj[v].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            // 방문하지 않은 노드면 해당 노드를 다시 시작 노드로하여 DFSUtil을 호출
            if (!visited[n])
                DFSUtil(n); // 재귀호출!
        }
    }
}


