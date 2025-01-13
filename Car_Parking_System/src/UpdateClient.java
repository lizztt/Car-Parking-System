import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class UpdateClient extends NewClient implements ActionListener {
    JFrame frame;
    JLabel title;
    String clientFName;
    JButton update,back;
    public UpdateClient(String clientFName){
        this.clientFName = clientFName;
        frame = new JFrame();
        frame.setSize(900,500);
        frame.setLocation(200,100);
        frame.getContentPane().setBackground(new Color(0,128,255));
        frame.setLayout(null);


        title = new JLabel("UPDATE CLIENT DETAILS");
        title.setBounds(300,30,500,50);
        title.setFont(new Font("Gothic", Font.BOLD, 24));
        title.setForeground(new Color(0, 0, 0));
        frame.add(title);

        lblClientFName = new JLabel("First Name");
        lblClientFName.setBounds(50,150,150,30);
        lblClientFName.setFont(new Font("Gothic", Font.PLAIN, 22));
        lblClientFName.setForeground(new Color(0, 0, 0));
        frame.add(lblClientFName);

        textFieldClientFName = new JTextField();
        textFieldClientFName.setBounds(200,150,150,30);
        frame.add(textFieldClientFName);

        lblClientLName = new JLabel("Last Name");
        lblClientLName.setBounds(400,150,150,30);
        lblClientLName.setFont(new Font("Gothic", Font.PLAIN, 22));
        lblClientLName.setForeground(new Color(0, 0, 0));
        frame.add(lblClientLName);

        textFieldClientLName = new JTextField();
        textFieldClientLName.setBounds(600,150,150,30);
        frame.add(textFieldClientLName);

        lblVehicleRegNo = new JLabel("Veh Reg Num");
        lblVehicleRegNo.setBounds(50,200,200,30);
        lblVehicleRegNo.setFont(new Font("Gothic", Font.PLAIN, 22));
        lblVehicleRegNo.setForeground(new Color(0, 0, 0));
        frame.add(lblVehicleRegNo);

        textFieldVehicleRegNo = new JTextField();
        textFieldVehicleRegNo.setBounds(200,200,150,30);
        frame.add(textFieldVehicleRegNo);

        lblVehicleType = new JLabel("Vehicle Type");
        lblVehicleType.setBounds(400,200,150,30);
        lblVehicleType.setFont(new Font("Gothic", Font.PLAIN, 22));
        lblVehicleType.setForeground(new Color(0, 0, 0));
        frame.add(lblVehicleType);

        textFieldVehicleType = new JTextField();
        textFieldVehicleType.setBounds(600,200,150,30);
        frame.add(textFieldVehicleType);


        try {
            JDBC c = new JDBC();
            String query = "select * from Visitor where `First Name` = '"+clientFName+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                lblClientFName.setText(rs.getString("First Name"));
                lblClientLName.setText(rs.getString("Last Name"));
                lblVehicleRegNo.setText(rs.getString("Vehicle Registration Number"));
                lblVehicleType.setText(rs.getString("Vehicle Type"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        update = new JButton("Update");
        update.setBounds(250,350,150,40);
        update.setForeground(new Color(0, 0, 0));
        update.setBackground(new Color(255, 255, 255));
        update.setFont(new Font("Gothic", Font.BOLD, 20));
        update.addActionListener(this);
        frame.add(update);


        back = new JButton("Back");
        back.setBounds(450,350,150,40);
        back.setForeground(new Color(0, 0, 0));
        back.setBackground(new Color(248, 244, 255));
        back.setFont(new Font("Gothic", Font.BOLD, 20));
        back.addActionListener(this);
        frame.add(back);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==update){

            String FirstName = textFieldClientFName.getText();
            String LastName = textFieldClientLName.getText();
            String VehicleRegNo = textFieldVehicleRegNo.getText();
            String VehicleType = textFieldVehicleType.getText();

            try {
                JDBC conn = new JDBC();
                String query = "UPDATE Visitor SET `First Name` = '"+FirstName+"', `Last Name` = '"+LastName+"', " +
                        "`Vehicle Registration Number` = '"+VehicleRegNo+"', `Vehicle Type` = '"+VehicleType+"' " +
                        "WHERE `First Name` = '"+clientFName+"'";

                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Updated Successfully");
                frame.setVisible(false);
                new Home();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            frame.setVisible(false);
            new Home();
        }
    }

    public static void main(String[]args){
        new UpdateClient("");
    }


}
