class MyThread extends Thread {
    public MyThread(String name, int priority) {
        super(name);
        setPriority(priority); // Set thread priority
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " with priority " + getPriority());
        }
    }
}

public class priority {
    public static void main(String[] args) {
        MyThread high = new MyThread("HighPriority", Thread.MAX_PRIORITY);     // 10
        MyThread low = new MyThread("LowPriority", Thread.MIN_PRIORITY);       // 1

        low.start();
        high.start();
    }
}
