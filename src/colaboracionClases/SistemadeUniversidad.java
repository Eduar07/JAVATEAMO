package colaboracionClases;

import java.sql.SQLOutput;

class  Estudiante{
    String nombre, carrera;
    int semestre;

    public Estudiante(String nombre, String carrera, int semestre){
        this.nombre = nombre;
        this.semestre = semestre;
        this.carrera = carrera;
    }

    void mostrarInfo(){
        System.out.println("========INFORMACION ESTUDIANTE=========");
        System.out.println("Nombre: " + nombre);
        System.out.println("Carrera: " + carrera);
        System.out.println("Semestre: " + semestre);
        System.out.println("=======================================");
    }
}

class Materia{
    String nombre;
    int creditos;
    String profesor;


    public Materia(String nombre, int creditos, String profesor){
        this.nombre = nombre;
this.creditos = creditos;
this.profesor = profesor;
    }


    void mostrarInfo(){
        System.out.println("==========INFORMACION DE LA MATERIA==========");
        System.out.println("Materia: " + nombre);
        System.out.println("Creditos "  + creditos);
        System.out.println("Profesor " + profesor);
    }

}


class Inscripcion{
    Estudiante estudiante;
    Materia materia;
    double calificacion;

    public Inscripcion(Estudiante e, Materia m) {
        this.estudiante = e;
        this.materia = m;
        this.calificacion = 0.0;
    }
    void realizarInscripcion() {
        System.out.println("\n════════════════════════════════════════");
        System.out.println("✅ INSCRIPCIÓN REALIZADA");
        System.out.println("════════════════════════════════════════");
        System.out.println("Estudiante: " + estudiante.nombre);
        System.out.println("Se inscribió en: " + materia.nombre);
        System.out.println("Profesor: " + materia.profesor);
        System.out.println("Créditos: " + materia.creditos);
        System.out.println("════════════════════════════════════════\n");
    }


    void asignarCalificacion(double nota) {
        if (nota >= 0 && nota <= 5) {
            this.calificacion = nota;
            System.out.println("📝 Calificación asignada: " + nota);
        } else {
            System.out.println("❌ Error: La calificación debe estar entre 0 y 5");
        }
    }


    void mostrarResultado() {
        System.out.println("\n========== RESULTADO ACADÉMICO ==========");
        System.out.println("👤 Estudiante: " + estudiante.nombre);
        System.out.println("📖 Materia: " + materia.nombre);
        System.out.println("📊 Calificación: " + calificacion);

        if (calificacion == 0.0) {
            System.out.println("⚠️  Estado: SIN CALIFICAR");
        } else if (calificacion >= 3.0) {
            System.out.println("✅ Estado: APROBÓ");
        } else {
            System.out.println("❌ Estado: REPROBÓ");
        }
        System.out.println("=========================================\n");
    }

    // Método adicional: verificar si aprobó
    boolean aprobo() {
        return calificacion >= 3.0;
    }
}


class SistemaUniversidad {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║   SISTEMA UNIVERSITARIO v1.0         ║");
        System.out.println("╚═══════════════════════════════════════╝");

        // Crear estudiantes
        Estudiante estudiante1 = new Estudiante("Andrés Mauricio Ibáñez Pérez", "Derecho", 9);
        Estudiante estudiante2 = new Estudiante("María Fernanda López", "Ingeniería", 5);

        // Mostrar info de estudiantes
        estudiante1.mostrarInfo();
        estudiante2.mostrarInfo();

        // Crear materias
        Materia materia1 = new Materia("Matemáticas", 4, "Carlos Hernández");
        Materia materia2 = new Materia("Programación Java", 3, "Ana García");
        Materia materia3 = new Materia("Derecho Civil", 5, "Pedro Martínez");

        // Mostrar info de materias
        materia1.mostrarInfo();
        materia2.mostrarInfo();
        materia3.mostrarInfo();

        System.out.println("\n\n════════════ INSCRIPCIONES ════════════\n");

        // Inscripción 1: Estudiante1 en Matemáticas
        Inscripcion inscripcion1 = new Inscripcion(estudiante1, materia1);
        inscripcion1.realizarInscripcion();
        inscripcion1.asignarCalificacion(4.5);
        inscripcion1.mostrarResultado();

        // Inscripción 2: Estudiante2 en Programación
        Inscripcion inscripcion2 = new Inscripcion(estudiante2, materia2);
        inscripcion2.realizarInscripcion();
        inscripcion2.asignarCalificacion(2.8);
        inscripcion2.mostrarResultado();

        // Inscripción 3: Estudiante1 en Derecho Civil
        Inscripcion inscripcion3 = new Inscripcion(estudiante1, materia3);
        inscripcion3.realizarInscripcion();
        inscripcion3.asignarCalificacion(5.0);
        inscripcion3.mostrarResultado();

        // Resumen final
        System.out.println("\n════════════ RESUMEN FINAL ════════════");
        System.out.println("\n--- " + estudiante1.nombre + " ---");
        System.out.println("Matemáticas: " + (inscripcion1.aprobo() ? "✅ APROBÓ" : "❌ REPROBÓ"));
        System.out.println("Derecho Civil: " + (inscripcion3.aprobo() ? "✅ APROBÓ" : "❌ REPROBÓ"));

        System.out.println("\n--- " + estudiante2.nombre + " ---");
        System.out.println("Programación Java: " + (inscripcion2.aprobo() ? "✅ APROBÓ" : "❌ REPROBÓ"));
    }
}
