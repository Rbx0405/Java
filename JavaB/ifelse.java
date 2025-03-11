import java.util.Scanner;

public class ifelse {
    public static void main(String[] args) {
        // Creating Scanner object
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Using if-else to check even or odd
        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }

        // Closing the scanner
        scanner.close();
    }
}

