package designpatterns.singleton.builder;


public class Employee {
    private String fName;
    private String lName;
    private int age;

    public Employee(EmployeeBuilder builder) {
        this.fName = builder.fName;
        this.lName = builder.lName;
        this.age = builder.age;
    }

    // All getter, No setter
    public String getfName() {
        return fName;
    }

    public int getAge() {
        return age;
    }

    public String getlName() {
        return lName;
    }



    public static class EmployeeBuilder {
        private String fName;
        private String lName;
        private int age;

        //constructor for mandatory fields
        public EmployeeBuilder(String fName) {
            this.fName = fName;
        }

        public EmployeeBuilder() {}


        //setters for optional fields
        public EmployeeBuilder setlName(String lName) {
            this.lName = lName;
            return this;
        }

        public EmployeeBuilder setAge(int age) throws Exception {
            if(age > 100)
                throw new Exception("Invalid age");
            this.age = age;
            return this;
        }

        //to create Employee object
        public Employee build() {
            return new Employee(this);
        }

    }
}
