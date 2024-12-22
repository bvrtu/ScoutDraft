import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class Client implements Serializable {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 22879;
    // Determining the address and the port
    private static Socket socket;

    public void startClient() {
        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            // Creating a socket
            System.out.println("Connected to the server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void closeConnection() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Player> asktoDatabase(String name, String nation, int age,int ability, String division, String position){
        Player senderobject = new Player(name,0,ability,nation,age,"",division,position);
        // Stores the parameter data in an object to serialize it.
        try{
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(senderobject);
            // Sending the object to the server
            InputStream input = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(input);
            ArrayList<Player> player = (ArrayList<Player>) objectInputStream.readObject();
            // Gets the response of the server
            return player;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Client client = new Client();
        client.startClient();
        // Starts the client socket
        Gui gui = new Gui();
        gui.show();
        client.closeConnection();
    }
}