package year2024.month10_2024.N1865;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            List<Edge> adj = new ArrayList<>();

            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                adj.add(new Edge(S, E, T));
                adj.add(new Edge(E, S, T));
            }

            for (int i = 1; i <= W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                adj.add(new Edge(S, E, -T));
            }

            boolean yes = false;

            int[] dist = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                dist[i] = Integer.MAX_VALUE;
            }
            dist[1] = 0;


            for (int i = 1; i <= N - 1; i++) {
                bellmanFord(dist, adj);
            }

            int[] dist1 = new int[N + 1];
            for (int i = 1; i<= N; i++) {
                dist1[i] = dist[i];
            }

            bellmanFord(dist1, adj);

            for (int i = 1; i <= N; i++) {
                if (dist[i] != dist1[i]) {
                    yes = true;
                }
            }

            if (yes) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void bellmanFord(int[] dist, List<Edge> adj) {

        for (Edge edge : adj) {
            int s = edge.s;
            int e = edge.e;
            int d = edge.d;


            if (dist[e] > dist[s] + d) {
                dist[e] = dist[s] + d;
            }
        }
    }

    public static class Edge {
        int s;
        int e;
        int d;

        public Edge(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }
    }
}


// N개의 지점
// M개의 도록
// W개의 월홀이 N개의 지점 사이에 있다.

// 도로는 무방향 -> 그래프 문제?
// 웜홀은 방향이 있다!


//웜홀은 시간이 뒤로 간다 -> 음의 간선 -> 벨만 포드?
//음의 간선이 있는 지 확인하라

// N(지점의 수), M(도로의 개수), W(웜홀의 개수)