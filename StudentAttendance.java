import java.util.*;

public class StudentAttendance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> attendance = new HashMap<>();

        // Read number of students
        int n = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String studentId = input[0];
            String status = input[1];
            attendance.put(studentId, status);
        }

        // Read number of operations
        int m = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < m; i++) {
            String[] command = scanner.nextLine().split(" ");
            String operation = command[0];

            switch (operation) {
                case "GET":
                    String idToGet = command[1];
                    System.out.println(attendance.getOrDefault(idToGet, "Not Found"));
                    break;

                case "CHECK_KEY":
                    String keyToCheck = command[1];
                    System.out.println(attendance.containsKey(keyToCheck) ? "Yes" : "No");
                    break;

                case "CHECK_VALUE":
                    String valueToCheck = command[1];
                    System.out.println(attendance.containsValue(valueToCheck) ? "Yes" : "No");
                    break;

                case "REPLACE":
                    String idToReplace = command[1];
                    String newStatus = command[2];
                    if (attendance.containsKey(idToReplace)) {
                        attendance.put(idToReplace, newStatus);
                    }
                    break;
            }
        }
    }
}
