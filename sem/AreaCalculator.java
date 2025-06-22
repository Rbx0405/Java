public class AreaCalculator {

    // Area of Square
    public void area(int side) {
        System.out.println("Area of Square: " + (side * side));
    }

    // Area of Rectangle
    public void area(int length, int breadth) {
        System.out.println("Area of Rectangle: " + (length * breadth));
    }

    // Area of Triangle
    public void area(double base, double height) {
        System.out.println("Area of Triangle: " + (0.5 * base * height));
    }

    public static void main(String[] args) {
        AreaCalculator calc = new AreaCalculator();

        calc.area(5);               // Square
        calc.area(4, 6);            // Rectangle
        calc.area(5.0, 3.0);        // Triangle
    }
}

