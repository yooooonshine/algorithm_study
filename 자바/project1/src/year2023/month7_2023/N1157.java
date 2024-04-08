package year2023.month7_2023;

import java.util.Scanner;
import java.util.*;

public class N1157 {
    public void func(){
        Scanner sc = new Scanner(System.in);
        String my_string = sc.next();
        my_string = my_string.toUpperCase(); // 대문자로 변환하여 대소문자 구분 안한다.
        Map<Character, Integer> dict = new HashMap<>(); //이건 딕셔너리 형성 <키의 타입, 값의 타입>
        // 자바는 문자열 for문이 불가능하다. 문자열으 stringPool에 저장되기에, 따라서 문자열을 문자열 길이만큼 반복
        for (int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            if (dict.containsKey(c)){
                int temporary_int = dict.get(c);
                temporary_int++;
                dict.put(c, temporary_int);
            }
            else{
                dict.put(c, 1);
            }
        }
        int max_number = 0;
        int same_counter = 0;
        char max_char = ' ';
        Iterator<Character> keys = dict.keySet().iterator();
        while (keys.hasNext()){
            Character key = keys.next();
            if(max_number < dict.get(key)){
                max_number = dict.get(key);
                same_counter = 0;
                max_char = key;
            } else if (max_number == dict.get(key)) {
                same_counter = 1;
            }

        }
        if (same_counter == 1){
            System.out.println('?');
        }
        else{
            System.out.println(max_char);
        }
    }
}

//파일을 생성하면 기본으로 생성되는 파일명 클래스안에 메인함수 메소드가 존재
//이 메인함수가 static인 이유는 클래스안에서 객체생성없이 호출해야하기에
//스레드란 프로세스안에서 실질적으로 작업을 수행하는 단위