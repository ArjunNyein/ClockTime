

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class TestClockTimeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestClockTimeTest
{
    /**
     * Default constructor for test class TestClockTimeTest
     */
    public TestClockTimeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testname()
    {
        TestClockTime object1 = new TestClockTime();
        ClockTime clockTim1 = new ClockTime(12, 12, 12);
        ClockTime clockTim2 = new ClockTime(12, 12, 12);
        assertEquals(true, clockTim1.equals(clockTim2));
    }

    @Test
    public void test2()
    {
        ClockTime clockTim3 = new ClockTime(12, 12, 12);
        ClockTime clockTim4 = new ClockTime(6, 6, 6);
        assertEquals(true, clockTim3.equals(clockTim4));
    }

    @Test
    public void test3()
    {
        ClockTime clockTim1 = new ClockTime(12, 12, 12);
        ClockTime clockTim2 = new ClockTime(12, 12, 12);
        assertEquals(12, clockTim1.getHour());
    }
}



