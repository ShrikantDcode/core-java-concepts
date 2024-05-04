package core.ObjectEquality;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

class Employee {
    String name;
    int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Employee emp = (Employee) o;
        return Objects.equals(id, emp.id) && Objects.equals(name, emp.name);
    }
    public int hashCode() {
        return Objects.hash(id);
    }
}
public class EqualsHashCodeDemo {
    public static void main(String[] args) {
        Employee c1 = new Employee("abc", 1);
        Employee c2 = new Employee("abcx", 1);
        HashMap<Employee, String> map = new HashMap<>();
        map.put(c1, "C1");
        map.put(c2, "C2");
        System.out.println(c1.equals(c2)+" | "+(c1.hashCode() == c2.hashCode())+" | "+(c1 == c2));
        System.out.println(map.get(new Employee("abcx", 1)));

    }

}
