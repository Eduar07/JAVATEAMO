package colaboracionClases;

// ========== CLASE 1: PLATO ==========
class Plato {
    String nombre;
    double precio;
    int tiempoPreparacion;

    public Plato(String nombre, double precio, int tiempoPreparacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    void mostrarInfo() {
        System.out.println("\n========== PLATO ==========");
        System.out.println("🍽️  " + nombre);
        System.out.println("💰 Precio: $" + precio);
        System.out.println("⏱️  Tiempo: " + tiempoPreparacion + " min");
        System.out.println("===========================");
    }
}

// ========== CLASE 2: MESERO ==========
class Mesero {
    String nombre;
    int pedidosAtendidos;

    public Mesero(String nombre) {
        this.nombre = nombre;
        this.pedidosAtendidos = 0;
    }

    void tomarPedido(Plato plato, int mesa) {
        pedidosAtendidos++;
        System.out.println("👨‍🍳 Mesero " + this.nombre + " tomó pedido de: " + plato.nombre + " (Mesa " + mesa + ")");
    }

    void mostrarEstadisticas() {
        System.out.println("\n--- ESTADÍSTICAS DEL MESERO ---");
        System.out.println("👨‍🍳 " + nombre);
        System.out.println("📊 Pedidos atendidos: " + pedidosAtendidos);
    }
}

// ========== CLASE 3: PEDIDO (COLABORACIÓN) ==========
class Pedido {
    Mesero mesero;
    Plato plato1;
    Plato plato2;
    Plato plato3;
    int mesa;

    public Pedido(Mesero m, int mesa) {
        this.mesero = m;
        this.mesa = mesa;
    }

    void agregarPlato(Plato p, int numero) {
        if (numero == 1) {
            plato1 = p;
            mesero.tomarPedido(p, mesa);  // ← El mesero registra el pedido
        }
        if (numero == 2) {
            plato2 = p;
            mesero.tomarPedido(p, mesa);
        }
        if (numero == 3) {
            plato3 = p;
            mesero.tomarPedido(p, mesa);
        }
    }

    double calcularTotal() {
        double total = 0;
        if (plato1 != null) total += plato1.precio;
        if (plato2 != null) total += plato2.precio;
        if (plato3 != null) total += plato3.precio;
        return total;
    }

    int calcularTiempoTotal() {
        int tiempo = 0;
        if (plato1 != null) tiempo += plato1.tiempoPreparacion;
        if (plato2 != null) tiempo += plato2.tiempoPreparacion;
        if (plato3 != null) tiempo += plato3.tiempoPreparacion;
        return tiempo;
    }

    void mostrarTicket() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║            TICKET                  ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println("📍 Mesa: " + mesa);
        System.out.println("👨‍🍳 Mesero: " + mesero.nombre);
        System.out.println("\n--- PEDIDO ---");

        int contador = 0;
        if (plato1 != null) {
            contador++;
            System.out.println(contador + ". " + plato1.nombre);
            System.out.println("   $" + plato1.precio + " (" + plato1.tiempoPreparacion + " min)");
        }
        if (plato2 != null) {
            contador++;
            System.out.println(contador + ". " + plato2.nombre);
            System.out.println("   $" + plato2.precio + " (" + plato2.tiempoPreparacion + " min)");
        }
        if (plato3 != null) {
            contador++;
            System.out.println(contador + ". " + plato3.nombre);
            System.out.println("   $" + plato3.precio + " (" + plato3.tiempoPreparacion + " min)");
        }

        System.out.println("\n─────────────────────────────────────");
        System.out.println("💰 TOTAL: $" + calcularTotal());
        System.out.println("⏱️  Tiempo estimado: " + calcularTiempoTotal() + " min");
        System.out.println("═════════════════════════════════════\n");
    }
}

// ========== MAIN ==========
public class SistemaRestaurante {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE RESTAURANTE v1.0        ║");
        System.out.println("╚═══════════════════════════════════════╝\n");

        // Crear platos del menú
        Plato plato1 = new Plato("Arroz con Pollo", 23000, 30);
        Plato plato2 = new Plato("Arroz Chino", 18000, 19);
        Plato plato3 = new Plato("Arroz con Arveja", 27000, 28);
        Plato plato4 = new Plato("Bandeja Paisa", 35000, 40);
        Plato plato5 = new Plato("Ajiaco", 28000, 35);

        // Mostrar menú
        System.out.println("════════════ MENÚ DEL DÍA ════════════");
        plato1.mostrarInfo();
        plato2.mostrarInfo();
        plato3.mostrarInfo();
        plato4.mostrarInfo();
        plato5.mostrarInfo();

        // Crear meseros
        Mesero mesero1 = new Mesero("Carlos Hernández");
        Mesero mesero2 = new Mesero("Ana María López");

        System.out.println("\n\n════════════ PEDIDOS ════════════\n");

        // ✅ PEDIDO 1: Mesa 5 con 3 platos
        Pedido pedido1 = new Pedido(mesero1, 5);
        pedido1.agregarPlato(plato1, 1);
        pedido1.agregarPlato(plato2, 2);
        pedido1.agregarPlato(plato3, 3);
        pedido1.mostrarTicket();

        // ✅ PEDIDO 2: Mesa 8 con 2 platos
        Pedido pedido2 = new Pedido(mesero2, 8);
        pedido2.agregarPlato(plato4, 1);
        pedido2.agregarPlato(plato5, 2);
        pedido2.mostrarTicket();

        // ✅ PEDIDO 3: Mesa 12 con 1 plato
        Pedido pedido3 = new Pedido(mesero1, 12);
        pedido3.agregarPlato(plato1, 1);
        pedido3.mostrarTicket();

        // Estadísticas finales
        System.out.println("\n════════════ ESTADÍSTICAS ════════════");
        mesero1.mostrarEstadisticas();
        mesero2.mostrarEstadisticas();
    }
}
