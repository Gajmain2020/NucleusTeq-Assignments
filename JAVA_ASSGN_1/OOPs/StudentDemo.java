import java.util.Scanner;

class Student {
    // Attributes of the student
    private String name;
    private int rollNumber;
    private double marks;

    // Constructor to initialize the student object
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to display student details
    public void displayStudentInfo() {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking student details input from the user
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter marks: ");
        double marks = scanner.nextDouble();

        // Creating a Student object
        Student student = new Student(name, rollNumber, marks);

        // Displaying student information
        student.displayStudentInfo();

        scanner.close();
    }
}
