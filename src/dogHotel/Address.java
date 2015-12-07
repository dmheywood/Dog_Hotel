
package dogHotel;

/**
 * @author David Heywood
 * Date: April 23, 2014
 */

public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
    /**
     *  Default Constructor
     */
    public Address(){
        this("", "", "", "");
    }
    /**
     * Parameterized constructor that accepts an Address object
     * @param address
     */
    public Address(Address address){
        this.street = address.street;
        this.city = address.city;
        this.state = address.state;
        this.zip = address.zip;
    }
    /**
     * Parameterized Constructor that accepts String objects
     * @param street  the street number and name 
     * @param city  the city
     * @param state the state
     * @param zip the zip
     */
    public Address(String street, String city, String state, String zip){
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    /**
     * Mutator for the street
     * @param street String for street
     */
    public void setStreet(String street){
        this.street = street;
    }
    /**
     * Mutator for city 
     * @param city String for city
     */
    public void setCity(String city){
        this.city = city;
    }
    /**
     * Mutator for state
     * @param state String for state
     */
    public void setState(String state){
        this.state = state;
    }
    /**
     * Mutator for zip
     * @param zip String for zip
     */
    public void setZip(String zip){
        this.zip = zip;
    }
    /**
     * Accessor for street
     * @return the street
     */
    public String getStreet(){
        return street;
    }
    /**
     * Accessor for city
     * @return the city
     */
    public String getCity(){
        return city;
    }
    /**
     * Accessor for state
     * @return the state
     */
    public String getState(){
        return state;
    }
    /**
     * Accessor for zip
     * @return zip
     */
    public String getZip(){
        return zip;
    }
    /**
     * toString method for Address object 
     * @return the address in envelop address format
     */
    @Override
    public String toString(){
        return street + "\n" + city + ", " + state + "  " + zip;
    }
}
