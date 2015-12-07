package dogHotel;

/**
 * @author David Heywood
 * Date: April 23, 2014
 */
public class Dog {

    private String name;
    private Name owner;
    private String breed;
    private double age;
    private double weight;
    
    /**
     * Default Constructor
     */
    Dog() {
        this("", "", "", "", "", 0.0, 0.0);
    }
    
    /**
     * Parameterized Constructor
     * 
     * @param name a String that is the dog's name
     * @param ownerFirst a String that is the do owners first name
     * @param ownerMiddle a String that is the dog owners middle name
     * @param ownerLast a String that is the dog owners last name
     * @param breed a String that is the breed of the dog
     * @param age a double that is the age of the dog
     * @param weight a double that is the weight of the dog
     */
    public Dog(String name, String ownerFirst, String ownerMiddle, String ownerLast, String breed,
            double age, double weight) {
        this.name = name;
        this.owner = new Name(ownerFirst, ownerMiddle, ownerLast);
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }
    
    /**
     * 
     * @param name a String that is the dog's name
     * @param owner an object that is the dog owner's name
     * @param breed a String that is the breed of the dog
     * @param age a double that is the age of the dog
     * @param weight a double that is the weight of the dog
     */
    public Dog(String name, Name owner, String breed, double age, double weight) {
        this.name = name;
        this.owner = new Name(owner);
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }
    
    /**
     * Mutator for the dog's name
     * @param name a String that is the dog's name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Mutator for the owner's name
     * @param owner a Name object that is the dog owner's name
     */
    public void setOwner(Name owner) {
        this.owner = owner;
    }
    
    /**
     * Mutator for the breed of the dog
     * @param breed a String that is the breed of the dog
     */    
    public void setBreed (String breed){
        this.breed = breed;
    }
    
    /**
     * Mutator for the dog's age
     * @param age a double that is the dog's age
     */
    public void setAge(double age) {
        this.age = age;
    }
    
    /**
     * Mutator for the dog's weight
     * @param weight a double that is the dog's weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    /**
     * Accessor for the dog's name
     * @return name to the calling method
     */
    public String getName() {
        return name;
    }
    
    /**
     * Accessor for the dog owners name
     * @return owner to the calling method
     */
    public Name getOwner() {
        return owner;
    }
    
    /**
     * Accessor for the dog's breed
     * @return breed to the calling method
     */
    public String getBreed() {
        return breed;
    }
    
    /**
     * Accessor for the dog's age
     * @return age to the calling method
     */
    public double getAge() {
        return age;
    }
    
    /**
     * Accessor for the weight of the dog
     * @return weight to the calling method
     */
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        String dogString;
        dogString = "\nName:        " + getName()
                + "\nOwner:       " + getOwner()
                + "\nAge:         " + getAge()
                + "\nWeight:      " + getWeight() + "lbs";
        return dogString;
    }
}
