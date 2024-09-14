/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medico;

import Usuario.Usuario;
import java.util.ArrayList;

/**
 *
 * @author MATEO
 */
public class Medico extends Usuario{

   private String especialidad;

    public Medico(String nombre, String apellido, String dni, String especialidad) {
        super(nombre,apellido, dni);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    // Método para el diagnóstico
    public String diagnosticar(String sintomas) {
        return "Diagnóstico basado en: " + sintomas;
    }
    // Método para recetar tratamiento
    public String recetarTratamiento(String tratamiento) {
        return tratamiento;  // Devuelve el tratamiento que fue ingresado
    }

    // Método estático para verificar las credenciales del médico sólo con su dni
    public static Medico login(ArrayList<Medico> listaMedicos, String dni) {
        for (Medico medico : listaMedicos) {
            if (medico.getDni().equals(dni)) {
                return medico;
            }
        }
        return null;
    }    
}
