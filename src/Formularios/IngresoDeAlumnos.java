/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BaseDeDatos.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Dios Es Amor & Vida
 */
public class IngresoDeAlumnos extends javax.swing.JInternalFrame {
    
    //NUEVA 
    Connection cn;
   CallableStatement cts;
   ResultSet r;
   ConexionBD conectar=new ConexionBD();

   //Vieja
   Connection con;
    //ResultSet r;
    CallableStatement st;
  
        
    public IngresoDeAlumnos() {
        initComponents();
        cn=conectar.conecion();
        
        
        try {
            MenuPrincipal.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        
        
//        //Codigo Para La Conexion Con La Base De Datos 
//        String url="jdbc:sqlserver://DIOSTEBENDIGA:1433;databaseName=Fundecar";
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error de conexion"+e.getMessage(),"Error De Conexion Con La Base De Datos General",JOptionPane.ERROR_MESSAGE);
//        }
//        try {
//            cn=DriverManager.getConnection(url,"sa","123456");
//            JOptionPane.showMessageDialog(null, "Conexion Con La Base De Datos Exitosa");
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "error de conexion"+e.getMessage(),"error de conexion",JOptionPane.ERROR_MESSAGE);
//        
        
//Fin De Conexion Con La Base De Datos
    


        
        
        this.inhabilitar();
        this.setTitle("Sistema General Instituto Fundecar - Formulario Para El Ingreso De Nuevos Alumnos");
    }
    
   public void CuadrarTabla() {
        JTIngresoDeAlumnos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JTIngresoDeAlumnos.doLayout();   
        
        TableColumnModel columnModel = JTIngresoDeAlumnos.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(200);
        columnModel.getColumn(4).setPreferredWidth(200);
        columnModel.getColumn(5).setPreferredWidth(200);
        columnModel.getColumn(6).setPreferredWidth(200);
        columnModel.getColumn(7).setPreferredWidth(200);
        columnModel.getColumn(8).setPreferredWidth(200);
        columnModel.getColumn(9).setPreferredWidth(200);
   }
    public void guardar(){
        String nom=this.JTIANombre.getText();
        String cod=this.JTIACodigo.getText();
        String TipoId= this.JCBIAIdentificacion.getSelectedItem().toString();
        String iden=this.JTIATipoDeIdentificacion.getText();
        String Dir=this.JTIADireccion.getText();
        String FecI=this.JDCIAFechaDeIngreso.getDate().toString();
        String Oins= this.JCIAOtraInstitucion.getSelectedItem().toString();
        String NomP=this.JRIANombreDelPlantel.getText();
        String UltC=this.JRIAUltimoCurso.getText();
        String CurA=this.JRIACursoAIniciar.getText();
        try {
            cts=cn.prepareCall("{call IngresarAlumnos(?,?,?,?,?,?,?,?,?,?)}");
            cts.setString(1, nom);
            cts.setString(2, cod);
            cts.setString(3, TipoId);
            cts.setString(4, iden);
            cts.setString(5, Dir);
            cts.setString(6, FecI);
            cts.setString(7, Oins);
            cts.setString(8, NomP);
            cts.setString(9, UltC);
            cts.setString(10, CurA);
            
            int rpta=cts.executeUpdate();
            if (rpta==1)
            {
                JOptionPane.showMessageDialog(null, "Datos Ingresados Correctamente");
            }
        } catch (Exception e) {
            Logger.getLogger(IngresoDeAlumnos.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "No se guardo correctamente");
        }
    }
    public void Buscar(){
        String nom=this.JTIANombre.getText();
        try {
            cts=cn.prepareCall("{call BuscarAlumnosRegistrados (?)}");
            cts.setString(1, nom);
            r=cts.executeQuery();
            if(r.next())
            {
                JOptionPane.showMessageDialog(null, "Datos Encontrados");
                this.JTIANombre.setText(r.getString(1));
                this.JTIACodigo.setText(r.getString(2));
                this.JCBIAIdentificacion.setSelectedItem(r.getString(3));
                this.JTIATipoDeIdentificacion.setText(r.getString(4));
                this.JTIADireccion.setText(r.getString(5));
                this.JDCIAFechaDeIngreso.setDate(r.getDate(6));
                this.JCIAOtraInstitucion.setSelectedItem(r.getString(7));
                this.JRIANombreDelPlantel.setText(r.getString(8));
                this.JRIAUltimoCurso.setText(r.getString(9));
                this.JRIACursoAIniciar.setText(r.getString(10));
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No Se Encontraron Registros");
            }
        } catch (Exception e) {
        }
    }
    
