import java.util.ArrayList;
import java.util.List;

public class RecursiveTools {

    public String reverseString(String str) {
        if (str.length() <= 1) {
            return str;
        }
        char temp = str.charAt(str.length()-1);
        str = (new StringBuilder(str)).deleteCharAt(str.length()-1).toString();
        return temp + reverseString(str);
    }

    public int sizeOfList (ArrayList<String> l) {
        if (l.size() == 0) {
            return 0;
        }
        l.remove(0);
        return 1 + sizeOfList(l);
    }

    public boolean stringEqualityTest(String s1, String s2) {
        char temp1 = s1.charAt(s1.length()-1);
        char temp2 = s2.charAt(s2.length()-1);
        s1 = (new StringBuilder(s1)).deleteCharAt(s1.length()-1).toString();
        s2 = (new StringBuilder(s2)).deleteCharAt(s2.length()-1).toString();
        return temp1 == temp2 && stringEqualityTest(s1, s2);
    }


    public boolean listEqualityTest(ArrayList<String> l1, ArrayList<String> l2) {
        if (l1.size() != l2.size()) {
            return false;
        }
        return listEqualityTest(l1,l2,0);
    }

    private boolean listEqualityTest(ArrayList<String> l1, ArrayList<String> l2, int i) {
        if (l1.size() == i && l2.size() == i) {
            return true;
        }
        return stringEqualityTest(l1.get(i), l2.get(i)) && listEqualityTest(l1,l2,i+1);
    }

    public boolean listCustomComparison(ArrayList<String>l1, ArrayList<String> l2) {
        if (sizeOfList((ArrayList<String>) l1.clone()) == 0 || sizeOfList((ArrayList<String>) l1.clone()) == 0) {
            return false;
        }
        if (sizeOfList((ArrayList<String>) l1.clone()) != sizeOfList((ArrayList<String>) l1.clone())) {
            return false;
        }
        return listCustomComparison(l1, l2, 0);
    }

    private boolean listCustomComparison(ArrayList<String>l1, ArrayList<String> l2, int i) {
        if (sizeOfList((ArrayList<String>) l1.clone()) == i) {
            return true;
        }
        if (i % 2 == 1) {
            if (!stringEqualityTest(l1.get(0), reverseString(l2.get(0)))) {
                return false;
            }
        }
        return listCustomComparison(l1, l2, i+1);
    }
}



