class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " | Priority: " + getPriority() + " | Iteration: " + i);
            try {
                Thread.sleep(100); // small delay to simulate work
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class ThreadPriorityDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");
        MyThread t3 = new MyThread("Thread-3");

        // Set custom priorities
        t1.setPriority(4);
        t2.setPriority(2);
        t3.setPriority(8);

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}
