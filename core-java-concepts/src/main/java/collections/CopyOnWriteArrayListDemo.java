package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(3);
        list.add(1, 5);
        ListIterator litr =  list.listIterator();
        litr.forEachRemaining(System.out::println);

        System.out.println(list.toString());
    }
}
