package ObjectClass;

import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Objects;

class Employee {

    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        //return true;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class ObjectKeyExample {
    public static void main(String[] args) {
        //linkedHashMap maintains insertion order
        LinkedHashMap<Employee, Integer> companyReg = new LinkedHashMap<>();
        LocalTime start = LocalTime.now();
        System.out.println(start.getSecond()+ " : "+start.getNano());
        for(int i=1 ; i<= 20000; i++){
            companyReg.put(new Employee("Shri", i), i*2);
        }
        System.out.println(LocalTime.now().getSecond()+ " : "+LocalTime.now().getNano());
        System.out.println("nano : "+(LocalTime.now().getNano() - start.getNano()));
//        companyReg.put(new Employee("Shri", 34), 400000);
//        companyReg.put(new Employee("Shri", 35), 150000);
        //companyReg.put(new Employee("Jhon", 31), 300000);
        LocalTime start2 = LocalTime.now();
        System.out.println(start2.getSecond()+ " :: "+start2.getNano());
        System.out.println(companyReg.get(new Employee("Shri", 14000)));
//        companyReg.forEach((k, v) -> {
//            System.out.println(new StringBuilder().append(k.getName()).append(" : ").append(k.getAge())
//                    .append(" = ").append(v).toString());
//        });
        System.out.println(LocalTime.now().getSecond()+ " :: "+start2.getNano());
        System.out.println(companyReg.size());


    }
}
