/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Yesica
 */
public class Examen {
    int codigo;
    String fecha;
    int hora;
    String dni;
    String cod_aula;
    String texto;

    public Examen(int codigo) {
        this.codigo = codigo;
       
    }

    public Examen(int codigo, String fecha, int hora, String cod_aula, String texto) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.cod_aula = cod_aula;
        this.texto = texto;
    }

    @Override
    public String toString() {
        return Integer.toString(codigo);
    }
    

    public int getCodigo() {
        return codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public int getHora() {
        return hora;
    }

    public String getDni() {
        return dni;
    }

    public String getCod_aula() {
        return cod_aula;
    }

    public String getTexto() {
        return texto;
    }
    
    
}
