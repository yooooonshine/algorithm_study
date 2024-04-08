package year2023.month7_2023;

import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class N11656 {
    public void func(){
        Scanner sc = new Scanner(System.in);
        String my_string = sc.next();
        ArrayList<String> my_string_list = new ArrayList<>(); // 동적 배열
        char arr[] = my_string.toCharArray();
        for(int i = 0; i < arr.length; i++){
            String temporary_string = "";
            for(int j = i; j < arr.length; j++){
                temporary_string += arr[j];
            }
            my_string_list.add(temporary_string);
        }
        // 정렬을 위해 ArrayList에서 배열로
        String[] arr2 = new String[my_string_list.size()];
        my_string_list.toArray(arr2);
        Arrays.sort(arr2);
        for(int i = 0; i < arr2.length; i++){
            System.out.println(arr2[i]);
        }

    }
}


// ArrayList<Integer> list = new ArrayList<>(); // 동적 배열