// Parent Class: Student
class Student {
    protected String name;
    protected int rollNumber;

    // Constructor
    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    // Method to display student information (to be overridden)
    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
    }

    // Method Overloading (Compile-time Polymorphism)
    public void displayInfo(String course) {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Course: " + course);
    }
}

// Child Class: GraduateStudent (Overriding the method)
class GraduateStudent extends Student {
    private String researchTopic;

    // Constructor
    public GraduateStudent(String name, int rollNumber, String researchTopic) {
        super(name, rollNumber);
        this.researchTopic = researchTopic;
    }

    // Method Overriding (Runtime Polymorphism)
    @Override
    public void displayInfo() {
        super.displayInfo(); // Calling parent method
        System.out.println("Research Topic: " + researchTopic);
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        // Parent class object
        Student student = new Student("Alice", 101);
        System.out.println("Student Info:");
        student.displayInfo(); // Calls parent class method

        System.out.println("\nStudent Info with Course:");
        student.displayInfo("Computer Science"); // Method Overloading

        // Child class object
        GraduateStudent gradStudent = new GraduateStudent("Bob", 102, "AI in Healthcare");
        System.out.println("\nGraduate Student Info:");
        gradStudent.displayInfo(); // Calls overridden method in child class
    }
}
