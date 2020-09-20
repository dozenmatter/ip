package duke.store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Saving and loading of saved data
 */
public class Storage {
    private static final String CURRENT_DIR = System.getProperty("user.dir");
    private static final String SEPARATOR = File.separator;

    private File saveFile;

    /**
     * Instantiates a Storage object with save file path.
     *
     * @param filePath save file path
     */
    public Storage(String filePath) {
        try {
            filePath = CURRENT_DIR + filePath.replace("/", SEPARATOR).replace("\\", SEPARATOR);
            saveFile = new File(filePath);

            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }

            if (!saveFile.exists()) {
                saveFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(filePath + " creation failed.");
        }
    }

    /**
     * Saves task list into a file.
     *
     * @param content list of tasks
     */
    public void save(String content) {
        try {
            FileWriter fileWriter = new FileWriter(saveFile);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Write to " + saveFile.getName() + " failed.");
        }
    }

    /**
     * Loads data from file into a String object.
     *
     * @return a String object containing saved data
     */
    public String load() {
        String data = "";
        try {
            Scanner sc = new Scanner(saveFile);
            while(sc.hasNextLine()) {
                data += sc.nextLine() + "\n";
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to read from " + saveFile.getName());
        }

        return data;
    }
}
