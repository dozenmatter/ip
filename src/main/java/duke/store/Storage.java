package duke.store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    private final String HOME = System.getProperty("user.dir");
    private final String SEPARATOR = File.separator;
    private final String DIRECTORY = HOME + SEPARATOR + "data" + SEPARATOR;
    private final String FILENAME = "duke.txt";
    private final File SAVE_FILE = new File(DIRECTORY + FILENAME);

    public Storage() {
        try {
            if (!SAVE_FILE.getParentFile().exists()) {
                SAVE_FILE.getParentFile().mkdirs();
            }

            if (!SAVE_FILE.exists()) {
                SAVE_FILE.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(FILENAME + " creation failed");
        }
    }

    public void save(String content) {
        try {
            FileWriter fileWriter = new FileWriter(SAVE_FILE);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Write to " + FILENAME + " failed.");
        }
    }

    public String load() {
        String data = "";
        try {
            Scanner sc = new Scanner(SAVE_FILE);
            while(sc.hasNextLine()) {
                data += sc.nextLine() + "\n";
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to read from " + FILENAME);
        }

        return data;
    }
}
