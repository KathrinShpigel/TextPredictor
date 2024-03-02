import core.TextPredictionProvider;
import core.TextPredictor;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TextPredictor textPredictor = new TextPredictionProvider(3);

        String test7 = "I eat you eat we eat they eat they eat they eat";
        System.out.println(Arrays.toString(textPredictor.getNextWordSuggestions(test7)));
    }
}
