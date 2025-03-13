class Car {
    String model;

    Car(String carModel) { // Parameterized constructor
        model = carModel;
    }

    void display() {
        System.out.println("Car model: " + model);
    }

    public static void main(String[] args) {
        Car myCar = new Car("Tesla Model S");
        myCar.display();
    }
}


