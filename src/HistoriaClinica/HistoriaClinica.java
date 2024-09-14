/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HistoriaClinica;

import Medico.Medico;
import Paciente.Paciente;

/**
 *Composición: HistoriaClinica depende de Paciente. Si el paciente es eliminado, su historia clínica también se elimina.
Asociación: La historia clínica se asocia a un Medico, pero la existencia del médico no depende de la historia clínica.
* 
 * @author Gian Marrufo
 */
public class HistoriaClinica {
    private Paciente paciente; // Composición: Historia clínica depende del paciente
    private Medico medico; // Asociación: La historia clínica se asocia a un médico
    private String diagnostico;
    private String tratamiento;

    public HistoriaClinica(Paciente paciente, Medico medico) {
        this.paciente = paciente;
        this.medico = medico;
    }

    public void registrarConsulta(String diagnostico, String tratamiento) {
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "Paciente: " + paciente.getNombre() + "\n" +
               "Médico: " + medico.getNombre() + "\n" +
               "Diagnóstico: " + diagnostico + "\n" +
               "Tratamiento: " + tratamiento;
    }
}
