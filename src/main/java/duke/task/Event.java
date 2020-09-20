package duke.task;

import duke.exception.DukeException;
import duke.parser.DateTimeParser;

import java.text.ParseException;
import java.util.Date;

/**
 * Creates an Event task.
 */
public class Event extends Task implements DateTimeParser {
    private final char ICON = 'E';
    private String at;
    private Date parseAt;

    /**
     * Instantiates an Event object with description and at.
     *
     * @param description event description
     * @param at event at
     */
    public Event(String description, String at) throws DukeException {
        super(description);
        this.at = at;

        try {
            parseAt = STRING_TO_DATE.parse(at);
        } catch (ParseException e) {
            throw new DukeException(ERROR_INVALID_DATE_STRING);
        }
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
        return "[" + ICON + "]" + super.toString() + " (at: " + DATE_TO_STRING.format(parseAt) + ")";
    }
}
