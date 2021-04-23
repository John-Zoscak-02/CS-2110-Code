import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PancakeMakerTest {

    String[] requiredIngredientsArray = { "flour","salt","soda","powder","buttermilk","egg" };
    ArrayList<String> requiredIngredients = new ArrayList(Arrays.asList(requiredIngredientsArray));

    PancakeMaker pancakeMaker;
    String[] arrayOne = { "flour","salt","powder","buttermilk" };
    String[] arrayTwo = { "soda","egg" };
    String[] arrayThree = { "flour","salt","soda","powder","buttermilk","egg" };
    String[] arrayFour = {};
    String[] arrayNull = null;

    ArrayList<String> result1;
    ArrayList<String> result2;
    ArrayList<String> result3;
    ArrayList<String> result4;

    @Before
    public void setUp() throws Exception {
        pancakeMaker = new PancakeMaker();

        result1 = (ArrayList<String>) requiredIngredients.clone();
        result1.removeAll(Arrays.asList(arrayOne));
//        System.out.println(result1);

        result2 = (ArrayList<String>) requiredIngredients.clone();
        result2.removeAll(Arrays.asList(arrayTwo));
//        System.out.println(result2);

        result3 = (ArrayList<String>) requiredIngredients.clone();
        result3.removeAll(Arrays.asList(arrayThree));
//        System.out.println(result3);

        result4 = (ArrayList<String>) requiredIngredients.clone();
        result4.removeAll(Arrays.asList(arrayFour));
//        System.out.println(result4);
    }

    @Test
    public void determineWholeFoodsOrderTestOne() {
        assertEquals(result1, pancakeMaker.determineWholeFoodsOrder(arrayOne));
    }
    @Test
    public void determineWholeFoodsOrderTestTwo() {
        assertEquals(result2, pancakeMaker.determineWholeFoodsOrder(arrayTwo));
    }
    @Test
    public void determineWholeFoodsOrderTestFull() {
        assertEquals(result3, pancakeMaker.determineWholeFoodsOrder(arrayThree));
    }
    @Test
    public void determineWholeFoodsOrderTestEmpty() {
        assertEquals(result4, pancakeMaker.determineWholeFoodsOrder(arrayFour));
    }
    @Test
    public void determineWholeFoodsOrderTestNull() {
        try {
            pancakeMaker.determineWholeFoodsOrder(arrayNull);
            fail("Was supposed to throw NullPointer but didn't");
        } catch (Exception e) {
            assertTrue(e.getMessage(), true);
        }
    }
}