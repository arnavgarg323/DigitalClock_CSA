import java.awt.Font;
import java.util.Scanner;

public class DigitalClockRunner
{
    /**
     * This class is used to test your DigitalClock class.
     * Run the buildClock method to see your clock in action.
     * You'll need to provide an hour, minute, and second parameter.
     *
     * DO NOT MODIFY ANY OF THE CODE IN THIS CLASS, EVER. 
     * If you do, you run the risk of ruining the GUI (graphical user interface). 
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hour:");
        int hour = input.nextInt();

        System.out.println("Minute:");
        int minute = input.nextInt();

        System.out.println("Second:");
        int second = input.nextInt();

        buildClock(hour, minute, second);

    }

    public static void buildClock(int h, int m, int s)
    {
        //setting up the Canvas
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-1, 1);
        Font font = new Font("Helvetica Neue", Font.BOLD, 120);
        StdDraw.setFont(font);

        //subtract one second to allow time for Standard Draw to display to the Canvas
        DigitalClock clock = new DigitalClock(h, m, s-1);

        while (true)
        {
            StdDraw.text(0, 0, clock.toString());
            StdDraw.show();
            StdDraw.pause(1000);
            StdDraw.clear();
            clock.nextSecond();
        }
    }
}