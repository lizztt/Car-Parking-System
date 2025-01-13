import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewClient extends JFrame implements ActionListener {

    JTable table;

    JScrollPane jScrollPane;

    JLabel lblPolicy1, lblPolicy2, lblPolicy3,lblSelect;
    Choice clientFName;
    JButton update, back;

    public ViewClient(){
        JFrame frame = new JFrame();
        setSize(900,400);
        setLocation(190,100);
        getContentPane().setBackground(new Color(0,128,255));
        setLayout(null);

        lblPolicy1 = new JLabel("HONEST");
        lblPolicy1.setBounds(500,5,100,30);
        lblPolicy1.setFont(new Font("Gothic",Font.BOLD,20) );
        lblPolicy1.setForeground(new Color(0,0,0));
        add(lblPolicy1);

        lblPolicy2 = new JLabel("EFFICIENT");
        lblPolicy2.setBounds(500,35,200,30);
        lblPolicy2.setFont(new Font("Gothic",Font.BOLD,20));
        lblPolicy2.setForeground(new Color(0,0,0));
        add(lblPolicy2);

        lblPolicy3 = new JLabel("SECURE");
        lblPolicy3.setBounds(500,65,200,30);
        lblPolicy3.setFont(new Font("Gothic",Font.BOLD,20));
        lblPolicy3.setForeground(new Color(0,0,0));
        add(lblPolicy3);



        lblSelect = new JLabel("Select Client");
        lblSelect.setBounds(20,20,150,20);
        add(lblSelect);

        clientFName = new Choice();
        clientFName.setBounds(180,20,150,20);
        add(clientFName);

        try {
            JDBC c = new JDBC();
            ResultSet rs = c.s.executeQuery("select * from `Visitor`");
            while (rs.next()){
                clientFName.add(rs.getString("First Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        table = new JTable();
        try {
            JDBC c = new JDBC();
            ResultSet rs = c.s.executeQuery("select * from Visitor");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0, 100, 900,600);
        add(jScrollPane);

        update = new JButton("Update");
        update.setBounds( 160,70,80,20);
        update.addActionListener(this);
        add(update);


        back = new JButton("Back");
        back.setBounds( 300,70,80,20);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource()==update){
            setVisible(false);
            new UpdateClient(clientFName.getSelectedItem());
        }else {
            setVisible(false);
            new Home();
        }

    }
    public static void main(String[]args){
        new ViewClient();
    }


}
