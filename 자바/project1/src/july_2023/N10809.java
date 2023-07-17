package july_2023;

import java.util.HashMap;
import java.util.Scanner;
import java.util.*;
public class N10809 {
    public void func(){
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', -1);
        map.put('b', -1);
        map.put('c', -1);
        map.put('d', -1);
        map.put('e', -1);
        map.put('f', -1);
        map.put('g', -1);
        map.put('h', -1);
        map.put('i', -1);
        map.put('j', -1);
        map.put('k', -1);
        map.put('l', -1);
        map.put('m', -1);
        map.put('n', -1);
        map.put('o', -1);
        map.put('p', -1);
        map.put('q', -1);
        map.put('r', -1);
        map.put('s', -1);
        map.put('t', -1);
        map.put('u', -1);
        map.put('v', -1);
        map.put('w', -1);
        map.put('x', -1);
        map.put('y', -1);
        map.put('z', -1);
        String my_string = sc.next();
        for (int i = 0; i < my_string.length(); i++){
            if (map.get(my_string.charAt(i)) == -1){
                map.put(my_string.charAt(i), i);
            }
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