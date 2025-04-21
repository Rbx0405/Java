// Abstract class
abstract class Animal {

    // Abstract method (no body)
    abstract void makeSound();

    // Regular method
    void sleep() {
        System.out.println("Sleeping...");
    }
}

// Subclass that extends Animal and implements makeSound
class Dog extends Animal {

    @Override
    void makeSound() {
        System.out.println("Dog says: Woof!");
    }
}

// Another subclass
class Cat extends Animal {

    @Override
    void makeSound() {
        System.out.println("Cat says: Meow!");
    }
}

// Main class
public class AbstractExample {
    public static void main(String[] args) {
        Animal a1 = new Dog();  // upcasting
        a1.makeSound();         // Dog's implementation
        a1.sleep();

        System.out.println();

        Animal a2 = new Cat();
        a2.makeSound();         // Cat's implementation
        a2.sleep();
    }
}
