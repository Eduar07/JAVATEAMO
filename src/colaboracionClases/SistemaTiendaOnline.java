package colaboracionClases;

// ========== CLASE 1: PRODUCTO ==========
class Producto {
    String nombre;
    double precio;
    int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    boolean hayStock(int cantidad) {
        return stock >= cantidad;
    }

    void reducirStock(int cantidad) {
        stock -= cantidad;
        System.out.println("✅ Stock actualizado de " + nombre + ": " + stock + " unidades");
    }

    void mostrarInfo() {
        System.out.println("\n========== PRODUCTO ==========");
        System.out.println("📦 Nombre: " + nombre);
        System.out.println("💰 Precio: $" + precio);
        System.out.println("📊 Stock: " + stock + " unidades");
        System.out.println("==============================");
    }
}

// ========== CLASE 2: CLIENTE ==========
class Cliente {
    String nombre;
    String direccion;
    double saldo;

    public Cliente(String nombre, String direccion, double saldo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.saldo = saldo;
    }

    boolean tieneSaldoSuficiente(double monto) {
        return saldo >= monto;
    }

    void reducirSaldo(double monto) {
        saldo -= monto;
        System.out.println("💳 Saldo restante de " + nombre + ": $" + saldo);
    }

    void mostrarInfo() {
        System.out.println("\n========== CLIENTE ==========");
        System.out.println("👤 Nombre: " + nombre);
        System.out.println("📍 Dirección: " + direccion);
        System.out.println("💵 Saldo: $" + saldo);
        System.out.println("=============================");
    }
}

// ========== CLASE 3: CARRITO DE COMPRAS ==========
class CarritoCompras {
    Cliente cliente;
    Producto producto1;
    Producto producto2;
    Producto producto3;
    int cantidadProd1;
    int cantidadProd2;
    int cantidadProd3;

    // Constructor solo recibe el cliente
    public CarritoCompras(Cliente c) {
        this.cliente = c;
        this.cantidadProd1 = 0;
        this.cantidadProd2 = 0;
        this.cantidadProd3 = 0;
    }

    void agregarProducto(Producto p, int cantidad, int posicion) {
        // Verificar stock
        if (!p.hayStock(cantidad)) {
            System.out.println("❌ No hay suficiente stock de " + p.nombre);
            System.out.println("   Stock disponible: " + p.stock);
            return;
        }

        // Agregar al carrito según la posición
        if (posicion == 1) {
            producto1 = p;
            cantidadProd1 = cantidad;
            System.out.println("✅ Agregado al carrito: " + cantidad + "x " + p.nombre);
        } else if (posicion == 2) {
            producto2 = p;
            cantidadProd2 = cantidad;
            System.out.println("✅ Agregado al carrito: " + cantidad + "x " + p.nombre);
        } else if (posicion == 3) {
            producto3 = p;
            cantidadProd3 = cantidad;
            System.out.println("✅ Agregado al carrito: " + cantidad + "x " + p.nombre);
        }
    }

    double calcularTotal() {
        double total = 0;
        if (producto1 != null) total += producto1.precio * cantidadProd1;
        if (producto2 != null) total += producto2.precio * cantidadProd2;
        if (producto3 != null) total += producto3.precio * cantidadProd3;
        return total;
    }

    void mostrarCarrito() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║         CARRITO DE COMPRAS           ║");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.println("👤 Cliente: " + cliente.nombre);
        System.out.println("\n--- PRODUCTOS ---");

        if (producto1 != null) {
            System.out.println("1. " + producto1.nombre + " x" + cantidadProd1 +
                    " = $" + (producto1.precio * cantidadProd1));
        }
        if (producto2 != null) {
            System.out.println("2. " + producto2.nombre + " x" + cantidadProd2 +
                    " = $" + (producto2.precio * cantidadProd2));
        }
        if (producto3 != null) {
            System.out.println("3. " + producto3.nombre + " x" + cantidadProd3 +
                    " = $" + (producto3.precio * cantidadProd3));
        }

        System.out.println("\n💰 TOTAL: $" + calcularTotal());
        System.out.println("═══════════════════════════════════════\n");
    }

    void finalizarCompra() {
        double total = calcularTotal();

        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║       FINALIZANDO COMPRA             ║");
        System.out.println("╚═══════════════════════════════════════╝");

        // Verificar saldo
        if (!cliente.tieneSaldoSuficiente(total)) {
            System.out.println("❌ COMPRA RECHAZADA");
            System.out.println("   Saldo insuficiente");
            System.out.println("   Necesitas: $" + total);
            System.out.println("   Tienes: $" + cliente.saldo);
            System.out.println("   Faltan: $" + (total - cliente.saldo));
            return;
        }

        // Reducir saldo del cliente
        cliente.reducirSaldo(total);

        // Reducir stock de productos
        if (producto1 != null) producto1.reducirStock(cantidadProd1);
        if (producto2 != null) producto2.reducirStock(cantidadProd2);
        if (producto3 != null) producto3.reducirStock(cantidadProd3);

        System.out.println("\n✅ ¡COMPRA EXITOSA!");
        System.out.println("   Total pagado: $" + total);
        System.out.println("   Envío a: " + cliente.direccion);
        System.out.println("═══════════════════════════════════════\n");
    }
}

// ========== MAIN ==========
public class SistemaTiendaOnline {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║     TIENDA ONLINE v1.0               ║");
        System.out.println("╚═══════════════════════════════════════╝\n");

        // Crear productos
        Producto prod1 = new Producto("Laptop HP", 3500000, 5);
        Producto prod2 = new Producto("Mouse Logitech", 85000, 20);
        Producto prod3 = new Producto("Teclado Mecánico", 250000, 10);
        Producto prod4 = new Producto("Monitor 24\"", 800000, 3);

        // Mostrar catálogo
        System.out.println("════════════ CATÁLOGO ════════════");
        prod1.mostrarInfo();
        prod2.mostrarInfo();
        prod3.mostrarInfo();
        prod4.mostrarInfo();

        // Crear clientes
        Cliente cliente1 = new Cliente("Juan Pérez", "Calle 123 #45-67", 5000000);
        Cliente cliente2 = new Cliente("María López", "Carrera 50 #20-30", 1000000);

        cliente1.mostrarInfo();
        cliente2.mostrarInfo();

        System.out.println("\n\n════════════ COMPRA 1 ════════════\n");

        // Carrito de Juan
        CarritoCompras carrito1 = new CarritoCompras(cliente1);
        carrito1.agregarProducto(prod1, 1, 1);  // 1 laptop
        carrito1.agregarProducto(prod2, 2, 2);  // 2 mouses
        carrito1.agregarProducto(prod3, 1, 3);  // 1 teclado
        carrito1.mostrarCarrito();
        carrito1.finalizarCompra();

        System.out.println("\n\n════════════ COMPRA 2 ════════════\n");

        // Carrito de María (sin saldo suficiente)
        CarritoCompras carrito2 = new CarritoCompras(cliente2);
        carrito2.agregarProducto(prod1, 1, 1);  // Intenta comprar laptop
        carrito2.agregarProducto(prod4, 2, 2);  // Intenta 2 monitores
        carrito2.mostrarCarrito();
        carrito2.finalizarCompra();  // Será rechazada

        // Estado final
        System.out.println("\n════════════ ESTADO FINAL ════════════");
        cliente1.mostrarInfo();
        cliente2.mostrarInfo();
        prod1.mostrarInfo();
        prod2.mostrarInfo();
    }
}
