package Logica;

// ---------------- FUNCIONES PARA EDITAR, INSERTAR, ELMINAR , BUSCAR, GUARDAR ----------------
//import Datos.vHabitacion;
import Datos.vProducto;
import Datos.vReserva;
//import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Date;

public class Freserva {

    private Conexion mysql = new Conexion();
    //private java.sql.Connection cn = (java.sql.Connection) mysql.Conectar();
    private Connection cn = (Connection) mysql.Conectar();
    private String sSQL = "";
    public Integer totalRegistro;

    // ------------ FUNCION MOSTRAR ----------------
    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;
        String[] titulos = {"ID", "idhabitacion", "Nuemro", "idcliente", "cliente", "idtrabajdor", "Trabjador",
            ", Tipo Reserva", "Fecha Reserva", "Fecha Ingreso", "Fecha Salida", "Costo alojamiento", "Estado de la reserva"};

        String[] registro = new String[13];

        totalRegistro = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT r.idreserva, r.idhabitacion_r, h.numero, r.idcliente_r,"
                + "(SELECT nombre From persona WHERE idpersona = r.idcliente_r)AS clienten, "
                + "(SELECT apaterno From persona WHERE idpersona = r.idcliente_r)AS clienteap, "
                + "r.idtrabajador_r,(SELECT nombre From persona WHERE idpersona = r.idtrabajador_r)AS trabajadorn, "
                + "(SELECT apaterno From persona WHERE idpersona = r.idtrabajador_r)AS trabajadorap, "
                + "r.tipo_reserva, r.fecha_reserva, r.fecha_ingresa,r.fecha_salida, "
                + "r.costo_alojamiento, r.estado "
                + "FROM reserva r INNER JOIN habitacion h "
                + "ON r.idhabitacion_r = h.idhabitacion WHERE r.fecha_reserva LIKE '%" + buscar + "%' ORDER BY r.idreserva DESC";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idreserva");
                registro[1] = rs.getString("idhabitacion");
                registro[2] = rs.getString("numero");
                registro[3] = rs.getString("idcliente");
                registro[4] = rs.getString("clienten") + " " + rs.getString("clienteap");
                registro[5] = rs.getString("idtrabajador");
                registro[6] = rs.getString("trabajadorn") + " " + rs.getString("trabajadorap");
                registro[7] = rs.getString("tipo_reserva");
                registro[8] = rs.getString("fecha_reserva");
                registro[9] = rs.getString("fecha_ingresa");
                registro[10] = rs.getString("fecha_salida");
                registro[11] = rs.getString("costo_alojamiento");
                registro[12] = rs.getString("estado");

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
    public boolean insertar(vReserva dts) {

        sSQL = " INSERT INTO reserva (idhabitacion, idcliente, idtrabajador, tipo_reserva, fecha_reserva, "
                + " fecha_ingresa,fecha_salida,costo_alojamiento,estado) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdhabitacion());
            pst.setInt(2, dts.getIdcliente());
            pst.setInt(3, dts.getIdtrabajador());
            pst.setString(4, dts.getTipo_reserva());
            pst.setDate(5, (Date) dts.getFecha_reserva());
            pst.setDate(6, (Date) dts.getFecha_ingresa());
            pst.setDate(7, (Date) dts.getFecha_salida());
            pst.setDouble(8, dts.getCosto_alojamiento());
            pst.setString(9, dts.getEstado());
            
            System.out.println(dts.getIdhabitacion());
            System.out.println(dts.getIdcliente());
            System.out.println(dts.getIdtrabajador());
            System.out.println(dts.getTipo_reserva());
            System.out.println(dts.getFecha_reserva());
            System.out.println(dts.getFecha_ingresa());
            System.out.println(dts.getFecha_salida());
            System.out.println(dts.getCosto_alojamiento());
            System.out.println(dts.getEstado());
            
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
    public boolean editar(vReserva dts) {

        sSQL = "UPDATE reserva SET idhabitacion=?, idcliente=?, idtrabajador=?, tipo_reserva=?, "
                + " fecha_reserva, fecha_ingresa, fecha_salida,costo_alojamiento, estado WHERE idreserva=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdhabitacion());
            pst.setInt(2, dts.getIdcliente());
            pst.setInt(3, dts.getIdtrabajador());
            pst.setString(4, dts.getTipo_reserva());
            pst.setDate(5, (Date) dts.getFecha_reserva());
            pst.setDate(6, (Date) dts.getFecha_ingresa());
            pst.setDate(7, (Date) dts.getFecha_salida());
            pst.setDouble(8, dts.getCosto_alojamiento());
            pst.setString(9, dts.getEstado());

            pst.setInt(10, dts.getIdreserva());

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

    //----------- FUNCION PAGAR ---------------------
    public boolean pagar(vReserva dts) {

        sSQL = "UPDATE reserva SET estado= 'Pagada"
                + " WHERE idreserva=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdreserva());

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
    public boolean eliminar(vReserva dts) {

        sSQL = "DELETE FROM reserva WHERE idreserva = ?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdreserva());

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
