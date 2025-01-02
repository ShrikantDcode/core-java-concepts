package collections;

import java.util.*;

public class ListIteratorExample {

    public static void main(String[] args) {
        //To avoid ConcurrentModification exception while updating list
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        //Arrays.asList is used to create fix-sized list

        ListIterator<String> iterator = list.listIterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.equals("B")) {
                iterator.set("Updated-B"); // Modify the current element
            } else if (element.equals("C")) {
                iterator.add("New-C"); // Add a new element after C
            }
        }

//        When to Use ListIterator
//        When bi-directional traversal is needed.
//                When you want to modify a list during iteration (add, update, or delete elements).
//        When you need the index of elements during traversal.
//                For implementing advanced data manipulation or state management.
//                In contrast, a regular Iterator is sufficient for simpler, read-only, forward-only traversals.
//
                System.out.println(list); // [A, Updated-B, C, New-C, D]

        //Reverse traversal example
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous()+", ");
        }

        // this demonstrates ConcurrentModification exception
        list.forEach(e -> {
            if(e.equals("A")) {
                list.remove("A"); // or list.add("abcd");
            }
        });
    }
}