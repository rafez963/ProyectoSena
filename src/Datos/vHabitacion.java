package Datos;

public class vHabitacion {

    private static int idhabitacion;
    private static String numero;
    private static String piso;
    private static String descripcion;
    private static String caracteristicas;
    private static Double precio_diario;
    private static String estado;
    private static String tipo_habitacion;

    public vHabitacion(int idhabitacion, String numero, String piso, String descripcion, String caracteristicas, Double precio_diario, String estado, String tipo_habitacion) {
        this.idhabitacion = idhabitacion;
        this.numero = numero;
        this.piso = piso;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.precio_diario = precio_diario;
        this.estado = estado;
        this.tipo_habitacion = tipo_habitacion;

    }

    public vHabitacion() {
    }

    public static int getIdhabitacion() {
        return idhabitacion;
    }

    public static void setIdhabitacion(int idhabitacion) {
        vHabitacion.idhabitacion = idhabitacion;
    }

    public static String getNumero() {
        return numero;
    }

    public static void setNumero(String numero) {
        vHabitacion.numero = numero;
    }

    public static String getPiso() {
        return piso;
    }

    public static void setPiso(String piso) {
        vHabitacion.piso = piso;
    }

    public static String getDescripcion() {
        return descripcion;
    }

    public static void setDescripcion(String descripcion) {
        vHabitacion.descripcion = descripcion;
    }

    public static String getCaracteristicas() {
        return caracteristicas;
    }

    public static void setCaracteristicas(String caracteristicas) {
        vHabitacion.caracteristicas = caracteristicas;
    }

    public static Double getPrecio_diario() {
        return precio_diario;
    }

    public static void setPrecio_diario(Double precio_diario) {
        vHabitacion.precio_diario = precio_diario;
    }

    public static String getEstado() {
        return estado;
    }

    public static void setEstado(String estado) {
        vHabitacion.estado = estado;
    }

    public static String getTipo_habitacion() {
        return tipo_habitacion;
    }

    public static void setTipo_habitacion(String tipo_habitacion) {
        vHabitacion.tipo_habitacion = tipo_habitacion;
    }

}
