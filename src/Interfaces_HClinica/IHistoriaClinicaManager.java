/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces_HClinica;

import java.util.List;

/**
 *
 * @author Gian Marrufo
 */
//Esta interfaz gestiona las historias clínicas.
public interface IHistoriaClinicaManager {
    //Agrega una historia clínica a la lista.
    public void agregarHistoriaClinica(IHistoriaClinica historia);
    //Devuelve una lista de historias clínicas
    public List<IHistoriaClinica> obtenerHistoriasClinicas();
}
