package ventana;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author MI PC
 */
public class Ventana1 extends javax.swing.JFrame {

    public Ventana1() {
        initComponents();
        setTitle("Ventana1");
        //cerrar ventana
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrarMascotas = new javax.swing.JButton();
        btnRegistrarConsulta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnRegistrarPropietarios = new javax.swing.JButton();
        btnAgendamientoCitas = new javax.swing.JButton();
        btnRegistrarVeterinarios = new javax.swing.JButton();
        btnRegistrarVacunas = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItemVerHistorial = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemVerServicios = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemCerrar = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "......Sistema de Gestion de Clinica Veterinaria.........", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Gabriola", 0, 32), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("¡Bienvenido Querido Usuario!");

        btnRegistrarMascotas.setBackground(new java.awt.Color(51, 255, 102));
        btnRegistrarMascotas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnRegistrarMascotas.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrarMascotas.setText("Registro de Mascotas");
        btnRegistrarMascotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarMascotasActionPerformed(evt);
            }
        });

        btnRegistrarConsulta.setBackground(new java.awt.Color(0, 204, 102));
        btnRegistrarConsulta.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnRegistrarConsulta.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrarConsulta.setText("Registro de Consultas");
        btnRegistrarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarConsultaActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("¿Que desea hacer hoy?");

        btnRegistrarPropietarios.setBackground(new java.awt.Color(51, 255, 102));
        btnRegistrarPropietarios.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnRegistrarPropietarios.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrarPropietarios.setText("Registro de Propietarios");
        btnRegistrarPropietarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPropietariosActionPerformed(evt);
            }
        });

        btnAgendamientoCitas.setBackground(new java.awt.Color(0, 204, 102));
        btnAgendamientoCitas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnAgendamientoCitas.setForeground(new java.awt.Color(0, 0, 0));
        btnAgendamientoCitas.setText("Agendamiento de Citas");
        btnAgendamientoCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendamientoCitasActionPerformed(evt);
            }
        });

        btnRegistrarVeterinarios.setBackground(new java.awt.Color(51, 255, 102));
        btnRegistrarVeterinarios.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnRegistrarVeterinarios.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrarVeterinarios.setText("Registro de Veterinarios");
        btnRegistrarVeterinarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVeterinariosActionPerformed(evt);
            }
        });

        btnRegistrarVacunas.setBackground(new java.awt.Color(0, 204, 102));
        btnRegistrarVacunas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnRegistrarVacunas.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrarVacunas.setText("Registro de Vacunas");
        btnRegistrarVacunas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVacunasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrarMascotas)
                            .addComponent(btnRegistrarPropietarios)
                            .addComponent(btnRegistrarVeterinarios))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrarVacunas)
                            .addComponent(btnAgendamientoCitas)
                            .addComponent(btnRegistrarConsulta))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarMascotas)
                    .addComponent(btnRegistrarConsulta))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarVacunas)
                    .addComponent(btnRegistrarVeterinarios))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarPropietarios)
                    .addComponent(btnAgendamientoCitas))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 204, 102));

        jMenu3.setBackground(new java.awt.Color(0, 153, 102));
        jMenu3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12))); // NOI18N
        jMenu3.setForeground(new java.awt.Color(0, 0, 0));
        jMenu3.setText("Menu");

        jMenu6.setText("Historial");

        jMenuItemVerHistorial.setText("Ir a Historial");
        jMenuItemVerHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerHistorialActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemVerHistorial);

        jMenu3.add(jMenu6);

        jMenu4.setText("Servicios");

        jMenuItemVerServicios.setText("ver servicios");
        jMenuItemVerServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerServiciosActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemVerServicios);

        jMenu3.add(jMenu4);

        jMenu5.setBackground(new java.awt.Color(0, 204, 153));
        jMenu5.setForeground(new java.awt.Color(0, 0, 0));
        jMenu5.setText("Salir");

        jMenuItemCerrar.setBackground(new java.awt.Color(0, 255, 153));
        jMenuItemCerrar.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jMenuItemCerrar.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItemCerrar.setText("Cerrar");
        jMenuItemCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCerrarActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemCerrar);

        jMenu3.add(jMenu5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarMascotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarMascotasActionPerformed
        VentanaMascota ventaMas = new VentanaMascota();
        ventaMas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarMascotasActionPerformed

    private void btnRegistrarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarConsultaActionPerformed
        VentanaConsulta ventaConsul = new VentanaConsulta();
        ventaConsul.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarConsultaActionPerformed

    private void btnRegistrarPropietariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPropietariosActionPerformed
        VentanaPropietario vPropi = new VentanaPropietario();
        vPropi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarPropietariosActionPerformed

    private void btnAgendamientoCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendamientoCitasActionPerformed
        VentanaAgendamientoDeCita vac = new VentanaAgendamientoDeCita();
        vac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgendamientoCitasActionPerformed

    private void btnRegistrarVeterinariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVeterinariosActionPerformed
        VentanaVeterinario vVe = new VentanaVeterinario();
        vVe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarVeterinariosActionPerformed

    private void btnRegistrarVacunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVacunasActionPerformed
        VentanaVacuna vVa = new VentanaVacuna();
        vVa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarVacunasActionPerformed

    private void jMenuItemCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCerrarActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Deseas salir de la aplicación?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItemCerrarActionPerformed

    private void jMenuItemVerServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerServiciosActionPerformed
        VentanaServicio ventaServi = new VentanaServicio();
        ventaServi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemVerServiciosActionPerformed

    private void jMenuItemVerHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerHistorialActionPerformed
        VentanaHistorial ventaHisto = new VentanaHistorial();
        ventaHisto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemVerHistorialActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendamientoCitas;
    private javax.swing.JButton btnRegistrarConsulta;
    private javax.swing.JButton btnRegistrarMascotas;
    private javax.swing.JButton btnRegistrarPropietarios;
    private javax.swing.JButton btnRegistrarVacunas;
    private javax.swing.JButton btnRegistrarVeterinarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemCerrar;
    private javax.swing.JMenuItem jMenuItemVerHistorial;
    private javax.swing.JMenuItem jMenuItemVerServicios;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
