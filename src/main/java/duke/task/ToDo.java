package duke.task;

public class ToDo extends Task {
    private final char ICON = 'T';

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
