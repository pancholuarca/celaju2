
package bdcelaju;

import java.sql.*;
import com.mysql.cj.jdbc.ConnectionWrapper;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexion {
    
    public static Connection con;
    
    public void conectar(){
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdcelaju?zeroDateTimeBehavior=CONVERT_TO_NULL","root","root1234");
            if (con!=null){
            System.out.println("Conectado a la base de datos");
            con.close();
            }
        } catch (Exception e) {
            System.out.println("Sin Conexion a base de datos");
        }
    }
  
}
