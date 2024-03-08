import enums.Command;
import core.MapPredictor;
import core.TextPredictor;
import services.ConsoleHelper;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static constants.ConsoleColors.*;
import static constants.ConsoleColors.RESET;

public class Application {
    private TextPredictor textPredictor;
    private Scanner scanner;

    public Application() {
        try {
            textPredictor = new MapPredictor(3);
            scanner = new Scanner(System.in);
        } catch (IllegalArgumentException exception) {
            ConsoleHelper.displayErrorMessage(exception.getMessage());
        }
    }

    /**
     * Starts the application, running an interactive loop to handle user input
     * Within the loop:
     * 1. Displays the available options to the user
     * 2. Prompts the user to enter a command or word
     * 3. Parses the input to determine if it corresponds to a command or a word
     * 4. If a command is detected, processes the command accordingly
     * 5. If the input is not recognized as a command, treats it as a word and attempts to provide suggestions
     * The loop continues indefinitely until the application is terminated
     */
    public void run() {
        while (true) {
            ConsoleHelper.displayOptions();
            System.out.println(String.format("Please enter next word %s", GREEN));
            String answer = scanner.nextLine();
            Command command = Command.fromString(answer);

            if (command != null) {
                processCommand(command);
            } else {
                handleWordSuggestions(answer);
            }
        }
    }

    private void rollbackModel() {
        textPredictor.clearDictionary();
        ConsoleHelper.printSuccessMessage("The model has been rolled back successfully");
    }

    private void changeLimit() {
        System.out.println(String.format("%sPlease enter new suggestions limit:%s", RESET, GREEN));
        try {
            int limit = scanner.nextInt();
            scanner.nextLine();
            textPredictor.setPredictionLimit(limit);
            ConsoleHelper.printSuccessMessage("The suggestions limit has been changed successfully");
        } catch (InputMismatchException exception) {
            ConsoleHelper.displayErrorMessage("Suggestions limit must be a number");
            scanner.nextLine(); // Consume invalid input
        } catch (IllegalArgumentException exception) {
            ConsoleHelper.displayErrorMessage(exception.getMessage());
        }
    }

    private void handleWordSuggestions(String word) {
        ArrayList<String> suggestions = textPredictor.getNextWordSuggestions(word);
        if (suggestions.isEmpty()) {
            System.out.println(String.format("%sUnfortunately, there are no suggestions for the word \"%s\"\n", RESET, word));
        } else {
            System.out.println(String.format("%sHere are suggestions for the word \"%s\" => %s\n", RESET, word, suggestions));
        }
    }

    private void processCommand(Command command) {
        switch (command) {
            case QUIT:
                System.exit(0); // Terminate the application
                break;
            case ROLLBACK:
                rollbackModel();
                break;
            case LIMIT:
                changeLimit();
                break;
        }
    }
}
