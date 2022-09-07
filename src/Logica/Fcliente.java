package Logica;

import Datos.vCliente;
import Datos.vHabitacion;
import Datos.vProducto;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Fcliente {
    

    private Conexion mysql = new Conexion();
    private Connection cn = (Connection) mysql.Conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

//--------------- FUNCION  MOSTRAR ----------------------------------
    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apaterno", "Amaterno", "Doc", "Numero Documento", "Direccion",
            "Telefono", "Email", "Codigo"};
        
        String[] registro = new String[10];
        totalregistros = 0;

        modelo = new DefaultTableModel(null, titulos);

        //INSTRUCCION SQL
        
        if(buscar.isEmpty()){
             sSQL = "SELECT p.idpersona, p.nombre, p.apaterno, p.amaterno, p.tipo_documento, p.num_documento, "
                + "p.direccion, p.telefono, p.email,c.codigo_cliente FROM persona p INNER JOIN cliente c "
                + " ORDER BY idpersona DESC";
        }
        else {
               sSQL = "SELECT p.idpersona, p.nombre, p.apaterno, p.amaterno, p.tipo_documento, p.num_documento, "
                + "p.direccion, p.telefono, p.email,c.codigo_cliente FROM persona p INNER JOIN cliente c "
                + " WHERE num_documento LIKE ' %" + buscar + "% ' ORDER BY idpersona DESC";
        
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
                registro[9] = rs.getString("codigo_cliente");

                totalregistros += 1;
                modelo.addRow(registro);
            }

            return modelo;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

//--------------  FUNCION INSERTAR ----------------------------------
    public boolean insertar(vCliente dts) {
        sSQL = "INSERT INTO persona (nombre,apaterno,amaterno,tipo_documento,num_documento,direccion,telefono,email) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        
        sSQL2 = "INSERT INTO cliente (idpersona_c, codigo_cliente) "
                + "VALUES ((SELECT idpersona FROM persona ORDER BY idpersona DESC LIMIT 1),?) ";

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

            pst2.setString(1, dts.getCodigo_cliente());
           
          
            int n = pst.executeUpdate();

            // SI N DIFERENTE DE CERO SE CREA A UNA PERSONA
            if (n != 0) {

                int n2 = pst2.executeUpdate();
                // SI N2 DIFERENTE DE CERO SE CREA UN CLIENTE

                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }

            } else {

                return false;
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

//------------------ FUNCION EDITAR ------------------------
    public boolean editar(vCliente dts) {

        sSQL = "UPDATE perosna  SET nombre=?, apaterno=?, amaterno=?, tipo_documento=?,"
                + " num_documento=?, direccion=?, telefono=?, email=?, codigo_cliente=?"
                + "WHERE idpersona=?";

        sSQL2 = "UPDATE cliente SET codigo_cliente=? WHERE idpersona_c";

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
            pst.setString(8, dts.getTelefono());
            pst.setInt(9, dts.getIdpersona());

            pst.setString(1, dts.getCodigo_cliente());
            pst.setInt(2, dts.getIdpersona());

            int n = pst.executeUpdate();

            // SI N DIFERENTE DE CERO SE CREA A UNA PERSONA
            if (n != 0) {

                int n2 = pst2.executeUpdate();
                // SI N2 DIFERENTE DE CERO SE CREA UN CLIENTE

                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }

            } else {

                return false;
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    //---------- FUNCION ELIMINAR ------------------
    public boolean eliminar(vCliente dts) {

        sSQL = "DELETE FROM cliente WHERE idpersona = ?";
        sSQL2 = "DELETE FROM persona WHERE idpersona_c = ?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setInt(1, dts.getIdpersona());
            pst2.setInt(1, dts.getIdpersona());

            int n = pst.executeUpdate();

            // SI N DIFERENTE DE CERO SE CREA A UNA PERSONA
            if (n != 0) {

                int n2 = pst2.executeUpdate();
                // SI N2 DIFERENTE DE CERO SE CREA UN CLIENTE

                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }

            } else {

                return false;
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

}
