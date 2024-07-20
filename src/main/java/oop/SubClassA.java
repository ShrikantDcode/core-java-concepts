package oop;

class Super<J extends Number>  {

    protected  Object  m1 (String a) {
        System.out.println("Supper::m1 "+a);
        return null;
    }

    public J m2 ()  {
        System.out.println("Supper::m2 ");
        return null;
    }
}

public class SubClassA<K extends Integer> extends Super {
    public String m1 (String a){
        System.out.println("OverridingExample::m1 "+a);
        return null;
    }

    public K m2 () {
        System.out.println("OverridingExample::m2 ");
        //if(a == "sub")
        return null;
    }
    public static void main(String[] args)  {

        Super sub = new SubClassA();
        sub.m1("sub");
        sub.m2();
//        Super supper2 = new Super();
//        supper2.m1("super");
//
//        sub.m2(2);
//        supper2.m2(3);
    }
}
