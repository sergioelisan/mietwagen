package com.venolabs.mietwagen;

import java.awt.EventQueue;

import com.venolabs.mietwagen.ui.MainFrame;

public class Controller {
	
	public void init() {
		EventQueue.invokeLater(() -> {
			MainFrame.INSTANCE.createGUI();
		});
	}
	
	public void showGUI() {
		EventQueue.invokeLater(() -> {
			MainFrame.INSTANCE.setVisible(true);
		});
	}

}
