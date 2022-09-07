package Logica;

//import com.sun.jdi.connect.spi.Connection;
//import com.mysql.cj.jdbc.ConnectionImpl;
//import com.sun.jdi.connect.spi.Connection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import javax.swing.JOptionPane;
//import java.sql.Connection;
//import java.sql.Driver;

public class Conexion {
    // BASE DE DATOS ALTERNATIVA  db = anrahotel
    public String db = "anrahotel";
    //public String db = "hoteldb";
    public String url = "jdbc:mysql://localhost/" + db;
    public String user = "root";
    public String pass = "";
    
//public String url = "jdbc:mysql://192.168.80.25/"+db;   
//public String user = "usuarioreserva";        
//public String pass="contraseña123";
    
    public Conexion() {
    }

    public Connection Conectar() {
        Connection link= null;

        try {
            //org.gjt.mm.mysql.Driver
            Class.forName("com.mysql.jdbc.Driver");
            //Driver para generar la coneccion - se usa la ruta que esta en el archivo de coneccion dentro de las librerias
            link = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);

        } catch ( Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            System.out.println(e.toString());
        }
        return link;
    }
}
