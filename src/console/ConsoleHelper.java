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
     * Prints the option to the console with the specified description and color.
     * This method is intended for printing a single option.
     *
     * @param option      the option to print
     * @param description the description of the option
     * @param color       the color to use for displaying the option
     * @param <Option>    the enum type representing the options
     */
    public static <Option extends Enum<Option>> void printOption(Option option, String description, String color) {
        System.out.println(String.format("%s> %s\"%s\"%s %s", RESET, color, option, RESET, description));
    }
}
