import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {

    JTextField Username,Password;


    Connection conn;

    public Login(){

        JFrame frame = new JFrame();
        setSize(520,700);
        getContentPane().setBackground(new Color(0,200,255));
        setLocation( 350,10);
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon("C:/Users/user/Downloads/Blue_Car-removebg-preview.png");
        JLabel imageLabel1 = new JLabel(imageIcon);
        imageLabel1.setBounds(150,50,182,130);
        add(imageLabel1);

        JLabel title = new JLabel("CAR PARKING SYSTEM LOGIN");
        title.setBounds(70,170,500,100);
        title.setFont(new Font("Gothic", Font.BOLD, 24));
        title.setForeground(new Color(0, 0, 0));
        add(title);


        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(118, 281, 233, 41);
        lblUsername.setFont(new Font("Gothic", Font.BOLD, 22));
        lblUsername.setForeground(new Color(0,0,0));
        add(lblUsername);

        Username = new JTextField();
        Username.setBounds(117, 323, 265, 41);
        Username.setBackground(new Color(255,255,255));
        add(Username);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(117, 409, 198, 33);
        lblPassword.setFont(new Font("Gothic", Font.BOLD, 22));
        lblPassword.setForeground(new Color(0,0,0));
        add(lblPassword);

        Password = new JTextField();
        Password.setBounds(117, 442, 265, 41);
        Password.setBackground(new Color(255,255,255));
        add(Password);

        JButton login = new JButton("LOGIN");
        login.setFont(new Font("Gothic", Font.BOLD, 20));
        login.setBounds(170,600,150,50);
        login.setForeground(new Color(0, 0, 0));
        login.setBackground(new Color(255, 255, 255));
        login.addActionListener(this);
        add(login);




        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String username = Username.getText();
            String password = Password.getText();

            JDBC c = new JDBC();
            String query ="select * from login where username = '"+username+"' and password ='"+password+"'";

            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()){
                JOptionPane.showMessageDialog(null,"Login Successful");
                setVisible(false);
                new Home();
            }else {
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                setVisible(false);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }




    public static void main(String[]args){
        Login login = new Login();
    }


}
