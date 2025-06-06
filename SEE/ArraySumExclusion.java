import java.util.Scanner;

public class ArraySumExclusion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read array size
        int n = scanner.nextInt();
        
        // Read array elements
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Calculate sum with exclusion rules
        int sum = calculateSumWithExclusion(arr);
        
        // Output the result
        System.out.println(sum);
        
        scanner.close();
    }
    
    public static int calculateSumWithExclusion(int[] arr) {
        int sum = 0;
        boolean skipNext = false;
        
        for (int i = 0; i < arr.length; i++) {
            // If we're in skip mode due to previous 6, skip current number
            if (skipNext) {
                // If current number is 7, stop skipping after this
                if (arr[i] == 7) {
                    skipNext = false;
                }
                continue; // Skip this number
            }
            
            // If current number is 6, start skipping next numbers
            if (arr[i] == 6) {
                skipNext = true;
                continue; // Skip the 6 itself
            }
            
            // Add to sum if not skipped
            sum += arr[i];
        }
        
        return sum;
    }
}
