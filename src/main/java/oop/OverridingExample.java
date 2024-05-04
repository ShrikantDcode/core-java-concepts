package oop;

import model.Animal;
import model.Dog;
import model.Food;

import java.util.ArrayList;
import java.util.List;

class Supper {

    protected  Object  m1 (Object a) {
        System.out.println("Supper::m1 "+a);
        return null;
    }

    public <J extends Number> J m2 (J a)  {
        System.out.println("Supper::m2 "+a);
        return null;
    }
}

public class OverridingExample extends Supper {
    public String m1 (String a){
        System.out.println("OverridingExample::m1 "+a);
        return null;
    }

    public <K extends Integer> K m2 (String a) {
        System.out.println("OverridingExample::m2 "+a);
        //if(a == "sub")
        return null;
    }
    public static void main(String[] args)  {

        OverridingExample supper1 = new OverridingExample();
        supper1.m1("sub");
        Supper supper2 = new Supper();
        supper2.m1("super");

        supper1.m2(2);
        supper2.m2(3);
    }
}
