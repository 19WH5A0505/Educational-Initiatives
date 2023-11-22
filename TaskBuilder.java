package todolist;
// Creational Pattern: Builder Pattern
class TaskBuilder 
{
	private Task task;

	TaskBuilder(String description) 
	{
		this.task = new Task(description);
	}

	TaskBuilder setDueDate(String dueDate)
	{
		this.task.setDueDate(dueDate);
		return this;
	}

	Task build() 
	{
		return this.task;
	}
}
