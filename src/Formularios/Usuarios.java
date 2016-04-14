/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import static Formularios.MenuPrincipal.Escritorio;
import java.awt.Dimension;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Dios Es Amor & Vida
 */
public class Usuarios extends javax.swing.JInternalFrame {

    
    Connection con;
    ResultSet r;
    CallableStatement st;
    
    public Usuarios() {
        initComponents();
        
                
       //Codigo Para La Conexion Con La Base De Datos 
        String url="jdbc:sqlserver://DIOSTEBENDIGA:1433;databaseName=Fundecar";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion"+e.getMessage(),"Error De Conexion Con La Base De Datos General",JOptionPane.ERROR_MESSAGE);
        }
        try {
            con=DriverManager.getConnection(url,"sa","123456");
            JOptionPane.showMessageDialog(null, "Conexion Con La Base De Datos Exitosa");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error de conexion"+e.getMessage(),"error de conexion",JOptionPane.ERROR_MESSAGE);
        
        
        //Fin De Conexion Con La Base De Datos
    
        JTUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JTUsuarios.doLayout();   
        
        TableColumnModel columnModel = JTUsuarios.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(200);
        columnModel.getColumn(4).setPreferredWidth(200);
        columnModel.getColumn(5).setPreferredWidth(200);

        this.inhabilitar();
        this.setTitle("Sistema General Fundacion Del Caribe Fundecar - Formulario Para La Creacion De Nuevos Usuarios");

    }
    }
    public void guardar(){
        String nom=this.JTXNombre.getText();
        String TipoUs=(String) this.JCBUTipo.getSelectedItem();
        String carg=this.JTXCargo.getText();
        String Obs=this.JTXObservaciones.getText();
        String Use=this.JTXUsuarios.getText();
        String Contra=this.JTXContraseña.getText();
        try {
            st=con.prepareCall("{call IngresarUsuario(?,?,?,?,?,?)}");
            st.setString(1, nom);
            st.setString(2, TipoUs);
            st.setString(3, carg);
            st.setString(4, Obs);
            st.setString(5, Use);
            st.setString(6, Contra);
            
            int rta=st.executeUpdate();
            if (rta==1)
            {
                JOptionPane.showMessageDialog(null, "Datos Ingresados Correctamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se guardo correctamente");
        }
    }
    
    public void Modificar(){
        String nom=this.JTXNombre.getText();
        String TipoUs=(String) this.JCBUTipo.getSelectedItem();
        String carg=this.JTXCargo.getText();
        String Obs=this.JTXObservaciones.getText();
        String Use=this.JTXUsuarios.getText();
        String Contra=this.JTXContraseña.getText();
        try {
            st=con.prepareCall("{call ModificarIngresoDeUsuarios(?,?,?,?,?,?)}");
            st.setString(1, nom);
            st.setString(2, TipoUs);
            st.setString(3, carg);
            st.setString(4, Obs);
            st.setString(5, Use);
            st.setString(6, Contra);
            
            int rta=st.executeUpdate();
            if (rta==1)
            {
                JOptionPane.showMessageDialog(null, "Datos Ingresados Correctamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se guardo correctamente");
        }
    }
//    public void CargarUsuarios()
//    {
//        DefaultTableModel modelo=(DefaultTableModel)JTUsuarios.getModel();
//        
//        res=ConexionGeneralDeBD.Consulta("select*from IngresoDeUsuarios");
//        
//    }
    public void Limpiar(){
        
        //Cajas de texto
        
        JTXNombre.setText("");
        JTXCargo.setText("");
        JTXObservaciones.setText("-");
        JTXUsuarios.setText("");
        JTXContraseña.setText("");
        JTXUBusqueda.setText("");

    }
    
    public void habilitar(){
                
        //Cajas de texto
        JTXNombre.setEnabled(true);
        JCBUTipo.setEnabled(true);
        JTXContraseña.setEnabled(true);
        JTXCargo.setEnabled(true);
        JTXObservaciones.setEnabled(true);
        JTXUsuarios.setEnabled(true);
        JTXContraseña.setEnabled(true);
              
        
        //Botones
        JBUGuardar.setEnabled(true);
        JBUCancelar.setEnabled(true);
        JBUExaminar.setEnabled(true);
        
    }
    
    public void inhabilitar(){
        
        //Cajas de texto
        JTXNombre.setEnabled(false);
        JCBUTipo.setEnabled(false);
        JTXContraseña.setEnabled(false);
        JTXCargo.setEnabled(false);
        JTXObservaciones.setEnabled(false);
        JTXUsuarios.setEnabled(false);
        JTXContraseña.setEnabled(false);
        
        
        
        //Botones
        JBUGuardar.setEnabled(false);
        JBUCancelar.setEnabled(false);
        JBUExaminar.setEnabled(false);
        
    }
    
    public void BuscarDatos(){
        String nom=JTXUBusqueda.getText();
        try {
            st=con.prepareCall("{BuscarUsuariosRegistrador}");
            st.setString(1, nom);
            r=st.executeQuery();
            if(r.next())
            {
                JOptionPane.showMessageDialog(null, "Datos Encontrados");;
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No se encontraron los datos");
            }
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JTXContraseña = new javax.swing.JPasswordField();
        JTXUsuarios = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JTXObservaciones = new javax.swing.JTextField();
        JTXCargo = new javax.swing.JTextField();
        JCBUTipo = new javax.swing.JComboBox<>();
        JTXNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        JBUExaminar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        JBUGuardar = new javax.swing.JButton();
        JBUCancelar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        JCBUsuarios = new javax.swing.JComboBox<>();
        JTXUBusqueda = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTUsuarios = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        JBBUsuarios = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);

        jLabel8.setText("Creacion De Usuarios - Sistema Fundecar");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actualizacion De Usuarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12), new java.awt.Color(0, 153, 255))); // NOI18N

        jLabel9.setText("Nombre Del Empleado");

        jLabel6.setText("Nombre Del Usuario");

        jLabel7.setText("Contraseña Del Usuario");

        JTXContraseña.setBackground(new java.awt.Color(255, 204, 51));
        JTXContraseña.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        JTXUsuarios.setBackground(new java.awt.Color(255, 204, 51));
        JTXUsuarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        jLabel1.setText("Tipo De Usuario - Nivel");

        jLabel2.setText("Cargo Actual Del Empleado");

        jLabel3.setText("Observaciones");

        JTXObservaciones.setBackground(new java.awt.Color(255, 204, 51));
        JTXObservaciones.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        JTXCargo.setBackground(new java.awt.Color(255, 204, 51));
        JTXCargo.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        JCBUTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Una Opcion", "Administrador", "Auxiliar" }));
        JCBUTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JCBUTipoMouseEntered(evt);
            }
        });

        JTXNombre.setBackground(new java.awt.Color(255, 204, 51));
        JTXNombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        JBUExaminar.setText("...");
        JBUExaminar.setToolTipText("Buscar Empleado");
        JBUExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUExaminarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/nuevo.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusable(false);
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        JBUGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/guardar.png"))); // NOI18N
        JBUGuardar.setBorder(null);
        JBUGuardar.setBorderPainted(false);
        JBUGuardar.setContentAreaFilled(false);
        JBUGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBUGuardar.setFocusable(false);
        JBUGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUGuardarActionPerformed(evt);
            }
        });

        JBUCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/cancelar.png"))); // NOI18N
        JBUCancelar.setBorder(null);
        JBUCancelar.setBorderPainted(false);
        JBUCancelar.setContentAreaFilled(false);
        JBUCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBUCancelar.setFocusable(false);
        JBUCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTXUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(JTXContraseña)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBUGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBUCancelar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JTXObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(JTXNombre)
                                        .addGap(18, 18, 18)
                                        .addComponent(JBUExaminar))
                                    .addComponent(JTXCargo)
                                    .addComponent(JCBUTipo, 0, 209, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(JTXNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBUExaminar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JCBUTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTXCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTXObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JTXUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JTXContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(JBUGuardar)
                    .addComponent(JBUCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado De Usuarios Registrados En El Sistema", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12), new java.awt.Color(0, 153, 255))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        JCBUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Una Opcion", "Cargo", "Documento", "Nombre" }));
        JCBUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBUsuariosActionPerformed(evt);
            }
        });

        JTXUBusqueda.setBackground(new java.awt.Color(255, 204, 51));
        JTXUBusqueda.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        jCheckBox1.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jCheckBox1.setText("Eliminar Registros");
        jCheckBox1.setBorder(null);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        JTUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tipo", "Cargo", "Observaciones", "Usuarios", "Contraseña"
            }
        ));
        jScrollPane1.setViewportView(JTUsuarios);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/eliminar.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setFocusable(false);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/imprimir.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setFocusable(false);

        JBBUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/buscar.png"))); // NOI18N
        JBBUsuarios.setBorder(null);
        JBBUsuarios.setBorderPainted(false);
        JBBUsuarios.setContentAreaFilled(false);
        JBBUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBBUsuarios.setFocusable(false);
        JBBUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBUsuariosActionPerformed(evt);
            }
        });

        jLabel4.setText("Total Registrados");

        jTextField1.setBackground(new java.awt.Color(255, 204, 51));
        jTextField1.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jTextField1.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCBUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                            .addComponent(JTXUBusqueda))
                        .addGap(18, 18, 18)
                        .addComponent(JBBUsuarios)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBBUsuarios)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTXUBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCBUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Listado De Usuarios", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBUExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUExaminarActionPerformed
        // TODO add your handling code here:
        IngresoDeTrabajadores creaciondeempleados =new IngresoDeTrabajadores();
        Escritorio.add(creaciondeempleados);
        creaciondeempleados.show();

        Dimension desktopSize = Escritorio.getSize();
        Dimension FrameSize = creaciondeempleados.getSize();
        creaciondeempleados.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        creaciondeempleados.show();
    }//GEN-LAST:event_JBUExaminarActionPerformed

    private void JCBUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBUsuariosActionPerformed
        // TODO add your handling code here:
        if(JCBUsuarios.getSelectedItem()=="Seleccione Una Opcion"){
            JTXUBusqueda.setEnabled(false);
        }
        else if(JCBUsuarios.getSelectedItem()=="Cargo"){
            JTXUBusqueda.setEnabled(true);
        }
        else if(JCBUsuarios.getSelectedItem()=="Nombre"){
            JTXUBusqueda.setEnabled(true);
        }
        else if (JCBUsuarios.getSelectedItem()=="Identificacion"){
            JTXUBusqueda.setEnabled(true);
        }
    }//GEN-LAST:event_JCBUsuariosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.Limpiar();
        this.habilitar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void JBUCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUCancelarActionPerformed
        // TODO add your handling code here:
        this.inhabilitar();
    }//GEN-LAST:event_JBUCancelarActionPerformed

    private void JBUGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUGuardarActionPerformed
        // TODO add your handling code here:
        if (JTXNombre.getText().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Por Favor Ingrese El Nombre Del Empleado","Error",JOptionPane.ERROR_MESSAGE);                      
        }
        
        else if (JTXCargo.getText().isEmpty())
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese El Cargo Actual Del Empleado","Error",JOptionPane.ERROR_MESSAGE);                         
        }
        else if (JTXObservaciones.getText().isEmpty())
        {
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese Una Observacion","Error",JOptionPane.ERROR_MESSAGE);                 
        }
        else if (JTXUsuarios.getText().isEmpty())
        {    
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese El Nombre Del Usuario A Registrar","Error",JOptionPane.ERROR_MESSAGE);
        }                    
        
        else if (JTXContraseña.getText().isEmpty())
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese La Contraseña Del Usuario A Registrar","Error",JOptionPane.ERROR_MESSAGE);                
        }
    
        else 
        {
        if (JOptionPane.showConfirmDialog(null,"Desea Registrar El Prestamos","Confirmar",1)==0){
           DatosDeIngreso leer = new DatosDeIngreso();
            
            leer.setNombre(JTXNombre.getText());
            leer.setTipoUsuario(JCBUTipo.getSelectedItem());
            leer.setCargoActual(JTXCargo.getText());
            leer.setObservaciones(JTXObservaciones.getText());
            leer.setUsuarios(JTXUsuarios.getText());
            leer.setContraseña(JTXContraseña.getText());
                         
            
            //INGRESAR DATOS A TABLA
            DefaultTableModel modelo = (DefaultTableModel) JTUsuarios.getModel();


            Object [] Fila=new Object[6];

            Fila[0]=JTXNombre.getText();
            Fila[1]=JCBUTipo.getSelectedItem();
            Fila[2]=JTXCargo.getText();
            Fila[3]=JTXObservaciones.getText();
            Fila[4]=JTXUsuarios.getText();
            Fila[5]=JTXContraseña.getText();
            

                modelo.addRow(Fila);


                JTUsuarios.setModel(modelo);
        this.guardar();
        
        
        
        }
        }
    }//GEN-LAST:event_JBUGuardarActionPerformed

    private void JCBUTipoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCBUTipoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBUTipoMouseEntered

    private void JBBUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBUsuariosActionPerformed
        // TODO add your handling code here:
        this.BuscarDatos();
    }//GEN-LAST:event_JBBUsuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBBUsuarios;
    private javax.swing.JButton JBUCancelar;
    private javax.swing.JButton JBUExaminar;
    private javax.swing.JButton JBUGuardar;
    private javax.swing.JComboBox<String> JCBUTipo;
    private javax.swing.JComboBox<String> JCBUsuarios;
    private javax.swing.JTable JTUsuarios;
    private javax.swing.JTextField JTXCargo;
    private javax.swing.JPasswordField JTXContraseña;
    private javax.swing.JTextField JTXNombre;
    private javax.swing.JTextField JTXObservaciones;
    private javax.swing.JTextField JTXUBusqueda;
    private javax.swing.JTextField JTXUsuarios;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private static class DatosDeIngreso {

        public DatosDeIngreso() {
        }

        private void setNombre(String text) {
            
        }

        private void setTipoUsuario(Object selectedItem) {
            
        }

        private void setCargoActual(String text) {
            
        }

        private void setObservaciones(String text) {
            
        }

        private void setUsuarios(String text) {
            
        }

        private void setContraseña(String text) {
            
        }
    }
}
