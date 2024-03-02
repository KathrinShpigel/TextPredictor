package core;

import java.util.*;

public class TextPredictionProvider implements TextPredictor {
    private Map<String, Map<String, Integer>> dictionary = new HashMap<>();
    private int numOfWords;

    public TextPredictionProvider(int numOfWords) {
        setPredictionLimit(numOfWords);
    }

    public void setPredictionLimit(int numOfWords) {
        this.numOfWords = numOfWords;
    }

    public void trainModel(String text) {
        if (text == null || text.isEmpty()) return;

        ArrayList<String> words = Helper.extractWords(text);

        while (words.size() > 1) {
            String word = words.removeFirst();
            String nextWord = words.getFirst();

            if (dictionary.containsKey(word)) {
                Map<String, Integer> value = dictionary.get(word);
                if (value.containsKey(nextWord)) {
                    value.put(nextWord, value.get(nextWord) + 1);
                } else {
                    value.put(nextWord, 1);
                }
            } else {
                Map<String, Integer> value = new HashMap<>();
                value.put(nextWord, 1);
                dictionary.put(word, value);
            }
        }
    }

    public String[] getNextWordSuggestions(String sentence) {
        String[] suggestions = new String[numOfWords];

        if (sentence == null || sentence.isEmpty()) {
            return suggestions;
        }

        trainModel(sentence);
        String word = Helper.extractWords(sentence).getLast();

        if (dictionary.containsKey(word) && dictionary.get(word).size() >= numOfWords) {
            Map<String, Integer> frequencies = dictionary.get(word);
            List<Integer> topFrequencies = getTopFrequencies(frequencies);

            int i = 0;
            for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
                if (topFrequencies.contains(entry.getValue())) {
                    int index = topFrequencies.indexOf(entry.getValue());
                    String key = entry.getKey();
                    suggestions[index] = key;
                    topFrequencies.set(index, -1);
                    if (++i > numOfWords) break;
                }
            }
        }

        return suggestions;
    }

    private List<Integer> getTopFrequencies(Map<String, Integer> frequencies) {
        List<Integer> result = new ArrayList<>(frequencies.values());
        Collections.sort(result, new DescendingIntegerComparator());
        return result.subList(0, numOfWords);
    }

    public void clearDictionary() {
        dictionary = new HashMap<>();
    }
}
