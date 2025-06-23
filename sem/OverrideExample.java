// Superclass
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

// Main class
public class OverrideExample {
    public static void main(String[] args) {
        Animal a = new Animal(); // superclass reference to superclass object
        a.sound();               // Animal makes a sound

        Dog d = new Dog();       // subclass reference to subclass object
        d.sound();               // Dog barks

        Animal ref = new Dog();  // superclass reference to subclass object (polymorphism)
        ref.sound();             // Dog barks (overridden method is called)
    }
}