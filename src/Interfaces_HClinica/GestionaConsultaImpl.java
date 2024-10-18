/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces_HClinica;

/**
 *
 * @author Gian Marrufo
 */

//import HistoriaClinica.HistoriaClinica;
import Medico.Medico;
import Paciente.GestionaPaciente;
import Paciente.Paciente;
import java.io.IOException;
import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utp.edu.pe.poo.pantalla.LecturaInformacion;

public class GestionaConsultaImpl implements IGestionaConsulta{
     private static LecturaInformacion lecturaInformacion = new LecturaInformacion();

    @Override
    public void registrarConsulta(Scanner sc, Medico medico, String pathArchivoPacientes) throws IOException {
        System.out.print("DNI del paciente: ");
        String dni = sc.nextLine();

        Paciente paciente = GestionaPaciente.buscarPacientePorDni(dni, pathArchivoPacientes);

        if (paciente == null) {
            System.out.println("Paciente no encontrado. Registra al paciente primero.");
        } else {
            System.out.println("Paciente: " + paciente.getNombre() + " " + paciente.getApellido());

            System.out.println("Ingrese síntomas del paciente: ");
            String sintomas = sc.nextLine();

            LocalDate fechaConsulta = LocalDate.now();
            String diagnostico = medico.diagnosticar(sintomas);
            String tratamiento = lecturaInformacion.lecturaString("Recetar tratamiento", "Ingrese el tratamiento: ");

            // Creamos la historia clínica y registramos la consulta
            IHistoriaClinica historiaClinica = new HistoriaClinicaImpl(paciente, medico, fechaConsulta);
            historiaClinica.registrarConsulta(diagnostico, tratamiento);

            paciente.agregarHistoriaClinica(historiaClinica);

            System.out.println("Consulta registrada con éxito.");
            System.out.println(historiaClinica.obtenerInformacionConsulta());
            System.out.println("Número de historias clínicas del paciente: " + paciente.obtenerHistoriasClinicas().size());
        }
    }

    @Override
    public void verHistorialConsultas(Scanner sc, String pathArchivoPacientes) throws IOException {
        System.out.print("DNI del paciente: ");
        String dni = sc.nextLine();

        Paciente paciente = GestionaPaciente.buscarPacientePorDni(dni, pathArchivoPacientes);

        if (paciente == null) {
            System.out.println("Paciente no encontrado.");
        } else {
            System.out.println("Paciente encontrado: " + paciente.getNombre());
            List<IHistoriaClinica> historial = paciente.obtenerHistoriasClinicas();

            if (historial.isEmpty()) {
                System.out.println("Este paciente no tiene consultas registradas.");
            } else {
                for (IHistoriaClinica consulta : historial) {
                    System.out.println(consulta.obtenerInformacionConsulta());
                }
            }
        }
    }
}
