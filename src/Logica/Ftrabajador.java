package Logica;

import Datos.vCliente;
import Datos.vProducto;
import Datos.vTrabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ftrabajador {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

//--------------------- METODO MOSTRAR -------------------------------------------------------------
    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apaterno", "Amaterno", "Doc", "Numero Documento", "Direccion",
            "Telefono", "Email", "Sueldo", "Acceso", "Login", "Clave", "Estado"};
        String[] registro = new String[14];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        if(buscar.isEmpty()){
            sSQL = " SELECT p.idpersona, p.nombre, p.apaterno, p.amaterno, p.tipo_documento, "
                + "p.num_documento, p.direccion, p.telefono, p.email, t.sueldo, t.acceso, t.login, t.password, t.estado "
                + "FROM persona p INNER JOIN trabajador t ON p.idpersona=t.idpersona_t "
                + " ORDER BY p.idpersona DESC";
        }
        else{
            sSQL = " SELECT p.idpersona, p.nombre, p.apaterno, p.amaterno, p.tipo_documento, "
                    + "p.num_documento, p.direccion, p.telefono, p.email, t.sueldo, t.acceso, t.login, t.password, t.estado "
                    + "FROM persona p INNER JOIN trabajador t ON p.idpersona=t.idpersona_t "
                    + " WHERE p.num_documento LIKE ' %"+buscar+"% ' ORDER BY p.idpersona DESC";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apaterno");
                registro[3] = rs.getString("amaterno");
                registro[4] = rs.getString("tipo_documento");
                registro[5] = rs.getString("num_documento");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("telefono");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("sueldo");
                registro[10] = rs.getString("acceso");
                registro[11] = rs.getString("login");
                registro[12] = rs.getString("password");
                registro[13] = rs.getString("estado");

                totalregistros += 1;
                modelo.addRow(registro);
               
            }
            
            
            return modelo;

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }

    }
// --------------------METODO INSERTAR ----------------------------------------------

    public boolean insertar(vTrabajador dts) {

        sSQL = "INSERT INTO persona (nombre,apaterno,amaterno,tipo_documento,num_documento,direccion,telefono,email) "
                 + "VALUES (?,?,?,?,?,?,?,?)";

        sSQL2 = "INSERT INTO trabajador (idpersona_t, sueldo,acceso,login,password, estado) "
                + " VALUES ((SELECT idpersona FROM persona ORDER BY idpersona DESC LIMIT 1),?,?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApaterno());
            pst.setString(3, dts.getAmaterno());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNum_documento());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());
            
            pst2.setDouble(1, dts.getSueldo());
            pst2.setString(2, dts.getAcceso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getEstado().substring(0, 1));

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        return false;
    }

//------------------METODO EDITAR --------------------------------------
    public boolean editar(vTrabajador dts) {

        sSQL = "UPDATE persona SET nombre=?, apaterno=?, amaterno=?, tipo_documento=?, num_documento=?, "
                + "direccion=?, telefono=?, email=?";

        sSQL2 = "UPDATE trabajador SET sueldo=?, acceso=?, login=?, password=?, estado=? "
                + "WHERE idpersona_t=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApaterno());
            pst.setString(2, dts.getAmaterno());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNum_documento());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());

            pst2.setDouble(1, dts.getSueldo());
            pst2.setString(2, dts.getAcceso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getEstado());
            pst2.setInt(6, dts.getIdpersona());

            int n = pst.executeUpdate();
            
            if(n != 0){
                int n2 = pst.executeUpdate();
                
                if(n2 != 0){
                    return true;
                }else{
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }       
        return false;
    }
    
//-------------METODO ELMINAR ----------------------------
    public boolean eliminar(vTrabajador dts){
    
        sSQL = "DELETE FROM trabajador WHERE idpersona=?";
        sSQL2 = "DELETE FROM persona WHERE idpersona_t=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setInt(1, dts.getIdpersona());
            pst2.setInt(1, dts.getIdpersona());
            
            int n = pst.executeUpdate();
            
            if(n != 0){
                int n2 = pst2.executeUpdate();
                if(n2 != 0){
                    return true;
                }else {
                    return false;
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
//--------------------- METODO MOSTRAR -------------------------------------------------------------
    public DefaultTableModel login(String login, String password) {

        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apaterno", "Amaterno", "Acceso", "Login", "Clave", "Estado"};
        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = " SELECT p.idpersona, p.nombre, p.apaterno, p.amaterno, "
                + " t.acceso, t.login, t.password, t.estado "
                + "FROM persona p JOIN trabajador t "
                + "WHERE t.login= '"+login+"' AND t.password='"+password+"' AND t.estado='A'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apaterno");
                registro[3] = rs.getString("amaterno");
                
                registro[4] = rs.getString("acceso");
                registro[5] = rs.getString("login");
                registro[6] = rs.getString("password");
                registro[7] = rs.getString("estado");

                totalregistros += 1;
                modelo.addRow(registro);
                
                

            }
            return modelo;

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }

    }

}
