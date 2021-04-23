import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;


public class RecursiveToolsTest {

    private RecursiveTools tools;

    @Before
    public void setUp() {
        tools = new RecursiveTools();
    }

    @Test
    public void reverseStringTest1() {
        assertEquals("olleh", tools.reverseString("hello"));
    }

    @Test
    public void reverseStringTest2() {
        assertEquals(" ", tools.reverseString(" "));
    }

    @Test
    public void reverseStringTest3() {
        assertEquals("How is it going?", tools.reverseString("?gniog ti si woH"));
    }

    @Test
    public void sizeOfListTest1() {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        assertEquals(10, tools.sizeOfList(arrayList));
    }

    @Test
    public void sizeOfListTest2() {
        ArrayList<String> arrayList = new ArrayList<>();
        assertEquals(0, tools.sizeOfList(arrayList));
    }

    @Test
    public void sizeOfListTest3() {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(new String[314]));
        assertEquals(314, tools.sizeOfList(arrayList));
    }

    @Test
    public void stringEqualityTest1() {
        assertTrue(tools.stringEqualityTest("", ""));
    }

    @Test
    public void stringEqualityTest2() {
        assertFalse(tools.stringEqualityTest("hello", "quack"));
    }

    @Test
    public void stringEqualityTest3() {
        assertTrue(tools.stringEqualityTest("pnuemonoultramicroscopicsilicovolcanoconiosis", "pnuemonoultramicroscopicsilicovolcanoconiosis"));
    }

    @Test
    public void listEqualityTest1() {
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        assertTrue(tools.listEqualityTest(arrayList1, arrayList2));
    }

    @Test
    public void listEqualityTest2() {
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "not the same"));
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        assertFalse(tools.listEqualityTest(arrayList1, arrayList2));
    }

    @Test
    public void listEqualityTest3() {
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "not the same"));
        assertFalse(tools.listEqualityTest(arrayList1, arrayList2));
    }

    @Test
    public void listEqualityTest4() {
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "not the same"));
        assertFalse(tools.listEqualityTest(arrayList1, arrayList2));
    }

    @Test
    public void listEqualityTest5() {
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "not the same"));
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        assertFalse(tools.listEqualityTest(arrayList1, arrayList2));
    }
    @Test
    public void listEqualityTest6() {
        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        assertTrue(tools.listEqualityTest(arrayList1, arrayList2));
    }

    @Test
    public void listCustomComparison1() {
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        assertTrue(tools.listCustomComparison(arrayList1, arrayList2));
    }

    @Test
    public void listCustomComparison2() {
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList("10", "20", "30", "40", "50", "60", "70", "80", "90", "100"));
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList("10", "20", "30", "40", "50", "60", "70", "80", "90", "100"));
        assertFalse(tools.listCustomComparison(arrayList1, arrayList2));
    }

    @Test
    public void listCustomComparison3() {
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList("10", "20", "30", "40", "50", "60", "70", "80", "90", "100"));
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList("01", "20", "03", "40", "05", "60", "07", "80", "09", "100"));
        assertTrue(tools.listCustomComparison(arrayList1, arrayList2));
    }

    @Test
    public void listCustomComparison4() {
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList("10"));
        ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList("01"));
        assertTrue(tools.listCustomComparison(arrayList1, arrayList2));
    }

    @Test
    public void listCustomComparison5() {
        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        assertFalse(tools.listCustomComparison(arrayList1, arrayList2));
    }
}