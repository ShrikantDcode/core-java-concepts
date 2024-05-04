package sorting;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
    int id;
    int salary;

    public Employee(int id, int salary) {
        this.id = id;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                '}';
    }
}

class CompareBySalary implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSalary() - o2.getSalary();
    }
}
public class SortingExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 8, 1, 5, 0);
        //Collections.sort(numbers);
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        //System.out.println(numbers);
        //numbers.forEach(System.out::print);

        List<Employee> employees = Arrays.asList(new Employee(2, 40000), new Employee(8, 30000),new Employee(1, 15000));
        /* old way 1 of passing comparator class object
        CompareBySalary compareBySalary = new CompareBySalary();
        Collections.sort(employees, compareBySalary); */
        /* old way 2 using Anonymous inner class implementation
        Collections.sort(employees,
                new Comparator<Employee>() {
                    public int compare(Employee o1, Employee o2) {
                        return o1.getSalary() - o2.getSalary();
                    }
        }); */

        /* new way 1 using lambda expression */
        Collections.sort(employees, (o1, o2) -> (int) o1.getSalary() - o2.getSalary());
        /* new way 2 using streams api and lambda expression */
        Stream<Employee> empStream = employees.stream();
        //empStream.sorted((o1, o2) -> o1.getSalary() - o2.getSalary()).forEach(System.out::println);
        empStream.sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

        System.out.println(employees);

    }
}
