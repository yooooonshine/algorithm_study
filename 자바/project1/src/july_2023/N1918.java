package july_2023;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack; //import

public class N1918 {
    public void func() {
        Stack<Character> stack = new Stack<>(); //char형 스택 선언
        HashMap<Character, Integer> mapBeforePush = new HashMap<>();
        mapBeforePush.put('(', 0);
        mapBeforePush.put(')', 3);
        mapBeforePush.put('+', 2);
        mapBeforePush.put('-', 2);
        mapBeforePush.put('*', 1);
        mapBeforePush.put('/', 1);

        HashMap<Character, Integer> mapAfterPush = new HashMap<>();
        mapAfterPush.put('(', 3);
        mapAfterPush.put(')', 3);
        mapAfterPush.put('+', 2);
        mapAfterPush.put('-', 2);
        mapAfterPush.put('*', 1);
        mapAfterPush.put('/', 1);
        Scanner sc = new Scanner(System.in);
        String my_string = sc.next();

        for (int i = 0; i < my_string.length(); i++) {
//            System.out.print(stack);
            if (my_string.charAt(i) == '(') {
                stack.push('(');
            } else if (my_string.charAt(i) == ')') {
                while(stack.peek() != '('){
                    System.out.print(stack.pop());
                }
                stack.pop();

            } else if (my_string.charAt(i) == '+' || my_string.charAt(i) == '-' || my_string.charAt(i) == '*' || my_string.charAt(i) == '/') {
                if (stack.empty()){
                    stack.push(my_string.charAt(i));
                }
                else if (mapAfterPush.get(stack.peek()) <= mapBeforePush.get(my_string.charAt(i))){ //넣는게 클때까지
                    while(mapAfterPush.get(stack.peek()) <= mapBeforePush.get(my_string.charAt(i))){
                        System.out.print(stack.pop());
                        if (stack.empty()){
                            break;
                        }
                    }
                    stack.push(my_string.charAt(i));
                }else{
                    stack.push(my_string.charAt(i));
                }

            }else {
                System.out.print(my_string.charAt(i)); //위에 해당안된다면 출력.
            }

        }
        while (!stack.empty()){
            System.out.print(stack.pop());
        }
    }
}
