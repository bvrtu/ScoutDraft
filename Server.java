import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static final int PORT = 22879; // The server's port
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(PORT);
            Socket socket = ss.accept();
            System.out.println("Connection has established");
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            // Gets the request as a Player object
            Player parameters = (Player) objectInputStream.readObject();
            // Server's ask does the database action
            ArrayList<Player> players = DatabaseAction.query(parameters.getName(), parameters.getNation(), parameters.getAge(),
                    parameters.getOverall(), parameters.getLeague(), parameters.getPositions().get(0));
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            // Sends the response to client
            objectOutputStream.writeObject(players);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}