package com.StudyPlanner2;
import java.time.LocalDate;

public class Task {
    private String taskName;
    private LocalDate dueDate;
    private boolean completed;

    public Task(String taskName, LocalDate dueDate) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.completed = false;
    }

    // Getters and setters
    // ...

    public void markAsCompleted() {
        this.completed = true;
    }

	public int getDueDate() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getTaskName() {
		// TODO Auto-generated method stub
		return 0;
	}
}
