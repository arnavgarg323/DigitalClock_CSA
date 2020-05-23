/**
 * This class is intended to model a 12-hour digital clock (e.g. 07:34:52 or 12:02:59).
 * The clock is able to be set to a specific time and then accurately begin keeping time. 
 * When appropriate, the time rolls over to the next minute, next hour, or both. 
 * 
 * //Add your name after "author" below.
 * @author Arnav Garg 
 */
public class DigitalClock
{

    //Fill in the necessary fields below
    private int hour;
    private int minute;
    private int second;
    private String r;
    private boolean is24 = false;
    /**
     * Constructor for objects of class DigitalClock
     * Replace the constructor. 
     * Rather than assigning the fields with the parameters in 3 different statements,
     * make a call to the setTime method using the constructor's parameters as the 
     * setTime method's parameters
     */
    public DigitalClock(int h, int m, int s)
    {
        if (h>12){
            is24 = true;
        }
        setTime(h, m, s);
    }

    /**
    * Assigns the fields by calling the appropriate set methods. 
    * In order to set the time, you must set the hour, set the minute, and set the second.
    */
    public void setTime(int h, int m, int s)
    {
            setHour(h);
            setMinute(m);
            setSecond(s);
    }

    /**
    * Mutator method for the hour field. 
    * It should check if the parameter is valid. If the parameter is invalid,
    * assign it a value of 0.
    * Fill in below. 
    */
    public void setHour(int h)
    {
        if(is24 == false){
            if (h >= 1 && h <= 12){
                hour = h;
            } else if (h>12){
                hour = 12;
            }else{
                hour = 1;
            }
        } else{
            if (h >= 1 && h <= 24){
                hour = h;
            }else{
                hour = 1;
            }
        }
    }
    
    /**
     * Mutator method for the hour field. 
     * It should check if the parameter is valid. If the parameter is invalid,
     * assign it a value of 0.
     * Fill in below. 
     */
    public void setMinute(int m)
    {
         if (m >= 0 && m <= 59){
            minute = m;
        } else{
            minute = 0;
        }
    }
    
    /**
     * Mutator method for the hour field. 
     * It should check if the parameter is valid. If the parameter is invalid,
     * assign it a value of 0.
     * Fill in below. 
     */
    public void setSecond(int s)
    {
        if (s >= 0 && s <= 59){
            second = s;
        } else{
            second = 0;
        }
    }

    /**
     * Update the hour field to the next hour.
     * Take note that nextHour() of 23:47:12 is 00:47:12. 
     */
    public void nextHour()
    {
        hour++;
        if (is24 == false){
            if(getHour()>12){
                hour=1;
            }
        } else{
            if(getHour()>24){
                hour=1;
            }
        }
    }
    
    /**
     * Update the minute field to the next minute.
     * Take note that nextMinute() of 03:59:13 is 04:00:13. 
     */
    public void nextMinute()
    {
        minute++;
       if (getMinute()>59){
           nextHour();
           minute = 0;
        }
    }
    
    /**
     * Update the second field to the next second.
     * Take note that nextSecond() of 23:59:59 is 00:00:00. 
     */
    public void nextSecond()
    {
        second++;
        if (getSecond()>59){
            nextMinute();
            second = 0;
        }
    }
    
    /**
     * Accessor method for the hour field. 
     * Replace below. 
     */
    public int getHour()
    {
        return hour;
    }
    
    /**
     * Accessor method for the minute field. 
     * Replace below. 
     */
    public int getMinute()
    {
        return minute;
    }
    
    /**
     * Accessor method for the second field. 
     * Replace below. 
     */
    public int getSecond()
    { 
        return second;
    }
    
    /**
     * returns "HH:MM:SS"
     * Hint: You might find it helpful to create a local String variable and progressively add to it.
     * Replace below. 
     */
    @Override 
    public String toString()
    {
        if(hour < 10 && minute < 10 && second < 10){
            r = "0"+hour+":0"+minute+":0"+second;
        } else if (hour >= 10 && minute < 10 && second < 10){
            r = ""+hour+":0"+minute+":0"+second;
        } else if (hour >= 10 && minute >= 10 && second < 10){
            r = ""+hour+":"+minute+":0"+second;
        } else if (hour >= 10 && minute < 10 && second >= 10){
            r = ""+hour+":0"+minute+":"+second;
        }else if (hour >= 10 && minute >= 10 && second >= 10){
            r = ""+hour+":"+minute+":"+second;
        } else if (hour < 10 && minute >= 10 && second < 10){
            r= "0"+hour+":"+minute+":0"+second;
        } else if (hour < 10 && minute < 10 && second >= 10){
            r= "0"+hour+":0"+minute+":"+second;
        } else if (hour < 10 && minute >= 10 && second >= 10){
            r= "0"+hour+":"+minute+":"+second;
        }
        
        return r;
    }

}
