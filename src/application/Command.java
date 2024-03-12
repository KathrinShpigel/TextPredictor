package application;

/**
 * Enum representing commands that can be entered by the user
 */
public enum Command {
    /**
     * Command to quit the application
     */
    QUIT(0),

    /**
     * Command to change the limit of suggestions
     */
    LIMIT(1);

    private final int value;

    Command(int value) {
        this.value = value;
    }

    /**
     * Gets the integer value associated with this enum constant
     *
     * @return the integer value of the enum constant
     */
    public int getValue() {
        return value;
    }

    /**
     * Retrieves the Command enum constant associated with the specified integer value
     *
     * @param value the integer value representing the Command enum constant
     * @return the Command enum constant corresponding to the specified value, or null if no matching enum constant is found
     */
    public static Command fromValue(int value) {
        for (Command command : Command.values()) {
            if (command.getValue() == value) {
                return command;
            }
        }
        return null;
    }
}
