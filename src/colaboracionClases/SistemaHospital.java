package colaboracionClases;

import java.sql.SQLOutput;

class Paciente {

    String nombre, enfermedad;
    int edad;

    public Paciente(String nombre, int edad, String enfermedad){
        this.nombre = nombre;
        this.edad = edad;
        this.enfermedad = enfermedad;
    }

    void mostrarInfo(){
        System.out.println("=============Informacion del paciente=============");
        System.out.println("Nombre : " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Enfermedaed: " + enfermedad);
        System.out.println("===================================================");
    }
}

class  Doctor {
    String nombre;
    String especialidad;
    int pacientesAtendidos;

    public Doctor(String nombre, String especialidad){
        this.nombre= nombre;
        this.especialidad = especialidad;
        this.pacientesAtendidos = 0;
    }

    void atenderPaciente(Paciente paciente){
        pacientesAtendidos++;
        System.out.println("👨‍⚕️ Dr. " + this.nombre + " está atendiendo a " + paciente.nombre);


    }
    void mostrarInfo(){
        System.out.println("=============Informacion del Doctor=============");
        System.out.println("Nombre : " + nombre);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Pacientes Atendidos: " + pacientesAtendidos);
        System.out.println("===================================================");
}
}


class Cita{
    Paciente paciente;
    Doctor doctor;
    String fecha;
    String diagnostico;

    public Cita(Paciente p, Doctor d, String fecha){
        this.paciente = p;
        this.doctor = d;
        this.fecha = fecha;
        this.diagnostico = "Pendiente";
    }



    void realizarConsulta() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      REALIZANDO CONSULTA MÉDICA       ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\n📅 Fecha: " + fecha);
        System.out.println("\n--- DATOS DEL PACIENTE ---");
        System.out.println("Nombre: " + paciente.nombre);
        System.out.println("Edad: " + paciente.edad + " años");
        System.out.println("Motivo de consulta: " + paciente.enfermedad);

        System.out.println("\n--- DATOS DEL MÉDICO ---");
        System.out.println("Doctor: Dr. " + doctor.nombre);
        System.out.println("Especialidad: " + doctor.especialidad);

        // El doctor atiende al paciente
        doctor.atenderPaciente(paciente);

        // Establecer diagnóstico basado en la enfermedad
        establecerDiagnostico();

        System.out.println("\n📋 DIAGNÓSTICO: " + diagnostico);
        System.out.println("\n✅ Consulta finalizada\n");
    }

    void establecerDiagnostico() {
        // Diagnóstico simple basado en la enfermedad
        if (paciente.enfermedad.toLowerCase().contains("dolor")) {
            diagnostico = "Se recomienda analgésicos y reposo";
        } else if (paciente.enfermedad.toLowerCase().contains("fiebre")) {
            diagnostico = "Infección viral, tratamiento sintomático";
        } else {
            diagnostico = "Requiere exámenes adicionales";
        }
    }

    void mostrarResumen() {
        System.out.println("\n========== RESUMEN DE CITA ==========");
        System.out.println("Fecha: " + fecha);
        System.out.println("Paciente: " + paciente.nombre);  // ✅ Accede al nombre
        System.out.println("Doctor: Dr. " + doctor.nombre + " (" + doctor.especialidad + ")");
        System.out.println("Diagnóstico: " + diagnostico);
        System.out.println("=====================================");
    }
}


public class SistemaHospital {
    public static void main(String[] args) {
        System.out.println("════════════════════════════════════");
        System.out.println("    SISTEMA HOSPITALARIO v1.0");
        System.out.println("════════════════════════════════════");

        // Crear pacientes
        Paciente paciente1 = new Paciente("Eduar Humberto", 35, "Dolor de cabeza intenso");
        Paciente paciente2 = new Paciente("Carlos Hernández", 38, "Fiebre alta");
        Paciente paciente3 = new Paciente("Ana López", 28, "Tos persistente");

        // Mostrar info de pacientes
        paciente1.mostrarInfo();
        paciente2.mostrarInfo();

        // Crear doctores (sin pacientesAtendidos)
        Doctor doctor1 = new Doctor("Andrés Mauricio", "Medicina General");
        Doctor doctor2 = new Doctor("Diego Ibáñez", "Pediatría");

        // Mostrar info de doctores
        doctor1.mostrarInfo();
        doctor2.mostrarInfo();

        // Crear citas (sin diagnóstico inicial)
        Cita cita1 = new Cita(paciente1, doctor1, "30 de Abril, 2024");
        Cita cita2 = new Cita(paciente2, doctor2, "4 de Octubre, 2024");
        Cita cita3 = new Cita(paciente3, doctor1, "15 de Mayo, 2024");

        // Realizar consultas
        cita1.realizarConsulta();
        cita2.realizarConsulta();
        cita3.realizarConsulta();

        // Mostrar estado final de los doctores
        System.out.println("\n════════════════════════════════════");
        System.out.println("    ESTADO FINAL DE LOS MÉDICOS");
        System.out.println("════════════════════════════════════");
        doctor1.mostrarInfo();
        doctor2.mostrarInfo();

        // Mostrar resúmenes de citas
        System.out.println("\n════════════════════════════════════");
        System.out.println("    RESÚMENES DE TODAS LAS CITAS");
        System.out.println("════════════════════════════════════");
        cita1.mostrarResumen();
        cita2.mostrarResumen();
        cita3.mostrarResumen();
    }
}