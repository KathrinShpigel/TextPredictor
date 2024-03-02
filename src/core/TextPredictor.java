package core;

/**
 * Interface for a text predictor, which suggests next word predictions based on input text.
 */
public interface TextPredictor {
    /**
     * Sets the limit for the number of words in the predictions.
     *
     * @param numOfWords the maximum number of words to include in the predictions
     */
    void setPredictionLimit(int numOfWords);

    /**
     * Trains the predictor model using the provided sentence.
     *
     * @param text the sentence used for training the predictor model
     */
    void trainModel(String text);

    /**
     * Retrieves the next word suggestions based on the given sentence.
     *
     * @param sentence the input sentence to generate predictions for
     * @return an array of suggested next words
     */
    String[] getNextWordSuggestions(String sentence);

    /**
     * Clears the dictionary or model used for predictions.
     */
    void clearDictionary();
}
