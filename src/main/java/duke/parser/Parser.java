package duke.parser;

import duke.exception.DukeException;
import duke.command.AddDeadlineCommand;
import duke.command.AddEventCommand;
import duke.command.AddToDoCommand;
import duke.command.Command;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.ExitCommand;
import duke.command.ListCommand;

/**
 * Parses user input.
 */
public class Parser {
    /* List of user input commands */
    private static final String COMMAND_TODO = "todo";
    private static final String COMMAND_DEADLINE = "deadline";
    private static final String COMMAND_EVENT = "event";
    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_DONE = "done";
    private static final String COMMAND_BYE = "bye";
    private static final String COMMAND_DELETE = "delete";

    private static final String ERROR_INVALID_COMMAND = "I'm sorry, but I don't know what that means :(";

    /**
     * Parse user inputs into command for execution.
     *
     * @param input user input string
     * @return the command based on user input
     * @throws DukeException if user command is invalid
     */
    public static Command parse(String input) throws DukeException {
        String[] tokens = input.split(" ", 2);

        if (tokens.length < 2) {
            tokens = new String[]{tokens[0], ""};
        }

        String command = tokens[0].trim();
        String arguments = tokens[1].trim();

        switch (command) {
        case COMMAND_TODO:
            return new AddToDoCommand(arguments);
        case COMMAND_DEADLINE:
            return new AddDeadlineCommand(arguments);
        case COMMAND_EVENT:
            return new AddEventCommand(arguments);
        case COMMAND_DONE:
            return new DoneCommand(arguments);
        case COMMAND_LIST:
            return new ListCommand();
        case COMMAND_DELETE:
            return new DeleteCommand(arguments);
        case COMMAND_BYE:
            return new ExitCommand();
        default:
            throw new DukeException(ERROR_INVALID_COMMAND);
        }
    }
}
