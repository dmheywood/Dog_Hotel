package dogHotel;

import java.text.DecimalFormat;

/**
 * @author David Heywood
 * Date: April 23, 2014
 */
public class Hotel extends Address {

    private Address address;
    private double rate;
    private int capacity;
    private int occupancy;
    // An array to hold Guest objects
    private Guest[] guest;

    /**
     * Default Constructor
     */
    Hotel() {
        rate = 0.0;
        capacity = 0;
        occupancy = 0;
    }

    /**
     * Parameterized Constructor
     *
     * @param street a String for street number and name
     * @param city a String for the city
     * @param state a String for the state
     * @param zip a String for the zip code
     * @param capacity an int for the maximum capacity of the hotel
     * @param rate a double for the nightly room rate
     */
    public Hotel(String street, String city, String state, String zip, int capacity, double rate) {
        super(street, city, state, zip);
        this.rate = rate;
        this.capacity = capacity;
        this.guest = new Guest[capacity];
        this.occupancy = 0;
    }

    /**
     * Parameterized Constructor that accepts an Address object
     *
     * @param address accepts an Address object
     * @param capacity an int for the maximum capacity of the hotel
     * @param rate a double for the nightly room rate
     */
    public Hotel(Address address, int capacity, double rate) {
        super(address);
        this.rate = rate;
        this.capacity = capacity;
        this.guest = new Guest[capacity];
        this.occupancy = 0;
    }

    /**
     * Mutator that sets the address of the hotel
     *
     * @param street a String for street number and name
     * @param city a String for the city
     * @param state a String for the state
     * @param zip a String for the zip code
     */
    public void setAddress(String street, String city, String state, String zip) {
        this.address.setStreet(street);
        this.address.setCity(city);
        this.address.setState(state);
        this.address.setZip(zip);
    }

    /**
     * Mutator that sets the address of the hotel
     *
     * @param inAddress accepts an Address object
     */
    public void setAddress(Address inAddress) {
        this.address.setStreet(inAddress.getStreet());
        this.address.setCity(inAddress.getCity());
        this.address.setState(inAddress.getState());
        this.address.setZip(inAddress.getZip());
    }

    /**
     * Mutator that sets the nightly rate of the room
     *
     * @param rate the rate to set
     */
    public void setRate(double rate) {
        this.rate = rate;
    }
    
    public String checkOutGuest(String ownerLast) {
        int roomNum;
        roomNum = findGuest(ownerLast);
        if (roomNum != -1){
            // Create an invoice
            printInvoice(roomNum);
            
            // Set index of checked out guest to null
            guest[roomNum] = null;
        }else{
            //return string ownerLast not found
        }            
        return null;        
    }
    
    /**
     * Helper method that prints out the guests invoice
     * @param roomNum is the room number of the guest who is checking out
     */
    public void printInvoice(int roomNum){
        String dogName;
        double charge;
        int lengthOfStay;
        dogName = guest[roomNum].getName();
        lengthOfStay = guest[roomNum].getLengthOfStay();
        charge = rate * lengthOfStay;
        System.out.println("\nInvoice");
        System.out.println("\nDog Name: " + dogName);
        System.out.println("\nLength of Stay: " + lengthOfStay);
        System.out.println("\nCharge: " + charge);
    }
    /**
     * Helper method performs a linear search to look for owners name in the array of guests to find the room number of
     * that owner
     * @param ownerLast
     * @return the room number
     */
    public int findGuest(String ownerLast) {
        int index = 0;
        while (index < guest.length && (guest[index] == null || !guest[index].getOwner().getLast().equals(ownerLast))) {
            index++;
        }
        if (index == guest.length) {
            index = -1;
        }
        return index;
    }        

    /**
     * Helper method that finds the first available room
     *
     * @return roomNumber which will be the index number that contains the first null element
     */
    public int findEmptyRoom() {
        int roomNum = -1;
        for (int i = 0; i <= guest.length - 1; i++) {
            if (guest[i] == null) {
                roomNum = i;
                break;
            } else {
                roomNum = -1;
            }
        }
        return roomNum;
    }
    
    /**
     * Helper method that assigns the guest a room number at check-in
     *
     * @param g reference variable for array of guests
     * @param roomNum reference variable for the room number of a guest
     * @return the boolean value assigned to the refVar isAdded to the calling method
     */
    public boolean addGuestAt(Guest g, int roomNum) {
        boolean isAdded;
        if (occupancy == capacity) {
            isAdded = false;
        }else {
            guest[roomNum] = g;
            occupancy++;
            isAdded = true;
        }
        return isAdded;
    }
    
    /**
     * Helper method to find who the guest is in a room
     * @param room
     * @return the guest in the room requested to the calling function
     */
    public Guest getGuestAt(int room) {
        Guest guestAtRoom = null;
        if (room >= 0 && room < capacity) {
            guestAtRoom = guest[room];
        }
        return guestAtRoom;
    }
    
    /**
     * Helper method that creates a string array that will contain the amount of food, type of food and the room number
     * associated with that food order for each guest in the hotel.
     * @return the string array foodOrder to the calling method
     */    
    public String[] createFeedingOrder() {
        DecimalFormat moneyStyle = new DecimalFormat("0.0");
        int roomNum, j=0;
        double amountOfFood;
        String typeOfFood, dogName;
        String[] foodOrder = new String[occupancy];
        System.out.println("Room #" + "   " + "Dog Name" + "     " + "Food Type" + "       " + "Food Amount(ounces)");
        for (int i = 0; i < guest.length; i++){
            if (guest[i] != null){
                roomNum = i;
                dogName = guest[i].getName();
                amountOfFood = guest[i].determineAmountOfFood();
                typeOfFood = guest[i].determineTypeOfFood();
                foodOrder[j]= "  " + roomNum + "       " + dogName + "      " + typeOfFood + "          "
                        + moneyStyle.format(amountOfFood);
                System.out.println(foodOrder[j]);
                j++;
            }
        }
        return foodOrder;    
}    

    /**
     * Mutator for the maximum capacity of the hotel
     *
     * @param capacity and int for the maximum capacity of the hotel
     */
    public void setCapacity(int capacity) {
        this.guest = new Guest[capacity];
        this.capacity = capacity;
    }

    /**
     * Mutator for the current occupancy of the hotel
     *
     * @param occupancy an int for the current number of occupants in the hotel
     */
    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }
    
    /**
     * Accessor for Address object
     * 
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Accessor for nightly room rate
     *
     * @return the nightly room rate to the calling method
     */
    public double getRate() {
        return rate;
    }

    /**
     * Accessor for the maximum capacity of the hotel
     *
     * @return the maximum capacity of the hotel to the calling method
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Accessor for the current number of occupants in the hotel
     *
     * @return the number of occupants to the calling method
     */
    public int getOccupancy() {
        return occupancy;
    }
}
