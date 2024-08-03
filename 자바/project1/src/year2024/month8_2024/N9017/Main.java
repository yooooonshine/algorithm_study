package year2024.month8_2024.N9017;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // T개의 테스트 케이스
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			List<Integer> t = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

			Map<Integer, Integer> teamCount = new HashMap<>();

			for (Integer teamName : t) {
				if (teamCount.containsKey(teamName)) {
					teamCount.replace(teamName, teamCount.get(teamName) + 1);
				} else {
					teamCount.put(teamName, 1);
				}
			}

			Map<Integer, Team> map = new HashMap<>();

			int point = 1;
			for (int j = 0; j < t.size(); j++) {
				int teamName = t.get(j);
				if (teamCount.get(teamName) < 6) {
					continue;
				}

				if (map.containsKey(teamName)) {
					Team team = map.get(teamName);

					if (team.count < 4) {
						team.addSum(point);
					}

					if (team.count == 4) {
						team.num5 = point;
					}

					team.addCount();
				} else {
					Team team = new Team(0, 0);
					team.addSum(point);
					team.addCount();

					map.put(teamName, team);
				}

				point++;
			}

			int winner = 0;
			int minCount = Integer.MAX_VALUE;
			int num5 = 0;

			Set<Integer> teams = map.keySet();

			for (Integer teamName : teams) {
				Team team = map.get(teamName);

				if (team.count >= 6) {
					if (team.sum < minCount) {
						winner = teamName;
						minCount = team.sum;
						num5 = team.num5;

					} else if (team.sum == minCount) {
						if (team.num5 < num5) {
							winner = teamName;
							minCount = team.sum;

							num5 = team.num5;
						}
					}
				}
			}

			System.out.println(winner);
		}
	}
}

class Team {
	int count;
	int sum;
	int num5;

	public Team(int count, int sum) {
		this.count = count;
		this.sum = sum;
		this.num5 = 0;
	}

	public void addCount() {
		this.count++;
	}

	public void addSum(int point) {
		this.sum += point;
	}

}

// 개인성적을 매기고 합쳐서 팀성적,
// 여섯 명의 선수 중 상위 4개의 합이 성적
// 결승점 통과 순서대로 점수, 가장 낮은 점수 우승
// 여섯 명의 선수가 참여하지 못하면 탈락
// 동점은 5번쨰 선수가 가장 빨리 들어온 팀

// T -> 테스트 케이스 수

// Map을 사용해서 각 팀당 count와 점수를 더한다.
// count가 4이상이 되면, 점수는 더하지 않고 count만 더한다/
// count가 6이상이면서, 점수가 가장 작은 팀을 출력한다.
