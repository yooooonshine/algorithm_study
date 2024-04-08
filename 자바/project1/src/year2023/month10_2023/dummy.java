package year2023.month10_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class dummy {
    public void func() {
        //스트림 생성
        ArrayList<Integer> myList = new ArrayList<Integer>(Arrays.asList(1,2,3));
        Stream<Integer> myStream = myList.stream();

        //배열 스트림
        String[] stringList = new String[]{"a","b","c"};
        Stream<String> myStream1 = Arrays.stream(stringList, 1, 3);

        //스트림 빌더
        Stream<Integer> myStream2 = Stream.<Integer>builder()
                                            .add(1)
                                            .add(2)
                                            .add(3)
                                            .build();
    }
}
