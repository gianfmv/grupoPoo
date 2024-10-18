/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces_HClinica;

/**
 *
 * @author Gian Marrufo
 */

import Medico.Medico;
import java.io.IOException;
import java.util.Scanner;

//Esta interfaz gestiona las consultas médicas.
public interface IGestionaConsulta {
    //Permite registrar una consulta para un paciente.
    void registrarConsulta(Scanner sc, Medico medico, String pathArchivoPacientes) throws IOException;
    //Muestra el historial de consultas de un paciente.
    void verHistorialConsultas(Scanner sc);    
}
