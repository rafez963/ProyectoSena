package Logica;

// ---------------- FUNCIONES PARA EDITAR, INSERTAR, ELMINAR , BUSCAR, GUARDAR ----------------
//import Datos.vHabitacion;
import Datos.vPago;
import Datos.vProducto;
//import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;

public class Fpago {

    private Conexion mysql = new Conexion();
    //private java.sql.Connection cn = (java.sql.Connection) mysql.Conectar();
    private Connection cn = (Connection) mysql.Conectar();
    private String sSQL = "";
    public Integer totalRegistro;

    // ------------ FUNCION MOSTRAR ----------------
    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;
        String[] titulos = {"ID", "idreserva", "Comprobante", "Numero", "idv", "Total", "Fecha Emision", "Fecha Pago"};
        String[] registro = new String[8];

        totalRegistro = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * FROM idreserva WHERE idreserva=" + buscar + " ORDER BY idpago DESC";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpago");
                registro[1] = rs.getString("idreserva");
                registro[2] = rs.getString("tipo_comprobante");
                registro[3] = rs.getString("num_comprobante");
                registro[4] = rs.getString("igv");
                registro[5] = rs.getString("total_pago");
                registro[6] = rs.getString("fecha_emision");
                registro[7] = rs.getString("fecha_pago");

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
    public boolean insertar(vPago dts) {

        sSQL = " INSERT INTO pago (idreserva, tipo_comprobante, num_comprobante,igv, total_emision,fecha_pago"
                + ", fecha_pago )"
                + "VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdreserva());
            pst.setString(2, dts.getTipo_comprobante());
            pst.setString(3, dts.getNum_comprobante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getTotal_pago());
            pst.setDate(6, dts.getFecha_emision());
            pst.setDate(4, dts.getFecha_pago());

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
    public boolean editar(vPago dts) {

        sSQL = "UPDATE pago SET idreserva = ?, tipo_comprobante = ?, num_comprobante = ?, igv = ?, total_pago = ?,"
                + "fecha_emision, fecha_pago WHERE idpago=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdreserva());
            pst.setString(2, dts.getTipo_comprobante());
            pst.setString(3, dts.getNum_comprobante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getTotal_pago());
            pst.setDate(6, dts.getFecha_emision());
            pst.setDate(4, dts.getFecha_pago());
            
            pst.setInt(8, dts.getIdpago());

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
    public boolean eliminar(vPago dts) {

        sSQL = "DELETE FROM pago WHERE idpago = ?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdpago());

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
