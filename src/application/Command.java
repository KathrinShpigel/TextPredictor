package application;

/**
 * Enum representing commands that can be entered by the user
 */
public enum Command {
    /**
     * Command to quit the application
     */
    QUIT,

    /**
     * Command to change the limit of suggestions
     */
    LIMIT;

    /**
     * Parses a string input into a corresponding Command enum value.
     *
     * @param text the string input representing a command
     * @return the Command enum value corresponding to the input, or null if no matching command is found
     */
    public static Command fromString(String text) {
        return switch (text.toLowerCase()) {
            case "quit" -> QUIT;
            case "limit" -> LIMIT;
            default -> null;
        };
    }
}
