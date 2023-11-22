# Educational-Initiatives

Personal To-Do List Manager

This is a simple To-Do List Manager implemented in Java, showcasing the use of design patterns such as Memento and Builder.

Features

-Add tasks with optional due dates.
-Mark tasks as completed.
-Delete tasks.
-View tasks based on filters (all, completed, pending).
-Undo the last action.

Prerequisites

- Java Development Kit (JDK) installed.
- Git (optional, for cloning the repository).

Design Patterns
-Memento Pattern
	The Memento pattern is used to implement the undo functionality. The TaskState class captures the state of a 	task, allowing for restoration.

-Builder Pattern
	The Builder pattern is employed in the TaskBuilder class to create tasks with optional parameters in a clean 	and readable way.

Usage
-Compile the Java files.
	javac TodoListExample.java
-Run the TodoListExample class.
	java TodoListExample
