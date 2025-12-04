package Ejercicios_5_Praticas_Instancias_Java;

public class Comparacion_objetos {

    String titulo;
    String autor;

    int paginas;

    double precio;

    boolean esDigital = false;



    public static void main(String[] args) {
     Comparacion_objetos libro = new Comparacion_objetos();
     libro.titulo = "Cien años de soledad";
     libro.autor = "Gabriel garcia marquez";
     libro.paginas = 150;
     libro.precio = 12.750;
     libro.esDigital = true;

        Comparacion_objetos libro2 = new Comparacion_objetos();
        libro2.titulo = "EL viejo y el mar";
        libro2.autor = "Antonio banderas";
        libro2.paginas = 110;
        libro2.precio = 11.750;


        if(libro.paginas> libro2.paginas){
            System.out.println("--------LIBRO1--------");
            System.out.println("Titulo: " + libro.titulo);
            System.out.println("Autor: " + libro.autor);
            System.out.println("Paginas: " + libro.paginas);
            System.out.println("Precio: " + libro.precio);
            System.out.println("EsDigital: " + libro.esDigital);
            libro2.esDigital = true;
        } else {

            System.out.println("\n--------LIBRO2--------");
            System.out.println("Titulo: " + libro2.titulo);
            System.out.println("Autor: " + libro2.autor);
            System.out.println("Paginas: " + libro2.paginas);
            System.out.println("Precio: " + libro2.precio);
            System.out.println("EsDigital: " + libro2.esDigital);


        }

    }
}
