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

<<<<<<< HEAD:src/Interfaces_HClinica/HistoriaClinicaImpl.java
public class HistoriaClinicaImpl implements IHistoriaClinica{
    private Paciente paciente;
    private Medico medico;
    private LocalDate fechaConsulta;
=======
/**
 *Composición: HistoriaClinica depende de Paciente. Si el paciente es eliminado, su historia clínica también se elimina.
Asociación: La historia clínica se asocia a un Medico, pero la existencia del médico no depende de la historia clínica.
* 
 * @author Gian Marrufo
 */
public class HistoriaClinica {
    private Paciente paciente; // Composición: Historia clínica depende del paciente
    private Medico medico; //  La relación entre Medico y HistoriaClinica es una relación de agregación. Un médico puede realizar múltiples consultas sin que las historias clínicas sean dependientes de la existencia del médico.
>>>>>>> 78652994c08a28dc48bfe316b9d6fe89f12a600a:src/HistoriaClinica/HistoriaClinica.java
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
