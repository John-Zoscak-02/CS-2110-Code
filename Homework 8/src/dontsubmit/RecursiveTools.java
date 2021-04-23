package dontsubmit;

import java.util.ArrayList;
import java.util.List;


public class RecursiveTools {

    public String reverseString(String str) {
        return reverseString(str.toCharArray(), 0);
    }



    private String reverseString(char[] string, int i) {
        if (string.length == i) {
            return "";
        }
        return reverseString(string, i+1) + string[i];
    }



    public int sizeOfList (List<String> l) {
        return sizeOfList(l, 0);
    }



    private int sizeOfList(List temp, int i) {
        if (temp.size() == i) {
            return 0;
        }
        return 1 + sizeOfList(temp, i + 1);
    }



    public boolean stringEqualityTest(String s1, String s2) {
        return stringEqualityTest(s1,s2,0);
    }



    private boolean stringEqualityTest(String s1, String s2, int i) {
        if (s1.length() == i ) {
            if (s2.length() == i) {
                return true;
            }
            return false;
        }
        return s1.charAt(i) == s2.charAt(i) && stringEqualityTest(s1,s2,i+1);
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
        if (sizeOfList(l1) == 0 || sizeOfList(l2) == 0) {
            return true;
        }
        if (sizeOfList(l1) != sizeOfList(l2)) {
            return false;
        }
        if (sizeOfList(l1) % 2 == 1) {
            if (!stringEqualityTest(l1.get(0), reverseString(l2.get(0)))) {
                return false;
            }
            System.out.println(l1.get(0) + reverseString(l2.get(0)));
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