    public void Modificar(){
        String nom=this.JTIANombre.getText();
        String cod=this.JTIACodigo.getText();
        String TipoId= this.JCBIAIdentificacion.getSelectedItem().toString();
        String iden=this.JTIATipoDeIdentificacion.getText();
        String Dir=this.JTIADireccion.getText();
        String FecI=this.JDCIAFechaDeIngreso.getDate().toString();
        String Oins= this.JCIAOtraInstitucion.getSelectedItem().toString();
        String NomP=this.JRIANombreDelPlantel.getText();
        String UltC=this.JRIAUltimoCurso.getText();
        String CurA=this.JRIACursoAIniciar.getText();
        try {
            cts=cn.prepareCall("{call ModificarAlumnosRegistrados(?,?,?,?,?,?,?,?,?,?)}");
            cts.setString(1, nom);
            cts.setString(2, cod);
            cts.setString(3, TipoId);
            cts.setString(4, iden);
            cts.setString(5, Dir);
            cts.setString(6, FecI);
            cts.setString(7, Oins);
            cts.setString(8, NomP);
            cts.setString(9, UltC);
            cts.setString(10, CurA);
            
            int rpta=cts.executeUpdate();
            if (rpta==1)
            {
                JOptionPane.showMessageDialog(null, "Datos Modificados Correctamente");
            }
        } catch (Exception e) {
            Logger.getLogger(IngresoDeAlumnos.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "No Se Modificaron Correctamente");
        }
    }
    
    
    public void Mostrar(){
        DefaultTableModel tabla=new DefaultTableModel();
        try {
            tabla.addColumn("Nombre Del Alumno");
            tabla.addColumn("Codigo Del Estudiante");
            tabla.addColumn("Tipo De Identificacion");
            tabla.addColumn("Identificacion");
            tabla.addColumn("Direccion");
            tabla.addColumn("Fecha De Ingreso");
            tabla.addColumn("Viene De Otra Inst.");
            tabla.addColumn("Nombre Del Plantel");
            tabla.addColumn("Ultimo Curso Realizado");
            tabla.addColumn("Curso A Iniciar");
            
            cts=cn.prepareCall("{call MostrarAlumnosRegistrados}");
            r=cts.executeQuery();
            while (r.next()){
                Object dato[]=new Object[10];
                for (int i=0; i<10;i++){
                    dato[i]=r.getString(i+1);
                }
                tabla.addRow(dato);
            }
            
            this.JTIngresoDeAlumnos.setModel(tabla);
            this.CuadrarTabla();
        } catch (Exception e) {
            
        }
    }
    
    public void Limpiar(){
        
        //Cajas de texto
        JTIANombre.setText("");
        JTIACodigo.setText("");
        JTIATipoDeIdentificacion.setText("");
        JTIADireccion.setText("-");
        JRIANombreDelPlantel.setText("-");
        JRIAUltimoCurso.setText("-");
        JRIACursoAIniciar.setText("-");
        
                
    }
    
