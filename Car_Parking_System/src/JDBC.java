import java.sql.*;

public class JDBC {
    Connection c;
    Statement s;
    public JDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_parking_system_","root","");
            s = c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

