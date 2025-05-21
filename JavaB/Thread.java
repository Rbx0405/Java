
class MyThread extends Thread {
    @Override
    public void run() {
        // Code to be executed in this thread
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(500); // Pause for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

// Method 2: Implementing Runnable interface (preferred)
class MyRunnable implements Runnable {
    @Override
    public void run() {
        // Code to be executed in this thread
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(500); // Pause for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

// Thread Synchronization Example
class SharedResource {
    private int count = 0;
    
    // Synchronized method
    public synchronized void increment() {
        count++;
    }
    
    // Synchronized block
    public void anotherIncrement() {
        synchronized(this) {
            count++;
        }
        // Other non-synchronized code
    }
    
    public int getCount() {
        return count;
    }
}

// Using wait() and notify()
class MessageQueue {
    private String message;
    private boolean isEmpty = true;
    
    public synchronized String receive() {
        while (isEmpty) {
            try {
                wait(); // Release lock and wait
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        isEmpty = true;
        notifyAll(); // Notify waiting threads
        return message;
    }
    
    public synchronized void send(String message) {
        while (!isEmpty) {
            try {
                wait(); // Release lock and wait
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        isEmpty = false;
        this.message = message;
        notifyAll(); // Notify waiting threads
    }
}

// Main class to demonstrate threading
public class MultithreadingDemo {
    public static void main(String[] args) {
        System.out.println("=== Extending Thread ===");
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        thread1.start(); // Start thread execution
        thread2.start();
        
        try {
            thread1.join(); // Wait for thread1 to finish
            thread2.join(); // Wait for thread2 to finish
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        
        System.out.println("\n=== Implementing Runnable ===");
        Thread thread3 = new Thread(new MyRunnable(), "Thread-3");
        Thread thread4 = new Thread(new MyRunnable(), "Thread-4");
        thread3.start();
        thread4.start();
        
        try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        
        // Using lambda (Java 8+)
        System.out.println("\n=== Using Lambda ===");
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
            }
        }, "Lambda-Thread").start();
        
        // Thread Pool example using ExecutorService
        System.out.println("\n=== Using ExecutorService ===");
        import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " executed by " + 
                                   Thread.currentThread().getName());
            });
        }
        
        executor.shutdown(); // Shutdown executor service
    }
}
