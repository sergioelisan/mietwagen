package com.venolabs.mietwagen.ui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComponent;

/**
 *
 * @author sergio
 */
public class LoginScreen extends javax.swing.JPanel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final LoginScreen INSTANCE = new LoginScreen();

    private LoginScreen() {
        initComponents();
        setMinimumSize(new Dimension(1024, 600));
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbEnter = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 245));
        setPreferredSize(new java.awt.Dimension(1024, 600));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(950, 450));
        add(jLabel1);

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 45));

        lbEnter.setBackground(new java.awt.Color(255, 241, 145));
        lbEnter.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lbEnter.setForeground(java.awt.Color.darkGray);
        lbEnter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEnter.setText("Entrar");
        lbEnter.setOpaque(true);
        lbEnter.setPreferredSize(new java.awt.Dimension(200, 35));
        lbEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEnterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbEnterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbEnterMouseExited(evt);
            }
        });
        jPanel1.add(lbEnter);

        add(jPanel1);
    }

    private void lbEnterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEnterMouseClicked
        MainFrame.INSTANCE.login();
    }//GEN-LAST:event_lbEnterMouseClicked

    private void lbEnterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEnterMouseEntered
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(255,251,185));
    }//GEN-LAST:event_lbEnterMouseEntered

    private void lbEnterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEnterMouseExited
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(250,221,85));
    }//GEN-LAST:event_lbEnterMouseExited


    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbEnter;
    
}
