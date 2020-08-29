import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    private static final String BORDER = "____________________________________________________________";

    public static void main(String[] args) {
        printWelcome();

        Scanner sc = new Scanner(System.in);
        List<Task> tasks = new ArrayList<Task>();
        while (sc.hasNextLine()) {
            String input = sc.nextLine().trim();
            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                return;
            }

            if (input.equals("list")){
                if (tasks.isEmpty()){
                    System.out.println("The list is currently empty!");
                } else {
                    System.out.println(BORDER);
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < tasks.size(); i++){
                        System.out.printf("%d. %s\n", (i+1), tasks.get(i));
                    }
                    System.out.println(BORDER);
                }
                continue;
            }

            if (input.matches("done [0-9]+")) {
                int id = Integer.parseInt(input.split(" ")[1]) - 1;

                Task task = tasks.get(id);

                if (task.isDone) {
                    System.out.println("Task has been completed!");
                    continue;
                }

                task.markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.printf(" [%s] %s\n", task.getStatusIcon(), task.getDescription());
                continue;
            }

            if (input.startsWith("todo")) {
                String task = input.substring(5);
                tasks.add(new ToDo(task));

            } else if (input.startsWith("deadline")) {
                String[] tokens = input.substring(9).split("/by");
                String task = tokens[0].trim();
                String by = tokens[1].trim();
                tasks.add(new Deadline(task, by));

            } else if (input.startsWith("event")) {
                String[] tokens = input.substring(6).split("/at");
                String task = tokens[0].trim();
                String at = tokens[1].trim();
                tasks.add(new Event(task, at));
            }

            int size = tasks.size();
            System.out.println(BORDER);
            System.out.println("Got it. I've added this task:");
            System.out.println(tasks.get(size-1));
            System.out.println("Now you have " + size + " tasks in the list.");
            System.out.println(BORDER);
        }
    }

    public static void printWelcome(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

}
