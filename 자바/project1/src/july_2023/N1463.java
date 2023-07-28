package july_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;

public class N1463 {
    Queue<Point> my_queue = new LinkedList<>();
    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        my_queue.add(new Point(x, 0));
        while(true){
            Point temporaryPoint = my_queue.poll();
            if(temporaryPoint.x == 1){
                System.out.println(temporaryPoint.y);
                break;
            } else{
                MakeOne(temporaryPoint.x, temporaryPoint.y);
            }
        }
    }
    public void MakeOne(int x, int counter){
        if (x % 3 == 0){
            my_queue.add(new Point(x / 3,counter + 1));
        }
        if (x % 2 == 0) {
            my_queue.add(new Point(x / 2, counter + 1));
        }

        my_queue.add(new Point(x - 1, counter + 1));
    }
}
