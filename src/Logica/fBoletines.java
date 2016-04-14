/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Conexion_FormularioBoletines;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Dios Es Amor & Vida
 */
public class fBoletines {
    private Conexion mysql=new Conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistrados;
    
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        //titulos de las columnas de las tablas
        String[] titulos={"ID","Nombre Del Alumno","Grado","Numero Del Boletin","Fecha De Ingreso","Logros Cognitiva","Nivel Cognitiva",
            "Logros Comunicativa","Nivel Comunicativa","Logros Actitudes Y Valores","Nivel Actitudes Y Valores",
            "Logros Estetica","Nivel Estetica","","Logros Corporal","Nivel Corporal","","Logros Pre-Matematicas","Nivel Pre-Matematicas",
            "Logros Lecto Escritura","Nivel Lecto Escritura"," ","Logros Areas Integradas","Nivel Areas Integradas",
            "Logros Ingles","Nivel Ingles",};
        //Registro de cada uno de los titulos
        String []registro =new String[32];
        totalregistrados=0;
        modelo=new DefaultTableModel(null,titulos);
        
        sSQL="select*from boletines where piso like '%"+buscar+"%'order by IDBoletines";
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("IDBoletines");
                registro[1]=rs.getString("Nombre Del Alumno");
                registro[2]=rs.getString("Grado");
                registro[3]=rs.getString("Numero Del Boletin");
                registro[4]=rs.getString("Fecha De Ingreso");
                registro[5]=rs.getString("Logros Cognitiva");
                registro[6]=rs.getString("Nivel Cognitiva");
                registro[7]=rs.getString("Logros Comunicativa");
                registro[8]=rs.getString("Nivel Comunicativa");
                registro[9]=rs.getString("Logros Actitudes Y Valores");
                registro[10]=rs.getString("Nivel Actitudes Y Valores");
                registro[11]=rs.getString("Logros Estetica");
                registro[12]=rs.getString("Nivel Estetica");
                registro[13]=rs.getString("Logros Corporal");
                registro[14]=rs.getString("Nivel Corporal");
                registro[15]=rs.getString("Logros Pre-Matematicas");
                registro[16]=rs.getString("Nivel Pre-Matematicas");
                registro[17]=rs.getString("Logros Lecto Escritura");
                registro[18]=rs.getString("Nivel Lecto Escritura");
                registro[19]=rs.getString("Logros Areas Integradas");
                registro[20]=rs.getString("Nivel Areas Integradas");
                registro[21]=rs.getString("Logros Ingles");
                registro[22]=rs.getString("Nivel Ingles");
                
                totalregistrados=totalregistrados+1;
                modelo.addRow(registro);
                
                
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public  boolean  Insertar (Conexion_FormularioBoletines dts){
        sSQL="insert into boletines(Nombre Del Alumno,Grado,Numero Del Boletin,Fecha De Ingreso,Logros Cognitiva,Nivel Cognitiva,"
                + "Logros Comunicativa,Nivel Comunicativa ,Logros Actitudes Y Valores,Nivel Actitudes Y Valores,"
                + "Logros Estetica,Nivel Estetica,Logros Corporal,Nivel Corporal,Logros Pre-Matematicas,Nivel Pre-Matematicas,"
                + "Logros Lecto Escritura,Nivel Lecto Escritura,Logros Areas Integradas,Nivel Areas Integradas,"
                + "Logros Ingles,Nivel Ingles)"+
                "Values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            
            PreparedStatement pst=cn.prepareCall(sSQL);
            pst.setString(1, dts.getNombreDelAlumno());
            pst.setString(2, dts.getGrado());
            pst.setString(3, dts.getNumeroDelBoletin());
            pst.setDate(4, (Date) dts.getFechaDeIngreso());
            pst.setString(5, dts.getLogrosCognitiva());
            pst.setString(6, dts.getNivelCognitiva());
            pst.setString(7, dts.getLogrosComunicativa());
            pst.setString(8, dts.getNivelComunicativa());
            pst.setString(9, dts.getLogrosActitudesYValores());
            pst.setString(10, dts.getNivelActitudesYValores());
            pst.setString(11, dts.getLogrosEstetica());
            pst.setString(12, dts.getNivelEstetica());
            pst.setString(13, dts.getLogrosCorporal());
            pst.setString(14, dts.getNivelCorporal());
            pst.setString(15, dts.getLogrosPreMatematicas());
            pst.setString(16, dts.getNivelPreMatematicas());
            pst.setString(17, dts.getLogrosLectoEscritura());
            pst.setString(18, dts.getNivelLectoEscritura());
            pst.setString(19, dts.getLogrosAreasIntegradas());
            pst.setString(20, dts.getNivelAreasIntegradas());
            pst.setString(21, dts.getLogrosIngles());
            pst.setString(22, dts.getNivelIngles());
            
            int n=pst.executeUpdate();
            
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
 
    }
    
