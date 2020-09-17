package duke.task;

import duke.exception.DukeException;
import java.util.ArrayList;

/**
 * Stores a list of tasks
 */
public class TaskList {
    private ArrayList<Task> tasks;

    private static final String ERROR_READ_DATA = "Error occurred while reading from file. Unable to load saved data.";

    /**
     * Instantiates a TaskList object with saved data.
     *
     * @param data a list of saved tasks
     * @throws DukeException if saved data is corrupted
     */
    public TaskList(String data) throws DukeException {
        tasks = new ArrayList<>();

        if (!data.isEmpty()) {
            String[] lines = data.split("\n");
            for (String line : lines) {
                parseToArrayList(line);
            }
        }
    }

    /**
     * Instantiates a new empty TaskList object.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Parses a string of tasks into an ArrayList of tasks.
     *
     * @param line string of tasks
     * @throws DukeException if string cannot be parsed
     */
    public void parseToArrayList(String line) throws DukeException {
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

            tasks.add(t);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new DukeException(ERROR_READ_DATA);
        }
    }

    /**
     * Returns the size of the list.
     *
     * @return an integer containing size of list
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Adds a task into the list.
     *
     * @param t user specified task
     */
    public void addTask(Task t) {
        tasks.add(t);
    }

    /**
     * Removes a task from the list.
     *
     * @param index user specified task integer index
     */
    public void deleteTask(int index) {
        tasks.remove(index);
    }

    /**
     * Returns a Task object.
     *
     * @param index user specified task integer index
     * @return a Task object
     */
    public Task get(int index) {
        return tasks.get(index);
    }

    /**
     * Returns a string of TaskList.
     *
     * @return a String of tasks
     */
    @Override
    public String toString() {
        String saveTxt = "";
        for (Task task : tasks) {
            saveTxt += parseTaskToString(task);
        }
        return saveTxt;
    }

    /**
     * Parses a specific task into a formatted String for saving.
     *
     * @param t user task
     * @return a String formatted task delimited by |
     */
    private String parseTaskToString(Task t) {
        if (t instanceof Deadline) {
            Deadline d = (Deadline) t;
            return String.format("%s | %d | %s | %s\n", d.getIcon(), d.hasDone() ? 1 : 0, d.getDescription(), d.getBy());
        } else if (t instanceof Event) {
            Event e = (Event) t;
            return String.format("%s | %d | %s | %s\n", e.getIcon(), e.hasDone() ? 1 : 0, e.getDescription(), e.getAt());
        }
        return String.format("%s | %d | %s\n", t.getIcon(), t.hasDone() ? 1 : 0, t.getDescription());
    }
}
