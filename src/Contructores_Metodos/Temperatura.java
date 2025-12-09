package Contructores_Metodos;

public class Temperatura {
    double celsius;

    // Constructor
    public Temperatura(double celsius) {
        this.celsius = celsius;
    }

    // ========== MÉTODOS SET (modifican celsius) ==========

    void setCelsius(double temp) {
        this.celsius = temp;
        System.out.println("✅ Temperatura establecida: " + celsius + "°C");
    }

    void setFahrenheit(double fahrenheit) {
        this.celsius = (fahrenheit - 32) * 5.0 / 9.0;  // 5.0 para división decimal
        System.out.println("✅ Convertido de " + fahrenheit + "°F a " + celsius + "°C");
    }

    void setKelvin(double kelvin) {
        this.celsius = kelvin - 273.15;
        System.out.println("✅ Convertido de " + kelvin + "K a " + celsius + "°C");
    }

    // ========== MÉTODOS GET (consultan y convierten) ==========

    double getCelsius() {
        return celsius;
    }

    double getFahrenheit() {
        return (celsius * 9.0 / 5.0) + 32;  // 9.0 para división decimal
    }

    double getKelvin() {
        return celsius + 273.15;
    }


    void mostrarTemperaturas() {
        System.out.println("\n========== TEMPERATURAS ==========");
        System.out.println("Celsius:    " + String.format("%.2f", getCelsius()) + "°C");
        System.out.println("Fahrenheit: " + String.format("%.2f", getFahrenheit()) + "°F");
        System.out.println("Kelvin:     " + String.format("%.2f", getKelvin()) + "K");
        System.out.println("==================================\n");
    }

    public static void main(String[] args) {
        // Crear objeto con 25°C
        Temperatura temp = new Temperatura(25);
        System.out.println("--- Temperatura inicial: 25°C ---");
        temp.mostrarTemperaturas();

        // Cambiar a 100°F
        System.out.println("--- Cambiando a 100°F ---");
        temp.setFahrenheit(100);
        temp.mostrarTemperaturas();

        // Cambiar a 300K
        System.out.println("--- Cambiando a 300K ---");
        temp.setKelvin(300);
        temp.mostrarTemperaturas();

        // Cambiar directamente a 0°C
        System.out.println("--- Cambiando a 0°C ---");
        temp.setCelsius(0);
        temp.mostrarTemperaturas();
    }
}