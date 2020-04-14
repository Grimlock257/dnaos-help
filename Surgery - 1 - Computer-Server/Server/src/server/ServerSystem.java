package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerSystem {

    // Create some member variables (variables that belong to a particular instance of a class, i.e they are unique to each instance created)
    private DatagramSocket socket;
    private int port = 0;

    // Constructor for the ServerSystem object, takes in a port and stores it in the variable above.
    public ServerSystem(int port) {
        this.port = port;
    }

    /**
     * This method will try and listen on the provided port indefinitely, once received it will determine the type of message and print a message
     */
    public void processMessages() {
        try {
            socket = new DatagramSocket(port);
            socket.setSoTimeout(0);

            while (true) {
                // This will store the incoming information
                byte[] buffer = new byte[1024];

                // Create a new DatagramPacket object. In this context, it will write the contents into the above buffer object
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // When the socket receives some information, it will hand it to the packet object above
                socket.receive(packet);

                // The message we received, convert it to a String object as dealing with the string in a byte[] format would be horrible
                String message = new String(buffer);

                System.out.println("Received message: " + message);

                // Convert everything uppercase to make sure it works with the cases below. Based on what we receive, display some sort of message
                switch (message.toUpperCase().trim()) {
                    case "QUIT": // We received QUIT so do this...
                        System.out.println("I've been told to stop!");
                        System.out.println("Exiting...");

                        System.exit(0);
                    case "REGISTER": // We received REGISTER so do this...
                        System.out.println("I've got a register");
                        break;
                    case "BOOK": // We received BOOK so do this...
                        System.out.println("I've been told to book something");
                        break;
                    default: // The system doesn't understand the type of message received, so this 'default' cause will handle it, in this case just print it doesn't understand it
                        System.out.println("Don't know what to do with: " + message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Try/catch ?
            socket.close();
        }
    }
}