    public void habilitar(){
        
        //Cajas de texto
        JTIANombre.setEnabled(true);
        JTIACodigo.setEnabled(true);
        JTIATipoDeIdentificacion.setEnabled(true);
        JTIADireccion.setEnabled(true);
        JDCIAFechaDeIngreso.setEnabled(true);
        JCIAOtraInstitucion.setEnabled(true);
        JRIANombreDelPlantel.setEnabled(true);
        JRIAUltimoCurso.setEnabled(true);
        JRIACursoAIniciar.setEnabled(true);
        
        //Botones
        JBIAEditar.setEnabled(true);
        JBIAGuardar.setEnabled(true);
        
    }
    
    
    public void inhabilitar(){
        
        //Cajas de texto
        //Cajas de texto
        JTIANombre.setEnabled(false);
        JTIACodigo.setEnabled(false);
        JTIATipoDeIdentificacion.setEnabled(false);
        JTIADireccion.setEnabled(false);
        JDCIAFechaDeIngreso.setEnabled(false);
        JCIAOtraInstitucion.setEnabled(false);
        JRIANombreDelPlantel.setEnabled(false);
        JRIAUltimoCurso.setEnabled(false);
        JRIACursoAIniciar.setEnabled(false);
        
        //Botones
        JBIAEditar.setEnabled(false);
        JBIAGuardar.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JTIANombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JTIACodigo = new javax.swing.JTextField();
        JRIAUltimoCurso = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JTIADireccion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        JTIATipoDeIdentificacion = new javax.swing.JTextField();
        JDCIAFechaDeIngreso = new com.toedter.calendar.JDateChooser();
        JRIANombreDelPlantel = new javax.swing.JTextField();
        JRIACursoAIniciar = new javax.swing.JTextField();
        JBIANuevo = new javax.swing.JButton();
        JBIAGuardar = new javax.swing.JButton();
        JBIAEditar = new javax.swing.JButton();
        JBIACancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        JCBIAIdentificacion = new javax.swing.JComboBox<>();
        JCIAOtraInstitucion = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField11 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        JTIATotalIngresados1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTIngresoDeAlumnosRecientes = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        JTXBuscar = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        JTIATotalIngresados = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTIngresoDeAlumnos = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);

