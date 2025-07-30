package year2025.Month7.N20006;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int P = Integer.parseInt(st.nextToken()); // 플레이어수
		int M = Integer.parseInt(st.nextToken()); // 방의정원

		List<Room> rooms = new ArrayList<>();

		for (int p = 1; p <= P; p++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			Player nP = new Player(level, name);

			boolean in = false;
			for (Room room : rooms) {
				if (room.level - 10 <= level && level <= room.level + 10 && room.ps.size() < M) {
					room.ps.add(nP);
					in = true;
					break;
				}
			}

			if (!in) {
				Room room = new Room(level);
				room.ps.add(nP);
				rooms.add(room);
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (Room room : rooms) {
			if (room.ps.size() == M) {
				bw.write("Started!\n");
			} else {
				bw.write("Waiting!\n");
			}

			Collections.sort(room.ps);
			for (Player p : room.ps) {
				bw.write(p.l + " " + p.n + "\n");
			}
		}

		bw.flush();
	}

	public static class Player implements Comparable<Player> {
		int l;
		String n;

		public Player(int l, String n) {
			this.l = l;
			this.n = n;
		}

		@Override
		public int compareTo(Player p) {
			return this.n.compareTo(p.n);
		}
	}

	public static class Room {
		int level;
		List<Player> ps = new ArrayList<>();

		public Room(int level) {
			this.level = level;
		}
	}
}

// 비슷한 레벨의 플레이어들을 매칭
// 각 방은 처음 플레이어 레벨의 -10 ~ 10 까지
// 매칭 방이 없으면 새로 생성

// 입장 가능한 방이 여러 개면 먼저 생성한 방에 입장

// 플레이어수 p
// 플레이어 닉네임 n
// 레벨 i
// 정원 m


// 출력
// 최종 방의 상태
// 입장 플레이어들

// 방은 생성된 순서대ㅗㄹ
// 닉네임은 사전순으로
// 시작했으면 Started, 대기중이면 waiting

// 구현문제
//