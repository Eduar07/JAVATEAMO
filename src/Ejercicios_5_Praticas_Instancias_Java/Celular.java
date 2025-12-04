package Ejercicios_5_Praticas_Instancias_Java;

public class Celular {

    String marca;
    int modelo;

    String almacenamiento;

    String ram;

    boolean tiene5G = false;

    public static void main(String[] args) {

        Celular movil = new Celular();
        movil.marca = "Iphone";
        movil.modelo = 2025;
        movil.almacenamiento = "25GB";
        movil.ram = "16RAM";
        movil.tiene5G = true;

        Celular movil2 = new Celular();
        movil2.marca = "Xiaomi";
        movil2.modelo = 2015;
        movil2.almacenamiento = "15GB";
        movil2.ram = "8RAM";
        movil2.tiene5G = false;

        Celular movil3 = new Celular();
        movil3.marca = "Samsungs";
        movil3.modelo = 2005;
        movil3.almacenamiento = "15GB";
        movil3.ram = "5RAM";
        movil3.tiene5G = true;


        System.out.println("--------MOVIL1--------");
        System.out.println("Marca: " + movil.marca);
        System.out.println("Modelo: " + movil.modelo);
        System.out.println("Almacenamiento: " + movil.almacenamiento);
        System.out.println("Ram: " + movil.ram);
        System.out.println("Tiene5G: " + movil.tiene5G);




        System.out.println("--------MOVIL2--------");
        System.out.println("Marca: " + movil2.marca);
        System.out.println("Modelo: " + movil2.modelo);
        System.out.println("Almacenamiento: " + movil2.almacenamiento);
        System.out.println("Ram: " + movil2.ram);
        System.out.println("Tiene5G: " + movil2.tiene5G);




        System.out.println("--------MOVIL3--------");
        System.out.println("Marca: " + movil3.marca);
        System.out.println("Modelo: " + movil3.modelo);
        System.out.println("Almacenamiento: " + movil3.almacenamiento);
        System.out.println("Ram: " + movil3.ram);
        System.out.println("Tiene5G: " + movil3.tiene5G);


    }
}
