package com.venolabs.mietwagen.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.text.JTextComponent;

/**
 * UI Utils
 * @author sergio
 *
 */
public class UIU {

	public static final String IMG_FOLDER = "/images/";
	
	public static ImageIcon getImage(String fileName) {
		return new ImageIcon(UIU.class.getResource(IMG_FOLDER + fileName) );
	}
	
	public static void setPlaceholder(JTextComponent txtcomponent, String placeholder) {
        txtcomponent.setText(placeholder);
        txtcomponent.setFont(txtcomponent.getFont().deriveFont(Font.ITALIC));
        txtcomponent.setForeground(new Color(140, 140, 140));
    }

    public static void removePlaceholder(JTextComponent txtcomponent) {
        txtcomponent.setText("");
        txtcomponent.setFont(txtcomponent.getFont().deriveFont(Font.PLAIN));
        txtcomponent.setForeground(Color.BLACK);
    }

    public static boolean setOKStatus(JTextComponent status, String message) {
        status.setText(message);
        status.setForeground(new Color(55, 113, 200));
        
        return true;
    }

    public static boolean setRefusedStatus(JTextComponent status, String message) {
        status.setText(message);
        status.setForeground(Color.RED);
        
        return false;
    }
}
