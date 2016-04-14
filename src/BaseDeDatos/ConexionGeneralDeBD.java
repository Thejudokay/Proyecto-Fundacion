/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Dios Es Amor & Vida
 */
public class ConexionGeneralDeBD {
    static Connection contacto=null;
    
    public static Connection getConexion(){
     
        String url="jdbc:sqlserver://DIOSTEBENDIGA:1433;databaseName=Fundecar";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion"+e.getMessage(),"Error De Conexion Con La Base De Datos General",JOptionPane.ERROR_MESSAGE);
        }
        try {
            contacto=DriverManager.getConnection(url,"sa","123456");
            JOptionPane.showMessageDialog(null, "Conexion Con La Base De Datos Exitosa");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error de conexion"+e.getMessage(),"error de conexion",JOptionPane.ERROR_MESSAGE);
        }
        return contacto;
    }
    
    public static  ResultSet Consulta(String consulta){
        Connection con=getConexion();
        Statement declara;
        try {
            declara=con.createStatement();
            ResultSet respuesta=declara.executeQuery(consulta);
            return respuesta;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error"+e.getMessage(),"error de conexion",JOptionPane.ERROR_MESSAGE);
            return  null;
        }
    }
}
