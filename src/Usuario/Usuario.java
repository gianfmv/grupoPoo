/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

/**
 *
 * Generalización (Herencia): Usuario es una clase base general que tiene campos comunes como (nombre, apellido dni) para el Paciente y el Médico.
 * 
 * @author Rivas Cristian
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private String dni;

    public Usuario(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido=apellido;
        this.dni = dni;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
