/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Yesica
 */
public class Profesor {
    String dni;
    String nombre;

    public Profesor(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public Profesor() {
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }
    
    
}
