/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Aula;
import modelo.Examen;
import modelo.Profesor;

/**
 *
 * @author Yesica
 */
public class OperacionesTabla {
       Conexion bd;

    public OperacionesTabla(Conexion bd) {
        this.bd = bd;
    }
    
    public boolean existeDni(String dni) {
        boolean resultado = false;
        String sql = "select * from profesores where dni='" + dni + "'";
        PreparedStatement sentencia;

        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            if (registros.next()) {
                resultado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }
    
     public int crearProfesor(String dni, String nombre) {
        int resultado = 0;
        PreparedStatement sentencia;
        try {
            String sql = "insert into profesores (dni, nombre) "
                    + "values ('" + dni + "', '" + nombre + "')";

           
            sentencia = bd.getConexion().prepareStatement(sql);
            resultado = sentencia.executeUpdate();
            sentencia.close();

        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
         public boolean existeAula(String codigo) {
        boolean resultado = false;
        String sql = "select * from aulas where cod_aula='" + codigo + "'";
        PreparedStatement sentencia;

        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            if (registros.next()) {
                resultado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }
    
     public int crearAula(String codigo, String descripcion) {
        int resultado = 0;
        PreparedStatement sentencia;
        try {
            String sql = "insert into aulas (cod_aula, descripcion) "
                    + "values ('" + codigo + "', '" + descripcion + "')";

            
            sentencia = bd.getConexion().prepareStatement(sql);
            resultado = sentencia.executeUpdate();
            sentencia.close();

        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
     
  public ArrayList<Examen> todosExamenes(String dni) {

        ArrayList<Examen> examenes = new ArrayList<>();
        String sql = "select * from examenes where dni='"+dni+"'";
        PreparedStatement sentencia;
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            while (registros.next()) {
                examenes.add(new Examen(registros.getInt("codigo"), registros.getString("fecha"), registros.getInt("hora"), registros.getString("cod_aula"), registros.getString("texto")));
            }
            registros.close();

        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return examenes;
    }
     
    public ArrayList<Profesor> todosProfesores() {

        ArrayList<Profesor> profesores = new ArrayList<>();
        String sql = "select * from profesores";
        PreparedStatement sentencia;
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            while (registros.next()) {
                profesores.add(new Profesor(registros.getString("dni"), registros.getString("nombre")));
            }
            registros.close();

        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return profesores;
    }
    
    public boolean profesorDisponible(String dni, String fecha, int hora){
        boolean resultado = false;
        String sql = "select * from examenes where dni='" + dni + "' and fecha='"+ fecha+"' and hora='"+hora+"'";
        PreparedStatement sentencia;

        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            if (registros.next()) {
                resultado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado; 
    }
      public ArrayList<Aula> aulasLibres(String dni, String fecha, int hora) {

        ArrayList<Aula> aulas = new ArrayList<>();
        String sql = "select * from aulas where cod_aula not in(select cod_aula from examenes where fecha='"+ fecha+"' and hora="+hora+")";
        PreparedStatement sentencia;
        try {
            sentencia = bd.getConexion().prepareStatement(sql);
            ResultSet registros = sentencia.executeQuery();
            while (registros.next()) {
                aulas.add(new Aula(registros.getString("cod_aula")));
            }
            registros.close();

        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aulas;
    }
      
         public int crearExamen(String fecha, int hora, String dni, String codAula, String texto) {
        int resultado = 0;
        PreparedStatement sentencia;
        try {
            String sql = "insert into examenes (fecha, hora, dni, cod_aula, texto) "
                    + "values ('" + fecha + "', '" + hora +"', '" + dni +"', '" + codAula +"', '" + texto + "')";

            
            sentencia = bd.getConexion().prepareStatement(sql);
            resultado = sentencia.executeUpdate();
            sentencia.close();

        } catch (SQLException ex) {
            Logger.getLogger(OperacionesTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
