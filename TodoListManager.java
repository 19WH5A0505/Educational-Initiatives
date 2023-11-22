package todolist;
import java.util.ArrayList;
import java.util.List;

//To-Do List Manager
class TodoListManager
{
    private List<Task> tasks;
    private List<List<TaskState>> undoStack;

    TodoListManager()
    {
        this.tasks = new ArrayList<>();
        this.undoStack = new ArrayList<>();
        saveState();
    }

    void addTask(Task task)
    {
        tasks.add(task);
        saveState();
    }

    void markCompleted(String description) 
    {
        Task task = findTask(description);
        if (task != null)
        {
            task.markCompleted();
            saveState();
        }
    }

    void deleteTask(String description) 
    {
        Task task = findTask(description);
        if (task != null)
        {
            tasks.remove(task);
            saveState();
        }
    }

    List<Task> viewTasks(String filterType) 
    {
        if ("completed".equals(filterType)) 
        {
            List<Task> filteredTasks = new ArrayList<>();
            for (Task task : tasks) 
            {
                if (task.isCompleted()) 
                {
                    filteredTasks.add(task);
                }
            }
            return filteredTasks;
        }
        else if ("pending".equals(filterType)) 
        {
            List<Task> filteredTasks = new ArrayList<>();
            for (Task task : tasks)
            {
                if (!task.isCompleted()) 
                {
                    filteredTasks.add(task);
                }
            }
            return filteredTasks;
        } 
        else 
        {
            return tasks;
        }
    }

    void undo()
    {
        if (undoStack.size() > 1) 
        {
            undoStack.remove(undoStack.size() - 1);
            List<TaskState> state = undoStack.get(undoStack.size() - 1);
            for (int i = 0; i < tasks.size(); i++) 
            {
                state.get(i).restore();
            }
        }
    }

    private void saveState()
    {
        List<TaskState> state = new ArrayList<>();
        for(Task task : tasks)
        {
            state.add(new TaskState(task));
        }
        undoStack.add(state);
    }

    private Task findTask(String description)
    {
        for (Task task : tasks)
        {
            if (task.toString().startsWith(description)) 
            {
                return task;
            }
        }
        return null;
    }
}
