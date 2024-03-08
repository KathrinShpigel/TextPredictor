package core;

import java.util.*;

public class MapPredictor implements TextPredictor {
    private Map<String, Map<String, Integer>> dictionary = new HashMap<>();
    private int numOfWords;

    public MapPredictor(int numOfWords) throws IllegalArgumentException {
        setPredictionLimit(numOfWords);
    }

    public void setPredictionLimit(int numOfWords) throws IllegalArgumentException {
        if (numOfWords <= 0) {
            throw new IllegalArgumentException("Argument must be greater than 0");
        }

        this.numOfWords = numOfWords;
    }

    public void addText(String text) {
        if (text == null || text.isEmpty()) return;

        ArrayList<String> words = TextHelper.extractWords(text);

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

    public ArrayList<String> getNextWordSuggestions(String word) {
        ArrayList<String> suggestions = new ArrayList<>();
        word = TextHelper.convertToLowerCase(TextHelper.cleanText(word));

        if (word == null || word.isEmpty()) return suggestions;

        if (dictionary.containsKey(word) && dictionary.get(word).size() >= numOfWords) {
            Map<String, Integer> frequencies = dictionary.get(word);
            List<Integer> topFrequencies = getTopFrequencies(frequencies);

            for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
                if (topFrequencies.contains(entry.getValue())) {
                    int index = topFrequencies.indexOf(entry.getValue());
                    String key = entry.getKey();
                    suggestions.add(key);
                    topFrequencies.set(index, -1);
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
