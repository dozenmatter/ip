package duke.task;

/**
 * Handles ToDo tasks.
 */
public class ToDo extends Task {
    private final char ICON = 'T';

    /**
     * Instantiates a ToDo objects with description.
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
