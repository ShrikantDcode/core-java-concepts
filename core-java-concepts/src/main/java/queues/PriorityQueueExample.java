package queues;

import java.util.*;

public class PriorityQueueExample {

//    public static void m1(){
////        PriorityQueueExample p = new PriorityQueueExample();
////        p.instanceM2();
//        System.out.println("static m1");
//    }
//
//    public void instanceM2(){
//        PriorityQueueExample.m1();
//        System.out.println("instance m2");
//    }

    public static void main(String[] args) {
        Queue<String> msgs = new LinkedList<>();
            msgs.add("C");
            msgs.add("A");
            msgs.add("B");
        System.out.println("Strings FIFO Queue\n");

        while (!msgs.isEmpty()) {
            System.out.print(" "+msgs.poll());
        }


        Queue<String> msgs2 = new PriorityQueue<>(3);
            msgs2.add("C");
            msgs2.add("A");
            msgs2.add("B");
        msgs2.offer("D");
        System.out.println("\nStrings Stored in Natural Ordering in a Priority Queue\n");

        while (!msgs2.isEmpty()) {
            System.out.print(" "+msgs2.poll());
        }

        Deque<String> msgs3 = new ArrayDeque<>();
        msgs3.add("C");
        msgs3.add("A");
        msgs3.add("B");
        System.out.println("\nmessages in DQueue\n");
        System.out.print(" "+msgs3.pollFirst());
        while (!msgs3.isEmpty()) {
            System.out.print(" "+msgs3.poll());
        }


    }
}
