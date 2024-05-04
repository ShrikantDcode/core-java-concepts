package designpatterns.singleton.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        Employee employee1 = null;
        try {
            employee1 = new Employee.EmployeeBuilder("Shrikant")
                    .setlName("Dande")
                    .setAge(340)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Employee 1 "+employee1.getfName()+" , "
        +employee1.getlName()+" , "+employee1.getAge());
        //---------------------------------------------------------------------------
        //Object creation using lombok @Builder
        Employee2 employee2 = Employee2.builder()
                .fName("Jim")
                .lName("Rohn")
                .age(52)
                .build();
        System.out.println("Employee 2 "+employee2.getFName()+" , "
                +employee2.getLName()+" , "+employee2.getAge());
    }
}
