package todolist;
//Memento Pattern: TaskState

class TaskState 
{
    private Task task;
    private boolean completed;

    TaskState(Task task) 
    {
        this.task = task;
        this.completed = task.isCompleted();
    }

    void restore()
    {
        task.setCompleted(completed);
    }
}
