package duke.command;

import duke.exception.DukeException;
import duke.store.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Marks a task as done
 */
public class DoneCommand extends Command {
    private int taskNum;

    private static final String ERROR_INVALID_TASK_NUMBER = "You specified an invalid task number! :(";
    private static final String ERROR_NUMBER_FORMAT = "That is not an integer... :(";

    /**
     * DoneCommand constructor.
     *
     * @param arguments user specified task number
     * @throws DukeException if task number is invalid
     */
    public DoneCommand(String arguments) throws DukeException {
        try {
            taskNum = Integer.parseInt(arguments) - 1;
        } catch (NumberFormatException e) {
            throw new DukeException(ERROR_NUMBER_FORMAT);
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (isValidTaskNumber(tasks.getSize())) {
            Task t = tasks.get(taskNum);
            t.markAsDone();
            ui.printMarkAsDone(t);
            storage.save(tasks.toString());
        } else {
            throw new DukeException(ERROR_INVALID_TASK_NUMBER);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }

    /**
     * Takes in task list size and checks if user specified task number is valid
     *
     * @param size task list size
     * @return true if task number is >= 0 and < size, false otherwise.
     */
    private boolean isValidTaskNumber(int size) {
        return taskNum >= 0 && taskNum < size;
    }
}
