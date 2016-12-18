package com.venolabs.mietwagen.ui.handlers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

/**
 *
 * @author sergio
 */
public class MouseHandler implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseExited(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JComponent comp = (JComponent) e.getSource();
        comp.setBackground(new Color(255, 221, 85));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JComponent comp = (JComponent) e.getSource();
        comp.setBackground(new Color(250, 200, 1));
    }

}
