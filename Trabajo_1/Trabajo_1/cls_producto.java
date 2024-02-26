//**@author Alejandra**//

package Trabajo_1;

public class cls_producto {
    private String nombre;
    private String codigo_producto;
    private int existencias;
    private String fecha_registro;
    private float precio;
    
    public cls_producto(String nombre, String codigo_producto, int existencias, String fecha_registro, float precio) {
        this.nombre = nombre;
        this.codigo_producto = codigo_producto;
        this.existencias = existencias;
        this.fecha_registro = fecha_registro;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }
    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public int getExistencias() {
        return existencias;
    }
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }
    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
}