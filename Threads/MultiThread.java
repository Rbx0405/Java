public class MultiThread extends Thread {
    
    @Override
    public void run() {
        // Each thread will print numbers 1 to 5
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " prints: " + i);
            try {
                Thread.sleep(500); // Wait 0.5 seconds
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted");
            }
        }
    }
    
    public static void main(String[] args) {
        // Create 3 threads
        MultiThread t1 = new MultiThread();
        MultiThread t2 = new MultiThread();
        MultiThread t3 = new MultiThread();
        
        // Give them names
        t1.setName("Thread-A");
        t2.setName("Thread-B");  
        t3.setName("Thread-C");
        
        // Start all threads (they run at the same time!)
        t1.start();
        t2.start();
        t3.start();
        
        System.out.println("All threads started!");
    }
}
