package concurrency.thread_safe_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafeDemo {
    public static void main(String[] args) {
        int TASK_QUEUE_MAX_CAPACITY = 10;
        //List<Integer> sharedList = new ArrayList<Integer>(); //will give concurrentmodification exception
        List<Integer> sharedList = new CopyOnWriteArrayList<>(); //thread-safe collection
        Thread producer = new Thread(() -> {
            for (int i = 0; i < TASK_QUEUE_MAX_CAPACITY; i++) {
                sharedList.add(i);
                System.out.println("producer "+i);
            }
        });
        Thread consumer = new Thread(() -> {
            for (Integer num : sharedList) {
                System.out.println("consumer "+num);
                sharedList.remove(num);
            }
        });
        producer.start();
        consumer.start();
        //ExecutorService executorService = Executors.newFixedThreadPool(2);
        //executorService.execute(producer);
        //executorService.execute(consumer);
    }
}
