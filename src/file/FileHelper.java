package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A helper class providing methods for file-related operations
 */
public class FileHelper {
    /**
     * Reads text from a file and returns it as a String
     *
     * @param filePath The path to the text file
     * @return The text read from the file
     * @throws FileNotFoundException If the file is not found
     */
    public static String readTextFromFile(String filePath) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            result.append(scanner.nextLine()).append("\n");
        }

        scanner.close();
        return result.toString();
    }
}
