package oop;
class A {
    A() {
        print();
    }
    void print() {
        System.out.println("A::print");
    }
    void m1(){
        System.out.println("A::m1");
    }
}

class B extends A {
    int i;
    B() {
        super.print();
        this.i = 4;

    }
    @Override
    void print() {
        System.out.println("B::printB "+i);
    }
    void m1(){
        System.out.println("B::m1");
    }
}
public class DynamicBindingExample {
    public static void main(String[] args) {
        A a = new B();
        a.print();

        A a2 = new A();
        invokeHelper(a);
}
    static void invokeHelper(A reference){
        if(reference instanceof B) {
            B b3 = (B) reference;
            b3.m1();
        } else {
            System.out.println("Invalid reference");
        }
    }
}
//B
//B
//A
//B