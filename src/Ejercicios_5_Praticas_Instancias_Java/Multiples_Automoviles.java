package Ejercicios_5_Praticas_Instancias_Java;

public class Multiples_Automoviles {

    String marca;
    int modelo;

    int anio;


    public static void main(String[] args) {

        Multiples_Automoviles Automovil = new Multiples_Automoviles();
        Automovil.marca = "Maclaren";
        Automovil.modelo = 2025;
        Automovil.anio = 1995;

        Multiples_Automoviles Automovil2 = new Multiples_Automoviles();
        Automovil2.marca = "BMW";
        Automovil2.modelo = 2020;
        Automovil2.anio = 1994;

        Multiples_Automoviles Automovil3 = new Multiples_Automoviles();
        Automovil3.marca = "Ferrari";
        Automovil3.modelo = 2005;
        Automovil3.anio = 1998;




        System.out.println("--------Automovil1--------");
        System.out.println("Marca: " + Automovil.marca);
        System.out.println("Modelo: " + Automovil.modelo);
        System.out.println("Año: " + Automovil.anio);

        System.out.println("\n--------Automovil2--------");
        System.out.println("Marca: " + Automovil2.marca);
        System.out.println("Modelo: " + Automovil2.modelo);
        System.out.println("Año: " + Automovil2.anio);

        System.out.println("\n--------Automovil3--------");
        System.out.println("Marca: " + Automovil3.marca);
        System.out.println("Modelo: " + Automovil3.modelo);
        System.out.println("Año: " + Automovil3.anio);

}
    }