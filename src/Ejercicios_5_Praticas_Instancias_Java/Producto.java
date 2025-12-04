package Ejercicios_5_Praticas_Instancias_Java;

public class Producto {
    String nombre;
    double precio;
    int cantidad;
    String categoria;
    boolean enOferta = false;

    public static void main(String[] args) {
       Producto Producto1 = new Producto();
       Producto1.nombre = "Camisa";
       Producto1.precio = 25500;
       Producto1.cantidad = 100;
       Producto1.enOferta = true;

        Producto Producto2 = new Producto();
        Producto2.nombre = "Pantalon";
        Producto2.precio = 20000;
        Producto2.cantidad = 500;
        Producto2.enOferta = true;



        System.out.println("--------Producto1--------");
        System.out.println("Nombre: " + Producto1.nombre);
        System.out.println("Precio: " + Producto1.precio);
        System.out.println("Cantidad: " + Producto1.cantidad);
        System.out.println("enOFerta: " + Producto1.enOferta);

        System.out.println("\n--------Producto2--------");
        System.out.println("Nombre: " + Producto2.nombre);
        System.out.println("Precio: " + Producto2.precio);
        System.out.println("Cantidad: " + Producto2.cantidad);
        System.out.println("enOFerta: " + Producto2.enOferta);

    }
}
