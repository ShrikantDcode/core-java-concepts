package designpatterns.singleton.builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee2 {
    private String fName;
    private String lName;
    private int age;
}
