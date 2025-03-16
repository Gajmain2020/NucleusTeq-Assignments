import java.util.Scanner;

public class ArrayAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking array size input from user
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];
        int sum = 0;

        // Taking array elements input from user
        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
            sum += numbers[i]; // Adding elements to sum
        }

        // Calculating average
        double average = (double) sum / size;

        // Printing the result
        System.out.println("The average is: " + average);

        scanner.close();
    }
}
