/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paciente;

import HistoriaClinica.HistoriaClinica;
import Usuario.Usuario;
import java.util.ArrayList;
/**
 *
 * @author Fernando Risco 
 */
public class Paciente extends Usuario {
  // Composición: Un paciente "tiene" una lista de historias clínicas.
    // Si el paciente deja de existir, sus historias clínicas también lo hacen.
   private String direccion;
    private String telefono;
    private ArrayList<HistoriaClinica> historiasClinicas; // Composición

    public Paciente(String nombre, String apellido,String dni, String direccion, String telefono) {
        super(nombre,apellido, dni);
        this.direccion = direccion;
        this.telefono = telefono;
        this.historiasClinicas = new ArrayList<>(); // Inicializar la lista
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public ArrayList<HistoriaClinica> getHistoriasClinicas() {
        return historiasClinicas;
    }

    public void agregarHistoriaClinica(HistoriaClinica historia) {
        this.historiasClinicas.add(historia); // Agregar una historia clínica
    }
/*
    // Método estático para buscar paciente por DNI
    public static Paciente buscarPacientePorDni(String dni, ArrayList<Paciente> listaPacientes) {
        for (Paciente p : listaPacientes) {
            if (p.getDni().equals(dni)) {
                return p;
            }
        }
        return null;
    }*/
/*
    public static void mostrarPacientes(ArrayList<Paciente> listaPacientes) {
        for (Paciente p : listaPacientes) {
            System.out.println("Nombre: " + p.getNombre() +", Apellido: "+ p.getApellido() + ", DNI: " + p.getDni());
        }
    }*/
   /* 
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
    }*/
}
