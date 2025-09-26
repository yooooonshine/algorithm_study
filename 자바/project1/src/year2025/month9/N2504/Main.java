package year2025.month9.N2504;

import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");

		Stack<String> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			String c = arr[i];

			if (c.equals("(") || c.equals("[")) {
				stack.add(c);
			} else if (stack.isEmpty()) {
				System.out.println(0);
				return;
			} else if (c.equals(")")) {
				if (stack.peek().equals("(")) {
					stack.pop();

					stack.add("2");
				} else {
					String tmp = stack.pop();

					if (stack.isEmpty() || tmp.equals("(") || tmp.equals(")") || tmp.equals("[") || tmp.equals("]")) {
						System.out.println(0);
						return;
					}

					stack.pop();
					int tmpV = Integer.valueOf(tmp) * 2;

					if (!stack.isEmpty() && !stack.peek().equals("(") && !stack.peek().equals("[")) {
						tmpV += Integer.valueOf(stack.pop());
					}
					stack.add(String.valueOf(tmpV));
				}
			} else {
				if (stack.peek().equals("[")) {
					stack.pop();
					stack.add("3");
				} else {
					String tmp = stack.pop();

					if (stack.isEmpty() || tmp.equals("(") || tmp.equals(")") || tmp.equals("[") || tmp.equals("]")) {
						System.out.println(0);
						return;
					}

					stack.pop();

					int tmpV = Integer.valueOf(tmp) * 3;

					if (!stack.isEmpty() && !stack.peek().equals("(") && !stack.peek().equals("[")) {
						tmpV += Integer.valueOf(stack.pop());
					}

					stack.add(String.valueOf(tmpV));
				}
			}
		}

		int result = 0;
		while (!stack.isEmpty()) {
			String pop = stack.pop();

			if (pop.equals("(") || pop.equals(")") || pop.equals("[") || pop.equals("]")) {
				System.out.println(0);
				return;
			}

			result += Integer.valueOf(pop);
		}

		System.out.println(result);
	}
}

// 기호 ()[]

// () = 2
// [] = 3
// (x) = 2 * x
// [x] = 3 * x
// xy = x + y

// 숫자를 넣으려는데 안이 숫자면? 더한다
// ([는 그냥 넎느다
// )] -> 앞이 숫자면? 뺀다. 곱한다. 아니면 2넣는다.