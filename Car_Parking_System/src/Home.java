import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener {
    JLabel title;
    JButton createClient,viewClient,updateClient,deleteClient,logout,parking;
    public Home(){
        JFrame frame = new JFrame();
        setSize(535,600);
        setLayout(null);
        getContentPane().setBackground(new Color(0,128,255));
        setLocation(350,100);


        title = new JLabel("CAR PARKING SYSTEM");
        title.setBounds(125,10,400,100);
        title.setFont(new Font("Gothic", Font.BOLD, 24));
        title.setForeground(new Color(0, 0, 0));
        add(title);

        createClient = new JButton("Create Client");
        createClient.setFont(new Font("Gothic", Font.BOLD, 20));
        createClient.setBounds(30,130,220,50);
        createClient.setForeground(new Color(0, 0, 0));
        createClient.setBackground(new Color(30, 144, 255));
        createClient.setBorderPainted(false);
        createClient.addActionListener(this);
        add(createClient);

        viewClient = new JButton("View Client");
        viewClient.setFont(new Font("Gothic", Font.BOLD, 20));
        viewClient.setBounds(270,130,220,50);
        viewClient.setForeground(new Color(0, 0, 0));
        viewClient.setBackground(new Color(30, 144, 255));
        viewClient.setBorderPainted(false);
        viewClient.addActionListener(this);
        add(viewClient);

        updateClient = new JButton("Update Client");
        updateClient.setFont(new Font("Gothic", Font.BOLD, 20));
        updateClient.setBounds(30,200,220,50);
        updateClient.setForeground(new Color(0, 0, 0));
        updateClient.setBackground(new Color(30, 144, 255));
        updateClient.setBorderPainted(false);
        updateClient.addActionListener(this);
        add(updateClient);

        deleteClient = new JButton("Delete Client");
        deleteClient.setFont(new Font("Gothic", Font.BOLD, 20));
        deleteClient.setBounds(270,200,220,50);
        deleteClient.setForeground(new Color(0, 0, 0));
        deleteClient.setBackground(new Color(30, 144, 255));
        deleteClient.setBorderPainted(false);
        deleteClient.addActionListener(this);
        add(deleteClient);

        parking = new JButton("Parking");
        parking.setFont(new Font("Gothic", Font.BOLD, 20));
        parking.setBounds(150,270,220,50);
        parking.setForeground(new Color(0, 0, 0));
        parking.setBackground(new Color(30, 144, 255));
        parking.setBorderPainted(false);
        parking.addActionListener(this);
        add(parking);

        logout = new JButton("Logout");
        logout.setFont(new Font("Gothic", Font.BOLD, 20));
        logout.setBounds(150,460,220,50);
        logout.setForeground(new Color(0, 0, 0));
        logout.setBackground(new Color(30, 144, 255));
        logout.setBorderPainted(false);
        logout.addActionListener(this);
        add(logout);


        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createClient){
            setVisible(false);
            new CreateClient();
        }else if (e.getSource() == viewClient){
            setVisible(false);
            new ViewClient();
        } else if (e.getSource() == updateClient) {
            setVisible(false);
            new ViewClient();
        } else if (e.getSource() == deleteClient) {
            setVisible(false);
            new DeleteClient();
        }else if (e.getSource() == parking){
            setVisible(false);
            new Parking();
        }else if (e.getSource() == logout){
            setVisible(false);
            new Logout();
        }
    }
    public static void main(String []args){

        Home home = new Home();

    }


}
