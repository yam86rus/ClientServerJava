import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        int count = 0;
        ServerSocket serverSocket = new ServerSocket(8000);

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client add " + ++count);
        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
        writer.write("<h1>response</h1>");
        writer.flush();
        writer.close();
    }
}
