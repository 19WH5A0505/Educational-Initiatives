package todolist;
import java.util.List;
import java.util.Scanner;

public class TodoListExample {
    public static void main(String[] args) {
        TodoListManager todoManager = new TodoListManager();
        Scanner sc = new Scanner(System.in);

        Task task1 = new TaskBuilder("Buy groceries").setDueDate("2023-10-21").build();
        Task task2 = new TaskBuilder("Complete project").build();

        todoManager.addTask(task1);
        todoManager.addTask(task2);

        while (true) 
        {
            System.out.println("\nOptions:");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Delete Task");
            System.out.println("4. View Tasks");
            System.out.println("5. Undo");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = sc.nextLine();
                    System.out.print("Enter due date (or press Enter to skip): ");
                    String dueDate = sc.nextLine();

                    Task newTask = new TaskBuilder(description)
                            .setDueDate(dueDate.isEmpty() ? null : dueDate)
                            .build();

                    todoManager.addTask(newTask);
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    System.out.print("Enter task description to mark as completed: ");
                    String completedDescription = sc.nextLine();
                    todoManager.markCompleted(completedDescription);
                    System.out.println("Task marked as completed!");
                    break;

                case 3:
                    System.out.print("Enter task description to delete: ");
                    String deleteDescription = sc.nextLine();
                    todoManager.deleteTask(deleteDescription);
                    System.out.println("Task deleted successfully!");
                    break;

                case 4:
                    System.out.println("View Tasks:");
                    System.out.println("1. All Tasks");
                    System.out.println("2. Completed Tasks");
                    System.out.println("3. Pending Tasks");
                    System.out.print("Enter your choice: ");

                    int viewChoice = sc.nextInt();
                    sc.nextLine();

                    String filterType;
                    switch (viewChoice) 
                    {
                        case 1:
                            filterType = "all";
                            break;
                        case 2:
                            filterType = "completed";
                            break;
                        case 3:
                            filterType = "pending";
                            break;
                        default:
                            System.out.println("Invalid choice. Viewing all tasks.");
                            filterType = "all";
                    }

                    List<Task> tasks = todoManager.viewTasks(filterType);
                    for (Task task : tasks) {
                        System.out.println(task);
                    }
                    break;

                case 5:
                    todoManager.undo();
                    System.out.println("Undo successful!");
                    break;

                case 6:
                    System.out.println("Exiting the To-Do List Manager.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}