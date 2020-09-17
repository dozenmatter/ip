package duke.task;

/**
 * Handles Event tasks.
 */
public class Event extends Task {
    private final char ICON = 'E';
    private String at;

    /**
     * Instantiates an Event object with description and at.
     *
     * @param description event description
     * @param at event at
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * Returns a String at.
     *
     * @return a String at
     */
    public String getAt() {
        return at;
    }

    @Override
    public char getIcon() {
        return ICON;
    }

    @Override
    public String toString() {
        return "[" + ICON + "]" + super.toString() + " (at: " + at + ")";
    }
}
