package year2024.month7_2024.codingTest1;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 지도의 크키 N
		int M = Integer.parseInt(st.nextToken()); // 태운 손님의 수 M

		st = new StringTokenizer(br.readLine());

		int X = Integer.parseInt(st.nextToken()); // 택시 기본 요금
		int Y = Integer.parseInt(st.nextToken()); // 추가 요금
		int Z = Integer.parseInt(st.nextToken()); // 통행료
	}
}
