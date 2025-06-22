public class LogicalExample {
    public static void main(String[] args) {
        int a = 5, b = 10;
        System.out.println((a < b) && (a > 0));  // true
        System.out.println((a < b) || (a < 0));  // true
        System.out.println(!(a < b));            // false
    }
}