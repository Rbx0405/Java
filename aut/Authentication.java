import java.sql.*;
import java.util.Scanner;

public class Authentication {
    private static final String DB_URL = "jdbc:sqlite:users.db";

    public static void main(String[] args) {
        createUsersTable(); // Ensure table exists

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String newPassword = scanner.nextLine();
                    registerUser(newUsername, newPassword);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    boolean success = loginUser(username, password);
                    if (success) {
                        System.out.println("✅ Login successful!");
                    } else {
                        System.out.println("❌ Invalid username or password.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    // 🔹 Create 'users' table if not exists
    private static void createUsersTable() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "username TEXT UNIQUE NOT NULL," +
                         "password TEXT NOT NULL);";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 Register a new user
    private static void registerUser(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password); // ⚠ Store passwords securely using hashing
            pstmt.executeUpdate();
            System.out.println("✅ Registration successful!");
        } catch (SQLException e) {
            System.out.println("❌ Username already exists.");
        }
    }

    // 🔹 Authenticate user
    private static boolean loginUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password); // ⚠ Use hashing in production
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Returns true if user exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}