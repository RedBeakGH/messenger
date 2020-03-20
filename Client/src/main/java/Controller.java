import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Controller {
    private ChatWindow chatWindow;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Controller() {
        this.chatWindow = new ChatWindow(); //запуск формы основного окна чата.
        try {
            socket = new Socket("localhost", 9090); //подключение к серверу.
            in = new DataInputStream(new DataInputStream(socket.getInputStream()));
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            String msg = in.readUTF();
                            chatWindow.textArea.append(msg + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            chatWindow.send.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String msg = chatWindow.message.getText();
                    sendMsg(msg);
                    chatWindow.message.setText("");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
