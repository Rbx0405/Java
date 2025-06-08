import java.util.*;

public class SmallestUnconstructibleSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        int sum = 1;
        for (int x : arr) {
            if (x > sum) break;
            sum += x;
        }
        
        System.out.println(sum);
    }
}
