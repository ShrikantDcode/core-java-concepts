package problemsolving.array;
class Employee {
    int id;
}

public class ArrayInitialization {
    public static void main(String[] args) {
        boolean[] flags = new boolean[4];
        for (boolean b: flags){
            System.out.println(b);
        }
        System.out.println("===========================");
        Boolean flagsWrapper[] = new Boolean[4];
        //for (boolean b: flagsWrapper){
            System.out.println(flagsWrapper[0]);
        //}
        System.out.println("===========================");
        Employee[] emps = {new Employee(),  new Employee()};
        for (Employee e: emps){
            System.out.println(e.id);
        }

    }
}
