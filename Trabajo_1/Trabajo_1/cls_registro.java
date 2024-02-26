package Trabajo_1;
//import Trabajo_1.cls_producto;

public class cls_registro {
    private String fecha;
    private String codigo;
    private int cantidad;
    private float subtotal;
    
    public cls_registro(String fecha, String codigo, int cantidad, float subtotal) {
        this.fecha = fecha;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.subtotal = (float) ((subtotal * cantidad));
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
}