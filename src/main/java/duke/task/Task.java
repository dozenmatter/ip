package duke.task;

/**
 * Represents all Task objects.
 */
public abstract class Task {
    private String description;
    private boolean isDone;

    /**
     * Instantiates a Task object with description.
     *
     * @param description task description
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns an icon specifying whether a task is completed.
     *
     * @return a "tick" if completed, a "cross" otherwise
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * Returns the task description.
     *
     * @return a String of task description
     */
    public String getDescription(){
        return description;
    }

    /**
     * Specifies if task has been completed.
     *
     * @return true if completed, false otherwise
     */
    public boolean hasDone() {
        return isDone;
    }

    /**
     * Marks a task as done to true.
     */
    public void markAsDone(){
        isDone = true;
    }

    /**
     * Returns a specific Task icon.
     *
     * @return task icon
     */
    public abstract char getIcon();

    /**
     * Formats a Task object into a String.
     *
     * @return a String formatted Task object
     */
    @Override
    public String toString() {
        return String.format("[%s] %s", getStatusIcon(), description);
    }
}
