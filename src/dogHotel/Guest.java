package dogHotel;

/**
 *
 * @author David Heywood
 * Date: April 23, 2014
 */
public class Guest extends Dog {
    private String typeOfFood;
    private double amountOfFood;
    private int lengthOfStay;
    int length;

    /**
     * Default Constructor
     */
    Guest() {
        this("", "", "", "", "", 0.0, 0.0, 0);
    }
    
    /**
     * Parameterized Constructor
     * 
     * @param name a String that is the dog's name
     * @param breed a String that is the breed of the dog
     * @param age a double that is the age of the dog
     * @param weight a double that is the weight of the dog
     * @param days an int that is the length of stay in the hotel
     */
    public Guest(String name, String breed, double age, double weight,
            int days) {
        super(name, null, breed, age, weight);
        this.amountOfFood = 0;
        this.lengthOfStay = days;
        this.typeOfFood = "";
    }
    
    /**
     * Parameterized Constructor
     * 
     * @param name a String that is the dog's name
     * @param first a String that is the owners first name
     * @param middle a String that is the owners middle name
     * @param last a String that is the owners last name
     * @param breed a String that is the breed of the dog
     * @param age a double that is the age of the dog
     * @param weight a double that is the weight of the dog
     * @param days an int that is the length of stay in the hotel 
     */
    public Guest(String name, String first, String middle, String last, String breed, double age,
            double weight, int days) {
        super(name, first, middle, last, breed, age, weight);
        this.amountOfFood = 0;
        this.lengthOfStay = days;
        this.typeOfFood = "";
    }
    
    /**
     * Helper method that determines the amount of food to feed a guest based on their weight
     * @return amountOfFood to the calling method
     */
    public double determineAmountOfFood() {
        amountOfFood = 0.0;
        amountOfFood = getWeight() * 0.2;
        return amountOfFood;
    }
    
    /**
     * Helper method that determines the type of food to feed a guest based on their age
     * @return typeOfFood to the calling method
     */
    public String determineTypeOfFood() {
        double dogAge;
        dogAge = getAge();
        if (dogAge < 1.5) {
            typeOfFood = "Puppy Food";
        } else if (dogAge >= 7.0) {
            typeOfFood = "Senior Food";
        } else {
            typeOfFood = "Adult Food";
        }
        return typeOfFood;
    }

    /**
     * Accessor for type of food
     * @return the typeOfFood
     */
    public String getTypeOfFood() {
        return typeOfFood;
    }

    /**
     * Accessor for amount of food
     * @return the amountOfFood
     */
    public double getAmountOfFood() {
        return amountOfFood;
    }

    /**
     * Accessor for length of stay
     * @return the lengthOfStay
     */
    public int getLengthOfStay() {
        return lengthOfStay;
    }

    /**
     * Mutator for type of food
     * @param typeOfFood the typeOfFood to set
     */
    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    /**
     * Mutator for amount of food
     * @param amountOfFood the amountOfFood to set
     */
    public void setAmountOfFood(double amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    /**
     * Mutator for length of stay
     * @param lengthOfStay the lengthOfStay to set
     */
    public void setLengthOfStay(int lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
    }   
}
