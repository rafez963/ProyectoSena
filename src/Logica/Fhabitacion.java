package Logica;

//import com.mysql.cj.xdevapi.Statement;
//import com.sun.jdi.connect.spi.Connection;
import Datos.vHabitacion;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

// funciones guardar borrar elminar salir ...
public class Fhabitacion {

    private Conexion mysql = new Conexion();
    private Connection cn = (Connection) mysql.Conectar();
    private String sSQL = "";
    public Integer totalRegistro;

    // ------------ FUNCION MOSTRAR ----------------
    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;
        String[] titulos = {"ID", "Numero", "Piso", "Descripcion", "Caracteristicas", "Precio", "Estado", "Tipo Habitacion"};
        String[] registro = new String[8];

        totalRegistro = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * FROM habitacion WHERE piso LIKE '%" + buscar + "%' ORDER BY idhabitacion";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idhabitacion");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("piso");
                registro[3] = rs.getString("descripcion");
                registro[4] = rs.getString("caracteristicas");
                registro[5] = rs.getString("precio_diario");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("tipo_habitacion");

                totalRegistro += 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }

    }

    //------------ FUNCION INSERTAR -----------------
    public boolean insertar(vHabitacion dts) {

        sSQL = " INSERT INTO habitacion (numero, piso, descripcion, caracteristicas, precio_diario,estado, tipo_habitacion)"
                + "VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecio_diario());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipo_habitacion());

            int n = pst.executeUpdate();
            //CONDICION PARA COMPROBAR LA INSERCION DE REGISTRO EN LA TABLE

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    //----------- FUNCION EDITAR ---------------------
    public boolean editar(vHabitacion dts) {

        sSQL = "UPDATE habitacion SET numero=?, piso=?, descripcion=?, caracteristicas=?,precio_diario=?, estado=?, tipo_habitacion=? WHERE idhabitacion=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecio_diario());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipo_habitacion());
            pst.setInt(8, dts.getIdhabitacion());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;

            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    //----------- FUNCION DESOCUPAR ---------------------
    public boolean desocupar(vHabitacion dts) {

        sSQL = "UPDATE habitacion SET  estado='Disponible', tipo_habitacion=? WHERE idhabitacion=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdhabitacion());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;

            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    //----------- FUNCION OCUPAR ---------------------
    public boolean ocupar(vHabitacion dts) {

        sSQL = "UPDATE habitacion SET  estado='Ocupado', tipo_habitacion=? WHERE idhabitacion=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdhabitacion());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;

            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    //---------- FUNCION ELIMINAR ------------------
    public boolean eliminar(vHabitacion dts) {

        sSQL = "DELECT FROM habitacion WHERE idHabitacion = ?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdhabitacion());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    // ------------ FUNCION MOSTRAR ----------------
    public DefaultTableModel mostarvista(String buscar) {

        DefaultTableModel modelo;
        String[] titulos = {"ID", "Numero", "Piso", "Descripcion", "Caracteristicas", "Precio", "Estado", "Tipo Habitacion"};
        String[] registro = new String[8];

        totalRegistro = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * FROM habitacion WHERE piso LIKE '%" + buscar + "%' AND estado='Disponible' ORDER BY idhabitacion";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idhabitacion");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("piso");
                registro[3] = rs.getString("descripcion");
                registro[4] = rs.getString("caracteristicas");
                registro[5] = rs.getString("precio_diario");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("tipo_habitacion");

                totalRegistro += 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }

    }

}