        jLabel1.setText("Creacion de nuevos alumnos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro De Nuevos Alumnos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12), new java.awt.Color(0, 153, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel2.setText("Nombres Del Alumno");

        JTIANombre.setBackground(new java.awt.Color(255, 204, 51));
        JTIANombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel3.setText("Codigo Del Estudiante");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel4.setText("Viene De Otra Inst.");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel5.setText("Ult. Curso Realizado");

        JTIACodigo.setBackground(new java.awt.Color(255, 204, 51));
        JTIACodigo.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        JRIAUltimoCurso.setBackground(new java.awt.Color(255, 204, 51));
        JRIAUltimoCurso.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel7.setText("Tipo De Identificacion");

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel8.setText("Nombre Del Plantel");

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel9.setText("Direccion");

        JTIADireccion.setBackground(new java.awt.Color(255, 204, 51));
        JTIADireccion.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel10.setText("Fecha De Ingreso");

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel11.setText("Curso A Iniciar");

        JTIATipoDeIdentificacion.setBackground(new java.awt.Color(255, 204, 51));
        JTIATipoDeIdentificacion.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N

        JDCIAFechaDeIngreso.setBackground(new java.awt.Color(255, 204, 51));

        JRIANombreDelPlantel.setBackground(new java.awt.Color(255, 204, 51));
        JRIANombreDelPlantel.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N

        JRIACursoAIniciar.setBackground(new java.awt.Color(255, 204, 51));
        JRIACursoAIniciar.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N

        JBIANuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/nuevo.png"))); // NOI18N
        JBIANuevo.setBorder(null);
        JBIANuevo.setBorderPainted(false);
        JBIANuevo.setContentAreaFilled(false);
        JBIANuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBIANuevo.setFocusable(false);
        JBIANuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBIANuevoActionPerformed(evt);
            }
        });

        JBIAGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/guardar.png"))); // NOI18N
        JBIAGuardar.setBorder(null);
        JBIAGuardar.setBorderPainted(false);
        JBIAGuardar.setContentAreaFilled(false);
        JBIAGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBIAGuardar.setFocusable(false);
        JBIAGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBIAGuardarActionPerformed(evt);
            }
        });

        JBIAEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/editar.png"))); // NOI18N
        JBIAEditar.setBorder(null);
        JBIAEditar.setBorderPainted(false);
        JBIAEditar.setContentAreaFilled(false);
        JBIAEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBIAEditar.setFocusable(false);
        JBIAEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBIAEditarActionPerformed(evt);
            }
        });

        JBIACancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/cancelar.png"))); // NOI18N
        JBIACancelar.setBorder(null);
        JBIACancelar.setBorderPainted(false);
        JBIACancelar.setContentAreaFilled(false);
        JBIACancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBIACancelar.setFocusable(false);
        JBIACancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBIACancelarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        JCBIAIdentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "T.I.", "I.E." }));
        JCBIAIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBIAIdentificacionActionPerformed(evt);
            }
        });

        JCIAOtraInstitucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Una Opcion", "Si", "No" }));
        JCIAOtraInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCIAOtraInstitucionActionPerformed(evt);
            }
        });

        jLabel14.setText("Codigo");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setText("Mostrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTIACodigo)
                            .addComponent(JRIAUltimoCurso)
                            .addComponent(JTIADireccion)
                            .addComponent(JCIAOtraInstitucion, 0, 200, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JDCIAFechaDeIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(JRIANombreDelPlantel)
                            .addComponent(JRIACursoAIniciar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JCBIAIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JTIATipoDeIdentificacion))))
                    .addComponent(JTIANombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(JBIANuevo)
                            .addGap(18, 18, 18)
                            .addComponent(JBIAEditar))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(JBIAGuardar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1)
                                .addComponent(JBIACancelar))))
                    .addComponent(jLabel14)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(101, 101, 101)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(JTIANombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(JTIACodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)
                                            .addComponent(JTIATipoDeIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JCBIAIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(JTIADireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10)))
                                    .addComponent(JDCIAFechaDeIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(JRIANombreDelPlantel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JCIAOtraInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(JRIAUltimoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(JRIACursoAIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JBIANuevo)
                                    .addComponent(JBIAEditar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JBIAGuardar)
                                    .addComponent(JBIACancelar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jComboBox2.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Una Opcion" }));
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTextField11.setBackground(new java.awt.Color(255, 204, 51));
        jTextField11.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/buscar.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/imprimir.png"))); // NOI18N
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/cancelar.png"))); // NOI18N
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jCheckBox2.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jCheckBox2.setText("Eliminar Registros");
        jCheckBox2.setBorder(null);
        jCheckBox2.setFocusable(false);

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel13.setText("Total Registrados");

        JTIATotalIngresados1.setBackground(new java.awt.Color(255, 204, 51));
        JTIATotalIngresados1.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        JTIATotalIngresados1.setFocusable(false);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        JTIngresoDeAlumnosRecientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombres Del Alumno", "Apellidos Del Alumno", "Codigo Del Estudiante", "Tipo De Identificacion", "Direccion", "Fecha De Ingreso", "Viene De Otra Inst.", "Nombre Del Plantel", "Ult. Curso Realizado", "Curso A Iniciar"
            }
        ));
        jScrollPane2.setViewportView(JTIngresoDeAlumnosRecientes);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(JTIATotalIngresados1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox2)
                        .addGap(0, 102, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7)
                        .addComponent(jButton9)
                        .addComponent(jButton10)
                        .addComponent(jLabel13)
                        .addComponent(JTIATotalIngresados1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox2)))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1199, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Listado De Alumnos Recien Registrados", jPanel5);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jComboBox1.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Una Opcion" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JTXBuscar.setBackground(new java.awt.Color(255, 204, 51));
        JTXBuscar.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/buscar.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/imprimir.png"))); // NOI18N
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.setFocusable(false);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/cancelar.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jCheckBox1.setText("Eliminar Registros");
        jCheckBox1.setBorder(null);
        jCheckBox1.setFocusable(false);

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel12.setText("Total Registrados");

        JTIATotalIngresados.setBackground(new java.awt.Color(255, 204, 51));
        JTIATotalIngresados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTIATotalIngresadosActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        JTIngresoDeAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título 1", "Título 2", "Título 3", "Título 4"
            }
        ));
        jScrollPane3.setViewportView(JTIngresoDeAlumnos);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JTXBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(JTIATotalIngresados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 108, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTXBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jButton11)
                        .addComponent(jButton6)
                        .addComponent(jLabel12)
                        .addComponent(JTIATotalIngresados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox1)))
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1199, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Listado De Alumnos Registrados", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBIAGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBIAGuardarActionPerformed
        // TODO add your handling code here:
        
        if (JTIANombre.getText().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Por Favor Ingrese El Nombre Del Alumno ","Error",JOptionPane.ERROR_MESSAGE);                      
        }
                
        else if (JTIACodigo.getText().isEmpty())
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese El Codigo Del Alumno","Error",JOptionPane.ERROR_MESSAGE);                         
        }
        else if (JCBIAIdentificacion.getSelectedIndex() == 0)
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Seleccione El Tipo De Identificacion","Error",JOptionPane.ERROR_MESSAGE);                         
        }
        else if (JTIATipoDeIdentificacion.getText().isEmpty())
        {
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese El Numero De Identificacion","Error",JOptionPane.ERROR_MESSAGE);                 
        }
               
        
        else if (JTIADireccion.getText().isEmpty())
        {    
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese Una Direccion Si Aplica - Si No Aplica Ingrese -","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if (JCIAOtraInstitucion.getSelectedIndex() == 0)
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese Si Proveniente De Otra Institucion","Error",JOptionPane.ERROR_MESSAGE);                         
        }
        
                
        else if (JRIANombreDelPlantel.getText().isEmpty())
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese El Nombre Del Plantel Si Aplica Si No Ingrese - ","Error",JOptionPane.ERROR_MESSAGE);                
        }
        
        else if (JRIAUltimoCurso.getText().isEmpty())
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese El Ultimo Curso Realizado Si Aplica Si No Ingrese - ","Error",JOptionPane.ERROR_MESSAGE);                
        }
        
        else if (JRIACursoAIniciar.getText().isEmpty())
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese El Curso A Iniciar Si Aplica Si No Ingrese - ","Error",JOptionPane.ERROR_MESSAGE);                
        }
        
    
        else 
        {
        if (JOptionPane.showConfirmDialog(null,"Desea Registrar El Boletin","Confirmar",1)==0){
           IngresoDeAlumnos.DatosDeIngreso leer = new IngresoDeAlumnos.DatosDeIngreso();
            
           
           
            leer.setNombre(JTIANombre.getText());
            leer.setCodigo(JTIACodigo.getText());
            leer.setIdentificacion(JCBIAIdentificacion.getSelectedItem());
            leer.setTipoIdentificacion(JTIATipoDeIdentificacion.getText());
            leer.setDireccion(JTIADireccion.getText());
            leer.setOtraInstitucion(JCIAOtraInstitucion.getSelectedItem());
            leer.setNombrePlantel(JRIANombreDelPlantel.getText());
            leer.setUltimoCurso(JRIAUltimoCurso.getText());
            leer.setCursoAIniciar(JRIACursoAIniciar.getText());
            
        
        this.guardar();
        this.Mostrar();
        
        //INGRESAR DATOS A TABLA
            DefaultTableModel modelo = (DefaultTableModel) JTIngresoDeAlumnosRecientes.getModel();


            Object [] Fila=new Object[10];

            Fila[0]=JTIANombre.getText();
            Fila[1]=JTIACodigo.getText();
            Fila[2]=JCBIAIdentificacion.getSelectedItem().toString();
            Fila[3]=JTIATipoDeIdentificacion.getText();
            Fila[4]=JTIADireccion.getText();
            Fila[5]=JDCIAFechaDeIngreso.getDate().toString();
            Fila[6]=JCIAOtraInstitucion.getSelectedItem().toString();
            Fila[7]=JRIANombreDelPlantel.getText();
            Fila[8]=JRIAUltimoCurso.getText();
            Fila[9]=JRIACursoAIniciar.getText();

                modelo.addRow(Fila);


                JTIngresoDeAlumnosRecientes.setModel(modelo);
        
        
        int TotalGuardados;
        TotalGuardados =JTIngresoDeAlumnosRecientes.getRowCount();
        JTIATotalIngresados.setText(""+TotalGuardados);
    }//GEN-LAST:event_JBIAGuardarActionPerformed
        }
    }
    private void JCBIAIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBIAIdentificacionActionPerformed
        // TODO add your handling code here:
        if(JCBIAIdentificacion.getSelectedItem()=="-"){
            JTIATipoDeIdentificacion.setEnabled(false);
        }
        else if(JCBIAIdentificacion.getSelectedItem()=="T.I."){
            JTIATipoDeIdentificacion.setEnabled(true);
        }
        else if (JCBIAIdentificacion.getSelectedItem()=="I.E."){
            JTIATipoDeIdentificacion.setEnabled(true);
        }
    }//GEN-LAST:event_JCBIAIdentificacionActionPerformed

    private void JCIAOtraInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCIAOtraInstitucionActionPerformed
        // TODO add your handling code here:
        if(JCIAOtraInstitucion.getSelectedItem()=="Seleccione Una Opcion"){
            JRIANombreDelPlantel.setEnabled(false);
        }
        else if (JCIAOtraInstitucion.getSelectedItem()=="Seleccione Una Opcion"){
            JRIAUltimoCurso.setEnabled(false);
        }
        else if (JCIAOtraInstitucion.getSelectedItem()=="Seleccione Una Opcion"){
            JRIACursoAIniciar.setEnabled(false);
        }
        else if(JCIAOtraInstitucion.getSelectedItem()=="Si"){
            JRIANombreDelPlantel.setEnabled(true);
        }
        else if(JCIAOtraInstitucion.getSelectedItem()=="Si"){
            JRIAUltimoCurso.setEnabled(true);
        }
        else if(JCIAOtraInstitucion.getSelectedItem()=="Si"){
            JRIACursoAIniciar.setEnabled(true);
        }
        else if (JCIAOtraInstitucion.getSelectedItem()=="No"){
            JRIANombreDelPlantel.setEnabled(false);
        }
        else if (JCIAOtraInstitucion.getSelectedItem()=="No"){
            JRIAUltimoCurso.setEnabled(false);
        }
        else if (JCIAOtraInstitucion.getSelectedItem()=="No"){
            JRIACursoAIniciar.setEnabled(false);
        }
    }//GEN-LAST:event_JCIAOtraInstitucionActionPerformed

    private void JBIACancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBIACancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_JBIACancelarActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void JBIANuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBIANuevoActionPerformed
        // TODO add your handling code here:
        
        this.Limpiar();
        try{
        
         cts=cn.prepareCall("{call Genera_Numero_De_Alumnos}");
       r=cts.executeQuery();
       if (r.next())
        
          jTextField1.setText(r.getString(1));
            }catch (Exception e){} 
          this.habilitar();
         
        
        
    }//GEN-LAST:event_JBIANuevoActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        char car=evt.getKeyChar();
         if(  jTextField1.getText().length()>=5)evt.consume();
          if((car<'c' || car>'c') && (car<'C' || car>'C')&&(car<'0'||car>'9')) evt.consume();
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.Mostrar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JBIAEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBIAEditarActionPerformed
        // TODO add your handling code here:
        this.Modificar();
    }//GEN-LAST:event_JBIAEditarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void JTIATotalIngresadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTIATotalIngresadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTIATotalIngresadosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBIACancelar;
    private javax.swing.JButton JBIAEditar;
    private javax.swing.JButton JBIAGuardar;
    private javax.swing.JButton JBIANuevo;
    private javax.swing.JComboBox<String> JCBIAIdentificacion;
    private javax.swing.JComboBox<String> JCIAOtraInstitucion;
    private com.toedter.calendar.JDateChooser JDCIAFechaDeIngreso;
    private javax.swing.JTextField JRIACursoAIniciar;
    private javax.swing.JTextField JRIANombreDelPlantel;
    private javax.swing.JTextField JRIAUltimoCurso;
    private javax.swing.JTextField JTIACodigo;
    private javax.swing.JTextField JTIADireccion;
    private javax.swing.JTextField JTIANombre;
    private javax.swing.JTextField JTIATipoDeIdentificacion;
    private javax.swing.JTextField JTIATotalIngresados;
    private javax.swing.JTextField JTIATotalIngresados1;
    private javax.swing.JTable JTIngresoDeAlumnos;
    private javax.swing.JTable JTIngresoDeAlumnosRecientes;
    private javax.swing.JTextField JTXBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    // End of variables declaration//GEN-END:variables

    private static class DatosDeIngreso {

        public DatosDeIngreso() {
        }

        private void setNombre(String text) {
            
        }

        private void setCodigo(String text) {
            
        }

        private void setIdentificacion(Object selectedItem) {
            
        }

        private void setTipoIdentificacion(String text) {
            
        }

        private void setDireccion(String text) {
            
        }

        private void setOtraInstitucion(Object selectedItem) {
            
        }

        private void setNombrePlantel(String text) {
            
        }

        private void setUltimoCurso(String text) {
            
        }

        private void setCursoAIniciar(String text) {
            
        }
    }
}
