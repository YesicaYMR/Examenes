/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Yesica
 */
public class Aula {
    String codAula;

    public Aula(String codAula) {
        this.codAula = codAula;
    }

    @Override
    public String toString() {
        return codAula;
    }

    public String getCodAula() {
        return codAula;
    }
    
    
}
