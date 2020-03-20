import javax.swing.*;
import java.awt.*;
import java.util.Comparator;

public class ChatWindow extends JFrame {
    public JTextArea textArea;
    public JTextArea message;
    public JButton send;

    public ChatWindow() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        SpringLayout springLayout = new SpringLayout();
        Container container = this.getContentPane();
        container.setLayout(springLayout);
        textArea = new JTextArea(29, 79);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        message = new JTextArea(5, 55);
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        send = new JButton("Send");

        JScrollPane jScrollPaneTextArea = new JScrollPane(textArea);
        container.add(jScrollPaneTextArea);
        JScrollPane jScrollPaneMessage = new JScrollPane(message);
        container.add(jScrollPaneMessage);
        container.add(send);

        springLayout.putConstraint(SpringLayout.WEST, jScrollPaneTextArea, 3, SpringLayout.WEST, container);
        springLayout.putConstraint(SpringLayout.NORTH, jScrollPaneMessage, 470, SpringLayout.NORTH, container);
        springLayout.putConstraint(SpringLayout.WEST, jScrollPaneMessage, 3, SpringLayout.WEST, container);
        springLayout.putConstraint(SpringLayout.WEST, send, 10, SpringLayout.EAST, jScrollPaneMessage);
        springLayout.putConstraint(SpringLayout.NORTH, send, 10, SpringLayout.NORTH, jScrollPaneMessage);


        setResizable(false);
        setSize(894, 600);
        setVisible(true);
    }

}
