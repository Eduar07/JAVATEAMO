package Ejercicios_5_Praticas_Instancias_Java;

public class Estudiantes {

    String nombre;
    int edad;
    String Carrera;
    int semestre;
    boolean esActivo = false;


    public static void main(String[] args) {
        //PRIMER ESTUDIANTE

        Estudiantes estudiante1 = new Estudiantes();
        estudiante1.nombre = "Eduar";
        estudiante1.edad = 12;
        estudiante1.Carrera = "Ingeniera de Software";
        estudiante1.semestre = 6;
        estudiante1.esActivo = true;

        //SEGUNDO ESTUDIANTE

        Estudiantes estudiante2= new Estudiantes();
        estudiante2.nombre = "Michel";
        estudiante2.edad = 30;
        estudiante2.Carrera = "Ingeniero de Sistemas";
        estudiante2.semestre = 5;
        estudiante2.esActivo = true;

        System.out.println("--------Estudiante1--------");
        System.out.println("Nombre: " + estudiante1.nombre);
        System.out.println("Edad: " + estudiante1.edad);
        System.out.println("Carrera: " + estudiante1.Carrera);
        System.out.println("Semestre: " + estudiante1.semestre);
        System.out.println("Esta activo: " + estudiante1.esActivo);

        System.out.println("\n---------Estudiante2--------");
        System.out.println("Nombre: " + estudiante2.nombre);
        System.out.println("Edad: " + estudiante2.edad);
        System.out.println("Carrera: " + estudiante2.Carrera);
        System.out.println("Semestre: " + estudiante2.semestre);
        System.out.println("Esta activo: " + estudiante2.esActivo);

    }
}

