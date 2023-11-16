package com.StudyPlanner2;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StudyPlanner2 {
    private List<Course> courses;
    private List<Task> tasks;

    public StudyPlanner2() {
        this.courses = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    public void addCourse(String courseName, String instructor) {
        Course course = new Course(courseName, instructor);
        courses.add(course);
    }

    public void addTask(String taskName, LocalDate dueDate) {
        Task task = new Task(taskName, dueDate);
        tasks.add(task);
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task.getTaskName() + " - Due: " + task.getDueDate());
        }
    }

    public static void main(String[] args) {
        StudyPlanner2 studyPlanner = new StudyPlanner2();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Course\n2. Add Task\n3. Mark Task as Completed\n4. Display Tasks\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter instructor: ");
                    String instructor = scanner.nextLine();
                    studyPlanner.addCourse(courseName, instructor);
                    break;
                case 2:
                    System.out.print("Enter task name: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Enter due date (YYYY-MM-DD): ");
                    String dateStr = scanner.nextLine();
                    LocalDate dueDate = LocalDate.parse(dateStr);
                    studyPlanner.addTask(taskName, dueDate);
                    break;
                case 3:
                    System.out.print("Enter the index of the task to mark as completed: ");
                    int index = scanner.nextInt();
                    studyPlanner.markTaskAsCompleted(index - 1);
                    break;
                case 4:
                    studyPlanner.displayTasks();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
