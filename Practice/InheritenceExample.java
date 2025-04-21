// Parent class (superclass)
class Vehicle {

    // Method of parent class
    void start() {
        System.out.println("Vehicle is starting...");
    }

    void stop() {
        System.out.println("Vehicle is stopping...");
    }
}

// Child class (subclass) that inherits from Vehicle
class Car extends Vehicle {

    // Child class has its own method too
    void honk() {
        System.out.println("Car is honking: Beep beep!");
    }
}

// Main class
public class InheritanceExample {
    public static void main(String[] args) {
        // Create an object of the child class
        Car myCar = new Car();

        // Call inherited methods
        myCar.start();  // from Vehicle
        myCar.honk();   // from Car
        myCar.stop();   // from Vehicle
    }
}
