package application;

import console.ConsoleHelper;
import core.MapPredictor;
import core.TextPredictor;
import file.FileHelper;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static console.ConsoleColors.*;

public class Application {
    private static final String FILE_PATH = "src/resources/dataSet/input.txt";
    private static final int NUM_OF_WORDS = 3;
    private TextPredictor textPredictor;
    private Scanner scanner;

    public Application() {
        try {
            textPredictor = new MapPredictor(NUM_OF_WORDS);
            scanner = new Scanner(System.in);
        } catch (IllegalArgumentException exception) {
            ConsoleHelper.printErrorMessage(exception.getMessage());
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
        try {
            String textFromFile = FileHelper.readTextFromFile(FILE_PATH);
            textPredictor.addText(textFromFile);

            while (true) {
                ConsoleHelper.printOption(Command.QUIT.getValue(), "to quit from the app", RED);
                ConsoleHelper.printOption(Command.LIMIT.getValue(), "to change the limit of suggestions", YELLOW);
                ConsoleHelper.printInfoMessage("Please enter next word");

                if (scanner.hasNextInt()) {
                    int answer = scanner.nextInt();

                    Command command = Command.fromValue(answer);

                    if (command != null) {
                        switch (command) {
                            case QUIT -> System.exit(0);
                            case LIMIT -> changeLimit();
                            default -> throw new IllegalStateException(String.format("Unexpected command: %s", command.getValue()));
                        }
                    }

                    ConsoleHelper.printInfoMessage("This command is unexpected\n");
                } else {
                    String answer = scanner.nextLine();
                    handleWordSuggestions(answer);
                }
            }
        } catch (FileNotFoundException exception) {
            ConsoleHelper.printErrorMessage("File not found");
        } catch (Exception exception) {
            ConsoleHelper.printErrorMessage(exception.getMessage());
        }
    }

    private void changeLimit() {
        ConsoleHelper.printInfoMessage("\nPlease enter new suggestions limit");
        try {
            int limit = scanner.nextInt();
            scanner.nextLine();
            textPredictor.setPredictionLimit(limit);
            ConsoleHelper.printSuccessMessage("\nThe suggestions limit has been changed successfully");
        } catch (InputMismatchException exception) {
            ConsoleHelper.printErrorMessage("\nSuggestions limit must be a number");
            scanner.nextLine(); // Consume invalid input
        } catch (IllegalArgumentException exception) {
            ConsoleHelper.printErrorMessage(exception.getMessage());
        }
    }

    private void handleWordSuggestions(String word) {
        List<String> suggestions = textPredictor.getNextWordSuggestions(word);
        if (suggestions.isEmpty()) {
            ConsoleHelper.printResultMessage(String.format("Unfortunately, there are no suggestions for the word \"%s\"\n", word));
        } else {
            ConsoleHelper.printResultMessage(String.format("Here are suggestions for the word \"%s\" => %s\n", word, suggestions));
        }
    }
}
