package computer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Computer {

    /**
     * Entry point to the server program
     */
    public static void main(String[] args) {
        try {
            // The following two lines will allow us to read keyboard input (System.in is the keyboard)
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader keyboard = new BufferedReader(input);

            // Create a socket from which we will send packets of data
            DatagramSocket socket = new DatagramSocket(5000);

            // Get the address of the server system from the localhost machine (this only works as the server and computer are on the same physical machine, this will need to be adjusted to work on separate physical machines)
            InetAddress addr = InetAddress.getByName("localhost");

            System.out.println("Computer has started... please type something in...");
            while (true) {
                System.out.print("> ");

                // Get some keyboard input
                String message = keyboard.readLine();

                // Create a packet with our inputted information and send it to the provided socket (address and port provided as the final two arguments - this address and port match the ones the ServerSystem is using)
                DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, addr, 4000);
                socket.send(packet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
