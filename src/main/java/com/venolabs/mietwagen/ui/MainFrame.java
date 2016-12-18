package com.venolabs.mietwagen.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author sergio
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static final MainFrame INSTANCE = new MainFrame();

    public static final Dimension SCREENS_DIMENSION = new Dimension(1024, 550);

    public static final String CLIENT_SCREEN = "client screen";
    public static final String CAR_SCREEN = "car screen";
    public static final String RENT_A_CAR_SCREEN = "rent screen";
    public static final String RENTS_SCREEN = "rents screen";
    public static final String RETURN_SCREEN = "renturn screen";

    private static final String HOME_SCREEN = "home screen";
    private static final String LOGIN_SCREEN = "login screen";

    private MainFrame() {
        super("MietWagen 1.0");
    }

    public void createGUI() {
        getContentPane().add(LoginScreen.INSTANCE, BorderLayout.CENTER);
        pack();

        setIconImage(new ImageIcon(getClass()
                .getResource("/images/icon.png")).getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void login() {
        getContentPane().removeAll();
        initComponents();
        home();
    }

    public void home() {
        show(HOME_SCREEN);
    }

    public void show(String screen) {
        pnContent.removeAll();
        switch (screen) {
            case CLIENT_SCREEN:
                pnContent.add(CostumerRegistrationScreen.INSTANCE);
                break;
            case CAR_SCREEN:
                pnContent.add(CarRegistrationScreen.INSTANCE);
                break;
            case RENT_A_CAR_SCREEN:
                pnContent.add(RentACarScreen.INSTANCE);
                break;
            case RETURN_SCREEN:
                pnContent.add(ReturnACarScreen.INSTANCE);
                break;
            case RENTS_SCREEN:
                pnContent.add(RentsScreen.INSTANCE);
                break;
            case HOME_SCREEN:
                pnContent.add(HomeScreen.INSTANCE);
                break;
            case LOGIN_SCREEN:
                pnContent.add(LoginScreen.INSTANCE);
                break;

            default:
                setContentPane(HomeScreen.INSTANCE);
                break;
        }

        repaint();
        revalidate();
    }

    private void initComponents() {

        bar1 = new com.venolabs.mietwagen.ui.component.Bar();
        pnContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(bar1, java.awt.BorderLayout.PAGE_START);

        pnContent.setBackground(new java.awt.Color(255, 255, 245));
        pnContent.setPreferredSize(new java.awt.Dimension(1024, 550));
        getContentPane().add(pnContent, java.awt.BorderLayout.CENTER);

        pack();
    }

    private com.venolabs.mietwagen.ui.component.Bar bar1;
    private javax.swing.JPanel pnContent;

}
