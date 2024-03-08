package core;

import java.util.ArrayList;
import java.util.List;

/**
 * The Helper class provides utility methods for text processing.
 */
public class Helper {
    /**
     * Cleans the given text by removing special characters, while preserving letters and spaces.
     *
     * @param text the text to be cleaned
     * @return the cleaned text with only letters and spaces
     */
    public static String cleanText(String text) {
        if (text == null) return new String();

        return text.trim().replaceAll(Constants.CLEAN_TEXT_REGEX, "").replaceAll("\\s+", " ");
    }

    /**
     * Converts all words in the given text to lowercase.
     *
     * @param text the text to convert
     * @return the text with all words converted to lowercase
     */
    public static String convertToLowerCase(String text) {
        if (text == null) return new String();

        return text.toLowerCase();
    }

    /**
     * Cleans the text, converts all words to lowercase, and splits it into a list of words.
     *
     * @param text the text to be processed
     * @return a list of words extracted from the processed text
     */
    public static ArrayList<String> extractWords(String text) {
        ArrayList<String> result = new ArrayList<>();

        if (text == null) return result;

        String preparedText = convertToLowerCase(cleanText(text));

        if (preparedText.isEmpty()) return result;

        result.addAll(List.of(preparedText.split(" ")));

        return result;
    }
}
