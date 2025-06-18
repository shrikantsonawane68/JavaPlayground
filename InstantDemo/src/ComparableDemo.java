import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableDemo {

    //write a program usung comparable interface
    // to sort the list of objects

    // by using the name of the object
    // by using the age of the object

}

class Student implements Comparable<Student> {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    // Implement compareTo method
    public int compareTo(Student s) {
        return this.rollNo - s.rollNo; // Ascending order
    }

    public String toString() {
        return rollNo + " - " + name;
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(102, "Alice"));
        list.add(new Student(101, "Bob"));
        list.add(new Student(103, "Charlie"));

//        Collections.sort(list, Comparator.comparing(
//                //compare based on name
//                student -> student.name // Uses compareTo
//        )); // Uses compareTo
        Collections.sort(list); // Uses compareTo
        System.out.println(list);
    }
}
