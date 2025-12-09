package Contructores_Metodos;

public class VideoJuego {

    String nombre;
    int vida;
    int vidaMaxima;
    int nivel;
    int experiencia;

    public VideoJuego(String nombre ){
        this.nombre = nombre;
        this.vida = 100;
        this.vidaMaxima = 100;
        this.nivel = 1;
        this.experiencia = 0;
    }

    void recibirDanio(int danio){
        vida = vida - danio;
        if (vida < 0){
            vida = 0;
        }
        System.out.println("Recibistes " + danio + " de daño. Vida restante: " + vida);

        if(vida == 0){
            System.out.println("Lo siento tu vida se ha acabado ");
        }else {
            System.out.println("Has muerto..");
        }
    }

    void curar(int cantidad){
        if(vida >= vidaMaxima){
            System.out.println("💚 Vida completa (" + vida + "/" + vidaMaxima + "), no necesitas curación");
            return;
        }
        vida = vida + cantidad;
        if (vida > vidaMaxima){
            vida = vidaMaxima;
        }
        System.out.println("💚 Curaste " + cantidad + " puntos. Vida actual: " + vida + "/" + vidaMaxima);

    }

    void ganarExperiencia(int exp){
     experiencia = experiencia + exp;
        System.out.println("⭐ Ganaste " + exp + " de experiencia. Total: " + experiencia + "/100");

        while(experiencia>=100){
            nivel++;
            experiencia = experiencia -100;
            vidaMaxima = vidaMaxima + 20;
            vida = vidaMaxima;
            System.out.println("🎉 ¡SUBISTE DE NIVEL! Ahora eres nivel " + nivel);
            System.out.println("💪 Vida máxima aumentada a: " + vidaMaxima);
            System.out.println("💚 Vida restaurada completamente");

            if (experiencia > 0) {
                System.out.println("⭐ Experiencia restante: " + experiencia + "/100");
            }
        }


    }

    int getVida(){
        return vida;
    }

    int getNivel(){
        return nivel;
    }

    int getExperiencia(){
        return experiencia;
    }
    boolean estaVivo() {
        return vida > 0;
    }
    void mostrarEstadisticas(){
        System.out.println("\n========== ESTADÍSTICAS DEL JUGADOR ==========");
        System.out.println("Nombre: " + nombre);
        System.out.println("Vida: " + vida + "/" + vidaMaxima);
        System.out.println("Nivel: " + nivel);
        System.out.println("Experiencia: " + experiencia + "/100");
        System.out.println("Estado: " + (estaVivo() ? "Vivo 💚" : "Muerto 💀"));
        System.out.println("=============================================\n");
    }

    public static void main(String[] args) {
        // Constructor correcto (solo nombre)
        VideoJuego jugador = new VideoJuego("eduar guerrero");

        jugador.mostrarEstadisticas();

        // Recibir daño
        jugador.recibirDanio(30);
        jugador.mostrarEstadisticas();

        // Curar
        jugador.curar(20);
        jugador.mostrarEstadisticas();

        // Ganar experiencia (nivel 1 → 2)
        jugador.ganarExperiencia(50);
        jugador.mostrarEstadisticas();

        jugador.ganarExperiencia(60);  // Sube a nivel 2
        jugador.mostrarEstadisticas();

        // Recibir más daño
        jugador.recibirDanio(50);
        jugador.mostrarEstadisticas();

        // Ganar más experiencia (nivel 2 → 3)
        jugador.ganarExperiencia(120);  // Sube a nivel 3
        jugador.mostrarEstadisticas();

        // Intentar curar con vida completa
        jugador.curar(10);

        // Recibir daño mortal
        jugador.recibirDanio(200);
        jugador.mostrarEstadisticas();
    }
}
