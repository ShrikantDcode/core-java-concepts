package concurrency.producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutorDemo {
    public static void main(String[] args) {
        List<Integer> buffer = new ArrayList<>(10);
        Producer p1 = new Producer(buffer, 10);
        Consumer c1 = new Consumer(buffer);

        //method 1: create Threads by ourselves
//        Thread t1 = new Thread(p1);
//        t1.start();
//        Thread t2 = new Thread(c1);
//        t2.start();
//        Thread t3 = new Thread(c1);
//        t3.start();

        //method 2 : using executor service
        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(p1);
//        executorService.submit(c1);
//        executorService.submit(c1);
        executorService.execute(p1);
        executorService.execute(c1);
        executorService.execute(c1);



    }
}
