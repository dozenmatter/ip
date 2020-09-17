package duke.task;

/**
 * Handles Deadline tasks
 */
public class Deadline extends Task {
    private final char ICON = 'D';
    private String by;

    /**
     * Instantiates a Deadline object with description and by.
     *
     * @param description task description
     * @param by task deadline by
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns a by String.
     * @return a String containing by
     */
    public String getBy() {
        return by;
    }

    @Override
    public char getIcon() {
        return ICON;
    }

    @Override
    public String toString() {
        return "[" + ICON + "]" + super.toString() + " (by: " + by + ")";
    }
}
