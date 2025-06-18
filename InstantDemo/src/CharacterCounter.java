import java.util.Scanner;

public class CharacterCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Get character to count
        System.out.print("Enter a character to count: ");
        char ch = scanner.next().charAt(0);
        // Count occurrences
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }

        // Display result
        System.out.println("Character '" + ch + "' appears " + count + " times.");

        scanner.close();
    }
}
