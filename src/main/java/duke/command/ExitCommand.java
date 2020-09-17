package duke.command;

import duke.store.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Exits the program
 */
public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        storage.save(tasks.toString());
    }

    @Override
    public boolean isExit() {
        return true;
    }

}
