package file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
        try {
            return Files.readAllLines(Path.of(filePath)).toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
