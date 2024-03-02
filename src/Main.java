import core.TextPredictionProvider;
import core.TextPredictor;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TextPredictor textPredictor = new TextPredictionProvider(3);

        String test1 = "";
        System.out.println(Arrays.toString(textPredictor.getNextWordSuggestions(test1))); // [null, null, null]

        String test2 = "        ";
        System.out.println(Arrays.toString(textPredictor.getNextWordSuggestions(test2))); // [null, null, null]

        String test3 = "!@#$%^&*() 1234567890 !@#$%^&*() _____ !@#$%^&*() ++++++ !@#$%^&*() ////// !@#$%^&*()";
        System.out.println(Arrays.toString(textPredictor.getNextWordSuggestions(test3))); // [null, null, null]

        String test4 = " 2 apples, 5 dollars, 2 apples, 6 cats, 2 apples, 12 things, 2 apples, 1 ";
        System.out.println(Arrays.toString(textPredictor.getNextWordSuggestions(test4))); // [cats, things, dollars]

        String test5 = "I eat you eat we eat they eat they eat  they eat they eat we eat";
        System.out.println(Arrays.toString(textPredictor.getNextWordSuggestions(test5))); // [they, we, you]

        String test6 = "čćšđž street čćšđž city čćšđž place čćšđž world čćšđž street čćšđž world čćšđž street čćšđž";
        System.out.println(Arrays.toString(textPredictor.getNextWordSuggestions(test6))); // [street, world, city]
    }
}
