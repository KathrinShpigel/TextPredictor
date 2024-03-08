package core;

import java.util.ArrayList;

/**
 * Interface for a text predictor, which suggests next word predictions based on input text.
 */
public interface TextPredictor {
    /**
     * Sets the limit for the number of words in the predictions.
     *
     * @param numOfWords the maximum number of words to include in the predictions
     * @throws IllegalArgumentException If the argument is less than 0
     */
    void setPredictionLimit(int numOfWords);

    /**
     * Trains the predictor model using the provided sentence.
     *
     * @param text the sentence used for training the predictor model
     */
    void addText(String text);

    /**
     * Retrieves the next word suggestions based on the given sentence.
     *
     * @param word the input sentence to generate predictions for
     * @return an arrayList of suggested next words
     */
    ArrayList<String> getNextWordSuggestions(String word);

    /**
     * Clears the dictionary or model used for predictions.
     */
    void clearDictionary();
}
