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
public class Contacto {
    
    private long idContacto;
    private String nombre;
    private String correo;
    private String telefono;
    private long idTipoContacto;

    /**
     * @return the idContacto
     */
    public long getIdContacto() {
        return idContacto;
    }

    /**
     * @param idContacto the idContacto to set
     */
    public void setIdContacto(long idContacto) {
        this.idContacto = idContacto;
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
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

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
    
}
