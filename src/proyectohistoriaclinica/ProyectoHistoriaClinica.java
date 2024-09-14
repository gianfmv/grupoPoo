/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectohistoriaclinica;

import java.util.ArrayList;
import java.util.Scanner;
import Paciente.Paciente;
import Paciente.GestionaPaciente;
import Medico.Medico;
import HistoriaClinica.GestionaConsulta;
import utp.edu.pe.poo.pantalla.Pantalla;
/**
 *
 * @author Gian Marrufo
 */
public class ProyectoHistoriaClinica {

    /**
     * @param args the command line arguments
     */
    
// Agregación: Lista de pacientes y médicos, donde las listas existen independientemente
    private static ArrayList<Paciente> listaPacientes = new ArrayList<>();
    private static ArrayList<Medico> listaMedicos = new ArrayList<>();
    private static Pantalla pantalla = new Pantalla();

    public static void main(String[] args) {
        inicializarMedicos();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        Medico medicoLogueado = null;

        while (!salir) {
            if (medicoLogueado == null) {
                 System.out.println("******* INGRESO AL SISTEMA CLINICA UTP ***********");
                System.out.print("Ingrese su DNI para iniciar sesion: ");
                String dni = sc.nextLine();
                medicoLogueado = Medico.login(listaMedicos, dni);

                if (medicoLogueado == null) {
                    System.out.println("DNI incorrecto. Intente nuevamente.");
                } else {
                    System.out.println("\nMédico " + medicoLogueado.getNombre() + " " + medicoLogueado.getApellido() + " ha iniciado sesión.");
                }
            } else {
                String[] opciones = {
                    "1. Registrar nueva consulta",
                    "2. Registrar nuevo paciente",
                    "3. Ver lista de pacientes",
                    "4. Ver historial de consultas",
                    "5. Cerrar sesión",
                    "6. Salir del programa" 
                };
                int opcion = pantalla.Menu("\n===== Menú Principal =====", opciones);

                switch (opcion) {
                    case 1:
                        GestionaConsulta.registrarConsulta(sc, medicoLogueado, listaPacientes);
                        break;
                    case 2:
                        GestionaPaciente.registrarNuevoPaciente(sc, listaPacientes);
                        break;
                    case 3:
                        GestionaPaciente.verListaPacientes(listaPacientes);
                        break;
                    case 4:
                        GestionaConsulta.verHistorialConsultas(sc, listaPacientes);
                        break;
                    case 5:
                        medicoLogueado = null; 
                        System.out.println("Sesión cerrada.");
                        break;
                    case 6:
                        salir = true; // Salir del bucle y cerrar el programa
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            }
        }
        sc.close();
    }

    private static void inicializarMedicos() {
        listaMedicos.add(new Medico("Dr. Jack","Shephard", "12345678", "Cardiología"));
        listaMedicos.add(new Medico("Dra. Cameron","Dias", "87654321", "Pediatría"));
    }
    
    }

    

    
    

