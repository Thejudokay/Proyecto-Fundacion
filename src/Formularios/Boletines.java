/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import BaseDeDatos.ConexionBDBoletines;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Dios Es Amor & Vida
 */
public class Boletines extends javax.swing.JInternalFrame {

    Connection con;
    ResultSet r;
    CallableStatement st;
    
    public Boletines() {
        initComponents();
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/boletinesfundecar","root","");
            JOptionPane.showMessageDialog(null, "Conexion Con La Base De Datos Exitosa");
        } catch (Exception e) {
        }
        
        
//        this.inhabilitar();
//        this.setTitle("Sistema General Fundacion Del Caribe Fundecar - Formulario Para El Ingreso De Trabajadores");
//               
//        //Codigo Para La Conexion Con La Base De Datos 
//        String url="jdbc:sqlserver://DIOSTEBENDIGA:1433;databaseName=Fundecar";
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error de conexion"+e.getMessage(),"Error De Conexion Con La Base De Datos General",JOptionPane.ERROR_MESSAGE);
//        }
//        try {
//            con=DriverManager.getConnection(url,"sa","123456");
//            JOptionPane.showMessageDialog(null, "Conexion Con La Base De Datos Exitosa");
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "error de conexion"+e.getMessage(),"error de conexion",JOptionPane.ERROR_MESSAGE);
        
        
        //Fin De Conexion Con La Base De Datos
        
        JTBoletienesJardin.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JTBoletienesJardin.doLayout();
  
                
        TableColumnModel columnModel = JTBoletienesJardin.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(70);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(70);
        columnModel.getColumn(4).setPreferredWidth(200);
        columnModel.getColumn(5).setPreferredWidth(70);
        columnModel.getColumn(6).setPreferredWidth(200);
        columnModel.getColumn(7).setPreferredWidth(70);
        columnModel.getColumn(8).setPreferredWidth(200);
        columnModel.getColumn(9).setPreferredWidth(70);
        columnModel.getColumn(10).setPreferredWidth(200);
        columnModel.getColumn(11).setPreferredWidth(70);
        columnModel.getColumn(12).setPreferredWidth(200);
        columnModel.getColumn(13).setPreferredWidth(70);
        columnModel.getColumn(14).setPreferredWidth(200);
        columnModel.getColumn(15).setPreferredWidth(70);
        columnModel.getColumn(16).setPreferredWidth(200);
        columnModel.getColumn(17).setPreferredWidth(70);
        //Fin de columnas jtable
        
        
    
    }
    
    
    public void guardar(){
        
        String Alum=this.JTXBNombreDelAlumno.getText();
        String Grad=this.JTXBGrado.getText();
        String Num=this.JTXBNumeroDeBoletin.getText();
        Date Fech=this.JDCFecha.getDate();
        String cogn=this.JTPCognitiva1.getText();
        String niv1=this.JTPCognitiva1.getText();
        String comu=this.JTPComunicativa2.getText();
        String niv2=this.JTPCognitiva1.getText();
        String acti=this.JTPActitudes3.getText();
        String niv3=this.JTPCognitiva1.getText();
        String este=this.JTPEstetica4.getText();
        String niv4=this.JTPCognitiva1.getText();
        String cor=this.JTPCorporal5.getText();
        String niv5=this.JTPCognitiva1.getText();
        String mat=this.JTPMatematicas6.getText();
        String niv6=this.JTPCognitiva1.getText();
        String lect=this.JTPLectoEscritura7.getText();
        String niv7=this.JTPCognitiva1.getText();
        String areas=this.JTPAreasIntegradas8.getText();
        String niv8=this.JTPCognitiva1.getText();
        String ing=this.JTPIngles9.getText();
        String niv9=this.JTPCognitiva1.getText();
        try {
            st=con.prepareCall("{call IngresarBoletines(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            st.setString(1, Alum);
            st.setString(2, Grad);
            st.setString(3, Num);
            st.setDate(4, (java.sql.Date) Fech);
            st.setString(5, cogn);
            st.setString(6, niv1);
            st.setString(7, comu);
            st.setString(8, niv2);
            st.setString(9, acti);
            st.setString(10, niv3);
            st.setString(11, este);
            st.setString(12, niv4);
            st.setString(13, cor);
            st.setString(14, niv5);
            st.setString(15, mat);
            st.setString(16, niv6);
            st.setString(17, lect);
            st.setString(18, niv7);
            st.setString(19, areas);
            st.setString(20, niv8);
            st.setString(21, ing);
            st.setString(22, niv9);
            
            
            int rta=st.executeUpdate();
            if (rta==1)
            {
                JOptionPane.showMessageDialog(null, "Datos Ingresados Correctamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se guardo correctamente");
        }
    }
    public void Limpiar(){
        
        //Cajas de texto
        JTXBNombreDelAlumno.setText("");
        JTXBGrado.setText("");
        JTXBNumeroDeBoletin.setText("");
        
        //Caja de texto
        JTPCognitiva1.setText("");
        JTPComunicativa2.setText("");
        JTPActitudes3.setText("-");
        JTPEstetica4.setText("");
        JTPCorporal5.setText("");
        JTPMatematicas6.setText("");
        JTPLectoEscritura7.setText("");
        JTPAreasIntegradas8.setText("");
        JTPIngles9.setText("");

    }
    
    public void habilitar(){
        
        //Informacion Alumno . Boletin
        
        JTXBNombreDelAlumno.setEnabled(true);
        JTXBGrado.setEnabled(true);
        JTXBNumeroDeBoletin.setEnabled(true);
        JDCFecha.setEnabled(true);
        
        //Cajas de texto
        JTPCognitiva1.setEnabled(true);
        JTPComunicativa2.setEnabled(true);
        JTPActitudes3.setEnabled(true);
        JTPEstetica4.setEnabled(true);
        JTPCorporal5.setEnabled(true);
        JTPMatematicas6.setEnabled(true);
        JTPLectoEscritura7.setEnabled(true);
        JTPAreasIntegradas8.setEnabled(true);
        JTPIngles9.setEnabled(true);
             

        //Niveles - Combobox
        JCBBoletines1.setEnabled(true);
        JCBBoletines2.setEnabled(true);
        JCBBoletines3.setEnabled(true);
        JCBBoletines4.setEnabled(true);
        JCBBoletines5.setEnabled(true);
        JCBBoletines6.setEnabled(true);
        JCBBoletines7.setEnabled(true);
        JCBBoletines8.setEnabled(true);
        JCBBoletines9.setEnabled(true);
        
        
        //Botones
        JBBGuardar.setEnabled(true);
        JBBSalir.setEnabled(true);
        
    }
    
    public void inhabilitar(){
        
        //Informacion Alumno . Boletin
        
        JTXBNombreDelAlumno.setEnabled(false);
        JTXBGrado.setEnabled(false);
        JTXBNumeroDeBoletin.setEnabled(false);
        JDCFecha.setEnabled(false);
        
        
        //Cajas de texto
        JTPCognitiva1.setEnabled(false);
        JTPComunicativa2.setEnabled(false);
        JTPActitudes3.setEnabled(false);
        JTPEstetica4.setEnabled(false);
        JTPCorporal5.setEnabled(false);
        JTPMatematicas6.setEnabled(false);
        JTPLectoEscritura7.setEnabled(false);
        JTPAreasIntegradas8.setEnabled(false);
        JTPIngles9.setEnabled(false);
        
        //Niveles - Combobox
        JCBBoletines1.setEnabled(false);
        JCBBoletines2.setEnabled(false);
        JCBBoletines3.setEnabled(false);
        JCBBoletines4.setEnabled(false);
        JCBBoletines5.setEnabled(false);
        JCBBoletines6.setEnabled(false);
        JCBBoletines7.setEnabled(false);
        JCBBoletines8.setEnabled(false);
        JCBBoletines9.setEnabled(false);
        
        //Botones
        JBBGuardar.setEnabled(false);
        JBBSalir.setEnabled(false);
        
        
    }
    




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelDePrueba = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel10 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        JTPCognitiva1 = new javax.swing.JTextPane();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        JTPComunicativa2 = new javax.swing.JTextPane();
        jLabel91 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        JTPActitudes3 = new javax.swing.JTextPane();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        JTPCorporal5 = new javax.swing.JTextPane();
        jLabel94 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        JTPMatematicas6 = new javax.swing.JTextPane();
        jLabel95 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        JTPLectoEscritura7 = new javax.swing.JTextPane();
        jLabel96 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        JTPAreasIntegradas8 = new javax.swing.JTextPane();
        jLabel97 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        JTPIngles9 = new javax.swing.JTextPane();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        JTPEstetica4 = new javax.swing.JTextArea();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JCBBoletines1 = new javax.swing.JComboBox<>();
        JCBBoletines2 = new javax.swing.JComboBox<>();
        JCBBoletines3 = new javax.swing.JComboBox<>();
        JCBBoletines4 = new javax.swing.JComboBox<>();
        JCBBoletines5 = new javax.swing.JComboBox<>();
        JCBBoletines6 = new javax.swing.JComboBox<>();
        JCBBoletines7 = new javax.swing.JComboBox<>();
        JCBBoletines8 = new javax.swing.JComboBox<>();
        JCBBoletines9 = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        JTXBNombreDelAlumno = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        JTXBGrado = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        JTXBNumeroDeBoletin = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        JDCFecha = new com.toedter.calendar.JDateChooser();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTBoletienesJardin = new javax.swing.JTable();
        JBBGuardar = new javax.swing.JButton();
        JBBSalir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        PanelDePrueba.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel86.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel86.setText("Cognitiva");

        JTPCognitiva1.setBackground(new java.awt.Color(255, 204, 51));
        jScrollPane13.setViewportView(JTPCognitiva1);

        jLabel87.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("Dimensiones");

        jLabel88.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("Logros Alcanzados");

        jLabel89.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel89.setText("Nivel");

        jLabel90.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel90.setText("Comunicativa");

        JTPComunicativa2.setBackground(new java.awt.Color(255, 204, 51));
        jScrollPane14.setViewportView(JTPComunicativa2);

        jLabel91.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel91.setText("Actitudes y Valores");

        JTPActitudes3.setBackground(new java.awt.Color(255, 204, 51));
        jScrollPane15.setViewportView(JTPActitudes3);

        jLabel92.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel92.setText("Estetica");

        jLabel93.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel93.setText("Corporal");

        JTPCorporal5.setBackground(new java.awt.Color(255, 204, 51));
        jScrollPane17.setViewportView(JTPCorporal5);

        jLabel94.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel94.setText("Pre-Matematicas");

        JTPMatematicas6.setBackground(new java.awt.Color(255, 204, 51));
        jScrollPane18.setViewportView(JTPMatematicas6);

        jLabel95.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel95.setText("Lecto Escritura");

        JTPLectoEscritura7.setBackground(new java.awt.Color(255, 204, 51));
        jScrollPane19.setViewportView(JTPLectoEscritura7);

        jLabel96.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel96.setText("Areas Integradas");

        JTPAreasIntegradas8.setBackground(new java.awt.Color(255, 204, 51));
        jScrollPane20.setViewportView(JTPAreasIntegradas8);

        jLabel97.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel97.setText("Ingles");

        JTPIngles9.setBackground(new java.awt.Color(255, 204, 51));
        jScrollPane21.setViewportView(JTPIngles9);

        jLabel36.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel36.setText("Nivel");

        jLabel37.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel37.setText("Nivel");

        JTPEstetica4.setBackground(new java.awt.Color(255, 204, 51));
        JTPEstetica4.setColumns(20);
        JTPEstetica4.setRows(5);
        jScrollPane16.setViewportView(JTPEstetica4);

        jLabel38.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel38.setText("Nivel");

        jLabel39.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel39.setText("Nivel");

        jLabel40.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel40.setText("Nivel");

        jLabel41.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel41.setText("Nivel");

        jLabel42.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel42.setText("Nivel");

        jLabel43.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel43.setText("Nivel");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nivel Alcanzados");

        JCBBoletines1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "S", "A", "M", "B" }));
        JCBBoletines1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JCBBoletines2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "S", "A", "M", "B" }));
        JCBBoletines2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JCBBoletines3.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        JCBBoletines3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "S", "A", "M", "B" }));
        JCBBoletines3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JCBBoletines4.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        JCBBoletines4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "S", "A", "M", "B" }));
        JCBBoletines4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JCBBoletines5.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        JCBBoletines5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "S", "A", "M", "B" }));
        JCBBoletines5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JCBBoletines6.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        JCBBoletines6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "S", "A", "M", "B" }));
        JCBBoletines6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JCBBoletines7.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        JCBBoletines7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "S", "A", "M", "B" }));
        JCBBoletines7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JCBBoletines8.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        JCBBoletines8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "S", "A", "M", "B" }));
        JCBBoletines8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JCBBoletines9.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        JCBBoletines9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "S", "A", "M", "B" }));
        JCBBoletines9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel91)
                            .addComponent(jLabel90)
                            .addComponent(jLabel92)
                            .addComponent(jLabel86))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane14)
                                    .addComponent(jScrollPane15)
                                    .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel37)
                                        .addGap(18, 18, 18)
                                        .addComponent(JCBBoletines3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel38)
                                        .addGap(18, 18, 18)
                                        .addComponent(JCBBoletines4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JCBBoletines2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel88, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                    .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JCBBoletines1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5)))))
                    .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel95)
                            .addComponent(jLabel96)
                            .addComponent(jLabel97))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel43)
                                .addGap(18, 18, 18)
                                .addComponent(JCBBoletines9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel42)
                                .addGap(18, 18, 18)
                                .addComponent(JCBBoletines8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel41)
                                .addGap(18, 18, 18)
                                .addComponent(JCBBoletines7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel93)
                            .addComponent(jLabel94))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                            .addComponent(jScrollPane18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addGap(18, 18, 18)
                                .addComponent(JCBBoletines6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addGap(18, 18, 18)
                                .addComponent(JCBBoletines5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(jLabel88)
                    .addComponent(jLabel5))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel86)
                                .addGap(86, 86, 86))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel90)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel36)
                                    .addComponent(JCBBoletines2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel91)
                                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel37)
                                    .addComponent(JCBBoletines3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel38)
                                    .addComponent(JCBBoletines4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(89, 89, 89)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel39)
                                    .addComponent(JCBBoletines5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel92))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel93)
                                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel89)
                            .addComponent(JCBBoletines1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel94)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(JCBBoletines6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel95))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel97)
                                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel96))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(JCBBoletines7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(JCBBoletines8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(JCBBoletines9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73))))
        );

        jScrollPane5.setViewportView(jPanel10);

        jLabel32.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel32.setText("Nombre del Alumno");

        JTXBNombreDelAlumno.setBackground(new java.awt.Color(255, 204, 51));
        JTXBNombreDelAlumno.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel33.setText("Grado");

        JTXBGrado.setBackground(new java.awt.Color(255, 204, 51));
        JTXBGrado.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel34.setText("Numero de Boletin");

        JTXBNumeroDeBoletin.setBackground(new java.awt.Color(255, 204, 51));

        jLabel35.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jLabel35.setText("Fecha");

        JTBoletienesJardin.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        JTBoletienesJardin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cognitiva", "Nivel", "Comunicativa", "Nivel", "Actitudes y Valores", "Nivel", "Estetica", "Nivel", "Corporal", "Nivel", "Pre-Matematicas", "Nivel", "Lecto Escritura", "Nivel", "Areas Integradas", "Nivel", "Ingles", "Nivel"
            }
        ));
        jScrollPane2.setViewportView(JTBoletienesJardin);

        JBBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/guardar.png"))); // NOI18N
        JBBGuardar.setBorder(null);
        JBBGuardar.setBorderPainted(false);
        JBBGuardar.setContentAreaFilled(false);
        JBBGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBBGuardar.setFocusable(false);
        JBBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBGuardarActionPerformed(evt);
            }
        });

        JBBSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/salir.png"))); // NOI18N
        JBBSalir.setBorder(null);
        JBBSalir.setBorderPainted(false);
        JBBSalir.setContentAreaFilled(false);
        JBBSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JBBSalir.setFocusable(false);
        JBBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBSalirActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonesMenuVerdes/nuevo.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(18, 18, 18)
                                .addComponent(JTXBNombreDelAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JTXBGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel34)
                                .addGap(18, 18, 18)
                                .addComponent(JTXBNumeroDeBoletin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(JBBGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(JBBSalir))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JBBSalir)
                                .addComponent(JBBGuardar))
                            .addComponent(jButton1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(JTXBNombreDelAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(JTXBGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addComponent(JTXBNumeroDeBoletin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                .addContainerGap())
        );

        PanelDePrueba.addTab("Pre-Escolar", jPanel3);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Creacion De Boletines - Instituto Fundecar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelDePrueba, javax.swing.GroupLayout.PREFERRED_SIZE, 1233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelDePrueba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBGuardarActionPerformed
        // TODO add your handling code here:
        if (JTPCognitiva1.getText().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Por Favor Ingrese La Descripcion Del Logro - Cognitiva ","Error",JOptionPane.ERROR_MESSAGE);                      
        }
        
        else if (JCBBoletines1.getSelectedIndex() == 0)
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Seleccione El Nivel Del Logro - Cognitiva","Error",JOptionPane.ERROR_MESSAGE);                         
        }
        else if (JTPComunicativa2.getText().isEmpty())
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese La Descripcion Del Logro - Comunicativa","Error",JOptionPane.ERROR_MESSAGE);                         
        }
        else if (JCBBoletines2.getSelectedIndex() == 0)
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Seleccione El Nivel Del Logro - Comunicativa","Error",JOptionPane.ERROR_MESSAGE);                         
        }
        else if (JTPActitudes3.getText().isEmpty())
        {
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese La Descripcion Del Logro - Actitudes","Error",JOptionPane.ERROR_MESSAGE);                 
        }
        else if (JCBBoletines3.getSelectedIndex() == 0)
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Seleccione El Nivel Del Logro - Actitudes","Error",JOptionPane.ERROR_MESSAGE);                         
        }
        else if (JTPEstetica4.getText().isEmpty())
        {    
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese La Descripcion Del Logro - Estetica","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if (JCBBoletines4.getSelectedIndex() == 0)
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Seleccione El Nivel Del Logro - Estetica","Error",JOptionPane.ERROR_MESSAGE);                         
        }
        
        else if (JTPCorporal5.getText().isEmpty())
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese La Descripcion Del Logro - Corporal","Error",JOptionPane.ERROR_MESSAGE);                
        }
        else if (JCBBoletines5.getSelectedIndex() == 0)
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Seleccione El Nivel Del Logro - Corporal","Error",JOptionPane.ERROR_MESSAGE);                         
        }
        else if (JTPMatematicas6.getText().isEmpty())
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese La Descripcion Del Logro - Pre-Matematicas","Error",JOptionPane.ERROR_MESSAGE);                
        }
        else if (JCBBoletines6.getSelectedIndex() == 0)
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Seleccione El Nivel Del Logro - Pre-Matematicas","Error",JOptionPane.ERROR_MESSAGE);                         
        }
        else if (JTPLectoEscritura7.getText().isEmpty())
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese La Descripcion Del Logro - Lecto Escritura","Error",JOptionPane.ERROR_MESSAGE);                
        }
        
        else if (JCBBoletines7.getSelectedIndex() == 0)
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Seleccione El Nivel Del Logro - Lecto Escritura","Error",JOptionPane.ERROR_MESSAGE);                         
        }
        else if (JTPAreasIntegradas8.getText().isEmpty())
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese La Descripcion Del Logro - Areas Integradas","Error",JOptionPane.ERROR_MESSAGE);                
        }
        else if (JCBBoletines8.getSelectedIndex() == 0)
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Seleccione El Nivel Del Logro - Areas Integradas","Error",JOptionPane.ERROR_MESSAGE);                         
        }
        else if (JTPIngles9.getText().isEmpty())
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Ingrese La Descripcion Del Logro - Ingles","Error",JOptionPane.ERROR_MESSAGE);                
        }
        else if (JCBBoletines9.getSelectedIndex() == 0)
        {
            
                JOptionPane.showMessageDialog(null, "Por Favor Seleccione El Nivel Del Logro - Ingles","Error",JOptionPane.ERROR_MESSAGE);                         
        }
    
        else 
        {
        if (JOptionPane.showConfirmDialog(null,"Desea Registrar El Boletin","Confirmar",1)==0){
           Boletines.DatosDeIngreso leer = new Boletines.DatosDeIngreso();
            
           
           
            leer.setCognitiva(JTPCognitiva1.getText());
            leer.setNivel1(JCBBoletines1.getSelectedItem());
            leer.setComunicativa(JTPComunicativa2.getText());
            leer.setNivel2(JCBBoletines2.getSelectedItem());
            leer.setActitudes(JTPActitudes3.getText());
            leer.setNivel3(JCBBoletines3.getSelectedItem());
            leer.setEstetica(JTPEstetica4.getText());
            leer.setNivel4(JCBBoletines4.getSelectedItem());
            leer.setCorporal(JTPCorporal5.getText());
            leer.setNivel5(JCBBoletines5.getSelectedItem());
            leer.setMatematicas(JTPMatematicas6.getText());
            leer.setNivel6(JCBBoletines6.getSelectedItem());
            leer.setLectoEscritura(JTPLectoEscritura7.getText());
            leer.setNivel7(JCBBoletines7.getSelectedItem());
            leer.setAreasIntegradas(JTPAreasIntegradas8.getText());
            leer.setNivel8(JCBBoletines8.getSelectedItem());
            leer.setIngles(JTPIngles9.getText());
            leer.setNivel9(JCBBoletines9.getSelectedItem());
            
            
            this.guardar();
            
            //INGRESAR DATOS A TABLA
            DefaultTableModel modelo = (DefaultTableModel) JTBoletienesJardin.getModel();


            Object [] Fila=new Object[18];

            Fila[0]=JTPCognitiva1.getText();
            Fila[1]=JCBBoletines1.getSelectedItem();
            Fila[2]=JTPComunicativa2.getText();
            Fila[3]=JCBBoletines2.getSelectedItem();
            Fila[4]=JTPActitudes3.getText();
            Fila[5]=JCBBoletines3.getSelectedItem();
            Fila[6]=JTPEstetica4.getText();
            Fila[7]=JCBBoletines4.getSelectedItem();
            Fila[8]=JTPCorporal5.getText();
            Fila[9]=JCBBoletines5.getSelectedItem();
            Fila[10]=JTPMatematicas6.getText();
            Fila[11]=JCBBoletines6.getSelectedItem();
            Fila[12]=JTPLectoEscritura7.getText();
            Fila[13]=JCBBoletines7.getSelectedItem();
            Fila[14]=JTPAreasIntegradas8.getText();
            Fila[15]=JCBBoletines8.getSelectedItem();
            Fila[16]=JTPIngles9.getText();
            Fila[17]=JCBBoletines9.getSelectedItem();
            
            

                modelo.addRow(Fila);


                JTBoletienesJardin.setModel(modelo);
        
                
                
        }
        }
    }//GEN-LAST:event_JBBGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.habilitar();
        this.Limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JBBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_JBBSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBBGuardar;
    private javax.swing.JButton JBBSalir;
    private javax.swing.JComboBox<String> JCBBoletines1;
    private javax.swing.JComboBox<String> JCBBoletines2;
    private javax.swing.JComboBox<String> JCBBoletines3;
    private javax.swing.JComboBox<String> JCBBoletines4;
    private javax.swing.JComboBox<String> JCBBoletines5;
    private javax.swing.JComboBox<String> JCBBoletines6;
    private javax.swing.JComboBox<String> JCBBoletines7;
    private javax.swing.JComboBox<String> JCBBoletines8;
    private javax.swing.JComboBox<String> JCBBoletines9;
    private com.toedter.calendar.JDateChooser JDCFecha;
    private javax.swing.JTable JTBoletienesJardin;
    private javax.swing.JTextPane JTPActitudes3;
    private javax.swing.JTextPane JTPAreasIntegradas8;
    private javax.swing.JTextPane JTPCognitiva1;
    private javax.swing.JTextPane JTPComunicativa2;
    private javax.swing.JTextPane JTPCorporal5;
    private javax.swing.JTextArea JTPEstetica4;
    private javax.swing.JTextPane JTPIngles9;
    private javax.swing.JTextPane JTPLectoEscritura7;
    private javax.swing.JTextPane JTPMatematicas6;
    private javax.swing.JTextField JTXBGrado;
    private javax.swing.JTextField JTXBNombreDelAlumno;
    private javax.swing.JTextField JTXBNumeroDeBoletin;
    private javax.swing.JTabbedPane PanelDePrueba;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables

    private static class DatosDeIngreso {

        public DatosDeIngreso() {
        }

        private void setCognitiva(String text) {
            
        }

        private void setComunicativa(String text) {
            
        }

        private void setActitudes(String text) {
            
        }

        private void setEstetica(String text) {
            
        }

        private void setCorporal(String text) {
            
        }

        private void setMatematicas(String text) {
            
        }

        private void setLectoEscritura(String text) {
            
        }

        private void setAreasIntegradas(String text) {
            
        }

        private void setIngles(String text) {
            
        }

        private void setNivel1(Object selectedItem) {
            
        }

        private void setNivel2(Object selectedItem) {
            
        }

        private void setNivel3(Object selectedItem) {
            
        }

        private void setNivel4(Object selectedItem) {
            
        }

        private void setNivel5(Object selectedItem) {
            
        }

        private void setNivel6(Object selectedItem) {
            
        }

        private void setNivel7(Object selectedItem) {
            
        }

        private void setNivel8(Object selectedItem) {
            
        }

        private void setNivel9(Object selectedItem) {
            
        }
    }
}
