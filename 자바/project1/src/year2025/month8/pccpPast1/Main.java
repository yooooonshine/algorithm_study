package year2025.month8.pccpPast1;

import java.util.*;

public class Main {
	public int main(int[] bandage, int health, int[][] attacks) {
		int T = bandage[0]; // T초 시전 시 추가
		int healPerS = bandage[1];
		int A = bandage[2]; // 추가 회복량
		int healthMax = health;

		// 최대 T 구하기
		int maxT = 0;
		for (int i = 0; i <= attacks.length - 1; i++) {
			if (maxT < attacks[i][0]) {
				maxT = attacks[i][0];
			}
		}

		int healCount = 0;
		int attackCount = 0;
		for (int t = 1; t <= maxT; t++) {
			if (attacks[attackCount][0] == t) {
				health -= attacks[attackCount][1];
				healCount = 0;

				if (health <= 0) {
					return -1; // 체력 저하 끝
				}

				attackCount++;
			} else {
				health += healPerS;
				healCount++;

				if (healCount == T) {
					health += A;
					healCount = 0;
				}
			}

			if (healthMax < health) {
				health = healthMax;
			}
			System.out.println(health);
		}

		// 죽으면 -1 리턴

		return health;
	}
}

// 공격이 아니면
// 힐 + 1
// 성공 카운터 + 1
// 만약 성공카운터가 T가되면 성공카운터는 0, 힐 + A
// 공격이면
// 공격량 -하고 끝
// 만약 음수면 -1리턴

// t초 동안 붕대 감으면 1초마다 x만큼 회복
// t초 연속 -> y만큼 회복
// 최대 체력 존재

// 공격 받으면 연속성공 시간 -> 0
// 공격시 피해량만큼 체력 감소
// 체력 0이하면 체력 회복불가

// 생존 가능?
