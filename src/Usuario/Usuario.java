/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

//import Encriptar.EncriptadorCesar;
import Encriptar.EncriptadorBase64;
import Encriptar.IEncriptador;

/**
 *
 * Generalización (Herencia): Usuario es una clase base general que tiene campos comunes como (nombre, apellido dni) para el Paciente y el Médico.
 * 
 * @author Rivas Cristian
 */
public abstract class Usuario {
    private String nombre;
    private String apellido;
    private String dni;
    private String password;
    private IEncriptador encriptador;
    
    public Usuario(String nombre, String apellido, String dni, String password) {
        this.nombre = nombre;
        this.apellido=apellido;
        this.dni = dni;
        this.encriptador= new EncriptadorBase64();
        this.password=password;
    }

    // Métodos abstractos     
    public abstract boolean verificarPassword(String dni, String inputPassword);

    // Centralizamos la encriptación en Usuario
    public String encriptarPassword(String password) {
        return encriptador.Encriptar(password);
    }
    public String getPassword() {
        return password;
    }

    // Modificamos el setter de password para que siempre encripte la nueva contraseña
    public void setPassword(String password) {
        this.password = encriptarPassword(password);
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
