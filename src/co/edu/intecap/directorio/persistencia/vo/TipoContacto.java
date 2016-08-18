/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.directorio.persistencia.vo;

/**
 *
 * @author INTECAP
 */
public class TipoContacto {
    
    private long idTipoContacto;
    private String nombre;
    private boolean estado;

    /**
     * @return the idTipoContacto
     */
    public long getIdTipoContacto() {
        return idTipoContacto;
    }

    /**
     * @param idTipoContacto the idTipoContacto to set
     */
    public void setIdTipoContacto(long idTipoContacto) {
        this.idTipoContacto = idTipoContacto;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
