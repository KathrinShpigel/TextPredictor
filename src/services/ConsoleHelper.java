package services;

import enums.Command;

import static constants.ConsoleColors.*;
import static constants.ConsoleColors.RESET;

public class ConsoleHelper {
    public static void displayErrorMessage(String message) {
        System.out.println(String.format("%s%s%s\n", RED, message, RESET));
    }

    public static void displayOptions() {
        System.out.println(String.format("%s> %s\"%s\"%s to quit from the app", RESET, RED, Command.QUIT, RESET));
        System.out.println(String.format("> %s\"%s\"%s to rollback model", BLUE, Command.ROLLBACK, RESET));
        System.out.println(String.format("> %s\"%s\"%s to change the limit of suggestions", YELLOW, Command.LIMIT, RESET));
    }

    public static void printSuccessMessage(String message) {
        System.out.println(String.format("%s%s%s\n", GREEN, message, RESET));
    }
}
