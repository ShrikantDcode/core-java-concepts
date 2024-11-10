package queues;


import java.util.*;

class Student {
    int id;
    String name;
    double cgpa;
    public Student(String name, double cgpa,int id){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    int getID() { return this.id;}
    String getName() { return this.name;}
    double getCGPA() { return this.cgpa;}
    public String toString() { return "["+this.getName()+" "+this.getCGPA()+"]";}
}

class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (s2.getCGPA() != s1.getCGPA()) {
            return Double.compare(s2.getCGPA(), s1.getCGPA());
        } else if (!(s1.getName().equals(s2.getName()))) {
            return s1.getName().compareTo(s2.getName());
        } else {
            return s1.getID() - s2.getID();
        }
    }
}

public class StudentServePQueue{
    private final static Scanner scan = new Scanner(System.in);
    final static StudentServePQueue studentServePQueue = new StudentServePQueue();
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = studentServePQueue.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }

     List<Student> getStudents (List < String > events) {
            Comparator<Student> studentComparator =
                Comparator.comparing(Student::getCGPA)
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getID);
            PriorityQueue<Student> pq = new PriorityQueue<>(studentComparator);

            for (String line : events) {
                String[] starr = line.split(" ");
                if ("ENTER".equals(starr[0])) {
                    pq.add(new Student(starr[1], Double.valueOf(starr[2]), Integer.parseInt(starr[3])));
                } else if ("SERVED".equals(starr[0])) {
                    pq.poll();
                }

            }

            List<Student> list = new ArrayList<>();
            while (!pq.isEmpty()) {
                list.add(pq.poll());
            }
            return list;
        }
    }

