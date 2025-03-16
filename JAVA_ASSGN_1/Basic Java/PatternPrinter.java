import java.util.Scanner;

public class PatternPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the pattern to print:");
        System.out.println("1. Square");
        System.out.println("2. Triangle");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        System.out.print("Enter the size (number of rows): ");
        int size = scanner.nextInt();

        switch (choice) {
            case 1:
                printSquare(size);
                break;
            case 2:
                printTriangle(size);
                break;
            default:
                System.out.println("Invalid choice! Please enter 1 or 2.");
        }

        scanner.close();
    }

    // Method to print a square pattern
    public static void printSquare(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Method to print a right-angled triangle pattern
    public static void printTriangle(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
