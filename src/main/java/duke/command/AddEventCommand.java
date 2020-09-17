package duke.command;

import duke.exception.DukeException;
import duke.store.Storage;
import duke.task.Event;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Adds an Event task to TaskList.
 */
public class AddEventCommand extends Command {
    private Event event;

    private static final String PARAM_AT = " /at ";
    private static final String ERROR_EVENT = "Here is how to create an Event task:\nevent <task name> /at <date time: dd/MM/yyyy HHmm>\nGot it? :(";

    /**
     * AddEventCommand constructor.
     *
     * @param arguments event command arguments
     * @throws DukeException if user inputs invalid arguments
     */
    public AddEventCommand(String arguments) throws DukeException {
        try {
            String[] tokens = arguments.split(PARAM_AT);
            String taskName = tokens[0].trim();
            String at = tokens[1].trim();
            event = new Event(taskName, at);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException(ERROR_EVENT);
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addTask(event);
        ui.printAddTask(event, tasks.getSize());
        storage.save(tasks.toString());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
