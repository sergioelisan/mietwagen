package com.venolabs.mietwagen.ui.tables;

import com.venolabs.mietwagen.Facade;

@SuppressWarnings("serial")
public class OpenRentsModel extends RentHistoryModel {

	@Override
	public void update(Object... args) {
		rents = Facade.getOpenRents();
		fireTableDataChanged();
	}

}
