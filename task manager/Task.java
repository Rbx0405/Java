import javafx.beans.property.*;

public class Task {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final StringProperty dueDate = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();

    public Task(String title, String description, String dueDate, String status) {
        this.title.set(title);
        this.description.set(description);
        this.dueDate.set(dueDate);
        this.status.set(status);
    }

    public Task(int id, String title, String description, String dueDate, String status) {
        this.id.set(id);
        this.title.set(title);
        this.description.set(description);
        this.dueDate.set(dueDate);
        this.status.set(status);
    }

    public int getId() { return id.get(); }
    public String getTitle() { return title.get(); }
    public String getDescription() { return description.get(); }
    public String getDueDate() { return dueDate.get(); }
    public String getStatus() { return status.get(); }

    public void setStatus(String status) { this.status.set(status); }
    public StringProperty titleProperty() { return title; }
    public StringProperty dueDateProperty() { return dueDate; }
    public StringProperty statusProperty() { return status; }
}