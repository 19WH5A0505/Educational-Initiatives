package todolist;
// OOPS: Task 
class Task 
{
	private String description;
	private boolean completed;
	private String dueDate;

	Task(String description)
	{
		this.description = description;
		this.completed = false;
		this.dueDate = null;
	}

	void markCompleted() 
	{
		this.completed = true;
	}

	void markPending() 
	{
		this.completed = false;
	}

	boolean isCompleted() 
	{
		return completed;
	}

	void setCompleted(boolean completed) 
	{
		this.completed = completed;
	}

	void setDueDate(String dueDate) 
	{
		this.dueDate = dueDate;
	}

	@Override
	public String toString() 
	{
		String status = completed ? "Completed" : "Pending";
		String dueDateStr = dueDate != null ? ", Due: " + dueDate : "";
		return description + " - " + status + dueDateStr;
	}
}
