import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static final int PORT = 22879; // Sunucunun dinleyeceği port
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(PORT);
            Socket socket = ss.accept();
            System.out.println("Connection has established");
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Player parameters = (Player) objectInputStream.readObject();
            ArrayList<Player> players = DatabaseAction.query(parameters.getName(), parameters.getNation(), parameters.getAge(),
                    parameters.getOverall(), parameters.getLeague(), parameters.getPositions().get(0));
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(players);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}