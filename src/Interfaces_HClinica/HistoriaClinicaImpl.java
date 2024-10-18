/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces_HClinica;

/**
 *
 * @author Gian Marrufo
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Medico.Medico;
import Paciente.Paciente;

public class HistoriaClinicaImpl implements IHistoriaClinica{
    private Paciente paciente;
    private Medico medico;
    private LocalDate fechaConsulta;
    private String diagnostico;
    private String tratamiento;

    public HistoriaClinicaImpl(Paciente paciente, Medico medico, LocalDate fechaConsulta) {
        this.paciente = paciente;
        this.medico = medico;
        this.fechaConsulta = fechaConsulta;
    }

    @Override
    public void registrarConsulta(String diagnostico, String tratamiento) {
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    @Override
    public String obtenerInformacionConsulta() {
        DateTimeFormatter formatear = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Paciente: " + paciente.getNombre() + "\n" +
               "Médico: " + medico.getNombre() + "\n" +
               "Fecha Consulta: " + fechaConsulta.format(formatear) + "\n" +
               "Diagnóstico: " + diagnostico + "\n" +
               "Tratamiento: " + tratamiento;
    }
}
