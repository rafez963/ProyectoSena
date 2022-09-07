
package Datos;

public class vCliente extends vPersona {
    private String codigo_cliente;

    public vCliente() {
    }
    
    public vCliente(String codigo_cliente){
        this.codigo_cliente=codigo_cliente;
    }
/*
   public vCliente(int idpersona, String nombre, String apaterno,String amaterno, String tipo_documento, String num_documento, String direccion, String telefono, String email) {
        super(idpersona, nombre, apaterno,amaterno, tipo_documento, num_documento, direccion, telefono, email);
    }
*/
    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
    
}
