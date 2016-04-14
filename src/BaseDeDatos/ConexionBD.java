/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AVALOS
 */
public class ConexionBD {
    public Connection conecion(){
        Connection cn = null;
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         cn=DriverManager.getConnection("jdbc:sqlserver://DIOSTEBENDIGA:1433;DatabaseName=Fundecar;","sa","123456");
         }catch(  ClassNotFoundException | SQLException c){}
       return cn; 
    }
    
}
