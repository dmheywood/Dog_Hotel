package dogHotel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This program is designed to check-in/check-out guests in a hotel. The program will also create
 * and print out a food orders based on the age and weights of the dogs.
 * 
 * @author David Heywood
 * Date: April 23, 2014
 */
public class DogHotel {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * 
     * do while loop that displays the text menu to allow user input and user
     * interaction
     * 
     * switch statement will execute methods and save user input based on users
     * selections from the text menu
     */
    public static void main(String[] args) throws IOException {
        
        Scanner keyboard = new Scanner(System.in);
        Hotel hotel = new Hotel("123 Forest St.", "Portland", "ME", "04106", 25, 10.0);
        Guest guest = new Guest();
        readGuest(hotel);
        /*String[] foodOrder;*/
        String name, first, middle, last;
        int selection, lengthOfStay, roomNum, age;
        double weight;
        boolean added = true;

        do {
            System.out.println("Hotel\n");
            System.out.println(
                    "Select an option: \n"
                    + " 1) Check-in\n"
                    + " 2) Check-out\n"
                    + " 3) Create Feeding Order\n"                    
                    + " 4) Quit\n");
            selection = keyboard.nextInt();

            switch (selection) {
                case 1:
                    roomNum = hotel.findEmptyRoom();
                    added = hotel.addGuestAt(guest, roomNum);                    
                    System.out.println("Enter dogs name: ");
                    name = keyboard.next();
                    guest.setName(name);
                    System.out.println("Enter owners first name: ");
                    first = keyboard.next();
                    guest.getOwner().setFirst(first);
                    System.out.println("Enter owners middle name: ");
                    middle = keyboard.next();
                    guest.getOwner().setMiddle(middle);
                    System.out.println("Enter owners last name: ");
                    last = keyboard.next();
                    guest.getOwner().setLast(last);
                    System.out.println("Enter length of stay: ");
                    lengthOfStay = keyboard.nextInt();
                    guest.setLengthOfStay(lengthOfStay);
                    System.out.println("Enter the dogs weight: ");
                    weight = keyboard.nextDouble();
                    guest.setWeight(weight);
                    System.out.println("Enter the dogs age: ");
                    age = keyboard.nextInt();
                    guest.setAge(age);                    
                    break;
                case 2:
                    System.out.println("Enter owners last name: ");
                    last = keyboard.next();
                    hotel.checkOutGuest(last);
                    break;
                case 3:
                    hotel.createFeedingOrder();
                    break;
                case 4:
                    writeGuest(hotel);                    
            }
        } while (selection != 4); // end do while loop
    }
    
    /**
     * Helper method to read guests in from a file
     * @param h Hotel array
     * @throws java.io.FileNotFoundException
     */
    public static void readGuest(Hotel h) throws FileNotFoundException {
        Scanner in = null;
        String name, first, middle, last, breed;
        int room, days;
        double age, weight;
        boolean added = true;
        boolean everythingOK = true;
        try {
            in = new Scanner(new FileReader("datatest.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
            everythingOK = false;
        }
        if (everythingOK && added) {
            while (in.hasNext()) {
                room = in.nextInt();
                name = in.next();
                first = in.next();
                middle = in.next();
                last = in.next();
                breed = in.next();                
                age = in.nextDouble();
                weight = in.nextDouble();
                days = in.nextInt();
                Guest s = new Guest(name, first, middle, last, breed, age, weight, days);
                added = h.addGuestAt(s, room);
            }
        } else {
            System.out.println("bye");
        }
    }
 
    /**
     * Helper method to write guests to a file
     * @param h Hotel array
     * @throws IOException
     */
    public static void writeGuest(Hotel h) throws IOException {
        boolean isFile = true;
        int room = 0;
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("guestoutput.txt"));
        } catch (IOException ex) {
            System.out.println("Cannot find data file.");
            isFile = false;
        }
        if (isFile) {
            while (room < h.getCapacity()) {
                if (h.getGuestAt(room) != null) {
                    Guest guest = h.getGuestAt(room);
                    out.println(room + " " + guest.getName() + " "
                            + guest.getOwner().getFirst() + " "
                            + guest.getOwner().getMiddle() + " "
                            + guest.getOwner().getLast() + " "
                            + guest.getBreed() + " "
                            + guest.getAge() + " " + guest.getWeight() + " "
                            + guest.getLengthOfStay());
                }
                room++;
            }
            out.close();
        }
    }
}
