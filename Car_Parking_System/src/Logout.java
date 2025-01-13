import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Logout extends JFrame {
    public Logout() {
        JFrame frame = new JFrame();
        setSize(400,200);
        getContentPane().setBackground(new Color(0,200,255));
        setLocation( 350,50);
        setLayout(null);


        JLabel label = new JLabel("Are you sure you want to logout?");
        label.setBounds(20,5,700,70);
        label.setFont(new Font("Gothic", Font.BOLD, 22));
        add(label);

        JButton yesButton = new JButton("Yes");
        yesButton.setFont(new Font("Gothic", Font.BOLD, 20));
        yesButton.setBounds(50,100,70,30);
        yesButton.setForeground(new Color(0, 0, 0));
        yesButton.setBackground(new Color(255, 255, 255));
        yesButton.addActionListener(new ActionListener() {

           @Override
            public void actionPerformed(ActionEvent e) {
                //logout
                dispose();
            }
        });
        add(yesButton);

        JButton noButton = new JButton("No");
        noButton.setFont(new Font("Gothic", Font.BOLD, 20));
        noButton.setBounds(250,100,70,30);
        noButton.setForeground(new Color(0, 0, 0));
        noButton.setBackground(new Color(255, 255, 255));
        noButton.addActionListener(new ActionListener() {

            @Override
           public void actionPerformed(ActionEvent e) {


            }
        });
        add(noButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        Logout logout = new Logout();

    }
}
