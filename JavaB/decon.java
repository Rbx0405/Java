class decon implements AutoCloseable {
    public decon() {
        System.out.println("Resource acquired");
    }

    @Override
    public void close() {
        System.out.println("Resource released");
    }
}

public class Main {
    public static void main(String[] args) {
        try (decon res = new decon()) { // Use `decon` instead of `Resource`
            System.out.println("Using resource");
        } // `close()` will be called automatically here
    }
}
