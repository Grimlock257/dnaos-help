package server;

public class Server {

    /**
     * Entry point to the server program
     */
    public static void main(String[] args) {
        System.out.println("Server started...");
        
        // Create a new ServerSystem object, providing the argument '4000' - this is the port for the server to operate on (listen)
        ServerSystem myServer = new ServerSystem(4000);

        // Call the method (a method is a function that belongs to a class) called 'processMessage' to tell the myServer object to process incoming messages.
        myServer.processMessages();
    }
}