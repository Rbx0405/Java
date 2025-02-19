import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

public class TaskManager extends Application {
    private TableView<Task> table;
    private ObservableList<Task> taskList;
    private ComboBox<String> filterDropdown;

    @Override
    public void start(Stage primaryStage) {
        Label lblTitle = new Label("Task:");
        TextField txtTitle = new TextField();

        Label lblDesc = new Label("Description:");
        TextField txtDesc = new TextField();

        Label lblDue = new Label("Due Date (YYYY-MM-DD):");
        TextField txtDue = new TextField();

        Button btnAdd = new Button("Add Task");
        Button btnDelete = new Button("Delete Task");
        Button btnComplete = new Button("Mark Completed");

        filterDropdown = new ComboBox<>();
        filterDropdown.getItems().addAll("All", "Pending", "Completed");
        filterDropdown.setValue("All");
        
        table = new TableView<>();
        taskList = FXCollections.observableArrayList();
        loadTasks("All");

        TableColumn<Task, String> colTitle = new TableColumn<>("Task");
        colTitle.setCellValueFactory(cell -> cell.getValue().titleProperty());

        TableColumn<Task, String> colDue = new TableColumn<>("Due Date");
        colDue.setCellValueFactory(cell -> cell.getValue().dueDateProperty());

        TableColumn<Task, String> colStatus = new TableColumn<>("Status");
        colStatus.setCellValueFactory(cell -> cell.getValue().statusProperty());

        table.getColumns().addAll(colTitle, colDue, colStatus);
        table.setItems(taskList);

        btnAdd.setOnAction(e -> {
            Task task = new Task(txtTitle.getText(), txtDesc.getText(), txtDue.getText(), "Pending");
            Database.addTask(task);
            loadTasks(filterDropdown.getValue());
            txtTitle.clear();
            txtDesc.clear();
            txtDue.clear();
        });

        btnDelete.setOnAction(e -> {
            Task selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                Database.deleteTask(selected.getId());
                loadTasks(filterDropdown.getValue());
            }
        });

        btnComplete.setOnAction(e -> {
            Task selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                Database.updateTaskStatus(selected.getId(), "Completed");
                loadTasks(filterDropdown.getValue());
            }
        });

        // Filter task list based on selected value
        filterDropdown.setOnAction(e -> loadTasks(filterDropdown.getValue()));

        VBox layout = new VBox(10, lblTitle, txtTitle, lblDesc, txtDesc, lblDue, txtDue, btnAdd, btnDelete, btnComplete, filterDropdown, table);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Task Manager");
        primaryStage.show();
    }

    private void loadTasks(String filter) {
        taskList.clear();
        taskList.addAll(Database.getFilteredTasks(filter));
    }

    public static void main(String[] args) {
        launch(args);
    }
}