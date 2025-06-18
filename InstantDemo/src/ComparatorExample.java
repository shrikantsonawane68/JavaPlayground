import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import java.util.*;

class Students {
    int rollNo;
    String name;

    Students(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public String toString() {
        return rollNo + " - " + name;
    }
}

// Comparator for sorting by name
class NameComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name); // Ascending by name
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(102, "Alice"));
        list.add(new Student(101, "Bob"));
        list.add(new Student(103, "Charlie"));

        Collections.sort(list, new NameComparator()); // Uses Comparator
        System.out.println(list);
    }
}
