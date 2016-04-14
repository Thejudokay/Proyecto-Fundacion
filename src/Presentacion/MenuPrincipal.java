/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Formularios.*;
import BaseDeDatos.FondoMenuPrincipal;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Dios Es Amor & Vida
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public MenuPrincipal() {
        initComponents();
        
        // Inicio De Resolucion de pantalla
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
       
        this.setBounds((ancho / 2) - (this.getWidth() / 2), (alto / 2) - (this.getHeight() / 2), 500, 500);
        
        // Fin De Resolucion de pantalla
        
        //Jalamos la conexion de la base de datos
        BaseDeDatos.ConexionGeneralDeBD.getConexion();
        //Fin Jalamos la conexion de la base de datos
        
        //Inicio Fondo
        Escritorio.setBorder(new FondoMenuPrincipal());
        this.setExtendedState(MenuPrincipal.MAXIMIZED_BOTH);
        
        //Final del fondo
        
        try {
            MenuPrincipal.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        //Inicio Del Codigo Para El Icono De Programa
        this.setTitle("Sistema General Instituto Fundecar - Menu Principal");
       Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) d.getWidth() , (int) d.getHeight());
        
        
        this.setLocationRelativeTo(null);
        this.setResizable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        JMITrabajador = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1029, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Archivo-32x32.png"))); // NOI18N
        jMenu1.setText("Arhivo");

        jMenuItem19.setText("Salir Del Sistema");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem19);

        jMenuItem16.setText("Cerrar Sesion");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem16);

        jMenuBar1.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ingresar-32x32.png"))); // NOI18N
        jMenu3.setText("Ingresar");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Alumno-32x32.png"))); // NOI18N
        jMenuItem1.setText("Alumno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Asignatura-32x32.png"))); // NOI18N
        jMenuItem3.setText("Asignatura");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boletines-32x32.png"))); // NOI18N
        jMenuItem2.setText("Boletin");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NivelDeNotas-32x32.png"))); // NOI18N
        jMenuItem9.setText("Niveles De Notas");
        jMenu3.add(jMenuItem9);

        JMITrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Profesor-32x32.png"))); // NOI18N
        JMITrabajador.setText("Trabajador");
        JMITrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMITrabajadorActionPerformed(evt);
            }
        });
        jMenu3.add(JMITrabajador);

        jMenuBar1.add(jMenu3);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Consultar-32x32_1.png"))); // NOI18N
        jMenu5.setText("Consultas");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Alumno-32x32.png"))); // NOI18N
        jMenuItem4.setText("Alumno");
        jMenu5.add(jMenuItem4);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Asignatura-32x32.png"))); // NOI18N
        jMenuItem7.setText("Asignatura");
        jMenu5.add(jMenuItem7);

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Boletines-32x32.png"))); // NOI18N
        jMenuItem14.setText("Boletines");
        jMenu5.add(jMenuItem14);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Grados - Cursos-32x32.png"))); // NOI18N
        jMenuItem8.setText("Grados - Cursos");
        jMenu5.add(jMenuItem8);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Profesor-32x32.png"))); // NOI18N
        jMenuItem5.setText("Profesor");
        jMenu5.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IngresosPorFecha-32x32.png"))); // NOI18N
        jMenuItem6.setText("Ingresos Por Fecha");
        jMenu5.add(jMenuItem6);

        jMenuBar1.add(jMenu5);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mantenimiento-32x32.png"))); // NOI18N
        jMenu4.setText("Mantenimiento");

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/NuevoUsuario-32x32.png"))); // NOI18N
        jMenuItem10.setText("Agragar Usuarios");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);
        jMenu4.add(jSeparator1);

        jMenuItem13.setText("Consultar Usuarios");
        jMenu4.add(jMenuItem13);

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificacion De Usuarios-32x32.png"))); // NOI18N
        jMenuItem15.setText("Modificacion De Usuarios");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem15);

        jMenuBar1.add(jMenu4);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reportes-32x32.png"))); // NOI18N
        jMenu7.setText("Reportes");
        jMenuBar1.add(jMenu7);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Herramientas-32x32.png"))); // NOI18N
        jMenu8.setText("Herramientas");

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CopiaDeSeguridad-32x32.png"))); // NOI18N
        jMenu9.setText("Copia De Seguridad");

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Realizacion-32x32.png"))); // NOI18N
        jMenuItem11.setText("Creacion");
        jMenu9.add(jMenuItem11);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Restauracion-32x32.png"))); // NOI18N
        jMenuItem12.setText("Restauracion");
        jMenu9.add(jMenuItem12);

        jMenu8.add(jMenu9);

        jMenuBar1.add(jMenu8);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Acerca De-32x32_1.png"))); // NOI18N
        jMenu6.setText("Acerca De");

        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Acerca De-32x32.png"))); // NOI18N
        jMenuItem17.setText("Informacion");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem17);

        jMenuBar1.add(jMenu6);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Prueba-32x32.png"))); // NOI18N
        jMenu2.setText("jMenu2");

        jMenuItem18.setText("jMenuItem18");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem18);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        IngresoDeAlumnos ingresodealumnos =new IngresoDeAlumnos();
        Escritorio.add(ingresodealumnos);
        ingresodealumnos.show();

        Dimension desktopSize = Escritorio.getSize();
        Dimension FrameSize = ingresodealumnos.getSize();
        ingresodealumnos.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        ingresodealumnos.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        NuevaMaterias nuevamteria =new NuevaMaterias();
        Escritorio.add(nuevamteria);
        nuevamteria.show();

        Dimension desktopSize = Escritorio.getSize();
        Dimension FrameSize = nuevamteria.getSize();
        nuevamteria.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        nuevamteria.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void JMITrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMITrabajadorActionPerformed
        
        IngresoDeTrabajadores ingresodeprofesores =new IngresoDeTrabajadores();
        Escritorio.add(ingresodeprofesores);
        ingresodeprofesores.show();

        Dimension desktopSize = Escritorio.getSize();
        Dimension FrameSize = ingresodeprofesores.getSize();
        ingresodeprofesores.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        ingresodeprofesores.show();
    }//GEN-LAST:event_JMITrabajadorActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        Usuarios usuarios =new Usuarios();
        Escritorio.add(usuarios);
        usuarios.show();

        Dimension desktopSize = Escritorio.getSize();
        Dimension FrameSize = usuarios.getSize();
        usuarios.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        usuarios.show();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        Prueba Acercade =new Prueba();
        Escritorio.add(Acercade);
        Acercade.show();

        Dimension desktopSize = Escritorio.getSize();
        Dimension FrameSize = Acercade.getSize();
        Acercade.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        Acercade.show();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
        Prueba Acercade =new Prueba();
        Escritorio.add(Acercade);
        Acercade.show();

        Dimension desktopSize = Escritorio.getSize();
        Dimension FrameSize = Acercade.getSize();
        Acercade.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        Acercade.show();
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea Salir Del Sistema?",
                "Salida Del Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Boletines boletines =new Boletines();
        Escritorio.add(boletines);
        boletines.show();

        Dimension desktopSize = Escritorio.getSize();
        Dimension FrameSize = boletines.getSize();
        boletines.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        boletines.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        
        LoginFundecar acs=new LoginFundecar();
         acs.show(true);
         this.hide();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuItem JMITrabajador;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
