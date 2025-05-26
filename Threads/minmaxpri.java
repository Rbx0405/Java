class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " - Priority: " + getPriority() + " - Iteration: " + i);
        }
    }
}

public class minmaxpri {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("LowPriority");
        MyThread t2 = new MyThread("NormalPriority");
        MyThread t3 = new MyThread("HighPriority");

        // Set thread priorities
        t1.setPriority(Thread.MIN_PRIORITY);     // 1
        t2.setPriority(Thread.NORM_PRIORITY);    // 5 (default)
        t3.setPriority(Thread.MAX_PRIORITY);     // 10

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}
