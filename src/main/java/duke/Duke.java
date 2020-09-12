package duke;

import duke.file.FileManager;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
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

    // Error messages
    private static final String ERROR_TODO = "Here is how to create a Todo task:\ntodo <task name>\nGot it? :(";
    private static final String ERROR_DEADLINE = "Here is how to create a Deadline task:\ndeadline <task name> /by <date time>\nGot it? :(";
    private static final String ERROR_EVENT = "Here is how to create an Event task:\nevent <task name> /at <date time>\nGot it? :(";
    private static final String ERROR_INVALID_COMMAND = "I'm sorry, but I don't know what that means :(";
    private static final String ERROR_INVALID_TASK_NUMBER = "You specified an invalid task number! :(";
    private static final String ERROR_NUMBER_FORMAT = "That is not an integer... :(";

    /* List of user input commands */
    private static final String COMMAND_TODO = "todo";
    private static final String COMMAND_DEADLINE = "deadline";
    private static final String COMMAND_EVENT = "event";
    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_DONE = "done";
    private static final String COMMAND_BYE = "bye";
    private static final String COMMAND_DELETE = "delete";

    /* List of user command parameters */
    private static final String PARAM_AT = " /at ";
    private static final String PARAM_BY = " /by ";

    /**
     * Handles user I/O.
     */
    private static final Scanner SC = new Scanner(System.in);

    /**
     * Stores a list of user tasks
     */
    private static final ArrayList<Task> TASKS = new ArrayList<>();

    private static final FileManager FILE_MANAGER = new FileManager();

    public static void main(String[] args) {
        printWelcome();
        loadDataFromDisk();
        while (SC.hasNextLine()) {
            String input = getUserInput();
            executeUserCommand(input);
        }
    }

    /**
     * Displays welcome message.
     */
    public static void printWelcome() {
        System.out.println(MESSAGE_INTRO);
        System.out.println(MESSAGE_BODY);
    }

    /**
     * Displays the completed task.
     * @param taskNo user specified task number
     */
    public static void printMarkAsDone(int taskNo) {
        printWithDividers(MESSAGE_DONE_TASK, TASKS.get(taskNo).toString());
    }

    /**
     * Displays a list of tasks available.
     */
    public static void printListOfTasks() {
        System.out.println(DIVIDER);
        System.out.println(MESSAGE_LIST_TASK);
        for (int i = 0; i < TASKS.size(); i++) {
            System.out.println((i+1) + ". " + TASKS.get(i));
        }
        System.out.println(DIVIDER);
    }

    /**
     * Displays message whenever a new task is added.
     * @param task user specified duke.task.Task
     */
    public static void printAddTask(Task task) {
        String taskCount = "Now you have " + TASKS.size() + " tasks in the list.";
        printWithDividers(MESSAGE_ADD_TASK, task.toString(), taskCount);
    }

    public static void printRemoveTask(int taskNo) {
        String taskCount = "Now you have " + (TASKS.size()-1) + " tasks in the list.";
        printWithDividers(MESSAGE_DELETE_TASK, TASKS.get(taskNo).toString(), taskCount);
    }

    /**
     * Displays a message enclosed within dividers.
     * @param message user specified message(s)
     */
    public static void printWithDividers(String... message) {
        System.out.println(DIVIDER);
        for (String m : message) {
            System.out.println(m);
        }
        System.out.println(DIVIDER);
    }

    /**
     * Displays goodbye message and exits the program.
     */
    public static void exitProgram() {
        System.out.println(MESSAGE_GOODBYE);
        System.exit(0);
    }

    /**
     * Reads texts entered by user on command line
     * @return a String of text entered by the user
     */
    public static String getUserInput() {
        return SC.nextLine().trim();
    }

    /**
     * Handles and executes command entered by user
     * @param input raw input from user
     */
    public static void executeUserCommand(String input) {
        String[] processedInputs = processUserInput(input);
        String command = processedInputs[0];
        String args = processedInputs[1];

        try {
            switch (command) {
            case COMMAND_TODO:
                addToDo(args);
                break;
            case COMMAND_DEADLINE:
                addDeadline(args);
                break;
            case COMMAND_EVENT:
                addEvent(args);
                break;
            case COMMAND_DONE:
                processTaskAsDone(args);
                break;
            case COMMAND_LIST:
                printListOfTasks();
                break;
            case COMMAND_DELETE:
                deleteTask(args);
                break;
            case COMMAND_BYE:
                saveDataToDisk();
                exitProgram();
            default:
                throw new DukeException(ERROR_INVALID_COMMAND);
            }
        } catch (DukeException e) {
            printWithDividers(e.getMessage());
        }

    }

    /**
     * Separates user input into command word and command arguments.
     * @param input raw input from user
     * @return 2 element String array; first element is the command and second element is argument string
     */
    public static String[] processUserInput(String input) {
        String[] tokens = input.split(" ", 2);
        // if user has 2 or more arguments, return as usual
        // else, return just the single command and leave arguments as empty
        return (tokens.length == 2) ? tokens : new String[] {tokens[0], ""};
    }

    /**
     * Adds a ToDo task into TASKS.
     * @param task user specified ToDo task
     */
    public static void addToDo(String task) throws DukeException {
        if (task.isEmpty()) {
            throw new DukeException(ERROR_TODO);
        }
        addTask(new ToDo(task));
    }

    /**
     * Adds a duke.task.Deadline task into TASKS.
     * @param args user specified duke.task.Deadline arguments
     */
    public static void addDeadline(String args) throws DukeException {
        try {
            String[] tokens = args.split(PARAM_BY);
            String task = tokens[0].trim();
            String dateTime = tokens[1].trim();
            addTask(new Deadline(task, dateTime));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException(ERROR_DEADLINE);
        }
    }

    /**
     * Adds an duke.task.Event task into TASKS.
     * @param args user specified duke.task.Event arguments
     */
    public static void addEvent(String args) throws DukeException {
        try {
            String[] tokens = args.split(PARAM_AT);
            String task = tokens[0].trim();
            String dateTime = tokens[1].trim();
            addTask(new Event(task, dateTime));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException(ERROR_EVENT);
        }

    }

    /**
     * Processes a task as Done.
     * @param args user specified argument
     */
    public static void processTaskAsDone(String args) throws DukeException {
        try {
            int taskNum = getTaskNumber(args);
            if (validateTaskNumber(taskNum)) {
                TASKS.get(taskNum).markAsDone();
                printMarkAsDone(taskNum);
            } else {
                throw new DukeException(ERROR_INVALID_TASK_NUMBER);
            }
        } catch (NumberFormatException e) {
            printWithDividers(ERROR_NUMBER_FORMAT);
        }
    }

    /**
     * Adds a new task into TASKS.
     * @param task user defined task
     */
    public static void addTask(Task task) {
        TASKS.add(task);
        printAddTask(task);
    }

    public static void deleteTask(String args) throws DukeException {
        try {
            int taskNum = getTaskNumber(args);
            if (validateTaskNumber(taskNum)) {
                printRemoveTask(taskNum);
                TASKS.remove(taskNum);
            } else {
                throw new DukeException(ERROR_INVALID_TASK_NUMBER);
            }
        } catch (NumberFormatException e) {
            System.out.println(ERROR_NUMBER_FORMAT);
        }
    }

    /**
     * Checks if user given task number is valid.
     * @param taskNum user specified task number
     * @return true if task number is valid
     */
    public static boolean validateTaskNumber(int taskNum) {
        return taskNum >= 0 && taskNum < TASKS.size();
    }

    /**
     * Parses a String defined task number into Integer with 0-based indexing.
     * @param number user specified task number
     * @return 0-based index integer value
     */
    public static int getTaskNumber(String number) {
        return Integer.parseInt(number) - 1;
    }

    public static void saveDataToDisk() {
        FILE_MANAGER.writeToFile(parseListToString(TASKS));
    }

    public static String parseListToString(ArrayList<Task> tasks) {
        String saveTxt = "";
        for (Task t : tasks) {
            saveTxt += parseTaskToString(t);
        }
        return saveTxt;
    }

    public static String parseTaskToString(Task t) {
        if (t instanceof Deadline) {
            Deadline d = (Deadline) t;
            return String.format("%s | %d | %s | %s\n", d.getIcon(), d.hasDone() ? 1 : 0, d.getDescription(), d.getBy());
        } else if (t instanceof Event) {
            Event e = (Event) t;
            return String.format("%s | %d | %s | %s\n", e.getIcon(), e.hasDone() ? 1 : 0, e.getDescription(), e.getAt());
        }
        return String.format("%s | %d | %s\n", t.getIcon(), t.hasDone() ? 1 : 0, t.getDescription());
    }

    public static void loadDataFromDisk() {
        String data = FILE_MANAGER.readSavedFile();
        if (!data.isEmpty()) {
            String[] tokens = data.split("\n");
            for (String line : tokens) {
                parseToArrayList(line);
            }
        }
    }

    public static void parseToArrayList(String line) {
        try {
            String[] tokens = line.split("\\s\\|\\s");

            String icon = tokens[0];
            boolean isDone = Integer.parseInt(tokens[1]) == 1;
            String description = tokens[2];

            Task t;
            switch(icon) {
            case "D":
                String by = tokens[3];
                t = new Deadline(description, by);
                break;
            case "E":
                String at = tokens[3];
                t = new Event(description, at);
                break;
            default:
                t = new ToDo(description);
                break;
            }

            if (isDone) {
                t.markAsDone();
            }

            TASKS.add(t);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Error occurred while reading from file. Unable to load saved data.");
        }
    }
}
