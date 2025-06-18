public class PatternMatchingDemo {
    public static void main(String[] args) {
        //write a program to validate a string using regex
        //String input = "abc123";
        //String regex = "^[a-zA-Z]+\\d+$"; // Matches strings that start with letters and end with digits
        String input = "123&abc?def-ghi'jkl.mno,pqr%stu/vwx@y&z ("; // Example input
        String regex = "^[a-zA-Z0-9\\?\\-\\\u2019\\u0027\\.\\,\\%\\/\\@\\&\\(\\)\\s]{1,40}$";
        if (input.matches(regex)) {
            System.out.println("The input string is valid.");
        } else {
            System.out.println("The input string is invalid.");
        }
    }
}
