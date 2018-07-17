package kuvanova;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void testGetSum()
    {
        assertEquals(15,App.getSum(7,8));
    }
    @Test
    public void testGetMultiple()
    {
        assertEquals(20,App.getMultiple(4,5));
    }
}
