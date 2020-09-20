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
        String searchResult = "";
        for (int i = 0, j = 0; i < tasks.getSize(); i++) {
            Task task = tasks.get(i);
            if (task.getDescription().contains(keyword)) {
                searchResult += (++j) + ". " + task.toString() + "\n";
            }
        }

        // Remove the last break-line character
        searchResult = searchResult.substring(0, searchResult.length() - 1);
        ui.printSearchResult(searchResult);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
