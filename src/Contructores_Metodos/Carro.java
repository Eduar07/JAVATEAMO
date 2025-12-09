package Contructores_Metodos;

public class Carro {

    String marca;
    int modelo;
    int velocidadActual = 0;
    int velocidadMaxima;
    boolean encendido = false;

    public Carro(String marca, int modelo, int velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.velocidadActual = 0;        // Siempre inicia en 0
        this.encendido = false;           // Siempre inicia apagado
    }

     void encender(){
       encendido= true;
        System.out.println("El vehiculo esta encendido");
    }

    void apagar(){
        encendido = false;        // 👈 Cambia el estado
        velocidadActual = 0;      // 👈 Al apagar, velocidad a 0
        System.out.println("✅ El vehículo ha sido apagado");

    }

    void acelerar(int incremento){
        if(!encendido){
            System.out.println("Nopuedes acelerar, el carro esta apagado");
            return;
        }
        if(velocidadActual + incremento <= velocidadMaxima){
            velocidadActual +=incremento;
            System.out.println("Accelerando... velocidad " + velocidadActual + "km/hora");
        }else{
            velocidadActual = velocidadMaxima;
            System.out.println(" Has alcanzado la velocidad maxima: " +velocidadMaxima + "km/hora");
        }
    }

    void frenar(int decremento){
        if(velocidadActual - decremento >= 0){
            velocidadActual -= decremento;
            System.out.println(" Frenando... velocidad: " + velocidadActual + "km/h");
        }else{
            velocidadActual = 0;
            System.out.println("El vehiculo se ha detenido completamente");
        }
    }

  int getVelocidadActual(){
        return velocidadActual;
  }

  int getVelocidadMaxima(){
        return  velocidadMaxima;
  }

  boolean estaEncendido(){
        return encendido;
  }

    void mostrarEstado(){
        System.out.println("\n========== ESTADO DEL VEHÍCULO ==========");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidad actual: " + velocidadActual + " km/h");
        System.out.println("Velocidad máxima: " + velocidadMaxima + " km/h");
        System.out.println("Estado: " + (encendido ? "Encendido 🟢" : "Apagado 🔴"));
        System.out.println("=========================================\n");
    }

    public static void main(String[] args) {
        Carro auto= new Carro("Bmw", 2013,200);
        auto.mostrarEstado();
        auto.acelerar(50);
        auto.encender();
        auto.mostrarEstado();
        auto.acelerar(50);
        auto.acelerar(80);
        auto.acelerar(100);  // Intentará pasar el límite
        auto.mostrarEstado();
        auto.acelerar(150);
        auto.mostrarEstado();
        auto.apagar();
        auto.mostrarEstado();
}
}
