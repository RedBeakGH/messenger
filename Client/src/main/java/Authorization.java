import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Authorization extends JFrame {
    public Authorization() {
        super("Authorization");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        SpringLayout springLayout = new SpringLayout();
        Container container = this.getContentPane();
        container.setLayout(springLayout);
        JTextField login;
        container.add(login = new JTextField(15));
        JPasswordField password;
        container.add(password = new JPasswordField(15));
        JButton ok;
        container.add(ok = new JButton("Enter"));
        JButton exit;
        container.add(exit = new JButton("Exit "));
        JLabel labelLogin;
        container.add(labelLogin = new JLabel("Login:"));
        JLabel labelPass;
        container.add(labelPass = new JLabel("Password:"));
        springLayout.putConstraint(SpringLayout.WEST, labelLogin, 30, SpringLayout.WEST, container);
        springLayout.putConstraint(SpringLayout.NORTH, labelLogin, 30, SpringLayout.NORTH, container);
        springLayout.putConstraint(SpringLayout.WEST, labelPass, 30, SpringLayout.WEST, container);
        springLayout.putConstraint(SpringLayout.NORTH, labelPass, 60, SpringLayout.NORTH, container);
        springLayout.putConstraint(SpringLayout.NORTH, login, 30, SpringLayout.NORTH, container);
        springLayout.putConstraint(SpringLayout.WEST, login, 40, SpringLayout.EAST, labelLogin);
        springLayout.putConstraint(SpringLayout.NORTH, password, 60, SpringLayout.NORTH, container);
        springLayout.putConstraint(SpringLayout.WEST, password, 40, SpringLayout.EAST, labelLogin);
        springLayout.putConstraint(SpringLayout.WEST, ok, 103, SpringLayout.WEST, container);
        springLayout.putConstraint(SpringLayout.NORTH, ok, 100, SpringLayout.NORTH, container);
        springLayout.putConstraint(SpringLayout.WEST, exit, 190, SpringLayout.WEST, container);
        springLayout.putConstraint(SpringLayout.NORTH, exit, 100, SpringLayout.NORTH, container);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
