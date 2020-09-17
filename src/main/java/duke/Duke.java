package duke;

import duke.command.Command;
import duke.exception.DukeException;
import duke.parser.Parser;
import duke.store.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Entry point of Duke application
 * Initialises the application and starts the interaction with the user.
 */
public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Instantiates a Duke object with Ui
     * Attempts to load saved data from storage into TaskList.
     *
     * @param filePath save path to retrieve saved data
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.printError(e.getMessage());
            tasks = new TaskList();
        }
    }

    /**
     * Runs the program until termination.
     */
    public void run() {
        ui.printWelcome();
        runCommandLoopUntilExit();
        exit();
    }

    /**
     * Reads the user command and executes it, until the user issues the exit command.
     */
    private void runCommandLoopUntilExit() {
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.printError(e.getMessage());
            }
        }
    }

    /**
     * Prints the Goodbye message and exits.
     */
    private void exit() {
        ui.printGoodBye();
        System.exit(0);
    }

    /**
     * Program main method.
     *
     * @param args user specified arguments
     */
    public static void main(String[] args) {
        new Duke("/data/tasks.txt").run();
    }
}