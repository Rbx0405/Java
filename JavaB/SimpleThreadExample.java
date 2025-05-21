public class SimpleThreadExample {
    public static void main(String[] args) {
        System.out.println("Main thread starting...");
        
        // Create two threads with our Runnable implementation
        Thread thread1 = new Thread(new CounterTask("Thread-1"), "Thread-1");
        Thread thread2 = new Thread(new CounterTask("Thread-2"), "Thread-2");
        
        // Start both threads
        thread1.start();
        thread2.start();
        
        // Main thread continues execution
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread: " + i);
            try {
                Thread.sleep(700); // Sleep for 700 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }
        
        // Wait for both threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting for threads to finish");
        }
        
        System.out.println("Main thread ending...");
    }
}

// Create a Runnable implementation
class CounterTask implements Runnable {
    private String name;
    
    public CounterTask(String name) {
        this.name = name;
    }
    
    // This method contains the code that will be executed in a separate thread
    @Override
    public void run() {
        System.out.println(name + " starting...");
        
        // Count from 1 to 5
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + ": " + i);
            try {
                // Sleep for a random time between 200 and 500 milliseconds
                Thread.sleep((long)(Math.random() * 300) + 200);
            } catch (InterruptedException e) {
                System.out.println(name + " interrupted");
            }
        }
        
        System.out.println(name + " completed.");
    }
}
