package duke.task;

public class Event extends Task {
    private final char ICON = 'E';
    private String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    public String getAt() {
        return at;
    }

    @Override
    public char getIcon() {
        return ICON;
    }

    public void setAt(String at) {
        this.at = at;
    }

    @Override
    public String toString() {
        return "[" + ICON + "]" + super.toString() + " (at: " + at + ")";
    }
}
