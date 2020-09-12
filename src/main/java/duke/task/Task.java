package duke.task;

public class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String getDescription(){
        return description;
    }

    public boolean hasDone() {
        return isDone;
    }

    public void markAsDone(){
        isDone = true;
    }

    public char getIcon() {
        return ' ';
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", getStatusIcon(), description);
    }
}
