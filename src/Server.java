import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        int count = 0;
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client add " + ++count);

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

            String request = reader.readLine();
            System.out.println(request);

//            String response = "#" + count + " request length " + request.length();
            String response = "HTTP/1.0 200 OK\r\n" +
                    "Content-type: text/html\r\n" +
                    "\r\n" +
                    " Hello!!! :) ";
            writer.write(response);
            writer.newLine();
            writer.flush();

            writer.close();
            reader.close();
            clientSocket.close();
        }
    }
}


//            writer.write("HTTP/1.0 200 OK\r\n" +
//                            "Content-type: text/html\r\n" +
//                            "\r\n" +

/////////////////////////////////////////

//                            "<!doctype html>\n" +
//                            "<html lang=\"en\">\n" +
//                            "<head>\n" +
//                            "    <meta charset='UTF-8'>\n" +
//                            "    <meta name='viewport'\n" +
//                            "          content='width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0'>\n" +
//                            "    <meta http-equiv='X-UA-Compatible\" content=\"ie=edge'>\n" +
//                            "    <title>Document</title>\n" +
//                            "</head>\n" +
//                            "<style>\n" +
//                            "html {\n" +
//                            "    height: 100%;\n" +
//                            "}\n" +
//                            "\n" +
//                            "body {\n" +
//                            "    height: 100%;\n" +
//                            "    background: #000000;\n" +
//                            "    display: flex;\n" +
//                            "    align-items: center;\n" +
//                            "    justify-content: center;\n" +
//                            "}\n" +
//                            "\n" +
//                            ".loader {\n" +
//                            "    position: relative;\n" +
//                            "    width: 75px;\n" +
//                            "    height: 100px;\n" +
//                            "}\n" +
//                            "\n" +
//                            ".loader__bar {\n" +
//                            "    position: absolute;\n" +
//                            "    bottom: 0;\n" +
//                            "    width: 10px;\n" +
//                            "    height: 50%;\n" +
//                            "    background: #fff;\n" +
//                            "    transform-origin: center bottom;\n" +
//                            "    box-shadow: 1px 1px 0 rgba(0, 0, 0, 0.2);\n" +
//                            "}\n" +
//                            "\n" +
//                            ".loader__bar:nth-child(1) {\n" +
//                            "    left: 0px;\n" +
//                            "    transform: scale(1, 0.2);\n" +
//                            "    animation: barUp1 4s infinite;\n" +
//                            "}\n" +
//                            "\n" +
//                            ".loader__bar:nth-child(2) {\n" +
//                            "    left: 15px;\n" +
//                            "    transform: scale(1, 0.4);\n" +
//                            "    animation: barUp2 4s infinite;\n" +
//                            "}\n" +
//                            "\n" +
//                            ".loader__bar:nth-child(3) {\n" +
//                            "    left: 30px;\n" +
//                            "    transform: scale(1, 0.6);\n" +
//                            "    animation: barUp3 4s infinite;\n" +
//                            "}\n" +
//                            "\n" +
//                            ".loader__bar:nth-child(4) {\n" +
//                            "    left: 45px;\n" +
//                            "    transform: scale(1, 0.8);\n" +
//                            "    animation: barUp4 4s infinite;\n" +
//                            "}\n" +
//                            "\n" +
//                            ".loader__bar:nth-child(5) {\n" +
//                            "    left: 60px;\n" +
//                            "    transform: scale(1, 1);\n" +
//                            "    animation: barUp5 4s infinite;\n" +
//                            "}\n" +
//                            "\n" +
//                            ".loader__ball {\n" +
//                            "    position: absolute;\n" +
//                            "    bottom: 10px;\n" +
//                            "    left: 0;\n" +
//                            "    width: 10px;\n" +
//                            "    height: 10px;\n" +
//                            "    background: #fff;\n" +
//                            "    border-radius: 50%;\n" +
//                            "    animation: ball 4s infinite;\n" +
//                            "}\n" +
//                            "\n" +
//                            "@keyframes ball {\n" +
//                            "    0% {\n" +
//                            "        transform: translate(0, 0);\n" +
//                            "    }\n" +
//                            "    5% {\n" +
//                            "        transform: translate(8px, -14px);\n" +
//                            "    }\n" +
//                            "    10% {\n" +
//                            "        transform: translate(15px, -10px);\n" +
//                            "    }\n" +
//                            "    17% {\n" +
//                            "        transform: translate(23px, -24px);\n" +
//                            "    }\n" +
//                            "    20% {\n" +
//                            "        transform: translate(30px, -20px);\n" +
//                            "    }\n" +
//                            "    27% {\n" +
//                            "        transform: translate(38px, -34px);\n" +
//                            "    }\n" +
//                            "    30% {\n" +
//                            "        transform: translate(45px, -30px);\n" +
//                            "    }\n" +
//                            "    37% {\n" +
//                            "        transform: translate(53px, -44px);\n" +
//                            "    }\n" +
//                            "    40% {\n" +
//                            "        transform: translate(60px, -40px);\n" +
//                            "    }\n" +
//                            "    50% {\n" +
//                            "        transform: translate(60px, 0);\n" +
//                            "    }\n" +
//                            "    57% {\n" +
//                            "        transform: translate(53px, -14px);\n" +
//                            "    }\n" +
//                            "    60% {\n" +
//                            "        transform: translate(45px, -10px);\n" +
//                            "    }\n" +
//                            "    67% {\n" +
//                            "        transform: translate(37px, -24px);\n" +
//                            "    }\n" +
//                            "    70% {\n" +
//                            "        transform: translate(30px, -20px);\n" +
//                            "    }\n" +
//                            "    77% {\n" +
//                            "        transform: translate(22px, -34px);\n" +
//                            "    }\n" +
//                            "    80% {\n" +
//                            "        transform: translate(15px, -30px);\n" +
//                            "    }\n" +
//                            "    87% {\n" +
//                            "        transform: translate(7px, -44px);\n" +
//                            "    }\n" +
//                            "    90% {\n" +
//                            "        transform: translate(0, -40px);\n" +
//                            "    }\n" +
//                            "    100% {\n" +
//                            "        transform: translate(0, 0);\n" +
//                            "    }\n" +
//                            "}\n" +
//                            "\n" +
//                            "@keyframes barUp1 {\n" +
//                            "    0% {\n" +
//                            "        transform: scale(1, 0.2);\n" +
//                            "    }\n" +
//                            "    40% {\n" +
//                            "        transform: scale(1, 0.2);\n" +
//                            "    }\n" +
//                            "    50% {\n" +
//                            "        transform: scale(1, 1);\n" +
//                            "    }\n" +
//                            "    90% {\n" +
//                            "        transform: scale(1, 1);\n" +
//                            "    }\n" +
//                            "    100% {\n" +
//                            "        transform: scale(1, 0.2);\n" +
//                            "    }\n" +
//                            "}\n" +
//                            "\n" +
//                            "@keyframes barUp2 {\n" +
//                            "    0% {\n" +
//                            "        transform: scale(1, 0.4);\n" +
//                            "    }\n" +
//                            "    40% {\n" +
//                            "        transform: scale(1, 0.4);\n" +
//                            "    }\n" +
//                            "    50% {\n" +
//                            "        transform: scale(1, 0.8);\n" +
//                            "    }\n" +
//                            "    90% {\n" +
//                            "        transform: scale(1, 0.8);\n" +
//                            "    }\n" +
//                            "    100% {\n" +
//                            "        transform: scale(1, 0.4);\n" +
//                            "    }\n" +
//                            "}\n" +
//                            "\n" +
//                            "@keyframes barUp3 {\n" +
//                            "    0% {\n" +
//                            "        transform: scale(1, 0.6);\n" +
//                            "    }\n" +
//                            "    100% {\n" +
//                            "        transform: scale(1, 0.6);\n" +
//                            "    }\n" +
//                            "}\n" +
//                            "\n" +
//                            "@keyframes barUp4 {\n" +
//                            "    0% {\n" +
//                            "        transform: scale(1, 0.8);\n" +
//                            "    }\n" +
//                            "    40% {\n" +
//                            "        transform: scale(1, 0.8);\n" +
//                            "    }\n" +
//                            "    50% {\n" +
//                            "        transform: scale(1, 0.4);\n" +
//                            "    }\n" +
//                            "    90% {\n" +
//                            "        transform: scale(1, 0.4);\n" +
//                            "    }\n" +
//                            "    100% {\n" +
//                            "        transform: scale(1, 0.8);\n" +
//                            "    }\n" +
//                            "}\n" +
//                            "\n" +
//                            "@keyframes barUp5 {\n" +
//                            "    0% {\n" +
//                            "        transform: scale(1, 1);\n" +
//                            "    }\n" +
//                            "    40% {\n" +
//                            "        transform: scale(1, 1);\n" +
//                            "    }\n" +
//                            "    50% {\n" +
//                            "        transform: scale(1, 0.2);\n" +
//                            "    }\n" +
//                            "    90% {\n" +
//                            "        transform: scale(1, 0.2);\n" +
//                            "    }\n" +
//                            "    100% {\n" +
//                            "        transform: scale(1, 1);\n" +
//                            "    }\n" +
//                            "}"+
//                            "</style>\n" +
//                            "<body>\n" +
//                            " <div class=\"loader\">\n" +
//                            "        <div class='loader__bar'></div>\n" +
//                            "        <div class='loader__bar'></div>\n" +
//                            "        <div class='loader__bar'></div>\n" +
//                            "        <div class='loader__bar'></div>\n" +
//                            "        <div class='loader__bar'></div>\n" +
//                            "        <div class='loader__ball'></div>\n" +
//                            "      </div>"+
//                            "</body>\n" +
//                            "</html>"


/////////////////////////////////////////
