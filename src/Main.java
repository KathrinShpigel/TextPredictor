import core.MapPredictor;
import core.TextPredictor;

public class Main {
    public static void main(String[] args) {
        try {
            TextPredictor textPredictor = new MapPredictor(3);

            String test1 = "";
            textPredictor.addText(test1);
            System.out.println(textPredictor.getNextWordSuggestions(test1).toString()); // []

            String test2 = "        ";
            textPredictor.addText(test2);
            System.out.println(textPredictor.getNextWordSuggestions(test2.substring(test2.lastIndexOf(" ") + 1)).toString()); // []

            String test3 = "!@#$%^&*() 1234567890 !@#$%^&*() _____ !@#$%^&*() ++++++ !@#$%^&*() ////// !@#$%^&*()";
            textPredictor.addText(test3);
            System.out.println(textPredictor.getNextWordSuggestions(test3.substring(test3.lastIndexOf(" ") + 1)).toString()); // []


            String test4 = "\n\n\n 2 apples, \n 5 dollars, 2 apples, \n 6 cats, 2 apples, 12 things, 2 apples,\n 1 \n ";
            textPredictor.addText(test4);
            System.out.println(textPredictor.getNextWordSuggestions("apples").toString()); // [cats, things, dollars]

            String test5 = "I eat you eat we eat they eat they eat  they eat they eat we eat";
            textPredictor.addText(test5);
            System.out.println(textPredictor.getNextWordSuggestions("eat").toString()); // [they, we, you]

            String test6 = "čćšđž street čćšđž city čćšđž place čćšđž world čćšđž street čćšđž world čćšđž street čćšđž";
            textPredictor.addText(test6);
            System.out.println(textPredictor.getNextWordSuggestions("čćšđž").toString()); // [street, world, city]
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
