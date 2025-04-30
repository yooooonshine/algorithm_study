package year2025.month4.N2941;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] arr = br.readLine().toCharArray();

		int count = 0;
		int max = arr.length - 1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'c') {
				if (i + 1 <= max && arr[i + 1] == '=') {
					i++;
					count++;
				} else if (i + 1 <= max && arr[i + 1] == '-') {
					i++;
					count++;
				} else {
					count++;
				}
			} else if (arr[i] == 'd') {
				if (i + 1 <= max && arr[i + 1] == 'z' && i + 2 <= max && arr[i + 2] == '=') {
					i += 2;
					count++;
				} else if (i + 1 <= max && arr[i + 1] == '-') {
					i++;
					count++;
				} else {
					count++;
				}
			} else if (arr[i] == 'l' && i + 1 <= max &&  arr[i + 1] == 'j') {
				i++;
				count++;
			} else if (arr[i] == 'n' && i + 1 <= max && arr[i + 1] == 'j') {
				i++;
				count++;
			} else if (arr[i] == 's' && i + 1 <= max && arr[i + 1] == '=') {
				i++;
				count++;
			} else if (arr[i] == 'z' && i + 1 <= max && arr[i + 1] == '=') {
				i++;
				count++;
			} else {
				count++;
			}
		}
		System.out.println(count);
	}
}
