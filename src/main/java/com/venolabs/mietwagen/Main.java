package com.venolabs.mietwagen;

import java.awt.EventQueue;

import com.venolabs.mietwagen.bo.BOFactory;
import com.venolabs.mietwagen.ui.Splash;

public class Main {

	public static void main(String[] args) {
		// splash
		EventQueue.invokeLater(() -> Splash.INSTANCE.setVisible(true) );
				
		// construct
		Controller c = new Controller();
		c.init();

		// init database
		BOFactory.clientBO().notifyObservers();
		BOFactory.carBO().notifyObservers();
		BOFactory.rentBO().notifyObservers();
				
		EventQueue.invokeLater(() -> Splash.INSTANCE.dispose() );
		
		// show gui
		c.showGUI();		
	}
}
