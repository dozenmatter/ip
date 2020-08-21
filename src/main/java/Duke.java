import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("____________________________________________________________\n" +
                " Hello! I'm Duke\n" +
                " What can I do for you?\n" +
                "____________________________________________________________");
        List<String> al = new ArrayList<String>();
        while(true){
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            if (input.equals("bye")) {
                System.out.println(" Bye. Hope to see you again soon!");
                return;
            }

            if (input.equals("list")){
                if (al.isEmpty()){
                    System.out.println("The list is currently empty!");
                } else {
                    for (int i = 0; i < al.size(); i++){
                        System.out.println((i+1) + ". " + al.get(i));
                    }
                }
                continue;
            }
            al.add(input);
            System.out.println("added: " + input);
        }
    }
}
