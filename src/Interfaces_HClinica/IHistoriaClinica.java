/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces_HClinica;

/**
 *
 * @author Gian Marrufo
 */
public interface IHistoriaClinica {
    public void registrarConsulta(String diagnostico, String tratamiento);
    public String obtenerInformacionConsulta();
}
