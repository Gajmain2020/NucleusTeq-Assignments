import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Example 1: Division by zero (ArithmeticException)
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();
            
            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            int result = numerator / denominator; // May throw ArithmeticException
            System.out.println("Result: " + result);

            // Example 2: Array index out of bounds (ArrayIndexOutOfBoundsException)
            int[] numbers = {10, 20, 30, 40};
            System.out.print("Enter array index (0-3): ");
            int index = scanner.nextInt();
            System.out.println("Array value: " + numbers[index]); // May throw ArrayIndexOutOfBoundsException

            // Example 3: Invalid number format (NumberFormatException)
            scanner.nextLine(); // Consume leftover newline
            System.out.print("Enter a number as a string: ");
            String numberStr = scanner.nextLine();
            int parsedNumber = Integer.parseInt(numberStr); // May throw NumberFormatException
            System.out.println("Parsed number: " + parsedNumber);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds. Enter a valid index.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Enter a valid integer.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("Execution completed. Closing scanner.");
            scanner.close();
        }
    }
}
