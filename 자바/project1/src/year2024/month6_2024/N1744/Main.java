package year2024.month6_2024.N1744;

import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(nums);

		int sum = 0;

		for (int i = 0; i <= N - 1; i += 2) {
			if (i == N - 1) {
				if (nums[i] < 0) {
					sum -= nums[i];
				}
				break;
			}

			if (nums[i] >= 0) {
				break;
			}	else if (nums[i] < 0 && nums[i + 1] == 0) {
				break;
			} else if (nums[i] < 0 && nums[i + 1] > 0) {
				sum += nums[i];
				break;
			} else if (i + 2 == N - 1) {
				sum += nums[i] * nums[i + 1] + nums[i + 2];
				break;
			}

			sum += nums[i] * nums[i + 1];
		}

		for (int i = N - 1; i >= 0; i -= 2) {
			if (i == 0) {
				if (nums[i] > 0) {
					sum += nums[i];
				}
				break;
			}

			if (nums[i] <= 0) {
				break;
			} else if (nums[i] > 0 && nums[i - 1] == 0) {
				sum += nums[i];
				break;
			} else if (nums[i] > 0 && nums[i - 1] < 0) {
				sum += nums[i];
				break;
			} else if (nums[i] == 1 || nums[i - 1] == 1) {
				sum += nums[i] + nums[i - 1];
				continue;
			}

			sum += nums[i] * nums[i - 1];
		}

		System.out.println(sum);
	}
}
