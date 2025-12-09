package Contructores_Metodos;

public class Persona {
    String nombre;
    int edad;
    String ciudad;

    public Persona(String nombre, int edad, String ciudad){
       this.nombre = nombre;
       this.edad = edad;
       this.ciudad = ciudad;
    }

    void cambiarEdad(int nuevaEdad){
        if(nuevaEdad<0){
            System.out.println("La edad no puede ser negativa");
        }else{
            edad = nuevaEdad;
            System.out.println("Su edad es "+ nuevaEdad);
        }
    }

    void cambiarCiudad(String nuevaCiudad){
        ciudad = nuevaCiudad;
        System.out.println("Ciudad actualizada a :" + ciudad);
    }

    void mostrarInfo(){
        System.out.println("--- Información Personal ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Ciudad: " + ciudad);
        System.out.println();
    }
    public static void main(String[] args) {
        Persona persona1 = new Persona("eduad", 5, "bucaramanga");
        persona1.mostrarInfo();
        persona1.cambiarCiudad("Bogota");
        persona1.mostrarInfo();
        persona1.cambiarEdad(50);
        persona1.mostrarInfo();
    }
}

