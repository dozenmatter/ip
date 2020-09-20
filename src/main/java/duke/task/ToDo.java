package duke.task;

/**
 * Creates a ToDo task.
 */
public class ToDo extends Task {
    private final char ICON = 'T';

    /**
     * Instantiates a ToDo object with description.
     *
     * @param description task description
     */
    public ToDo(String description) {
        super(description);
    }

    @Override
    public char getIcon() {
        return ICON;
    }

    @Override
    public String toString() {
        return "[" + ICON + "]" + super.toString();
    }
}
