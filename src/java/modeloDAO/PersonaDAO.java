
package modeloDAO;

import config.Conexion;
import modelo.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PersonaDAO implements IntefazpersonaDAO{

    @Override
    public List<Persona> getPersonas() {
         List<Persona>personas=new ArrayList<>();
        String sql="select * from persona";
        try {
             PreparedStatement ps=Conexion.Conectar().prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             while (rs.next()) {                
                Persona p=new Persona();
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setDependencia(rs.getString(3));
                p.setFecha(rs.getString(4));
                p.setArchivo(rs.getString(5));
                personas.add(p);
            }
        } catch (Exception e) {
            System.err.println("Error:"+e);
        }
       
        return personas; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona getId(int id) {
        String sql="select * from persona where idPersona=?";
        Persona persona = new Persona();
        try {
             PreparedStatement ps=Conexion.Conectar().prepareStatement(sql);
             ps.setInt(1, id);
             ResultSet rs=ps.executeQuery();
             while (rs.next()) {               
                persona.setId(rs.getInt(1));
                persona.setNombres(rs.getString(2));
                persona.setDependencia(rs.getString(3));
                persona.setFecha(rs.getString(4));
                persona.setArchivo(rs.getString(5));
            }
        } catch (Exception e) {
            System.err.println("Error:"+e);
        }
        return  persona;
    }

    @Override
    public int add(Persona p) {
        int resultado=0;
        String sql="insert into persona(Nombres, Dependencia, Fecha, archivo) values (?,?,?,?)";
        try {
            PreparedStatement ps=Conexion.Conectar().prepareStatement(sql);
            ps.setString(1, p.getNombres());
            ps.setString(2, p.getDependencia());
            ps.setString(3, p.getFecha());
            ps.setString(4, p.getArchivo());
            resultado=ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error to add in BD"+e);
        }
        return resultado;
    }

    @Override
    public int update(Persona p) {
        int resultado=0;
        String sql="update persona set Nombres=?,Dependencia=?,Fecha=?, Archivo=? where idPersona=?";
        try {
            PreparedStatement ps=Conexion.Conectar().prepareStatement(sql);
            ps.setString(1, p.getNombres());
            ps.setString(2, p.getDependencia());
            ps.setString(3, p.getFecha());
            ps.setString(4, p.getArchivo());
            ps.setInt(5, p.getId());
            resultado=ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error to add in BD"+e);
        }
        return resultado;
    }

    @Override
    public int delete(int id) {
         int resultado=0;
         String sql="delete from persona where idPersona="+id;
         try {
            PreparedStatement ps=Conexion.Conectar().prepareStatement(sql);
            resultado = ps.executeUpdate();
        } catch (Exception e) {
        }
        return resultado;
    }
   
    
}
