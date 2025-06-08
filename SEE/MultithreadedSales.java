import java.util.*;

class SalesPersons extends Thread {
    private String[] names;
    private String[] days;
    private volatile boolean suspended = false;
    private int index = 0;
    
    public SalesPersons(String[] names, String[] days) {
        this.names = names;
        this.days = days;
    }
    
    public void run() {
        while (index < names.length) {
            synchronized(this) {
                while (suspended) {
                    try {
                        wait();
                    } catch (InterruptedException e) {}
                }
            }
            
            if (index < names.length) {
                System.out.println(names[index]);
                index++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
            }
        }
    }
    
    public synchronized void suspend() {
        suspended = true;
    }
    
    public synchronized void resume() {
        suspended = false;
        notify();
    }
}

class Days extends Thread {
    private String[] days;
    private SalesPersons salesThread;
    
    public Days(String[] days, SalesPersons salesThread) {
        this.days = days;
        this.salesThread = salesThread;
    }
    
    public void run() {
        for (String day : days) {
            System.out.println("Day: " + day);
            
            if (day.equals("Sunday")) {
                salesThread.suspend();
            } else if (day.equals("Wednesday")) {
                salesThread.resume();
            }
            
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {}
        }
    }
}

public class MultithreadedSales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        String[] salesPersons = new String[n];
        for (int i = 0; i < n; i++) {
            salesPersons[i] = sc.next();
        }
        
        int m = sc.nextInt();
        String[] days = new String[m];
        for (int i = 0; i < m; i++) {
            days[i] = sc.next();
        }
        
        SalesPersons salesThread = new SalesPersons(salesPersons, days);
        Days daysThread = new Days(days, salesThread);
        
        salesThread.start();
        daysThread.start();
        
        try {
            salesThread.join();
            daysThread.join();
        } catch (InterruptedException e) {}
    }
}