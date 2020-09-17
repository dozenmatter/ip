package duke.command;

import duke.exception.DukeException;
import duke.store.Storage;
import duke.task.TaskList;
import duke.task.ToDo;
import duke.ui.Ui;

/**
 * Adds a Todo task to TaskList.
 */
public class AddToDoCommand extends Command {
    private ToDo todo;
    private static final String ERROR_TODO = "Here is how to create a Todo task:\ntodo <task name>\nGot it? :(";

    /**
     * AddToDoCommand constructor.
     *
     * @param taskName user specified task name
     * @throws DukeException if task name is empty
     */
    public AddToDoCommand(String taskName) throws DukeException {
        if (taskName.isEmpty()) {
            throw new DukeException(ERROR_TODO);
        }
        todo = new ToDo(taskName);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addTask(todo);
        ui.printAddTask(todo, tasks.getSize());
        storage.save(tasks.toString());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
