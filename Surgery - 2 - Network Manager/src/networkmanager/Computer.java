package networkmanager;

/**
 * Similar to Node from LB project
 *
 * This is a model that represents a connected computer
 *
 * @author DNAOS
 */
public class Computer {
    // Some instance variabels (unique to each instance of the Computer class)
    private String processorType = "";
    private String networkIPAddress = "";
    private int networkPort = 0;
    
    // Constructor for the computer
    public Computer(String processorType, String IP, int port) {
        this.processorType = processorType;
        this.networkIPAddress = IP;
        this.networkPort = port;
    }

    // Getter
    public String getProcessorType() {
        return processorType;
    }

    // Getter
    public String getNetworkIPAddress() {
        return networkIPAddress;
    }

    // Getter
    public int getNetworkPort() {
        return networkPort;
    }
    
    // Simple way to display the properties of this connected computer. Could alternatively override Javas toString() method
    public void display() {
        System.out.println("Processor: " + this.processorType);
        System.out.println("IP Address: " + this.networkIPAddress);
        System.out.println("Port Number: " + this.networkPort);
    }
}
