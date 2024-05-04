package core;

public class LenzeTest {
    public static void main(String[] args) {
        //1.
        Integer i1 = 128;
        Integer i2 = 128;

        System.out.println(i1 == i2);
        Integer i3 = 127;
        Integer i4 = 127;
        System.out.println(i3 == i4);
        //2.
        System.out.print("T"+"E");
        System.out.print('s'+'t');
        //3.
        MyTest t = null;
        t.print(); // static member MyTest.print accessed via instance reference

        //4.
        Thread t1 = new Thread(() -> System.out.println("thread running"));
        t1.start();
        System.out.println("after start");
        t1.notify(); // IllegalMonitorStateException

    }
}

class MyTest {
    public static void print() {
        System.out.println("hello");
    }
}