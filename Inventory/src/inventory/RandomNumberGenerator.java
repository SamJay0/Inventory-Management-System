package inventory;

/**
 * @author SamJay
 */
public class RandomNumberGenerator {

    int minimumValue;
    int maximumValue;

    //defaultConstructor
    public RandomNumberGenerator() {
    }

    //non-default constructor
    public RandomNumberGenerator(int minValue, int maxValue) {
        this.minimumValue = minValue;
        this.maximumValue = maxValue;
    }

    /*
    *setters
     */
    public void setMinValue(int minValue) {
        this.minimumValue = minValue;
    }

    public void setMaxValue(int maxValue) {
        this.maximumValue = maxValue;
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
