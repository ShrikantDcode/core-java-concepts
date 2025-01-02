package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsMethods {
    public static void main(String[] args) {
        List<String> days = new ArrayList<>(10);
        days.add("monday");
        days.add("sunday");
        days.add("monday");
        days.add("Wedensday");
        
        clientsCode(days); // client code can modify list
        List<String> unmodifiableList = Collections.unmodifiableList(days);
        clientsCode(unmodifiableList); // client code can't modify list ...throws java.lang.UnsupportedOperationException

    }
    static void clientsCode(List<String> list){
        list.add("xx");
        System.out.println(list);
    }
}
