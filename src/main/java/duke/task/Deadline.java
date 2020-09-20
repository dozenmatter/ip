package duke.task;

import duke.exception.DukeException;
import duke.parser.DateTimeParser;

import java.text.ParseException;
import java.util.Date;

/**
 * Creates a Deadline task
 */
public class Deadline extends Task implements DateTimeParser {
    private final char ICON = 'D';
    private String by;
    private Date parseBy;

    /**
     * Instantiates a Deadline object with description and by.
     *
     * @param description task description
     * @param by task deadline by
     */
    public Deadline(String description, String by) throws DukeException {
        super(description);
        this.by = by;

        try {
            parseBy = STRING_TO_DATE.parse(by);
        } catch (ParseException e) {
            throw new DukeException(ERROR_INVALID_DATE_STRING);
        }
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
        return "[" + ICON + "]" + super.toString() + " (by: " + DATE_TO_STRING.format(parseBy) + ")";
    }
}
