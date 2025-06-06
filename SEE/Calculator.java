import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double a = s.nextDouble(), b = s.nextDouble();
        char op = s.next().charAt(0);
        switch(op) {
            case '+': System.out.printf("%.1f", a + b); break;
            case '-': System.out.printf("%.1f", a - b); break;
            case '*': System.out.printf("%.1f", a * b); break;
            case '/': case '%': 
                if(b == 0) System.out.print("cannot divide by zero.");
                else System.out.printf("%.1f", op == '/' ? a / b : a % b);
                break;
            default: System.out.print("invalid operator.");
        }
    }
}
