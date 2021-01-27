import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("127.0.0.1", 8000);
        System.out.println("Client started");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

        String request = reader.readLine();
        System.out.println(request);

        reader.close();
        clientSocket.close();
    }
}