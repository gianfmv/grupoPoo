/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paciente;

/**
 *
 * En esta clase agrupamos los métodos que nos servirán para la atención del paciente
 * 
 * @author Gian Marrufo
 */
import java.util.ArrayList;
import java.util.Scanner;
import HistoriaClinica.HistoriaClinica;
import utp.edu.pe.poo.pantalla.LecturaInformacion;

public class GestionaPaciente {

    // Método estáticos para registrar un nuevo paciente
   private static LecturaInformacion lecturaInformacion = new LecturaInformacion();

    public static void registrarNuevoPaciente(Scanner sc, ArrayList<Paciente> listaPacientes) {
        String nombre = lecturaInformacion.lecturaString("Registro de Paciente", "Nombre: ");
        String apellido = lecturaInformacion.lecturaString("Registro de Paciente", "Apellido: ");
        String dni = lecturaInformacion.lecturaString("Registro de Paciente", "DNI: ");
        String direccion = lecturaInformacion.lecturaString("Registro de Paciente", "Dirección: ");
        String telefono = lecturaInformacion.lecturaString("Registro de Paciente", "Teléfono: ");

        Paciente nuevoPaciente = new Paciente(nombre, apellido, dni, direccion, telefono);
        listaPacientes.add(nuevoPaciente);
        System.out.println("Paciente registrado con éxito.");
    }


    // Método para buscar un paciente por DNI
    public static Paciente buscarPacientePorDni(String dni, ArrayList<Paciente> listaPacientes) {
        for (Paciente p : listaPacientes) {
            if (p.getDni().equals(dni)) {
                return p;
            }
        }
        return null;
    }

    // Método para ver la lista de pacientes
    public static void verListaPacientes(ArrayList<Paciente> listaPacientes) {
        for (Paciente p : listaPacientes) {
            System.out.println("Nombre: " + p.getNombre() + ", DNI: " + p.getDni());
        }
    }
      // Método para ver el historial de consultas de un paciente
       public static void verHistorialConsultas(Paciente paciente) {
        ArrayList<HistoriaClinica> historial = paciente.getHistoriasClinicas();
        if (historial.isEmpty()) {
            System.out.println("No hay consultas registradas para este paciente.");
        } else {
            for (HistoriaClinica hc : historial) {
                System.out.println(hc);
            }
        }
    }
}
