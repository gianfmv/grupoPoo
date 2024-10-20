/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paciente;

import Utils.PersisteUsuario;
import Interfaces_HClinica.IHistoriaClinica;
import java.io.BufferedReader;
import java.io.FileReader;
import utp.edu.pe.poo.pantalla.LecturaInformacion;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;
//import java.util.Map;

/**
 * En esta clase agrupamos los métodos que nos servirán para la atención del paciente
 * 
 * @author Gian Marrufo
 */
public class GestionaPaciente {

    private static final String FILE_PATH = "D:/usuarios.txt"; // Ruta del archivo de persistencia que almacena los usuarios
    private static LecturaInformacion lecturaInformacion = new LecturaInformacion();
    
    private List<Paciente> pacientes;

    public GestionaPaciente(List<Paciente> pacientes) {
        this.pacientes = cargarPacientesDesdeArchivo(FILE_PATH);
    }
    /*
     * Cargamos los pacientes desde un archivo de texto y grabamos en una Arraylist listaPacientes los pacientes encontrados.
     * El archivo debe tener un formato específico separados por comas y
     * el último campo indica si es un Paciente o Medico.
    */
    public List<Paciente> cargarPacientesDesdeArchivo(String rutaArchivo) {
     List<Paciente> listaPacientes = new ArrayList<>();// array para guardar los pacientes

            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split(",");

                    // Verificamos si es un paciente y que la línea tenga la longitud adecuada en este caso debe tener 7 campos
                    if (datos.length == 7 && datos[6].equals("Paciente"))  {
                        String nombre = datos[0].trim();
                        String apellido = datos[1].trim();
                        String dni = datos[2].trim();
                        String direccion = datos[3].trim();
                        String telefono = datos[4].trim();
                        String password = datos[5].trim();  // Clave encriptada

                        // Creamos un nuevo objeto Paciente con los datos leídos
                        Paciente paciente = new Paciente(nombre, apellido, dni, password, direccion, telefono);
                        listaPacientes.add(paciente);//lo agregamos al array
                        //pacientes.add(paciente);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo de pacientes: " + e.getMessage());
            }        
            return listaPacientes;  // Devolvemos la lista de pacientes cargados 
    }
           
    // Método para registrar un nuevo paciente
    public void registrarNuevoPaciente(Scanner sc, List<Paciente> listaPacientes) throws IOException {
        String dni = lecturaInformacion.lecturaString("Registro de Paciente", "DNI: ");
        // Verificamos si el paciente ya existe buscando por DNI
        Paciente pacienteExistente = buscarPacientePorDni(dni);//,FILE_PATH);
        if (pacienteExistente != null) {
            System.out.println("Error: Ya existe un paciente registrado con el DNI: " + dni);
            return;  // Salimos del método si ya existe
        }

        // Si no existe, procedemos a registrar el nuevo paciente
        String nombre = lecturaInformacion.lecturaString("", "Nombre: ");
        String apellido = lecturaInformacion.lecturaString("", "Apellido: ");
        String direccion = lecturaInformacion.lecturaString("", "Dirección: ");
        String telefono = lecturaInformacion.lecturaString("", "Teléfono: ");
        String password = lecturaInformacion.lecturaString("", "Password: ");

        Paciente nuevoPaciente = new Paciente(nombre, apellido, dni, password, direccion, telefono);
        //Encriptamos la contraseña usando el método de setPassword de la clase abstracta Usuario, la cual se grabará encriptada en el archivo.
        nuevoPaciente.setPassword(password);        
        listaPacientes.add(nuevoPaciente);//Agregamos a la lista el nuevo paciente        
        System.out.println("Paciente registrado con éxito.");

        // Persistir el nuevo paciente en el archivo (se graba en el archivo de txt el paciente)
        PersisteUsuario.agrega(nuevoPaciente, FILE_PATH, "Paciente");
}   
    // buscamos un paciente en el archivo usando su DNI.
    public Paciente buscarPacientePorDni(String dni) {//, String rutaArchivo) {
       // List<Paciente> listaPacientes = cargarPacientesDesdeArchivo(rutaArchivo);

        for (Paciente paciente : pacientes) {
            if (paciente.getDni().equals(dni)) {
                return paciente;  // Retornar el paciente si el DNI coincide
            }
        }
        return null;  // Si no se encuentra, retornamos null
    }
    
    // Método para ver la lista de pacientes
    public void verListaPacientes(String rutaArchivo) {
        List<Paciente> listaPacientes = cargarPacientesDesdeArchivo(rutaArchivo);

        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
        } else {
            System.out.println("Se encontraron " + pacientes.size() + " pacientes."); 
            for (Paciente paciente : listaPacientes) {
                System.out.println("Nombre: " + paciente.getNombre() + " " + paciente.getApellido() + ", DNI: " + paciente.getDni());
            }
        }
    }
        // metodo para verificar el inicio de sesión del paciente, validamos el dni y la contraseña
       public Paciente login(String dni, String password) {         //List<Paciente> listaPacientes
         for (Paciente paciente : pacientes) {
             if (paciente.verificarPassword(dni, password)) {                             
                return paciente; // retornamos al paciente si las credenciales son correctas
            }
        }
        return null; // sino retornamos null
    }
       
       
    // Método para ver el historial de consultas de un paciente logueado
    public void verHistorialConsultas(Paciente paciente) {
        List<IHistoriaClinica> historial = paciente.obtenerHistoriasClinicas();
        if (historial.isEmpty()) {
            System.out.println("No hay consultas registradas para este paciente.");
        } else {
            for (IHistoriaClinica hc : historial) {
                System.out.println(hc);
            }
        }
    }
    
}
