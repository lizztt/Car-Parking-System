import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class DeleteClient extends JFrame implements ActionListener {

    Choice clientFName;
    JLabel labelClientFName,labelClientLName,lblLName,labelVehicleRegNo,lblVehicleRegNo,labelVehicleType,lblVehicleType;
    JButton delete,back;
    public DeleteClient(){
        setSize(600,400);
        setLocation(300,150);
        getContentPane().setBackground(new Color(0,128,255));
        setLayout(null);


        labelClientFName = new JLabel("First Name");
        labelClientFName.setBounds(50,50,100,30);
        labelClientFName.setFont(new Font("Gothic", Font.BOLD, 14));
        labelClientFName.setForeground(new Color(0, 0, 0));
        add(labelClientFName);

        clientFName = new Choice();
        clientFName.setBounds(200,55,150,30);
        add( clientFName);

        try{
            JDBC c = new JDBC();
            String query = "select * from Visitor";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                clientFName.add(rs.getString("First Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

       labelClientLName = new JLabel("Last Name");
       labelClientLName.setBounds(50,100,100,30);
       labelClientLName.setFont(new Font("Gothic", Font.BOLD, 14));
       labelClientLName.setForeground(new Color(0, 0, 0));
        add(labelClientLName);

        lblLName = new JLabel();
        lblLName.setBounds(200,100,100,30);
        lblLName.setFont(new Font("Gothic", Font.BOLD, 14));
        lblLName.setForeground(new Color(248, 244, 255));
        add(lblLName);

        labelVehicleRegNo = new JLabel("Veh Reg Num");
        labelVehicleRegNo.setBounds(50,150,100,30);
        labelVehicleRegNo.setFont(new Font("Gothic", Font.BOLD, 14));
        labelVehicleRegNo.setForeground(new Color(0, 0, 0));
        add(labelVehicleRegNo);

        lblVehicleRegNo = new JLabel();
        lblVehicleRegNo.setBounds(200,150,100,30);
        lblVehicleRegNo.setFont(new Font("Gothic", Font.BOLD, 14));
        lblVehicleRegNo.setForeground(new Color(255, 255, 255));
        add(lblVehicleRegNo);

        labelVehicleType = new JLabel("Vehicle Type");
        labelVehicleType.setBounds(50,200,100,30);
       labelVehicleType.setFont(new Font("Gothic", Font.BOLD, 14));
       labelVehicleType.setForeground(new Color(0, 0, 0));
        add(labelVehicleType);

       lblVehicleType = new JLabel();
       lblVehicleType.setBounds(200,200,200,30);
       lblVehicleType.setFont(new Font("Gothic", Font.BOLD, 14));
       lblVehicleType.setForeground(new Color(248, 244, 255));
        add(lblVehicleType);

        try{
            JDBC c = new JDBC();
            String query = "select * from Visitor where `First Name` = '"+clientFName.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                lblLName.setText(rs.getString("Last Name"));
                lblVehicleRegNo.setText(rs.getString("Vehicle Registration Number"));
               lblVehicleType.setText(rs.getString("Vehicle Type"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        clientFName.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try{
                    JDBC c = new JDBC();
                    String query = "select * from Visitor where `First Name` = '"+clientFName.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()){
                        lblLName.setText(rs.getString("Last Name"));
                        lblVehicleRegNo.setText(rs.getString("Vehicle Registration Number"));
                        lblVehicleType.setText(rs.getString("Vehicle Type"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        });

        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setFont(new Font("Gothic", Font.BOLD, 20));
        delete.setForeground(new Color(0, 0, 0));
        delete.setBackground(new Color(248, 244, 255));
        delete.addActionListener(this);
        add(delete);


        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setFont(new Font("Gothic", Font.BOLD, 20));
        back.setForeground(new Color(0, 0, 0));
        back.setBackground(new Color(255, 255, 255));
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==delete){
            try{
                JDBC c = new JDBC();
                String query = "delete from Visitor where `First Name` = '"+clientFName.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Deleted Successfully");
                setVisible(false);
                new Home();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Home();
        }
    }

    public static void main (String[]args){
        new DeleteClient();
    }


}
