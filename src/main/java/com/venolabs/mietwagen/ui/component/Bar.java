package com.venolabs.mietwagen.ui.component;

import com.venolabs.mietwagen.ui.MainFrame;
import com.venolabs.mietwagen.ui.handlers.MouseHandler;

/**
 *
 * @author sergio
 */
public class Bar extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Bar() {
        initComponents();

        lbHome.addMouseListener(new MouseHandler() );
        lbCarManagement.addMouseListener(new MouseHandler() );
        lbClientManagement.addMouseListener(new MouseHandler() );
        lbRentACar.addMouseListener(new MouseHandler() );
        lbReturn.addMouseListener(new MouseHandler() );
        lbRents.addMouseListener(new MouseHandler() );
    }

    private void initComponents() {

        lbHome = new javax.swing.JLabel();
        lbRentACar = new javax.swing.JLabel();
        lbReturn = new javax.swing.JLabel();
        lbRents = new javax.swing.JLabel();
        lbClientManagement = new javax.swing.JLabel();
        lbCarManagement = new javax.swing.JLabel();

        setBackground(new java.awt.Color(250, 200, 1));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        lbHome.setBackground(new java.awt.Color(250, 200, 1));
        lbHome.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbHome.setForeground(java.awt.Color.white);
        lbHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHome.setText("HOME");
        lbHome.setOpaque(true);
        lbHome.setPreferredSize(new java.awt.Dimension(160, 50));
        lbHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHomemouseClicked(evt);
            }
        });
        add(lbHome);

        lbRentACar.setBackground(new java.awt.Color(250, 200, 1));
        lbRentACar.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbRentACar.setForeground(java.awt.Color.white);
        lbRentACar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRentACar.setText("RENT A CAR");
        lbRentACar.setOpaque(true);
        lbRentACar.setPreferredSize(new java.awt.Dimension(160, 50));
        lbRentACar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRentACarmouseClicked(evt);
            }
        });
        add(lbRentACar);

        lbReturn.setBackground(new java.awt.Color(250, 200, 1));
        lbReturn.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbReturn.setForeground(java.awt.Color.white);
        lbReturn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReturn.setText("RETURN CAR");
        lbReturn.setOpaque(true);
        lbReturn.setPreferredSize(new java.awt.Dimension(160, 50));
        lbReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbReturnmouseClicked(evt);
            }
        });
        add(lbReturn);

        lbRents.setBackground(new java.awt.Color(250, 200, 1));
        lbRents.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbRents.setForeground(java.awt.Color.white);
        lbRents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRents.setText("RENTS");
        lbRents.setOpaque(true);
        lbRents.setPreferredSize(new java.awt.Dimension(160, 50));
        lbRents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRentsmouseClicked(evt);
            }
        });
        add(lbRents);

        lbClientManagement.setBackground(new java.awt.Color(250, 200, 1));
        lbClientManagement.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbClientManagement.setForeground(java.awt.Color.white);
        lbClientManagement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbClientManagement.setText("CLIENTS");
        lbClientManagement.setOpaque(true);
        lbClientManagement.setPreferredSize(new java.awt.Dimension(160, 50));
        lbClientManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbClientManagementmouseClicked(evt);
            }
        });
        add(lbClientManagement);

        lbCarManagement.setBackground(new java.awt.Color(250, 200, 1));
        lbCarManagement.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbCarManagement.setForeground(java.awt.Color.white);
        lbCarManagement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCarManagement.setText("CARS");
        lbCarManagement.setOpaque(true);
        lbCarManagement.setPreferredSize(new java.awt.Dimension(160, 50));
        lbCarManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCarManagementmouseClicked(evt);
            }
        });
        add(lbCarManagement);
    }

    private void lbHomemouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHomemouseClicked
        MainFrame.INSTANCE.home();
    }//GEN-LAST:event_lbHomemouseClicked

    private void lbRentACarmouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRentACarmouseClicked
        MainFrame.INSTANCE.show(MainFrame.RENT_A_CAR_SCREEN);
    }//GEN-LAST:event_lbRentACarmouseClicked

    private void lbRentsmouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRentsmouseClicked
        MainFrame.INSTANCE.show(MainFrame.RENTS_SCREEN);
    }//GEN-LAST:event_lbRentsmouseClicked

    private void lbClientManagementmouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbClientManagementmouseClicked
        MainFrame.INSTANCE.show(MainFrame.CLIENT_SCREEN);
    }//GEN-LAST:event_lbClientManagementmouseClicked

    private void lbCarManagementmouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCarManagementmouseClicked
        MainFrame.INSTANCE.show(MainFrame.CAR_SCREEN);
    }//GEN-LAST:event_lbCarManagementmouseClicked

    private void lbReturnmouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbReturnmouseClicked
        MainFrame.INSTANCE.show(MainFrame.RETURN_SCREEN);
    }//GEN-LAST:event_lbReturnmouseClicked


    
    private javax.swing.JLabel lbCarManagement;
    private javax.swing.JLabel lbClientManagement;
    private javax.swing.JLabel lbHome;
    private javax.swing.JLabel lbRentACar;
    private javax.swing.JLabel lbRents;
    private javax.swing.JLabel lbReturn;
    
}
