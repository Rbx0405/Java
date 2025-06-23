public class NumberFormatDemo {
    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "12a";  // invalid numeric format

        try {
            int num1 = Integer.parseInt(str1);
            System.out.println("Parsed number 1: " + num1);

            int num2 = Integer.parseInt(str2);  // causes exception
            System.out.println("Parsed number 2: " + num2);
        } catch (NumberFormatException e) {
            System.out.println("Exception: Invalid number format -> " + e.getMessage());
        }

        System.out.println("Program continues...");
    }
}