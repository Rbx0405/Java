public class VariableExample {

    // Instance variable (belongs to an object)
    String name = "Java";

    // Static variable (belongs to the class, shared among all objects)
    static int count = 0;

    public void showDetails() {
        // Local variable (declared inside a method)
        int year = 2025;

        System.out.println("Name: " + name);
        System.out.println("Year: " + year);
        System.out.println("Count: " + count);
    }

    public static void main(String[] args) {
        // Creating objects
        VariableExample obj1 = new VariableExample();
        VariableExample obj2 = new VariableExample();

        // Accessing instance and static variables
        obj1.name = "Java Basics";
        count++;  // static variable incremented
        obj1.showDetails();

        System.out.println(); // for spacing

        obj2.name = "Advanced Java";
        count++;  // static variable incremented again
        obj2.showDetails();
    }
}
