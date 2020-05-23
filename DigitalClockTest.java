/*
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import junit.framework.TestCase;

/**
 * This is a tester class written to check for bugs in your DigitalClock class. 
 * You should NOT modify any of this code at any point in your project. 
 * If you make any changes to this class, you risk losing the ability to 
 * check your progress as you work through the project.
 *
 * @author  Framedog
 * @version 2.0
 */

/*
public class DigitalClockTest
{
    private DigitalClock easyTime;
    private DigitalClock endOfMinuteTime;
    private DigitalClock endOfHourTime;
    private DigitalClock rolloverTime;

    /**
     * Sets up the test fixture.
     */
/*
    @Before
    public void setUp()
    {
        easyTime = new DigitalClock(11, 47, 55);
        endOfMinuteTime = new DigitalClock(7, 12, 59);
        endOfHourTime = new DigitalClock(10, 59, 59);
        rolloverTime = new DigitalClock(12, 59, 59);
    }

    @Test
    public void testGetHour()
    {
        assertEquals("getHour is not correct.", 11, easyTime.getHour());
        assertEquals("getHour is not correct.", 7, endOfMinuteTime.getHour());
        assertEquals("getHour is not correct.", 10, endOfHourTime.getHour());
        assertEquals("getHour is not correct.", 12, rolloverTime.getHour());
    }
    
    @Test
    public void testGetMinute()
    {
        assertEquals("getMinute is not correct.", 47, easyTime.getMinute());
        assertEquals("getMinute is not correct.", 12, endOfMinuteTime.getMinute());
        assertEquals("getMinute is not correct.", 59, endOfHourTime.getMinute());
        assertEquals("getMinute is not correct.", 59, rolloverTime.getMinute());
    }
    
    @Test
    public void testGetSecond()
    {
        assertEquals("getSecond is not correct.", 55, easyTime.getSecond());
        assertEquals("getSecond is not correct.", 59, endOfMinuteTime.getSecond());
        assertEquals("getSecond is not correct.", 59, endOfHourTime.getSecond());
        assertEquals("getSecond is not correct.", 59, rolloverTime.getMinute());
    }
    
    @Test
    public void testSetHour()
    {
        DigitalClock timer1 = new DigitalClock(1, 1, 1);
        timer1.setHour(12);
        assertEquals("setHour(12) expects hour to be 12.", 12, timer1.getHour());
        timer1.setHour(-3);
        assertEquals("Setting hour to a negative value should force hour to become 1.", 1, timer1.getHour());
        timer1.setHour(63);
        assertEquals("Setting hour to a value greater than 12 should force hour to be set to 12.", 12, timer1.getHour());
    }
    
    @Test
    public void testSetMinute()
    {
        DigitalClock timer1 = new DigitalClock(0, 0, 0);
        timer1.setMinute(47);
        assertEquals("setMinute(47) expects minute to be 47.", 47, timer1.getMinute());
        timer1.setMinute(-9);
        assertEquals("Setting minute to a negative value should force minute to become 0.", 0, timer1.getMinute());
        timer1.setMinute(64);
        assertEquals("Setting minute to a value greater than 59 should force minute to be set to 0.", 0, timer1.getMinute());    
    }
    
    @Test
    public void testSetSecond()
    {
        DigitalClock timer1 = new DigitalClock(0, 0, 0);
        timer1.setSecond(34);
        assertEquals("setSecond(34) expects second to be 34.", 34, timer1.getSecond());
        timer1.setSecond(-12);
        assertEquals("Setting second to a negative value should force second to become 0.", 0, timer1.getSecond());
        timer1.setSecond(78);
        assertEquals("Setting second to a value greater than 59 should force second to be set to 0.", 0, timer1.getSecond());
    }
    
    @Test
    public void testSetTime()
    {
        DigitalClock timer1 = new DigitalClock(0, 0, 0);
        //check that setTime works for acceptable parameters
        timer1.setTime(7, 23, 55);
        assertEquals("Does setTime call setHour?", 7, timer1.getHour());
        assertEquals("Does setTime call setMinute?", 23, timer1.getMinute());
        assertEquals("Does setTime call setSecond?", 55, timer1.getSecond());
        //check that setTime works for invalid parameters
        timer1.setTime(15, -5, 61);
        assertEquals("Did you remember to check for invalid parameters?", 12, timer1.getHour());
        assertEquals("Did you remember to check for invalid parameters?", 0, timer1.getMinute());
        assertEquals("Did you remember to check for invalid parameters?", 0, timer1.getSecond());
        
    }
    
    @Test
    public void testToString()
    {
        assertEquals("Did you include a colon between the hour:minute:second?", "11:47:55", easyTime.toString());
        DigitalClock singleDigitTime = new DigitalClock(2, 3, 4);
        assertEquals("Are you appropriately handling single-digit numbers by placing a 0 in front of the digit?", "02:03:04", singleDigitTime.toString());
    }
    
    @Test
    public void testNextSecond()
    {
        easyTime.nextSecond();
        assertEquals("nextSecond should increment the second field by 1.", 56, easyTime.getSecond());
        endOfMinuteTime.nextSecond();
        assertEquals("When second is 59, what should the value of second be after calling nextSecond()?", 0, endOfMinuteTime.getSecond());
    }
    
    @Test
    public void testNextMinute()
    {
        easyTime.nextMinute();
        assertEquals("nextMinute should increment the minute field by 1.", 48, easyTime.getMinute());
        rolloverTime.nextMinute();
        assertEquals("When minute is 59, what should the value of minute be after calling nextMinute()?", 0, rolloverTime.getMinute());
    }
    
    @Test
    public void testNextHour()
    {
        easyTime.nextHour();
        assertEquals("nextHour should increment the hour field by 1.", 12, easyTime.getHour());
        endOfMinuteTime.nextHour();
        assertEquals("nextHour should increment the hour field by 1.", 8, endOfMinuteTime.getHour());
    }

    @Test
    public void testEndOfMinuteRollover()
    {
        endOfMinuteTime.nextSecond();
        assertEquals("The next second after 59 is 0.", 0, endOfMinuteTime.getSecond());
        assertEquals("When the second advances from 59 to 0, the minute should be updated as well.", 13, endOfMinuteTime.getMinute());
    }
    
    @Test
    public void testEndOfHourRollover()
    {
        endOfHourTime.nextSecond();
        assertEquals("The next second after 59 is 0.", 0, endOfHourTime.getSecond());
        assertEquals("The next minute after 59 is 0.", 0, endOfHourTime.getMinute());
        assertEquals("If the time is 10:59:59, if the second is advanced then the minute and the hour should be incremented.", 11, endOfHourTime.getHour());
    }

    @Test
    public void testMidnightRollover()
    {
        rolloverTime.nextSecond();
        assertEquals("The next second after 12:59:59 should be 0.", 0, rolloverTime.getSecond());
        assertEquals("The next minute after 12:59:59 should be 0.", 0, rolloverTime.getMinute());
        assertEquals("The next hour after 12:59:59 should be 1.", 1, rolloverTime.getHour());
    }
}
 */


