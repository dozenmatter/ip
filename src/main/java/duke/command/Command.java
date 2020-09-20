package duke.command;

import duke.exception.DukeException;
import duke.store.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Represents an executable command.
 */
public abstract class Command {

    /**
     * Executes a specific command.
     *
     * @param tasks list of tasks
     * @param ui user interface functions
     * @param storage storage functions
     * @throws DukeException if an error occurs
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    /**
     * Checks if program is exiting.
     *
     * @return true if exiting, false otherwise
     */
    public abstract boolean isExit();

}
