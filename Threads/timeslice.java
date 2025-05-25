class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " - iteration " + i);
            try {
                Thread.sleep(500); // Simulate time slicing
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class timeslice {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");

        t1.start();
        t2.start();
    }
}
