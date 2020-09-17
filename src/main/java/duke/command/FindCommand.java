package duke.command;

import duke.exception.DukeException;
import duke.store.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Find a task by searching for keyword.
 */
public class FindCommand extends Command {
    private String keyword;
    private static final String ERROR_FIND_KEYWORD = "To find a task by keyword:\nfind <task name>\nGot it? :(";

    /**
     * FindCommand constructor.
     *
     * @param keyword user specified keyword
     */
    public FindCommand(String keyword) throws DukeException {
        if (keyword.isEmpty()) {
            throw new DukeException(ERROR_FIND_KEYWORD);
        }
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printSearchResult(tasks, keyword);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
