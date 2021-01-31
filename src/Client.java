import java.io.*;
import java.net.*;
import java.util.Date;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        while (true) {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Socket clientSocket =
                new Socket("127.0.0.1", 8000);

            Date date = new Date();
            long currentTime = date.getTime();
            String computerName = InetAddress.getLocalHost().getHostName();
            InetAddress IP = InetAddress.getLocalHost();

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            clientSocket.getOutputStream()
                    )
            );

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()
                    )
            );

            writer.write(date + " ; " + computerName + " ; " + IP.getHostAddress());
            writer.newLine();
            writer.flush();

            String response = reader.readLine();
            System.out.println(response);

            writer.close();
            reader.close();
        clientSocket.close();
        }
    }
}