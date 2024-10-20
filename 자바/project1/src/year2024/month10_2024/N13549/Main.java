package year2024.month10_2024.N13549;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] distance = new int[100000 + 1];
        dijkstra(100000, distance, N);

        System.out.println(distance[K]);
    }

    public static void dijkstra(int max, int[] distance, int start) {
        boolean[] visit = new boolean[max + 1];
        for (int i = 0; i <= max; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
            int dist1 = o1.dist;
            int dist2 = o2.dist;

            if (dist1 > dist2) {
                return 1;
            } else if (dist1 == dist2) {
                return 0;
            } else {
                return -1;
            }
        });

        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int e = edge.e;
            int dist = edge.dist;

            if (visit[e]) {
                continue;
            }
            visit[e] = true;

            if (e + 1 <= 100000 && distance[e + 1] > dist + 1) {
                distance[e + 1] = dist + 1;
                pq.add(new Edge(e + 1, dist + 1));
            }

            if (e - 1 >= 0 && distance[e - 1] > dist + 1) {
                distance[e - 1] = dist + 1;
                pq.add(new Edge(e - 1, dist + 1));
            }

            if (e * 2 <= 100000 && distance[e * 2] > dist) {
                distance[e * 2] = dist;
                pq.add(new Edge(e * 2, dist));
            }
        }
    }

    public static class Edge {
        int e;
        int dist;

        public Edge(int e, int dist) {
            this. e = e;
            this.dist = dist;
        }
    }
}

// 수빈이는 N
// 동생은 K
// 걷기 -1 or + 1 -> 1초
// 순간이동 2x -> 0초

// 최소 0, 최대 100000

// 가중치가 0