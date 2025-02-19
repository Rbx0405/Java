import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
    private static final String URL = "jdbc:sqlite:tasks.db";

    static {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS tasks (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "title TEXT, " +
                    "description TEXT, " +
                    "due_date TEXT, " +
                    "status TEXT DEFAULT 'Pending')";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addTask(Task task) {
        String sql = "INSERT INTO tasks (title, description, due_date, status) VALUES (?, ?, ?, 'Pending')";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getDescription());
            pstmt.setString(3, task.getDueDate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTask(int taskId) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, taskId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateTaskStatus(int taskId, String status) {
        String sql = "UPDATE tasks SET status = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, taskId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Task> getFilteredTasks(String filter) {
        ObservableList<Task> tasks = FXCollections.observableArrayList();
        String sql;
        if ("All".equals(filter)) {
            sql = "SELECT * FROM tasks";
        } else {
            sql = "SELECT * FROM tasks WHERE status = ?";
        }

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            if (!"All".equals(filter)) {
                pstmt.setString(1, filter);
            }

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tasks.add(new Task(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("due_date"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}