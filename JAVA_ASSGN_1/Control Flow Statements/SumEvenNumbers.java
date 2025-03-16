public class SumEvenNumbers {
    public static void main(String[] args) {
        int sum = 0;
        int num = 2; // Start with the first even number

        while (num <= 10) {
            sum += num; // Add the even number to sum
            num += 2;   // Move to the next even number
        }

        System.out.println("The sum of even numbers from 1 to 10 is: " + sum);
    }
}
