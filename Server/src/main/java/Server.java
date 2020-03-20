import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ClientHandler clientHandler;

    public Server() {
        clientHandler = new ClientHandler();
    }

    public void runServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(9090); //запуск сервера.
            while (true) {
                Socket socket = serverSocket.accept();//получения сокета с клиентом.
                clientHandler.addClient(socket);//добавление клиента в список клиентов.
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
