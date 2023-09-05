package september_2023;

import java.util.Iterator;
import java.util.LinkedList;


////기본 형태
//public class Graph {
//    private int V;
//    private LinkedList<Integer> adj[]; // 링크드리스트의 배열
//
//    // constructor
//    Graph (int v) {
//        V = v;
//        adj = new LinkedList[v];
//        // v개의 LinkedList 선언 및 생성
//        for (int i = 0; i < v; ++i) {
//            adj[i] = new LinkedList();
//        }
//    }
//    void addEdge (int v, int w) { // v번째 LinkedList 에 w를 삽입
//        adj[v].add(w);
//    }
//    // DFS 함수
//    void DFS(int v) { // v를 시작노드로!
//        boolean visited[] = new boolean[V]; // 각 노드이 방문 여부를 저장하기 위해
//        DFSUtil(v, visited);
//    }
//    // DFS에서 호출되는 함수
//    void DFSUtil(int v, boolean visited[])  {
//        // 현재 노드를 방문한 것으로 체크 (visited의 v번째 요소를 true로)
//        visited[v] = true;
//        System.out.println(v + " ");
//
//        // 방문한 노드와 인접한 모든 노드를 가지고 온다
//        Iterator<Integer> it = adj[v].listIterator();
//        while (it.hasNext()) {
//            int n = it.next();
//            // 방문하지 않은 노드면 해당 노드를 다시 시작 노드로하여 DFSUtil을 호출
//            if (!visited[n])
//                DFSUtil(n, visited); // 재귀호출!
//        }
//    }
//}

//N11726 형태
public class Graph {
    private int V; //정점 개수
    private LinkedList<Integer> adj[]; // 링크드리스트의 배열

    boolean[] visited = new boolean[1001];

    // constructor
    Graph (int v) {
        V = v;
        adj = new LinkedList[v + 1];
        // v개의 LinkedList 선언 및 생성
        for (int i = 1; i <= v; ++i) {
            adj[i] = new LinkedList();
        }
    }
    void addEdge (int v, int w) { // v번째 LinkedList 에 w를 삽입
        adj[v].add(w);
    }
    // DFS 함수
    void DFS(int v) { // v를 시작노드로!
        visited = new boolean[1000 + 1]; // 각 노드이 방문 여부를 저장하기 위해, 인덱스는 1이상 V이하
        DFSUtil(v);
    }
    // DFS에서 호출되는 함수
    void DFSUtil(int v)  {
        // 현재 노드를 방문한 것으로 체크 (visited의 v번째 요소를 true로)
        visited[v] = true;
        System.out.println(v + " ");

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