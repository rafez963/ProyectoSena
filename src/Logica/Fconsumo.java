package Logica;

// ---------------- FUNCIONES PARA EDITAR, INSERTAR, ELMINAR , BUSCAR, GUARDAR ----------------
//import Datos.vHabitacion;
import Datos.vConsumo;
import Datos.vProducto;
//import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;

public class Fconsumo {

    private Conexion mysql = new Conexion();
    //private java.sql.Connection cn = (java.sql.Connection) mysql.Conectar();
    private Connection cn = (Connection) mysql.Conectar();
    private String sSQL = "";
    public Integer totalRegistro;
    public Double totalConsumo;

    // ------------ FUNCION MOSTRAR ----------------
    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;
        String[] titulos = {"ID", "idreserva", "idproducto", "producto", "cantidad", "Precio de Venta", "estado"};
        String[] registro = new String[7];

        totalRegistro = 0;
        //va adicionando todo el total de consumos especifico a una reserva
        totalConsumo = 0.0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT c.idconsumo, c.idreserva, c.idproducto, p.nombre, c.cantidad, c.precio_venta,"
                + "c.estado  FROM consumo c INNER JOIN producto p "
                + " WHERE c.idreserva LIKE '" + buscar + "' ORDER BY c.idconsumo DESC";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idconsumo");
                registro[1] = rs.getString("idreserva");
                registro[2] = rs.getString("idproducto");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("cantidad");
                registro[5] = rs.getString("precio_venta");
                registro[6] = rs.getString("estado");

                totalRegistro += 1;
                totalConsumo += (rs.getDouble("cantidad")*rs.getDouble("precio_venta"));
                modelo.addRow(registro);

            }
            return modelo;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }

    }

    //------------ FUNCION INSERTAR -----------------
    public boolean insertar(vConsumo dts) {

        sSQL = " INSERT INTO consumo (idreserva, idproducto, cantidad, precio_venta, estado)"
                + "VALUES (?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdreserva());
            pst.setInt(2, dts.getIdproducto());
            pst.setDouble(3, dts.getCantidad());
            pst.setDouble(4, dts.getPrecio_venta());
            pst.setString(5, dts.getEstado());
            
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
    public boolean editar(vConsumo dts) {

        sSQL = "UPDATE consumo SET idreserva=?, idproducto=?, cantidad=?, precio_venta=?, estado=? "
                + " WHERE idconsumo=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

             pst.setInt(1, dts.getIdreserva());
            pst.setInt(2, dts.getIdproducto());
            pst.setDouble(3, dts.getCantidad());
            pst.setDouble(4, dts.getPrecio_venta());
            pst.setString(5, dts.getEstado());

            pst.setInt(6, dts.getIdconsumo());
            
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
    public boolean eliminar(vConsumo dts) {

        sSQL = "DELETE FROM consumo WHERE idconsumo = ?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdconsumo());

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
