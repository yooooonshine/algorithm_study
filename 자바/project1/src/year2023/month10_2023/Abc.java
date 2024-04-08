package year2023.month10_2023;

public class Abc {
    public enum Week {
        MON(1),
        TUES(2);
        int myInt;

        Week(int myInt) {
            this.myInt = myInt;
        }
    }

    public void func() {
        Week today = Week.MON;
        System.out.println(today == Week.MON);
        System.out.println(today);

        String a = "AW";
        a = "wqd";
        String b ="wqd";
        System.out.println(a == b);
    }
}
