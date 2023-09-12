package september_2023;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        N2178 my_class = new N2178();
        my_class.func();
    }
}




// 백준은 페키지 지우고, 모두 main으로 변경해야한다.
//
//    // 엔터로 구분해서 입력 받음
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    // 백준 문제는 입력을 띄어쓰기로 구분하는 경우가 있기 때문에 StringTokenizer 사용
//    StringTokenizer st = new StringTokenizer(br.readLine());


//세팅
//public class Main {
//        public static void main(String[] args){



//동적 배열
//ArrayList<String> my_string_list = new ArrayList<>(); // 동적 배열

//for(char x : str.toCharArray()) { 배열 for문 사용!


//버퍼 리더

//공백 포함하지 않는 int
//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//String s = br.readLine();
//int n = Integer.parseInt(s);

//공백 포함int
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine()); // br.readLine을 통해 읽은 뭍자열을 쪼개주는 객체
//    int a = Integer.parseInt(st.nextToken());
//    int b = Integer.parseInt(st.nextToken());


//버퍼 라이터
//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//bw.write('g');
//bw.newLine(); // 줄바꿈
//bw.flush(); // 남아있는 데이터 모두 출력
//bw.close();


//배열 binarySearch, copyOf, copyOfRange, equals, fill, sort 등을 잘 활용하자.
