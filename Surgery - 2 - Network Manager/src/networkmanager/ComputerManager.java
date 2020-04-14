package networkmanager;

import java.util.LinkedList;

/**
 * Stores a list of connected computers in a LinkedList object.
 * 
 * @author DNAOS
 */
public class ComputerManager {
    private LinkedList<Computer> availableComputers = new LinkedList<Computer>();
    
    public ComputerManager() {
        // TODO
    }
    
    // Provide a way to add an already existing Computer object to the list 
    public void addComputer(Computer newComputer) {
        if(newComputer != null) availableComputers.add(newComputer);
    }
    
    // Provide a way to add a Computer object to the list by supplying the properties of the Computer to be added then creating the actual Computer object and adding it to the list
    public void addComputer(String processorType, String networkIPAddress, int networkPoint) {
        availableComputers.add(new Computer(processorType, networkIPAddress, networkPoint));
    }
    
    // Iterate over the LinkedList and call the .display() method for each computer to print its details
    public void display() {
        for (Computer comp : availableComputers) {
            comp.display();
            System.out.println();
        }
    }
}
