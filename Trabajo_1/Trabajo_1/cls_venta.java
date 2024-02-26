package Trabajo_1;

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class cls_venta {
    static LinkedList<cls_producto> productos = new LinkedList<cls_producto>();
    static LinkedList<cls_registro> registros = new LinkedList<cls_registro>();
    static int posicionInt;
    static boolean swBln;

    public static void main(String[] args) {
        fnt_menu(true);
    }

    private static void fnt_registrar_producto() {
        String nombre = JOptionPane.showInputDialog(null, "Nombre");
        String codigo_producto = JOptionPane.showInputDialog(null, "Codigo del producto");
        int existencias = Integer.parseInt(JOptionPane.showInputDialog(null, "Existencias"));
        String fecha_registro = JOptionPane.showInputDialog(null, "Fecha de Ingreso");
        float precio = Integer.parseInt(JOptionPane.showInputDialog(null, "Precio de Producto"));
        productos.add(new cls_producto(nombre, codigo_producto, existencias, fecha_registro, precio));
        JOptionPane.showMessageDialog(null, "SE REGISTRO EXITOSAMENTE");
    }
    
    private static void fnt_consultar_producto() {
        String codigo = JOptionPane.showInputDialog(null, "Codigo del producto");
        swBln = false;
        posicionInt = 0;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo_producto() == codigo) {
                swBln = true;
                posicionInt = i;
                break;
            }
        }
        if (swBln == false) {
            JOptionPane.showMessageDialog(null, "NO SE ENCONTRO EL PRODUCTO INGRESADO");
        } else {
            JOptionPane.showMessageDialog(null, "NOMBRE: " + productos.get(posicionInt).getNombre()
                    + "\nCODIGO DE PRODUCTO: " + productos.get(posicionInt).getCodigo_producto() + "\nEXISTENCIAS: "
                    + "\nFECHA DE REGISTRO: " + productos.get(posicionInt).getFecha_registro()
                    + "\nPRECIO: " + productos.get(posicionInt).getPrecio());
        }
    }

    private static void fnt_actualizar_producto() {
        String codigo = JOptionPane.showInputDialog(null, "Codigo");
        swBln = false;
        for (int p = 0; p < productos.size(); p++) {
            if (registros.get(p).getCodigo().equals(codigo)) {
                swBln = true;
                break;
            }
        }
        if (swBln == false) {
            JOptionPane.showMessageDialog(null, "NO SE ENCONTRARAON REGISTROS");
        } else {
            String nuevoPrecioStr = JOptionPane.showInputDialog(null, "Ingrese el nuevo precio del producto");
            float nuevoPrecio = Float.parseFloat(nuevoPrecioStr);
            for (int i = 0; i < productos.size(); i++) {
                if (productos.get(i).getCodigo_producto().equals(codigo)) {
                    productos.get(i).setPrecio(nuevoPrecio);
                    int cantidadVendida = registros.get(i).getCantidad();
                    productos.get(i).setExistencias(productos.get(i).getExistencias() - cantidadVendida);
                    JOptionPane.showMessageDialog(null, "PRODUCTO ACTUALIZADO CON EXITO");
                    break;
                }
            }
        }
    }

    private static void fnt_productos(boolean m1) {
        while (m1 == true) {
            String op1 = JOptionPane.showInputDialog(null,
                    "REGISTRO DE PRODUTOS\n1. REGISTRAR\n2. CONSULTAR\n3. ACTUALIZAR\n4. SALIR");
            switch (op1) {
                case "1":
                    fnt_registrar_producto();
                    break;
                case "2":
                    fnt_consultar_producto();
                    break;
                case "3":
                    fnt_actualizar_producto();
                    break;
                case "4":
                    m1 = false;
                    break;
                default:
                    JOptionPane.showInputDialog(null, "ERROR");
            }
        }
    }

    private static void fnt_registrar() {
        String fecha = JOptionPane.showInputDialog(null, "Fecha");
        String codigo = JOptionPane.showInputDialog(null, "Codigo");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad"));
        float subtotal = Float.parseFloat(JOptionPane.showInputDialog(null, "Subtotal"));
        registros.add(new cls_registro(fecha, codigo, cantidad, subtotal));
        JOptionPane.showMessageDialog(null, "PRODUCTO REGISTRADO CON EXITOSAMENTE");
    }

    private static void fnt_reporte_ventas() {
        String codigo_producto = JOptionPane.showInputDialog(null, "Codigo");
        swBln = false;
        for (int p = 0; p < productos.size(); p++) {
            if (registros.get(p).getCodigo().equals(codigo_producto)) {
                swBln = true;
                break;
            }
        }
        if (swBln == false) {
            JOptionPane.showMessageDialog(null, "NO SE ENCONTRARAON REGISTROS");
        } else {
            for (int i = 0; i < registros.size(); i++) {
                if (registros.get(i).getCodigo().equals(codigo_producto)) {
                    JOptionPane.showMessageDialog(null, 
                    "FECHA REGISTRO: " + registros.get(i).getFecha() +
                    "\nPRECIO: " + registros.get(i).getSubtotal() + 
                    "\nCANTIDAD: " + registros.get(i).getCantidad() +
                    "\nMAS IVA: " + registros.get(i).getSubtotal() * 0.15 +
                    "\nPRECIO TOTAL: " + (registros.get(i).getSubtotal() + (registros.get(i).getSubtotal()*0.15)));
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE ENCONTRARON DATOS");
                }
            }
        }
    }

    private static void fnt_registrarventa(boolean m2) {
        while (m2 == true) {
            String op2 = JOptionPane.showInputDialog(null,
                    "REGISTRAR VENTA\n1. REGISTRAR\n2. REPORTE DE VENTA\n 3.SALIR");
            switch (op2) {
                case "1":
                    fnt_registrar();
                    break;
                case "2":
                    fnt_reporte_ventas();
                    break;
                case "3":
                    m2 = false;
                    break;
                default:
                    JOptionPane.showInputDialog(null, "ERROR");
            }
        }
    }

    private static void fnt_menu(boolean men) {
        while (men == true) {
            String opcion = JOptionPane.showInputDialog(null,
                    "MENU DE OPCIONES\n1. REGISTRAR PRODUCTO\n2. REALIZAR UNA VENTA\n3. SALIR");
            switch (opcion) {
                case "1":
                    fnt_productos(true);
                    break;
                case "2":
                    fnt_registrarventa(true);
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showInputDialog(null, "ERROR");
            }
        }
    }
}