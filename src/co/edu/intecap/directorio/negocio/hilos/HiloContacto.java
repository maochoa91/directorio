/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.directorio.negocio.hilos;

import co.edu.intecap.directorio.persistencia.conexion.ConexionBD;
import co.edu.intecap.directorio.persistencia.dao.ContactoDAO;
import co.edu.intecap.directorio.persistencia.vo.Contacto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import sun.net.www.content.audio.x_aiff;

/**
 *
 * @author INTECAP
 */
public class HiloContacto extends Thread{

    private JList<String> lstContactos;
    private List<Contacto> listaContactos;

    public HiloContacto(JList<String> lstContactos, List<Contacto> listaContactos) {
        this.lstContactos = lstContactos;
        this.listaContactos = listaContactos;
    }
    
    
    
    @Override
    public void run() {
        
        try {
            while (true) {
                listaContactos = new ContactoDAO(ConexionBD.conectar()).consultar();
                lstContactos.removeAll();
                DefaultListModel<String> modeloContactos = new DefaultListModel<>();
                for (Contacto elContacto : listaContactos) {

                    modeloContactos.addElement(elContacto.getNombre());
                }
                lstContactos.setModel(modeloContactos);
                Thread.sleep(15000);
                }   
            }catch (InterruptedException ex) {
                ex.printStackTrace(System.err);
            }

        }
    }
    
    
    

