class MyThread extends Thread {
    public void run() {
        System.out.println("Child running");
    }
}

public class join{
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        t.join(); // Main waits for t to finish
        System.out.println("Main after join");
    }
}
