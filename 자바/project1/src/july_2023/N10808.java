package july_2023;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class N10808 {
    public void func(){
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('b', 0);
        map.put('c', 0);
        map.put('d', 0);
        map.put('e', 0);
        map.put('f', 0);
        map.put('g', 0);
        map.put('h', 0);
        map.put('i', 0);
        map.put('j', 0);
        map.put('k', 0);
        map.put('l', 0);
        map.put('m', 0);
        map.put('n', 0);
        map.put('o', 0);
        map.put('p', 0);
        map.put('q', 0);
        map.put('r', 0);
        map.put('s', 0);
        map.put('t', 0);
        map.put('u', 0);
        map.put('v', 0);
        map.put('w', 0);
        map.put('x', 0);
        map.put('y', 0);
        map.put('z', 0);
        String my_string = sc.next();
        for (int i = 0; i < my_string.length(); i++){
            int num = map.get(my_string.charAt(i));
            map.put(my_string.charAt(i), num + 1);

        }
        Iterator<Character> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            Character key = keys.next();
            System.out.print(map.get(key));
            System.out.print(' ');
        }
    }


}


// 정수에 + '문자'를 하면 이상한 숫자가 출력된다. 문자를 숫자로 변환하나보다.

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 입력은 이게 더 빠르다.
//		char arr[] = br.readLine().toCharArray(); 읽은 문자열을 배열로 만들어준다