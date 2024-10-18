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

public interface IGestionaConsulta {
    void registrarConsulta(Scanner sc, Medico medico, String pathArchivoPacientes) throws IOException;
    void verHistorialConsultas(Scanner sc, String pathArchivoPacientes) throws IOException;    
}
