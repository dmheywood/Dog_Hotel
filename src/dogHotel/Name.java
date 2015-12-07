
package dogHotel;

/**
 * @author David Heywood
 * Date: April 23, 2014
 */

public class Name {
    private String first;
    private String last;
    private String middle;
    /**
     * Default Constructor
     */
    public Name(){
        this("","","");
    }
    /**
     * parameterized constructor that accepts a Name object
     * @param name a Name object
     */
    public Name(Name name){
        this.first = name.getFirst();
        this.middle = name.getMiddle();
        this.last = name.getLast();
    }
    /**
     * Parameterized constructor that accepts Strings 
     * @param first
     * @param middle
     * @param last
     */
    public Name(String first, String middle, String last){
        this.first = first;
        this.middle = middle;
        this.last = last;
    }
    /**
     * Mutator for first name
     * @param first a String for first name
     */
    public void setFirst(String first){
        this.first = first;
    }
    /**
     * Mutator for middle name
     * @param middle a String for middle name
     */
    public void setMiddle(String middle){
        this.middle = middle;
    }
    /**
     * Mutator for last name
     * @param last a String for last name
     */
    public void setLast(String last){
        this.last = last;
    }
    /**
     * Accessor for first name
     * @return first
     */
    public String getFirst(){
        return first;
    }
    /** 
     * Accessor for middle name
     * @return middle
     */
    public String getMiddle(){
        return middle;
    }
    /**
     * Accessor for last name
     * @return last 
     */
    public String getLast(){
        return last;
    }
    /**
     * toString method for Name object
     * @return a string in last, first middle  format
     */
    @Override
    public String toString(){
        return last + ", " + first + " " + middle;
    }
}

