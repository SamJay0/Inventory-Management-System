package inventory;

import java.util.Random;

/**
 * @author SamJay
 */
public final class RandomNumberGenerator {

    int minimumValue;
    int maximumValue;

    //defaultConstructor
    public RandomNumberGenerator() {
//        this.maximumValue=setMinValue();
//        this.maximumValue=setMaxValue();
        
    }

    //non-default constructor
    public RandomNumberGenerator(int minValue, int maxValue) {
        this.minimumValue = minValue;
        this.maximumValue = maxValue;
    }

    /*
    *setters
     */
    public int setMinValue() {
        Random rand=new Random();
        return Math.abs((rand.nextInt()%5))+1;
    }

    public int setMaxValue() {
       Random rand=new Random();
       return Math.abs(rand.nextInt()%11);
    }

    /*
    *getters
     */

    public int getMinValue() {
        return minimumValue;
    }

    public int getMaxValue() {
        return maximumValue;
    }

    //display
    @Override
    public String toString() {
        return "";
    }
   
}
