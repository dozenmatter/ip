package duke.ui;

import duke.task.Task;
import duke.task.TaskList;

import java.util.Scanner;

/**
 * Text UI of the Duke application.
 */
public class Ui {
    /* List of output messages shown to users */
    // Greetings
    private static final String MESSAGE_LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    private static final String MESSAGE_INTRO = "Hello from\n" + MESSAGE_LOGO;
    private static final String MESSAGE_BODY = "Hello! I'm Duke\nWhat can I do for you?";
    private static final String MESSAGE_GOODBYE = "Bye. Hope to see you again soon!";
    private static final String DIVIDER = "____________________________________________________________";

    // Tasks related messages
    private static final String MESSAGE_LIST_TASK = "Here are the tasks in your list:";
    private static final String MESSAGE_DONE_TASK = "Nice! I've marked this task as done:";
    private static final String MESSAGE_ADD_TASK = "Got it. I've added this task:";
    private static final String MESSAGE_DELETE_TASK = "Noted. I've removed this task:";
    private static final String MESSAGE_SEARCH_RESULT = "Here are the matching tasks in your list:";

    private final Scanner SC;

    public Ui() {
        SC = new Scanner(System.in);
    }

    /**
     * Displays welcome message.
     */
    public void printWelcome() {
        System.out.println(MESSAGE_INTRO);
        System.out.println(MESSAGE_BODY);
        System.out.println(DIVIDER);
    }

    /**
     * Displays a message enclosed within dividers.
     *
     * @param message user specified message(s)
     */
    public void printWithDividers(String... message) {
        System.out.println(DIVIDER);
        for (String m : message) {
            System.out.println(m);
        }
        System.out.println(DIVIDER);
    }

    /**
     * Displays goodbye message and exits the program.
     */
    public void printGoodBye() {
        System.out.println(MESSAGE_GOODBYE);
    }

    /**
     * Prompts for the command and reads the text entered by the user.
     *
     * @return command entered by the user
     */
    public String readCommand() {
        return SC.nextLine().trim();
    }

    /**
     * Prints error messages.
     *
     * @param error DukeException message
     */
    public void printError(String error) {
        printWithDividers(error);
    }

    /**
     * Prints task marked as done.
     *
     * @param task task to be marked as done
     */
    public void printMarkAsDone(Task task) {
        printWithDividers(MESSAGE_DONE_TASK, task.toString());
    }

    /**
     * Displays a list of tasks available.
     */
    public void printListOfTasks(TaskList tasks) {
        System.out.println(DIVIDER);
        System.out.println(MESSAGE_LIST_TASK);
        for (int i = 0; i < tasks.getSize(); i++) {
            System.out.println((i+1) + ". " + tasks.get(i));
        }
        System.out.println(DIVIDER);
    }

    /**
     * Displays message when a new task is added.
     * @param task user specified task
     */
    public void printAddTask(Task task, int size) {
        String taskCount = "Now you have " + size + " tasks in the list.";
        printWithDividers(MESSAGE_ADD_TASK, task.toString(), taskCount);
    }

    /**
     * Prints message when a task is removed.
     *
     * @param task user specified task
     * @param size size of task list
     */
    public void printRemoveTask(Task task, int size) {
        String taskCount = "Now you have " + size + " tasks in the list.";
        printWithDividers(MESSAGE_DELETE_TASK, task.toString(), taskCount);
    }

    /**
     * Prints search result of specified keyword.
     *
     * @param searchResult search result string
     */
    public void printSearchResult(String searchResult) {
        printWithDividers(MESSAGE_SEARCH_RESULT, searchResult);
    }
}
