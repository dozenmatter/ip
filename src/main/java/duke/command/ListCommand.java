package duke.command;

import duke.store.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * List all tasks
 */
public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printListOfTasks(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
