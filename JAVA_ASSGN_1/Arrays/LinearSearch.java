import java.util.Scanner;

public class LinearSearch {
    // Function to perform Linear Search
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // Return index if element is found
            }
        }
        return -1; // Return -1 if element is not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Taking the element to search
        System.out.print("Enter the number to search: ");
        int key = scanner.nextInt();

        // Performing Linear Search
        int result = linearSearch(arr, key);

        // Displaying the result
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }

        scanner.close();
    }
}
