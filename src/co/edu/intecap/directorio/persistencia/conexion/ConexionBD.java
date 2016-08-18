/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.directorio.persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author INTECAP
 */
public class ConexionBD {
    
    public static Connection conectar(){
         
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnn =DriverManager.getConnection("jdbc:mysql://192.168.7.243:3306/db_directorio","root","1234");
            return cnn;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No me he podido conectar con la base de datos, causa: ");
            ex.printStackTrace(System.err);
            return null;
        }
    }
    
    public static void desconectar(Connection cnn){
    
        try {
            cnn.close();
        } catch (SQLException ex) {
            System.out.println("No me he podido desconectar de la base de datos, causa: ");
            ex.printStackTrace(System.err);
        }
    
    }
}
