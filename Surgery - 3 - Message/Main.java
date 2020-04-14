package io.grimlock257.test;

/**
 * Example written at the end of a lecture by Dr Jon Robinson.
 *
 * Comments added by Adam.
 *
 * The idea of this program was a potential solution for how to structure the messages between the applications
 * (the initiator, load balancer and node(s)). They would sent essentially CSV strings between one another and
 * upon receiving a message split by the comma. Each message type (in this example STORE and PRINT) would be
 * determined from the first element in the split array. The rest of the arguments were then determined on the
 * type of message received based on their position in the split array.
 *
 * See https://grimlock257.github.io/dnaos-help/ for more details about transferring from Python to Java
 * (website thing I made a while back)
 */
public class Main {

    /**
     * The entry point of the program.
     *
     * Java forces the use of Objects for pretty much everything. You cannot use a method (a function that belongs to a class)
     * unless you have a instance (object) of the class instantiated. Static allows us to do this - access a method inside
     * a class definition while not actually have an instance created yet.
     *
     * The main method is static so that Java can start our program without an object, as the program hasn't ran yet thus
     * can't create any objects.
     *
     * Inside we just call new Main() which creates a new object (as Main is the name of this class).
     *
     * @param args The command line arguments to take in
     */
    public static void main(String[] args) {
        new Main();
    }

    /**
     * A nonstatic constructor for the main class
     */
    public Main() {
        // Call our processMessage() method twice with different parameters passed in (i.e representing different messages)
        processMessage("STORE,Node1,192.168.1.12,20");
        processMessage("PRINT,Node1");
    }

    /**
     * The purpose of this method is to take in a message and do something based on the type of message it is (PRINT, STORE etc.)
     * Void as this method doesn't return anything, it just does something
     *
     * @param message The message to process
     */
    public void processMessage(String message) {
        // Create a string array which takes in the message and splits it up based on commas
        String[] elements = message.split(",");

        // Switch based on the result of the getValidElement() method
        switch (getValidElement(elements, 0)) {
            case "PRINT":
                //...
                String details = getValidElement(elements, 1);
                System.out.println("PRINT: " + details);
                break;
            case "STORE":
                String nodeName = getValidElement(elements, 1);
                String IP = getValidElement(elements, 2);
                //...
                System.out.println("STORE: " + nodeName + " with IP " + IP);
                break;
            case "REMOVE":
                break;
            default:
                System.out.println("I give up!");
                break;
        }
    }

    /**
     * The purpose of this method is to get a valid argument passed to it.
     * Return type is String as we want to return a string back to the caller from this method
     *
     * @param elements The string array which contains all of our arguments, split into an array
     * @param position The position of the array that we want to check
     * @return Either the valid argument or nothing ("")
     */
    public String getValidElement(String[] elements, int position) {
        if (elements.length > position) {
            // This uses a ternary operator, it's a inline if statement for assigning that follows the following layout:
            // (condition) ? when true : when false
            // Example:
            // int a = 5
            // int b = 4
            // (a < b) ? "The number of the left was bigger" : "The number of the right was bigger"
            // Outputs: The number of the right was bigger

            // .trim() removes all whitespace
            return (elements[position] != null) ? elements[position].trim() : "";
        } else {
            return "";
        }
    }
}
