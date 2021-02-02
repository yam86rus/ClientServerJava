import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Server {
    static String readHtml() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Максим\\IdeaProjects\\ClientServerJava\\src\\template.html"))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                sb.append(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    static String spisok(Map<String, String> stringMap) {
        StringBuilder sb = new StringBuilder();
//        sb.append("HTTP/1.0 200 OK\r\n");
//        sb.append("Content-type: text/html\r\n");
//        sb.append("\r\n");
        sb.append("<!DOCTYPE html>");
        sb.append("<html lang='en'>");
        sb.append("<head>");
        sb.append("<meta charset='UTF-8'>");
        sb.append("<title>Кассы</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h1 style=\'color: darkblue\'>Кассы</h1>");
        sb.append("<table>");

        for (Map.Entry<String, String> entry : stringMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append("<tr>");
            sb.append("<td>Имя компьютера</td>");
            sb.append("<td>" + key + "</td>");
            sb.append("<td>Время ответа</td>");
            sb.append("<td>" + value + "</td>");
            sb.append("</tr>");
        }

        sb.append("</table>");
        sb.append("</body>");
        sb.append("</html>");
        return new String(sb);
    }

    static String showInfo(Map<String, String> mapList) {
        return "HTTP/1.0 200 OK\r\n" +
                "Content-type: text/html\r\n" +
                "\r\n" +
                mapList +
                readHtml();
    }

    static String showInfoNew(Map<String, String> mapNew) {
        return "HTTP/1.0 200 OK\r\n" +
                "Content-type: text/html\r\n" +
                "\r\n" + spisok(mapNew);
    }

    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();
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
            if (request == null) {
                System.out.println("Получена пустая строка, обрабатывать нечего.");
            } else if (request.substring(0, 3).equals("GET")) {
                System.out.println("Постучались с браузера");
            } else if (request.substring(0, 5).equals("kassa")) {
                System.out.println("Постучалось приложение");
                String[] str = request.split(";");
                map.put(str[2], str[1]);
                System.out.println(map);
                System.out.println("-----");
                System.out.println(spisok(map));
            }


            String response = "";
            if (request == null) {
                response = "Вы передали пустую строку (";
            } else if (request.substring(0, 5).equals("kassa")) {
                response = "Клиент - касса, можно ничего не показывать";
            } else {
                response = showInfoNew(map);
            }


            writer.write(response);
            writer.newLine();
            writer.flush();

            writer.close();
            reader.close();
            clientSocket.close();
        }
    }
}