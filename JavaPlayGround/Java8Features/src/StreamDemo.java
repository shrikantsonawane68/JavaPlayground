import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
    //can you find duplicate characters in a string using Java Streams
        //Using Java Stream to find duplicate characters in an array of strings
        //Use flatMap to convert the array of strings into a stream of characters
        //
        //Use Collectors.groupingBy to group the characters by count
        //
        //Filter the grouped characters to find duplicates
        //Use forEach to print the duplicate characters

        String str = "Hello World";
        str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> str.indexOf(c) != str.lastIndexOf(c))
                .distinct()
                .forEach(System.out::println);

        //can you find duplicate characters in a string using Java Streams
        String str2 = "Hello World";
        str2.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> str2.indexOf(c) != str2.lastIndexOf(c))
                .distinct()
                .forEach(System.out::println);

        //Program using Java 8 features to filter a list of strings starting with 'A' and convert them to uppercase.
        //Use Java 8 stream API to filter the strings starting with 'A'.
        //
        //Use map() function to convert the filtered strings to uppercase.
        //
        //Collect the results into a new list using collect() function.
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank");
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .toList();
        System.out.println("Filtered names: " + filteredNames);

        //can you find duplicate characters in a string using Java Streams
        //Using Java Stream to find duplicate characters in an array of strings
        //Use flatMap to convert the array of strings into a stream of characters
        //
        //Use Collectors.groupingBy to group the characters by count
        //
        //Filter the grouped characters to find duplicates
        //Use forEach to print the duplicate characters
        String str3 = "Hello World";
        str3.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> str3.indexOf(c) != str3.lastIndexOf(c))
                .distinct()
                .forEach(System.out::println);

        //create list and set of strings and print

        List<String> list = Arrays.asList("apple", "banana", "orange", "kiwi","banana");
        System.out.println("List of strings: " + list);
        //create a set of strings
        Set<String> set = new HashSet<>(list);
        Set<String> set1 = new HashSet<>(List.of("Ajay","shrikant","Dipali","shrikant"));
        System.out.println("Set of strings: " + set);
        System.out.println("Set of strings: " + set1);

        List upperCaseList = list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println("Uppercase List : "+ upperCaseList);

        Consumer<String> printer = System.out::println;
        List<String> items = List.of("A", "B", "C");

        items.forEach(s->printer.accept(s));  // Prints A B C
        items.forEach(printer);  // Prints A B C

        int i=10;
        String s="shrikant";
        //System.out.println(i.hashCode());
        System.out.println(s.hashCode());

        String s1 = "FB";
        //String s2 = "Ea";
        String s2 = "FB";
        System.out.println(s1.hashCode()); // Output: 2236
        System.out.println(s2.hashCode()); // Output: 2236
        System.out.println(s1.equals(s2)); // Output: false
        System.out.println(s1==s2); // Output: false
        //how to check if the hashcode are same or equal for these 2 strings
        Object o1 = s1;
        Object o2 = s2;
        System.out.println(o1.equals(o2));
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(o1.toString());
        System.out.println(o2.toString());
        System.out.println(s2.toString());

        String s3 = new String("FB");
        System.out.println(s3.toString());

        List<String> stringList= Arrays.asList("apple", "banana", "orange", "kiwi");
        List<String> adallEmptyList = Arrays.asList();
        stringList.addAll(adallEmptyList);
        System.out.println(stringList);

        //jagged array example
        int[][] jaggedArray = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };





    }
}
