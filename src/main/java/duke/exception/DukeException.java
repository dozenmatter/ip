package duke.exception;

/**
 * Duke's personalised Exception
 */
public class DukeException extends Exception {
    /**
     * DukeException constructor
     * @param errorMessage Duke exception message
     */
    public DukeException(String errorMessage) {
        super(errorMessage);
    }
}
