/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectohistoriaclinica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Paciente.Paciente;
import Paciente.GestionaPaciente;
import Medico.Medico;
//import HistoriaClinica.GestionaConsulta;
import Interfaces_HClinica.GestionaConsultaImpl;
import Usuario.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import utp.edu.pe.poo.pantalla.Pantalla;
/**
 *
 * @author Gian Marrufo
 */
public class ProyectoHistoriaClinica {

    /**
     * @param args the command line arguments
     */
    
    // Ruta del archivo donde se almacenan los datos de los pacientes
    private static final String PATH_ARCHIVO = "D:/usuarios.txt"; 
    // Agregación: Lista de pacientes y médicos, donde las listas existen independientemente
    private static ArrayList<Paciente> listaPacientes = new ArrayList<>();
    private static ArrayList<Medico> listaMedicos = new ArrayList<>();
    private static Pantalla pantalla = new Pantalla();

    public static void main(String[] args) throws IOException {
    // Cargamos los usuarios desde el archivo especificado en PATH_ARCHIVO
    cargarUsuariosDesdeArchivo(PATH_ARCHIVO);                
       
    Scanner sc = new Scanner(System.in);
    boolean salir = false; // variable para controlar la salida del programa
    Usuario usuarioLogueado = null; // Variable para almacenar el usuario que inicia sesión, es de la clase abstracta

    // Bucle principal del programa que se ejecuta mientras no se desee salir
    while (!salir) {
        // Si no hay un usuario logueado, solicitamos las credenciales
        if (usuarioLogueado == null) {
            System.out.println("******* INGRESO AL SISTEMA CLINICA UTP ***********");
            System.out.print("Ingrese su DNI para iniciar sesión: ");
            String dni = sc.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String password = sc.nextLine();

             // Primero intentamos iniciar sesión como médico
            usuarioLogueado = Medico.login(listaMedicos, dni, password);
            if (usuarioLogueado == null) {
                 // Si no se encontró un médicos en la lista, intentamos iniciar sesión como paciente
                usuarioLogueado = GestionaPaciente.login(listaPacientes, dni, password);
            }

             // Verificamos si el usuario no fue encontrado ya sea médico o paciente mostramos el mensaje de aviso para que intenten denuevo
            if (usuarioLogueado == null) {
                System.out.println("DNI o contraseña incorrectos. Intente nuevamente.");
            } else if (usuarioLogueado instanceof Medico) {// Verificamos si el usuario pertenece a la clase médico con instanceof
                // si es médico realizamos el casting a Medico
                Medico medicoLogueado = (Medico) usuarioLogueado;                 
                System.out.println("\nMédico " + medicoLogueado.getNombre() + " " + medicoLogueado.getApellido() + " ha iniciado sesión.");
                // Mostramos el menú para médicos y almacenamos en la variable salir
                salir = mostrarMenuMedico(sc, medicoLogueado); 
                usuarioLogueado = null; // Reiniciamos el usuario logueado a null, para pedir credenciales nuevamente si se cierra la sesión
            } else if (usuarioLogueado instanceof Paciente) { // Verificamos si el usuario pertenece a la clase paciente con instanceof
                 // Realizamos un casting a paciente
                Paciente pacienteLogueado = (Paciente) usuarioLogueado;
                System.out.println("\nPaciente " + pacienteLogueado.getNombre() + " " + pacienteLogueado.getApellido() + " ha iniciado sesión.");
                // Mostrar el menú para pacientes y salir si se elige cerrar sesión
                salir = mostrarMenuPaciente(sc, pacienteLogueado); 
                usuarioLogueado = null; // Volvemos a pedir credenciales tras cerrar sesión
            }
        }
    }
    sc.close();
    }
    //Método estático para mostrar el menú del medíco
    private static boolean mostrarMenuMedico(Scanner sc, Medico medicoLogueado) throws IOException {    
        boolean salir = false;// Variable para controlar la salida del menú médico
        GestionaConsultaImpl ges = new GestionaConsultaImpl();
        // Bucle para mostrar el menú hasta que el médico decida salir
        while (!salir) {
            String[] opciones = {
                "1. Registrar nueva consulta",
                "2. Registrar nuevo paciente",
                "3. Ver lista de pacientes",
                "4. Ver historial de consultas",
                "5. Cerrar sesión",
                "6. Salir del programa"
            };
            int opcion = pantalla.Menu("\n===== Menú Médico =====", opciones);

            switch (opcion) {
                case 1:
                    // Registramos nueva consulta, accedemos al archivo de pacientes
                    ges.registrarConsulta(sc, medicoLogueado, PATH_ARCHIVO);
                   // GestionaConsulta.registrarConsulta(sc, medicoLogueado, PATH_ARCHIVO);
                    break;
                case 2:
                    // Registramos nuevo paciente, 
                    GestionaPaciente.registrarNuevoPaciente(sc, listaPacientes);
                    break;
                case 3:
                     // Ver lista de pacientes
                    GestionaPaciente.verListaPacientes(PATH_ARCHIVO);
                    break;
                case 4:
                     // Ver historial de consultas
                    ges.verHistorialConsultas(sc, PATH_ARCHIVO);
                    break;
                case 5:
                    System.out.println("Sesión cerrada.");
                    return false; // Regresar al ciclo principal
                case 6:
                    salir = true; // Marcar para salir del menú médico
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        System.out.println("Saliendo del programa..."); // Mensaje al salir
        return true;
    }

    //Método estático para mostrar el menu del paciente
    private static boolean mostrarMenuPaciente(Scanner sc, Paciente pacienteLogueado) {
        boolean salir = false;// variable para controlar la salida del menú del paciente
        // Bucle para mostrar el menú hasta que el paciente decida salir
        while (!salir) {
            String[] opciones = {
                "1. Ver historial de consultas",
                "2. Cerrar sesión",
                "3. Salir del programa"
            };
            int opcion = pantalla.Menu("\n===== Menú Paciente =====", opciones);

            switch (opcion) {
                case 1:
                    GestionaPaciente.verHistorialConsultas(pacienteLogueado);
                    break;
                case 2:
                    System.out.println("Sesión cerrada.");
                    return false; // Regresar al ciclo principal
                case 3:
                    salir = true; // Marcar para salir del menú paciente
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        System.out.println("Saliendo del programa..."); // Mensaje al salir
        return true;
    }
    // Método estático en el que cargaremos los usuarios desde un archivo de texto.
    private static void cargarUsuariosDesdeArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {//leemos cada línea del archivo
                String[] partes = linea.split(","); // Separamos por las comas
                String nombre = partes[0];
                String apellido = partes[1];
                String dni = partes[2];
                String direccion = partes[3];
                String telefono = partes[4];
                String password = partes[5]; // Contraseña es la 6ta parte
                String tipoUsuario = partes[6];

                // Creamos a los usuarios según el tipo, el cual está definido en el último campo de la linea del archivo
                if (tipoUsuario.equals("Paciente")) {
                    Paciente paciente = new Paciente(nombre, apellido, dni,password, direccion, telefono );                 
                    listaPacientes.add(paciente); //agregamos al array listaPaciente
                } else if (tipoUsuario.equals("Medico")) {
                    Medico medico = new Medico(nombre, apellido, dni, password, direccion); // dado que le médico no tiene direccion usamos ese campo como especialidad                
                    listaMedicos.add(medico); //agregamos al array listaPaciente
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
}


    

    
    

