public class Yield {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("Child yielding...");
            Thread.yield(); // Hint to scheduler
            System.out.println("Child resumed");
        });
        t.start();
        System.out.println("Main running");
    }
}
