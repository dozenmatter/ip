import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        introduce();

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
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < tasks.size(); i++){
                        Task t = tasks.get(i);
                        System.out.printf("%d.[%s] %s\n", (i+1), t.getStatusIcon(), t.getDescription());
                    }
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

            tasks.add(new Task(input));
            System.out.println("added: " + input);
        }
    }

    public static void introduce(){
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
