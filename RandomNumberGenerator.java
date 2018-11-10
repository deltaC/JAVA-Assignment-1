import java.util.Random;
/**
 * The class randomly generates number within a given range.
 * 
 * @author (Tisa Majumder) 
 * @version (7th Septmeber 2018)
 */
public class RandomNumberGenerator
{
    int minimumValue;
    int maximumValue;
    /**
     * Constructor for objects of class Random Number Generator
     */
    public RandomNumberGenerator()
    {
        minimumValue = 0;
        maximumValue = 100;
    }
    
    /**
     * Non- Default Constructor for objects of class Random Number Generator
     * @param  min  the lowest range entered by user
     * @param max the highest range entered by user
     */
    public RandomNumberGenerator(int min, int max)
    {
        minimumValue = min;
        maximumValue = max;
    }
    
    /**
     * A random number generator method
     * @return  a number generated randomly between the minimum and maximum value
     */
    public int randomNumber()
    {
        int randomNum = (int)(minimumValue + Math.random()* maximumValue);
        return randomNum;
    }
}
