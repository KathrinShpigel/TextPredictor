package application;

import static application.ConsoleColors.*;

/**
 * Utility class providing methods for console-related functionalities such as displaying messages and options
 */
public class ConsoleHelper {
    /**
     * Displays an error message in red color
     *
     * @param message the error message to display
     */
    public static void displayErrorMessage(String message) {
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
     * Displays the available options to the user, including commands to quit, and change the limit of suggestions
     * The options are displayed with appropriate colors for better visibility
     */
    public static void displayOptions() {
        System.out.println(String.format("%s> %s\"%s\"%s to quit from the app", RESET, RED, Command.QUIT, RESET));
        System.out.println(String.format("> %s\"%s\"%s to change the limit of suggestions", YELLOW, Command.LIMIT, RESET));
    }
}
