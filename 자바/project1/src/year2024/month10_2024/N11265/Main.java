package year2024.month10_2024.N11265;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] distArr = new long[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                distArr[i][j] = Long.MAX_VALUE;
            }
        }

        long[][] adj = new long[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= N; k++) {
                adj[i][k] = Long.parseLong(st.nextToken());
            }
        }

        for (int k = 1; k <= N; k++) {
            dfs(distArr, adj, k, N);
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            long C = Long.parseLong(st.nextToken());

            if (distArr[A][B] <= C) {
                System.out.println("Enjoy other party");
            } else {
                System.out.println("Stay here");
            }
        }
    }

    public static void dfs(long[][] distArr, long[][] adj, int start, int N) {
        boolean[] visited = new boolean[N + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
            long dist1 = o1.dist;
            long dist2 = o2.dist;

            if (dist1 > dist2) {
                return 1;
            } else if (dist1 == dist2) {
                return 0;
            } else {
                return -1;
            }
        });

        pq.add(new Edge(start, 0L));

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int node = edge.n;
            long dist = edge.dist;

            if (visited[node]) {
                continue;
            }
            visited[node] = true;

            for (int i = 1; i <= N; i++) {
                if (adj[node][i] > 0) {
                    if (distArr[start][i] > dist + adj[node][i]) {
                        distArr[start][i] =  dist + adj[node][i];
                        pq.add(new Edge(i, distArr[start][i]));
                    }
                }
            }
        }
    }

    public static class Edge {
        int n;
        long dist;

        public Edge(int n, long dist) {
            this.n = n;
            this.dist = dist;
        }
    }
}


// 시간은 Long으로 잡아야 한다.
// 한 점에서 모든 점이 아니라 모든 점에서 모든 점이다.
// dfs가 아니다.