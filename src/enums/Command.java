package enums;

/**
 * Enum representing commands that can be entered by the user
 */
public enum Command {
    /**
     * Command to quit the application
     */
    QUIT,

    /**
     * Command to rollback the model
     */
    ROLLBACK,

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
        switch (text.toLowerCase()) {
            case "quit":
                return QUIT;
            case "rollback":
                return ROLLBACK;
            case "limit":
                return LIMIT;
            default:
                return null;
        }
    }
}
