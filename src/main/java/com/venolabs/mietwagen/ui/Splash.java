package com.venolabs.mietwagen.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JWindow;

import com.venolabs.mietwagen.util.UIU;

@SuppressWarnings("serial")
public class Splash extends JWindow {

	private final Dimension DIM = new Dimension(320, 406);
	
	public static final Splash INSTANCE = new Splash();
	
	private Splash() {
		setContentPane(new JPanel() {
			public void paintComponent(Graphics g) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, DIM.width, DIM.height);
				g.drawImage(UIU.getImage("logo.png").getImage(), 11, 11, null);
			}
		});
		setMinimumSize(DIM);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
	}
	
}
