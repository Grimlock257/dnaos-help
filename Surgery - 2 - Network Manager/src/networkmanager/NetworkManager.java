package networkmanager;

/**
 *
 * @author DNAOS
 */
public class NetworkManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an instance of the manager object
        ComputerManager manager = new ComputerManager();

        // Create a new computer object with these parameters      
        Computer comp = new Computer("Intel Penguine", "123.456.789.012", 8080);
        
        manager.addComputer(comp); // Use the first method to add a Computer by passing in an already constructed Computer object
        manager.addComputer("Intel Tomato", "xyz.abc.lol.omg", 9001); // Use the second method to add a Computer by passing the parameters of the to be created Computer object
        
        // Display the list of computers
        manager.display();
    }
    
}
