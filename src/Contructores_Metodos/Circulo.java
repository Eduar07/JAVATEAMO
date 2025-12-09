package Contructores_Metodos;

public class Circulo {

double radio;

    public Circulo(double radio){
        if (radio > 0) {
            this.radio = radio;
        } else {
            this.radio = 1;  // Valor por defecto si es inválido
            System.out.println("⚠️ Radio inválido. Se estableció en 1");
        }
    }

void setRadio(double nuevoRadio){
    if (nuevoRadio > 0) {
        this.radio = nuevoRadio;  // 👈 REEMPLAZA (no suma)
        System.out.println("✅ Radio actualizado a: " + nuevoRadio);
    } else {
        System.out.println("❌ Error: El radio debe ser mayor a 0");
    }
}

double getRadio(){
    return radio;
}

double calcularArea(){
    return Math.PI * radio * radio;
}

double Perimetro(){
        return 2 * Math.PI * radio;
}

double calcularDiametro(){
        return 2 * radio;
}

    void compararCon(Circulo otroCirculo) {
        double miArea = this.calcularArea();
        double otraArea = otroCirculo.calcularArea();

        System.out.println("\n========== COMPARACIÓN DE CÍRCULOS ==========");
        System.out.println("Círculo 1 - Radio: " + this.radio + " → Área: " + String.format("%.2f", miArea));
        System.out.println("Círculo 2 - Radio: " + otroCirculo.radio + " → Área: " + String.format("%.2f", otraArea));

        if (miArea > otraArea) {
            System.out.println("🔴 El PRIMER círculo tiene MAYOR área");
        } else if (miArea == otraArea) {
            System.out.println("🟡 Ambos círculos tienen la MISMA área");
        } else {
            System.out.println("🔵 El SEGUNDO círculo tiene MAYOR área");
        }
        System.out.println("============================================\n");
    }

    void mostrarInformacion() {
        System.out.println("\n========== INFORMACIÓN DEL CÍRCULO ==========");
        System.out.println("Radio:      " + String.format("%.2f", getRadio()));
        System.out.println("Diámetro:   " + String.format("%.2f", calcularDiametro()));
        System.out.println("Área:       " + String.format("%.2f", calcularArea()));
        System.out.println("Perímetro:  " + String.format("%.2f", Perimetro()));
        System.out.println("============================================\n");
    }

    public static void main(String[] args) {
        System.out.println("=== CREANDO CÍRCULOS ===\n");

        Circulo circulo1 = new Circulo(23);
        Circulo circulo2 = new Circulo(45);

        System.out.println("\n--- Estado inicial ---");
        circulo1.mostrarInformacion();
        circulo2.mostrarInformacion();

        System.out.println("--- Modificando radios ---");
        circulo1.setRadio(40);
        circulo2.setRadio(30);

        System.out.println("\n--- Estado después de modificar ---");
        circulo1.mostrarInformacion();
        circulo2.mostrarInformacion();

        // Comparación usando el método
        circulo1.compararCon(circulo2);

        // Intentar establecer radio negativo
        System.out.println("--- Probando validación ---");
        circulo1.setRadio(-10);

        // Crear círculo con radio inválido
        Circulo circulo3 = new Circulo(-5);
        circulo3.mostrarInformacion();
    }
}
