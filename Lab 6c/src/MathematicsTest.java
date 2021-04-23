import org.junit.*;

import static org.junit.Assert.*;

public class MathematicsTest {

    @Test
    public void powerTest1() {
        assertEquals(Math.pow(5, 2), Mathematics.power(5, 2), 0.1 );
    }

    @Test
    public void powerTest2() {
        assertEquals(Math.pow(5, -2), Mathematics.power(5, -2), 0.1 );
    }

    @Test
    public void powerTest3() {
        assertEquals(Math.pow(10, 0), Mathematics.power(10, 0), 0.1 );
    }

    @Test
    public void powerTest4() {
        assertEquals(Math.pow(Double.NaN, 2), Mathematics.power(Double.NaN, 2), 0.1 );
    }

    @Test
    public void powerTest5() {
        assertEquals(Math.pow(0, 2), Mathematics.power(0, 2), 0.1 );
    }

    @Test
    public void powerTest6() {
        assertEquals(Math.pow(5, 0), Mathematics.power(5, 0), 0.1 );
    }
    @Test
    public void powerTest7() {
        assertEquals(Double.NaN, Mathematics.power(0, -2), 0.1 );
    }


}