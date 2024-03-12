package console;

import java.util.Map;

import static console.ConsoleColors.*;

/**
 * Utility class providing methods for console-related functionalities such as displaying messages and options
 */
public class ConsoleHelper {
    /**
     * Prints an error message in red color
     *
     * @param message the error message to print
     */
    public static void printErrorMessage(String message) {
        System.out.println(String.format("%s%s%s\n", RED, message, RESET));
    }

    /**
     * Prints a success message in green color
     *
     * @param message the success message to print
     */
    public static void printSuccessMessage(String message) {
        System.out.println(String.format("%s%s%s\n", GREEN, message, RESET));
    }

    /**
     * Prints an info message in green color
     *
     * @param message the info message to print
     */
    public static void printInfoMessage(String message) {
        System.out.println(String.format("%s%s%s", GREEN, message, RESET));
    }

    /**
     * Prints a result message with decorations
     *
     * @param message the result message to print
     */
    public static void printResultMessage(String message) {
        String decoration = "\u2605";
        int lineLength = message.length() + 4;
        String line = decoration.repeat(lineLength);

        System.out.println(String.format("\n%s\n\n%s\n%s\n", line, message, line));
    }

    /**
     * Prints the available options to the user, along with their descriptions.
     * Each option is printed in the console with the specified color for better visibility.
     *
     * @param options a map containing the options as keys and their descriptions as values
     * @param <Option> the enum type representing the options
     */
    public static <Option extends Enum<Option>> void printOptions(Map<Option, String> options) {
        for (Map.Entry<Option, String> entry : options.entrySet()) {
            Option option = entry.getKey();
            String color = entry.getValue();
            System.out.println(String.format("%s> %s\"%s\"%s to change the limit of suggestions", RESET, color, option, RESET));
        }
    }
}
