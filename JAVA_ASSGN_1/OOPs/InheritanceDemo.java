import java.util.Scanner;

// Base class: Student
class Student {
    // Attributes
    protected String name;
    protected int rollNumber;
    protected double marks;

    // Constructor
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

// Derived class: GraduateStudent (inherits from Student)
class GraduateStudent extends Student {
    private String researchTopic;
    private String advisorName;

    // Constructor (calling parent class constructor using super)
    public GraduateStudent(String name, int rollNumber, double marks, String researchTopic, String advisorName) {
        super(name, rollNumber, marks);  // Calling parent class constructor
        this.researchTopic = researchTopic;
        this.advisorName = advisorName;
    }

    // Method to display Graduate Student details
    public void displayGraduateStudentInfo() {
        super.displayStudentInfo();  // Call parent class method
        System.out.println("Research Topic: " + researchTopic);
        System.out.println("Advisor Name: " + advisorName);
    }
}

// Main class to test the program
public class InheritanceDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for Graduate Student
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter research topic: ");
        String researchTopic = scanner.nextLine();

        System.out.print("Enter advisor name: ");
        String advisorName = scanner.nextLine();

        // Creating a GraduateStudent object
        GraduateStudent gradStudent = new GraduateStudent(name, rollNumber, marks, researchTopic, advisorName);

        // Displaying Graduate Student details
        System.out.println("\nGraduate Student Details:");
        gradStudent.displayGraduateStudentInfo();

        scanner.close();
    }
}
