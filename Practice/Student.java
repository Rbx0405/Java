// Define a class named Student
public class Student {

    // Fields of the class
    String name;
    int age;

    // Method to set values
    void setDetails(String studentName, int studentAge) {
        name = studentName;
        age = studentAge;
    }

    // Method to display student details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Main method – Entry point of the program
    public static void main(String[] args) {

        // Create first Student object
        Student s1 = new Student();
        s1.setDetails("Alice", 20);
        s1.displayDetails();

        System.out.println(); // just for spacing

        // Create second Student object
        Student s2 = new Student();
        s2.setDetails("Bob", 22);
        s2.displayDetails();
    }
}
