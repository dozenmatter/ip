package duke.command;

import duke.exception.DukeException;
import duke.store.Storage;
import duke.task.Deadline;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Adds a Deadline task to TaskList
 */
public class AddDeadlineCommand extends Command {
    private Deadline deadline;

    private static final String PARAM_BY = " /by ";
    private static final String ERROR_DEADLINE = "Here is how to create a Deadline task:\ndeadline <task name> /by <date time>\nGot it? :(";

    /**
     * AddDeadlineCommand constructor.
     *
     * @param arguments deadline command arguments
     * @throws DukeException if user inputs invalid arguments
     */
    public AddDeadlineCommand(String arguments) throws DukeException {
        try {
            String[] tokens = arguments.split(PARAM_BY);
            String taskName = tokens[0].trim();
            String by = tokens[1].trim();
            deadline = new Deadline(taskName, by);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException(ERROR_DEADLINE);
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addTask(deadline);
        ui.printAddTask(deadline, tasks.getSize());
        storage.save(tasks.toString());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
