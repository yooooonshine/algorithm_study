package year2024.month10_2024.N1922;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); // 연결할 수 있는 선의 수

        List<Edge> adj = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); // 비용

            adj.add(new Edge(a, b, c));
        }

        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = i;
        }

        Collections.sort(adj);

        int sum = 0;
        int count = 0;
        for (Edge edge : adj) {
            if (count == N - 1) {
                break;
            }

            int s = edge.s;
            int e = edge.e;
            int p = edge.p;
            if (find(A, s) != find(A, e)) {
                union(A, s, e);
                sum += p;
            }
        }

        System.out.println(sum);
    }

    public static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int p;

        public Edge(int s, int e, int p) {
            this.s = s;
            this.e = e;
            this.p = p;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.p, o.p);
        }
    }

    public static void union(int[] A, int a, int b) {
        int p1 = find(A, a);
        int p2 = find(A, b);

        if (p1 < p2) {
            A[p2] = p1;
        } else {
            A[p1] = p2;
        }
    }

    public static int find(int[] A, int p) {
        if (A[p] == p) {
            return p;
        }

        return A[p] = find(A, A[p]);
    }

}


// 최소 비용으로 연결
// 인접 리스트