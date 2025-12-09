package Contructores_Metodos;

public class Empleado {

    String nombre;
    String puesto;
    double sueldo;

    public Empleado(String nombre, String puesto, double sueldo){
        this.nombre = nombre;
        this.puesto = puesto;
        this.sueldo = sueldo;

    }

    void aumentarSalario(double porcentaje){
        double aumento = sueldo * porcentaje / 100;
        sueldo = sueldo + aumento;
        System.out.println("Aumento aplicado: $ " + aumento);
    }

    void mostrarInfo(){
        System.out.println("---Informacion del Empleaedo");
        System.out.println("Nombre: " +nombre);
        System.out.println("Puesto: " + puesto);
        System.out.println("Salario: $" + sueldo);
     }
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("eduar guerrero", "ingeniero", 20000);
        Empleado empleado2 = new Empleado("andres mauricio", "abogado", 12000);
        empleado1.mostrarInfo();
        empleado1.aumentarSalario(20);
        empleado1.mostrarInfo();

        empleado2.mostrarInfo();
    }
}
