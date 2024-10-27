package core;

interface Doable {
    default void doIt(){
        System.out.println("in doit");
    }
    static  void dontdoIt(){
        System.out.println("in don't doit");
    }
}
abstract class Do {
    void abstractDoIt(){
        System.out.println("in doit");
    }
}

public class InterfaceDefaultDemo extends Do implements Doable {

    public static void main(String[] args) {
        Doable.dontdoIt();
        Doable d = new InterfaceDefaultDemo();
        d.doIt();
        new InterfaceDefaultDemo().abstractDoIt();
    }
}

