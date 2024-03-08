import core.MapPredictor;
import core.TextPredictor;
import enums.Command;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static constants.ConsoleColors.*;

public class Main {
    private static final String PROMPT_PREFIX = "> ";

    public static void main(String[] args) {
        try {
            TextPredictor textPredictor = new MapPredictor(3);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                displayOptions();
                System.out.println(String.format("Please enter next word %s", GREEN));

                String answer = scanner.nextLine();
                Command command = Command.fromString(answer);

                if (command != null) {
                    processCommand(command, textPredictor, scanner);
                } else {
                    handleWordSuggestions(answer, textPredictor);
                }
            }
        } catch (IllegalArgumentException exception) {
            displayErrorMessage(exception.getMessage());
        }
    }

    private static void displayErrorMessage(String message) {
        System.out.println(String.format("%s%s%s\n", RED, message, RESET));
    }

    private static void displayOptions() {
        System.out.println(String.format("%s%s %s\"%s\"%s to quit from the app", RESET, PROMPT_PREFIX, RED, Command.QUIT, RESET));
        System.out.println(String.format("%s %s\"%s\"%s to rollback model", PROMPT_PREFIX, BLUE, Command.ROLLBACK, RESET));
        System.out.println(String.format("%s %s\"%s\"%s to change the limit of suggestions", PROMPT_PREFIX, YELLOW, Command.LIMIT, RESET));
    }

    private static void rollbackModel(TextPredictor textPredictor) {
        textPredictor.clearDictionary();
        System.out.println(String.format("%sThe model has been rolled back successfully%s\n", BLUE, RESET));
    }

    private static void changeLimit(TextPredictor textPredictor, Scanner scanner) {
        System.out.println(String.format("%sPlease enter new suggestions limit:%s", RESET, GREEN));
        try {
            int limit = scanner.nextInt();
            scanner.nextLine();
            textPredictor.setPredictionLimit(limit);
            System.out.println(String.format("%sThe suggestions limit has been changed successfully%s\n", YELLOW, RESET));
        } catch (InputMismatchException exception) {
            displayErrorMessage("Suggestions limit must be a number");
            scanner.nextLine(); // Consume invalid input
        } catch (IllegalArgumentException exception) {
            displayErrorMessage(exception.getMessage());
        }
    }

    private static void handleWordSuggestions(String word, TextPredictor textPredictor) {
        ArrayList<String> suggestions = textPredictor.getNextWordSuggestions(word);
        if (suggestions.isEmpty()) {
            System.out.println(String.format("%sUnfortunately, there are no suggestions for the word \"%s\"\n", RESET, word));
        } else {
            System.out.println(String.format("%sHere are suggestions for the word \"%s\" => %s\n", RESET, word, suggestions));
        }
    }

    private static void processCommand(Command command, TextPredictor textPredictor, Scanner scanner) {
        switch (command) {
            case QUIT:
                System.exit(0); // Terminate the application
                break;
            case ROLLBACK:
                rollbackModel(textPredictor);
                break;
            case LIMIT:
                changeLimit(textPredictor, scanner);
                break;
        }
    }
}
