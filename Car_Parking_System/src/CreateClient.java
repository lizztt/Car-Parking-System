import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class CreateClient extends NewClient implements ActionListener {
    JFrame frame;
    JLabel title;
    JButton create,back;

    public CreateClient(){
        frame = new JFrame();
        frame.setSize(900,500);
        frame.setLocation(200,100);
        frame.getContentPane().setBackground(new Color(0,128,255));
        frame.setLayout(null);


        title = new JLabel("CREATE CLIENT DETAILS");
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
        frame.add( textFieldVehicleRegNo);
        
        lblVehicleType = new JLabel("Vehicle Type");
        lblVehicleType.setBounds(400,200,150,30);
        lblVehicleType.setFont(new Font("Gothic", Font.PLAIN, 22));
        lblVehicleType.setForeground(new Color(0, 0, 0));
        frame.add(lblVehicleType);

        textFieldVehicleType = new JTextField();
        textFieldVehicleType.setBounds(600,200,150,30);
        frame.add(textFieldVehicleType);

        create = new JButton("Create");
        create.setBounds(250,350,150,40);
        create.setForeground(new Color(0, 0, 0));
        create.setBackground(new Color(255, 255, 255));
        create.setFont(new Font("Gothic", Font.BOLD, 20));
        create.addActionListener(this);
        frame.add(create);

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
        if (ae.getSource()==create){
            String FirstName = textFieldClientFName.getText();
            String LastName = textFieldClientLName.getText();
            String VehicleRegNo = textFieldVehicleRegNo.getText();
            String VehicleType = textFieldVehicleType.getText();

            try {
                JDBC conn = new JDBC();
                String query = "insert into Visitor values('"+FirstName+"','"+LastName+"','"+VehicleRegNo+"','"+VehicleType+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details are Added Successfully");
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
        CreateClient createClient = new CreateClient();
    }


}
