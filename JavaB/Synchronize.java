public class Synchronize {
    
    // Shared resource - a counter
    private int counter = 0;
    
    // Synchronized method to increment the counter
    public synchronized void increment() {
        counter++;
    }
    
    // Synchronized method to get the current counter value
    public synchronized int getCounter() {
        return counter;
    }
    
    public static void main(String[] args) throws InterruptedException {
        // Create an instance of our class with the shared counter
        Synchronize example = new Synchronize();
        
        // Create two threads that will increment the counter
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                example.increment();
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                example.increment();
            }
        });
        
        // Start both threads
        thread1.start();
        thread2.start();
        
        // Wait for both threads to complete
        thread1.join();
        thread2.join();
        
        // Print the final counter value
        System.out.println("Final counter value: " + example.getCounter());
    }
}          
