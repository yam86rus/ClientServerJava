import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        int count = 0;
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client add " + ++count);
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            writer.write("HTTP/1.0 200 OK\r\n" +
                    "Content-type: text/html\r\n" +
                    "\r\n" +
                    "<meta charset='UTF-8'>" +
                    "<title>Обзор касс</title>" +
                    "<h1>Это ответ с сервера</h1>\r\n" +
                    "<h2>Счетчик" + count + "</h2>" +
                    "<body>\n" +
                    "    <h3>Строка 1</h3>\n" +
                    "    <h3>Строка 2</h3>\n" +
                    "    <h3>Строка 3</h3>\n" +
                    "    <h3>Строка 4 </h3>\n" +
                    "    <h3>Строка 5</h3>\n" +
                    "</body>"
            );
            writer.flush();
            writer.close();
            clientSocket.close();
        }
    }
}
