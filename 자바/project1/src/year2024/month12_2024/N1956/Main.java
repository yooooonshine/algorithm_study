package year2024.month12_2024.N1956;

import java.util.*;
import java.io.*;

public class Main {
	public static int[][] dist;
	public static int MAX = 100000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		dist = new int[V + 1][V + 1];
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				dist[i][j] = MAX;
			}
		}

		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			dist[s][e] = w;
		}

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				for (int k = 1; k < +V; k++) {
					if (dist[j][k] > dist[j][i] + dist[i][k]) {
						dist[j][k] = dist[j][i] + dist[i][k];
					}
				}
			}
		}

		int min = MAX;
		for (int i = 1; i <= V; i++) {
			if (min > dist[i][i]) {
				min = dist[i][i];
			}
		}

		if (min == MAX) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}
}