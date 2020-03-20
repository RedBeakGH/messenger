import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler {
    private ArrayList<Socket> clients;
    private DataInputStream in;
    private DataOutputStream out;

    public ClientHandler() {
        this.clients = new ArrayList<Socket>();
    }

     public void addClient(Socket socket) throws IOException {
         clients.add(socket);
         in = new DataInputStream(socket.getInputStream());
         new Thread(new Runnable() {
             public void run() {
                 while (true){
                     try {
                         String msg = in.readUTF();
                         sendMsg(msg);
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
             }
         }).start();
     }

     public void sendMsg(String msg) {
        for(Socket socket:clients) {
            try {
                out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
     }

}
