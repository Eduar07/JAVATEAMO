package Contructores_Metodos;

public class Producto {

    String nombre;
    double precio;
    int stock;

    public Producto(){
        precio = 0.0;
        stock = 0;
        nombre = "Sin nombre";
    }

    public Producto(String nombre, double precio, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    void vender(int cantidad){
       if(cantidad<stock){
           stock = stock - cantidad;
           System.out.println("Unidades vendidas: " + cantidad);
       }else{
           System.out.println("Producto agotados");
       }
    }

    void reestablecer(int cantidad){
        stock = stock + cantidad;
        System.out.println("Reabastecido: " + cantidad +" Unidades");
    }


    void mostrarInfo(){
        System.out.println("--- Producto ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Stock: " + stock);
        System.out.println();
    }

    public static void main(String[] args) {
        Producto producto1 = new Producto();
        producto1.mostrarInfo();
        Producto Producto2 = new Producto("Lapto", 23900, 45);
        Producto2.mostrarInfo();
        Producto2.vender(5);
        Producto2.mostrarInfo();
        Producto2.reestablecer(8);
        Producto2.mostrarInfo();
    }
}
