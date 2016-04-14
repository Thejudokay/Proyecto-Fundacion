/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import Formularios.LoginFundecar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Dios Es Amor & Vida
 */
public class ConexionDeLogin {
  public String usuario = "sa";
  public String password = "123456";
  public String url = "jdbc:sqlserver://localhost:1433;databaseName=Fundecar;";
   
  public Connection cn = null;
  public Statement st = null;
        
  public Statement Conectar() 
        {
              
        try
       {
       
        Connection cn = DriverManager.getConnection(url,usuario,password);
       
        st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       
       } catch (SQLException i)
       {
           JOptionPane.showMessageDialog(null, i);
       } 
        return st;
        
       }
    public static void main(String[] args) {
        
        LoginFundecar login=new LoginFundecar();
        login.setVisible(true);
    }
}
