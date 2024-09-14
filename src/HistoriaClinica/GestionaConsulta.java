/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HistoriaClinica;

/**
 *Agrupamos en esta clase lo métodos para la historia clínica
 * 
 * @author Gian Marrufo
 */
import java.util.ArrayList;
import java.util.Scanner;
import Medico.Medico;
import Paciente.GestionaPaciente;
import Paciente.Paciente;
import utp.edu.pe.poo.pantalla.LecturaInformacion;

public class GestionaConsulta {

    // Método para registrar una consulta
private static LecturaInformacion lecturaInformacion = new LecturaInformacion();

    public static void registrarConsulta(Scanner sc, Medico medico, ArrayList<Paciente> listaPacientes) {
        System.out.print("DNI del paciente: ");
        String dni = sc.nextLine();

        Paciente paciente = GestionaPaciente.buscarPacientePorDni(dni, listaPacientes);

        if (paciente == null) {
            System.out.println("Paciente no encontrado. Registra al paciente primero.");
        } else {
            System.out.println("Paciente: " + paciente.getNombre() + " " + paciente.getApellido());
            System.out.println("Ingrese síntomas del paciente: ");
            String sintomas = sc.nextLine();

            // Registrar consulta
            String diagnostico = medico.diagnosticar(sintomas);
            String tratamiento = lecturaInformacion.lecturaString("Recetar tratamiento", "Ingrese el tratamiento: ");

            HistoriaClinica historiaClinica = new HistoriaClinica(paciente, medico);
            historiaClinica.registrarConsulta(diagnostico, tratamiento);
            paciente.agregarHistoriaClinica(historiaClinica); // Agregar la consulta al historial del paciente
            System.out.println("Consulta registrada con exito.");
            System.out.println(historiaClinica);
        }
    }

    // Método para ver el historial de consultas de un paciente
    public static void verHistorialConsultas(Scanner sc, ArrayList<Paciente> listaPacientes) {
        System.out.print("DNI del paciente: ");
        String dni = sc.nextLine();

        Paciente paciente = GestionaPaciente.buscarPacientePorDni(dni, listaPacientes);

        if (paciente == null) {
            System.out.println("Paciente no encontrado.");
        } else {
            GestionaPaciente.verHistorialConsultas(paciente);
        }
    }
}
