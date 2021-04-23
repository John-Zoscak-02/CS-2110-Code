import java.util.TreeMap;

public class PhoneBook {

    public static TreeMap<Integer, String> reverseBook(TreeMap<String, Integer> phoneBook) {
        TreeMap<Integer, String> temp = new TreeMap<Integer, String>();
        for ( String key : phoneBook.keySet()) {
            temp.put(phoneBook.get(key), key);
        }
        return temp;
    }

}
