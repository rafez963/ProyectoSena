package Logica;

// ---------------- FUNCIONES PARA EDITAR, INSERTAR, ELMINAR , BUSCAR, GUARDAR ----------------
//import Datos.vHabitacion;
import Datos.vProducto;
//import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;

public class Fproducto {

    private Conexion mysql = new Conexion();
    //private java.sql.Connection cn = (java.sql.Connection) mysql.Conectar();
    private Connection cn= (Connection) mysql.Conectar();
    private String sSQL = "";
    public Integer totalRegistro;

    // ------------ FUNCION MOSTRAR ----------------
    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;
        String[] titulos = {"ID", "Producto", "Descripcion", "Unidad de Medida", "Precio de Venta"};
        String[] registro = new String[5];

        totalRegistro = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * FROM producto WHERE nombre LIKE '%" + buscar + "%' ORDER BY idproducto DESC";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idproducto");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("descripcion");
                registro[3] = rs.getString("unidad_medida");
                registro[4] = rs.getString("precio_venta");

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
    public boolean insertar(vProducto dts) {

        sSQL = " INSERT INTO producto (nombre, descripcion, unidad_medida, precio_venta)"
                + "VALUES (?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getDescripcion());
            pst.setString(3, dts.getUnidad_medida());
            pst.setDouble(4, dts.getPrecio_venta());

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
    public boolean editar(vProducto dts) {

        sSQL = "UPDATE producto SET nombre=?, descripcion=?, unidad_medida=?, precio_venta=? WHERE idproducto=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getDescripcion());
            pst.setString(3, dts.getUnidad_medida());
            pst.setDouble(4, dts.getPrecio_venta());
            pst.setInt(5, dts.getIdproducto());

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
    public boolean eliminar(vProducto dts) {

        sSQL = "DELETE FROM producto WHERE idproducto = ?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdproducto());

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
}
