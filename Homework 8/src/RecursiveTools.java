import java.lang.reflect.Array;
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

    public int sizeOfList(List<String> l) {
        ArrayList<String> list = new ArrayList<>(l);
        return sizeOfListHelp(list);
    }

    private int sizeOfListHelp(ArrayList<String> temp) {
        if (temp.isEmpty()) {
            return 0;
        }
        temp.remove(0);
        return 1 + sizeOfList(temp);
    }

    public boolean stringEqualityTest(String s1, String s2) {
        if (s1.length() == 0) {
            return s2.length() == 0;
        }
        if (s2.length() == 0) {
            return false;
        }
        char temp1 = s1.charAt(s1.length()-1);
        char temp2 = s2.charAt(s2.length()-1);
        s1 = (new StringBuilder(s1)).deleteCharAt(s1.length()-1).toString();
        s2 = (new StringBuilder(s2)).deleteCharAt(s2.length()-1).toString();
        return temp1 == temp2 && stringEqualityTest(s1, s2);
    }


    public boolean listEqualityTest(ArrayList<String> l1, ArrayList<String> l2) {
        ArrayList<String> list1 = new ArrayList<>(l1);
        ArrayList<String> list2 = new ArrayList<>(l2);
        return listEqualityTestHelp(list1, list2);
    }

    public boolean listEqualityTestHelp(ArrayList<String> l1, ArrayList<String> l2) {
        if (l1.size() == 0) {
            return l2.size() == 0;
        }
        if (l2.size() == 0) {
            return false;
        }
        return stringEqualityTest(l1.remove(0), l2.remove(0)) && listEqualityTestHelp(l1, l2);
    }

    public boolean listCustomComparison(ArrayList<String>l1, ArrayList<String> l2) {
        if (sizeOfList(l1) == 0 && sizeOfList(l2) == 0) {
            return true;
        }
        if (sizeOfList(l1) != sizeOfList(l2)) {
            return false;
        }
        return listCustomComparison(l1, l2, 0);
    }

    private boolean listCustomComparison(ArrayList<String>l1, ArrayList<String> l2, int i) {
        if (sizeOfList(l1) == i) {
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



