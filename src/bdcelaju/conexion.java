
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
            }
        } catch (Exception e) {
            System.out.println("Sin Conexion a base de datos");
        }
    }
    
 
    
    public void sesion(String usuario, String contrase) throws SQLException{
        System.out.println("empezando login");
        System.out.println("nombre: "+usuario);
        System.out.println("password: "+contrase);
        PreparedStatement ps = con.prepareStatement("select * from usuario where nombre =? and password=?");
        System.out.println("consulta buena");
        ps.setString(1,usuario);
        ps.setString(2,contrase);
        
        //ejecuto la consulta ps para obtener un resultado
        ResultSet rs=ps.executeQuery();
        //si los datos concuerdan
        if(rs.next()==true){
           System.out.println("login succes");
        }else{
            System.out.println("login failed");
        }
    }
  
}
