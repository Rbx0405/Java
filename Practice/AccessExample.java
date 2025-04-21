// Superclass
class Person {
    // Private member
    private String name;

    // Setter method (to set the value)
    public void setName(String newName) {
        name = newName;
    }

    // Getter method (to get the value)
    public String getName() {
        return name;
    }
}

// Subclass
class Student extends Person {

    void showName() {
        // Cannot access 'name' directly because it's private
        // System.out.println(name); // ❌ Error

        // But we can access it using the public getter
        System.out.println("Student Name: " + getName());
    }
}

// Main class
public class AccessExample {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("Alice");  // using setter
        s1.showName();        // using getter inside subclass
    }
}
