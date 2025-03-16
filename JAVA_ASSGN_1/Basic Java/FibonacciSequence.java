import java.util.Scanner;

public class FibonacciSequence {

    // Method to print Fibonacci sequence up to 'n'
    public static void printFibonacci(int n) {
        int first = 0, second = 1;

        System.out.print("Fibonacci sequence: " + first);

        if (n > 0) {
            System.out.print(", " + second);
        }

        int next;
        while (true) {
            next = first + second;
            if (next > n) break;
            System.out.print(", " + next);
            first = second;
            second = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Please enter a non-negative number.");
        } else {
            printFibonacci(number);
        }

        scanner.close();
    }
}
