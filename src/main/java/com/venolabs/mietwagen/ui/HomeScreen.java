package com.venolabs.mietwagen.ui;

/**
 *
 * @author sergio
 */
public class HomeScreen extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final HomeScreen INSTANCE = new HomeScreen();

    private HomeScreen() {
        initComponents();
        createGUI();
    }

    private void createGUI() {
        setMinimumSize(MainFrame.SCREENS_DIMENSION);
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 245));
        setPreferredSize(new java.awt.Dimension(1024, 550));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/portrait_logo.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(900, 120));
        add(jLabel1);
    }


    
    private javax.swing.JLabel jLabel1;
    
}
