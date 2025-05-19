public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Main thread starting...");
        
        // Creating a thread using Thread subclass
        CounterThread thread1 = new CounterThread("Thread-1", 5);
        thread1.start();
        
        // Creating a thread using Runnable interface
        Thread thread2 = new Thread(new CounterRunnable("Thread-2", 5));
        thread2.start();
        
        // Creating a thread using lambda expression (Java 8+)
        Thread thread3 = new Thread(() -> {
            String threadName = "Thread-3";
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println(threadName + ": Count " + i);
                    Thread.sleep(800);
                }
                System.out.println(threadName + " finished.");
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
            }
        });
        thread3.start();
        
        try {
            // Wait for all threads to complete
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        
        System.out.println("Main thread exiting.");
    }
}

// Thread implementation by extending Thread class
class CounterThread extends Thread {
    private int count;
    
    public CounterThread(String name, int count) {
        super(name);
        this.count = count;
    }
    
    @Override
    public void run() {
        try {
            for (int i = 1; i <= count; i++) {
                System.out.println(getName() + ": Count " + i);
                Thread.sleep(1000);
            }
            System.out.println(getName() + " finished.");
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted.");
        }
    }
}

// Thread implementation using Runnable interface
class CounterRunnable implements Runnable {
    private String name;
    private int count;
    
    public CounterRunnable(String name, int count) {
        this.name = name;
        this.count = count;
    }
    
    @Override
    public void run() {
        try {
            for (int i = 1; i <= count; i++) {
                System.out.println(name + ": Count " + i);
                Thread.sleep(500);
            }
            System.out.println(name + " finished.");
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
    }
}
