-- Create the tasks table if it doesn't already exist
CREATE TABLE IF NOT EXISTS tasks (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    description TEXT,
    due_date TEXT,
    status TEXT DEFAULT 'Pending'
);

-- Insert sample data
INSERT INTO tasks (title, description, due_date, status) VALUES 
('Buy groceries', 'Milk, Bread, Eggs', '2025-02-20', 'Pending'),
('Complete project', 'Finalize and submit report', '2025-02-22', 'Pending'),
('Workout', 'Gym session at 6 PM', '2025-02-18', 'Completed');

-- Select all tasks to verify
SELECT * FROM tasks;