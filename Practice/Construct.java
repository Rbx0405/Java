public class Construct {

    // Instance variables
    String name;
    int age;

    // Constructor - same name as class, no return type
    Construct(String personName, int personAge) {
        name = personName;
        age = personAge;
    }

    // Method to display person info
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Main method
    public static void main(String[] args) {
        // Creating objects using constructor
        Construct  p1 = new Construct("Alice", 25);
        Construct  p2 = new Construct("Bob", 30);

        // Displaying their info
        p1.displayInfo();
        System.out.println(); // spacing
        p2.displayInfo();
    }
}
