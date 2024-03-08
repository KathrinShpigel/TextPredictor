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

    /**
     * Utility class containing ANSI escape codes for text color formatting in the console.
     */
    public static class ConsoleColors {
        /**
         * ANSI escape code to reset text color
         */
        public static final String RESET = "\033[0m";

        /**
         * ANSI escape code for base text colors
         */
        public static final String RED = "\033[0;31m";
        public static final String GREEN = "\033[0;32m";
        public static final String YELLOW = "\033[0;33m";
        public static final String BLUE = "\033[0;34m";
    }
}
