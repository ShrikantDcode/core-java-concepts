package concurrency;

class MyThread extends Thread {
    static Thread mainThread;
    public void run() {
        Thread.yield();
        for(int i =0; i< 3; i++) {
            System.out.println("Child Thread " + i);
        }
    }
}

public class YeildJoinExample {
    public static void main(String[] args) throws InterruptedException{
    MyThread.mainThread = Thread.currentThread();
    MyThread t1 = new MyThread();
    t1.start();
        for (int i = 0; i < 3; i++) {
            System.out.println("Main Thread " + i);
            //Thread.sleep(100);
        }
    }
}
