package streams;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


class Office {
  int deptId;

 String deptName;

 public int getDeptId() {

 return deptId;

 }

 public void setDeptId(int deptId) {

 this.deptId = deptId;

 }

 public String getDeptName() {

 return deptName;

 }

 public void setDeptName(String deptName) {

 this.deptName = deptName;

 }

 public Office(int deptId, String deptName) {

 super();

 this.deptId = deptId;

 this.deptName = deptName;

 }

 @Override

 public String toString() {

 return "Office [deptId=" + deptId + ", deptName=" + deptName + "]";

 }

 public Office() {

 super();

 }

}

public class ListToMap {


 public static void main(String[] args)

 {

 List<Office> listOfOffice=new ArrayList<>(
 Arrays.asList(new Office(101,"Sales"), new Office(301,"IT"),
     new Office(201,"IT"),
     new Office(401,"Sales"),
     new Office(501,"ETS")

 ));

 Map res= listOfOffice.stream().collect(Collectors.groupingBy(Office::getDeptName, Collectors.counting()));
                      //.toMap(Office::getDeptName, Office::getDeptId));

  System.out.println(res); //{Sales=2, ETS=1, IT=2}
  //show top 3 deprname in desc order
  listOfOffice.stream()
          .map(o -> o.deptName)
          .distinct()
          .sorted(Comparator.reverseOrder())
          .limit(3)
          .forEach(System.out::println);

  listOfOffice.stream()
          .sorted(Comparator.comparing(Office::getDeptName)
                  .thenComparing(Office::getDeptId))
          .limit(3)
          .forEach(System.out::println);
 }

}


