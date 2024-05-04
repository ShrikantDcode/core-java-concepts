package collections;

import java.util.*;

public class IteratorExample{

    static Iterator func(ArrayList mylist){
        Iterator it=mylist.iterator();
        while(it.hasNext()){
            Object element = it.next();
            if(element instanceof String)//Hints: use instanceof operator
                break;
        }
        return it;

    }
    @SuppressWarnings({ "unchecked" })
    public static void main(String []args){
        ArrayList<Integer> mylist = new ArrayList<>();
        mylist.add(12);
        mylist.add(30);
        mylist.add(2);
        mylist.add(60);
        mylist.add(5);
        // Iterator
        Iterator it= func(mylist);

        while(it.hasNext()){
            Object element = it.next();
            System.out.println((String) element);
        }
        //ListIterator
        ListIterator<Integer> listIterator = mylist.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.nextIndex()+" - "+listIterator.next());
            if(listIterator.nextIndex() == 1)
            listIterator.set(100);
            if(listIterator.previousIndex() == 1)
            listIterator.add(200);
//            if(listIterator.hasPrevious()) {
//                System.out.println("Previous :" + listIterator.previousIndex()+" "+listIterator.previous());
//                break;
//            }
        }

        //Splititerator
        Spliterator<Integer> spliterator = mylist.spliterator();
        spliterator.trySplit().forEachRemaining(System.out::println);
        spliterator.trySplit().forEachRemaining(System.out::println);
        spliterator.trySplit().forEachRemaining(System.out::println);
    }
}