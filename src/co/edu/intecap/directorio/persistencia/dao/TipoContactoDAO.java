/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.directorio.persistencia.dao;

import co.edu.intecap.directorio.persistencia.conexion.ConexionBD;
import co.edu.intecap.directorio.persistencia.vo.Contacto;
import co.edu.intecap.directorio.persistencia.vo.TipoContacto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author INTECAP
 */
public class TipoContactoDAO {
    
    private Connection cnn;
    
    public TipoContactoDAO(Connection cnn) {
        this.cnn = cnn;
    }
    
    public void insertar(TipoContacto entidad){
    
        try {
            String sql = "INSERT INTO tipo_contacto(nombre,estado)"
                         + " VALUES(?,?)";
            PreparedStatement sentencia = cnn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setString(1,entidad.getNombre());
            sentencia.setBoolean(2, entidad.isEstado());
            sentencia.executeUpdate();
            ResultSet resultado = sentencia.getGeneratedKeys();
            if (resultado.next()) {
                entidad.setIdTipoContacto(resultado.getLong(1));
            }
        } catch (Exception e) {
            System.out.println("Error al Insertar");
            e.printStackTrace(System.err);
        } finally{
            ConexionBD.desconectar(cnn);
        }
    }
    
    public void editar(TipoContacto entidad){
    
        try {
            String sql = "UPDATE tipo_contacto "
                       + "SET  id_tipo_contacto = ? ,"
                       +     " nombre = ? ,"
                       +     " estado = ? ,"
                       + "WHERE id_tipo_contacto = ?";
            PreparedStatement sentencia = cnn.prepareStatement(sql);
            sentencia.setLong(1, entidad.getIdTipoContacto());
            sentencia.setString(2,entidad.getNombre());
            sentencia.setBoolean(3,entidad.isEstado());
            sentencia.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Editar");
            e.printStackTrace(System.err);
        }finally{
            ConexionBD.desconectar(cnn);
        }
    }
    
    public List<TipoContacto> consultar(){
        
        List<TipoContacto> listaTipoContactos = new ArrayList<>();
        try {
            String sql =" select * from tipo_contacto";
            PreparedStatement sentencia = cnn.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {                
                TipoContacto miContacto = new TipoContacto();
                miContacto.setIdTipoContacto(resultado.getLong("id_tipo_contacto"));
                miContacto.setNombre(resultado.getString("nombre"));
                miContacto.setEstado(resultado.getBoolean("estado"));                
                listaTipoContactos.add(miContacto);
            }
            
        } catch (Exception e) {
            System.out.println("Error al Consultar");
            e.printStackTrace(System.err);
        }finally{
            ConexionBD.desconectar(cnn);
        }
        return listaTipoContactos;
    }
    
    public TipoContacto consultar(long id){
    
        TipoContacto miContacto = new TipoContacto();
        try {
                 String sql =" select * from tipo_contacto where id_tipo_contacto = ?";
                 PreparedStatement sentencia = cnn.prepareStatement(sql);
                 sentencia.setLong(1,id);
                 ResultSet resultado = sentencia.executeQuery();
                 if (resultado.next()) {
                        miContacto.setIdTipoContacto(resultado.getLong("id_tipo_contacto"));
                        miContacto.setNombre(resultado.getString("nombre"));
                        miContacto.setEstado(resultado.getBoolean("estado"));
                 }
 
        } catch (Exception e) {
             System.out.println("Error al Consultar");
             e.printStackTrace(System.err);
        }finally{
             ConexionBD.desconectar(cnn);
        }
        return miContacto;
    }
}
