package duke.task;

public class Deadline extends Task {
    private final char ICON = 'D';
    private String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public char getIcon() {
        return ICON;
    }

    public void setBy(String by) {
        this.by = by;
    }

    @Override
    public String toString() {
        return "[" + ICON + "]" + super.toString() + " (by: " + by + ")";
    }
}
