import java.util.Arrays;
import java.util.HashSet;

public class PuppyNames {

    public HashSet<String> names(HashSet<String> cards, HashSet<String> topNames) {
        cards.addAll(topNames);
        return cards;
    }

//    public static void main(String[] args) {
//        String[] cardsArray = {"Bob","Marley","Sam","Roxy","Bucky","Gus","Missy"};
//        String[] topNamesArray = {"Winston","Grant","Sam","Roxy","Bucky","Gus","Adam", "Beethoven", "June", "Rosy", "Han", "Willy"};
//        HashSet<String> cards = new HashSet<>(Arrays.asList(cardsArray));
//        HashSet<String> topNames = new HashSet<>(Arrays.asList(topNamesArray));
//        System.out.println(names(cards, topNames));
//    }
}