    public  boolean  Editar (Conexion_FormularioBoletines dts){
        sSQL="update boletines set Nombre Del Alumno=?,Grado=?,Numero Del Boletin=?,Fecha De Ingreso=?,Cognitiva=?,Logros Cognitiva=?,Nivel Cognitiva=?,"
                + "Comunicativa=?,Logros Comunicativa=?,Nivel Comunicativa=?,Actitudes Y Valores=?,Logros Actitudes Y Valores=?,Nivel Actitudes Y Valores=?,"
                + "Estetica=?,Logros Estetica=?,Nivel Estetica=?,Corporal=?,Logros Corporal=?,Nivel Corporal=?,Pre-Matematicas=?,Logros Pre-Matematicas=?,Nivel Pre-Matematicas=?,"
                + "Lecto Escritura=?,Logros Lecto Escritura=?,Nivel Lecto Escritura=?,Areas Integradas=?,Logros Areas Integradas=?,"
                + "Nivel Areas Integradas=?,Ingles=?,Logros Ingles=?,Nivel Ingles=?"
                + "where IDBoletines=?";
        try {
            PreparedStatement pst=cn.prepareCall(sSQL);
            pst.setString(1, dts.getNombreDelAlumno());
            pst.setString(2, dts.getGrado());
            pst.setString(3, dts.getNumeroDelBoletin());
            pst.setDate(4, (Date) dts.getFechaDeIngreso());
            pst.setString(5, dts.getLogrosCognitiva());
            pst.setString(6, dts.getNivelCognitiva());
            pst.setString(7, dts.getLogrosComunicativa());
            pst.setString(8, dts.getNivelComunicativa());
            pst.setString(9, dts.getLogrosActitudesYValores());
            pst.setString(10, dts.getNivelActitudesYValores());
            pst.setString(11, dts.getLogrosEstetica());
            pst.setString(12, dts.getNivelEstetica());
            pst.setString(13, dts.getLogrosCorporal());
            pst.setString(14, dts.getNivelCorporal());
            pst.setString(15, dts.getLogrosPreMatematicas());
            pst.setString(16, dts.getNivelPreMatematicas());
            pst.setString(17, dts.getLogrosLectoEscritura());
            pst.setString(18, dts.getNivelLectoEscritura());
            pst.setString(19, dts.getLogrosAreasIntegradas());
            pst.setString(20, dts.getNivelAreasIntegradas());
            pst.setString(21, dts.getLogrosIngles());
            pst.setString(22, dts.getNivelIngles());
            pst.setInt(23, dts.getIDBoletienes());
            
            int n=pst.executeUpdate();
            
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
 
    }
    
    public  boolean  Eliminar (Conexion_FormularioBoletines dts){
        sSQL="delete from Boletines where IDBoletines=?";
        try {
            
            PreparedStatement pst=cn.prepareCall(sSQL);
            
            pst.setInt(1, dts.getIDBoletienes());
            
            int n=pst.executeUpdate();
            
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
 
    }
    
    
    
}
