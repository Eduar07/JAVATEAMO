
package colaboracionClases;

// ========== CLASE 1: LIBRO (SIN public) ==========
class Libro {
    String titulo;
    String autor;
    boolean disponible;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    void marcarComoPrestado() {
        disponible = false;
    }

    void marcarComoDisponible() {
        disponible = true;
    }

    boolean estaDisponible() {
        return disponible;
    }

    void mostrarInfo() {
        System.out.println("📚 Libro: " + titulo);
        System.out.println("   Autor: " + autor);
        System.out.println("   Estado: " + (disponible ? "Disponible ✅" : "Prestado ❌"));
    }
}

// ========== CLASE 2: USUARIO (SIN public) ==========
class Usuario {
    String nombre;
    int librosPrestados;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.librosPrestados = 0;
    }

    void prestarLibro() {
        librosPrestados++;
    }

    void devolverLibro() {
        if (librosPrestados > 0) {
            librosPrestados--;
        }
    }

    int getLibrosPrestados() {
        return librosPrestados;
    }

    void mostrarInfo() {
        System.out.println("👤 Usuario: " + nombre);
        System.out.println("   Libros prestados: " + librosPrestados);
    }
}

// ========== CLASE 3: BIBLIOTECA (SIN public) ==========
class Biblioteca {
    String nombreBiblioteca;

    public Biblioteca(String nombre) {
        this.nombreBiblioteca = nombre;
    }

    void realizarPrestamo(Usuario usuario, Libro libro) {
        System.out.println("\n=== INTENTANDO PRÉSTAMO ===");
        libro.mostrarInfo();
        usuario.mostrarInfo();

        if (libro.estaDisponible()) {
            libro.marcarComoPrestado();
            usuario.prestarLibro();
            System.out.println("✅ Préstamo realizado exitosamente");
            System.out.println("   " + usuario.nombre + " ahora tiene el libro: " + libro.titulo);
        } else {
            System.out.println("❌ El libro no está disponible");
        }
    }

    void realizarDevolucion(Usuario usuario, Libro libro) {
        System.out.println("\n=== DEVOLVIENDO LIBRO ===");

        if (!libro.estaDisponible()) {
            libro.marcarComoDisponible();
            usuario.devolverLibro();
            System.out.println("✅ Devolución realizada exitosamente");
            System.out.println("   " + usuario.nombre + " devolvió: " + libro.titulo);
        } else {
            System.out.println("❌ Este libro ya está disponible");
        }
    }

    void mostrarEstado(Usuario usuario, Libro libro) {
        System.out.println("\n========== ESTADO ACTUAL ==========");
        System.out.println("Biblioteca: " + nombreBiblioteca);
        usuario.mostrarInfo();
        libro.mostrarInfo();
        System.out.println("===================================");
    }
}

// ========== CLASE PRINCIPAL (CON public) ==========
class SistemaBiblioteca {
    public static void main(String[] args) {
        // Crear la biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

        // Crear libros
        Libro libro1 = new Libro("Cien Años de Soledad", "Gabriel García Márquez");
        Libro libro2 = new Libro("El Quijote", "Miguel de Cervantes");
        Libro libro3 = new Libro("Harry Potter", "J.K. Rowling");

        // Crear usuarios
        Usuario usuario1 = new Usuario("Juan Pérez");
        Usuario usuario2 = new Usuario("María González");

        // Estado inicial
        biblioteca.mostrarEstado(usuario1, libro1);

        // Realizar préstamo
        biblioteca.realizarPrestamo(usuario1, libro1);
        biblioteca.mostrarEstado(usuario1, libro1);

        // Intentar prestar el mismo libro a otro usuario (debería fallar)
        biblioteca.realizarPrestamo(usuario2, libro1);

        // Usuario1 pide otro libro
        biblioteca.realizarPrestamo(usuario1, libro2);
        System.out.println("\n--- Usuario 1 ahora tiene ---");
        usuario1.mostrarInfo();

        // Devolver libro
        biblioteca.realizarDevolucion(usuario1, libro1);
        biblioteca.mostrarEstado(usuario1, libro1);

        // Ahora María puede pedir el libro
        biblioteca.realizarPrestamo(usuario2, libro1);
        System.out.println("\n--- Estado de ambos usuarios ---");
        usuario1.mostrarInfo();
        usuario2.mostrarInfo();

        // Estado final de los libros
        System.out.println("\n========== ESTADO DE TODOS LOS LIBROS ==========");
        libro1.mostrarInfo();
        System.out.println();
        libro2.mostrarInfo();
        System.out.println();
        libro3.mostrarInfo();
    }
}