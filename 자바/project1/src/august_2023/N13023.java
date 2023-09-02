package august_2023;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N13023 {

    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); //친구 관계의 수

        boolean visited[] = new boolean[n]; // 방문 여부를 검사할 배열

        LinkedList<Integer>[] adjList = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        // 두 정점 사이에 여러 개의 간선이 있을 수 있다.
        // 입력으로 주어지는 간선은 양방향이다.
        for (int i = 0; i < m; i++) {
            String[] temporaryList = br.readLine().split(" ");
            int v1 = Integer.parseInt(temporaryList[0]);
            int v2 = Integer.parseInt(temporaryList[1]);
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(adjList[i]); // 방문 순서를 위해 오름차순 정렬
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited,false); //visited 초기화
            if (dfs_list(0 ,i, adjList, visited)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    public static boolean dfs_list(int depth, int v, LinkedList<Integer>[] adjList, boolean[] visited) {
        visited[v] = true; // 정점 방문 표시
        Iterator<Integer> iter = adjList[v].listIterator(); // 정점 인접리스트 순회
        if (depth == 4) {
            visited[v] = false;
            return true;
        }
        while (iter.hasNext()) {
            int w = iter.next();
            if (!visited[w]) { // 방문하지 않은 정점이라면

                if (dfs_list(depth + 1, w, adjList, visited)) {
                    visited[v] = false;
                    return true; // 재귀 호출 결과가 true라면 바로 반환
                }

            }
        }
//        for (int i = 0; i < adjList[v].size(); i++) {
//            System.out.print(adjList[v].get(i) + " ");
//        }
        visited[v] = false;
        return false;
    }


}
