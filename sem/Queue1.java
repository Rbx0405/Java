import java.util.*;

public class Queue1 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // Adding elements
        queue.add("A");
        queue.add("B");
        queue.offer("C");

        // Viewing head
        System.out.println("Head (peek): " + queue.peek());

        // Removing elements
        System.out.println("Removed: " + queue.poll()); // A
        System.out.println("Removed: " + queue.remove()); // B

        // Current queue
        System.out.println("Remaining queue: " + queue);
    }
}