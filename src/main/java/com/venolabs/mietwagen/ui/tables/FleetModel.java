package com.venolabs.mietwagen.ui.tables;

import java.util.ArrayList;
import java.util.List;

import com.venolabs.mietwagen.Facade;
import com.venolabs.mietwagen.model.Car;

@SuppressWarnings("serial")
public class FleetModel extends TableModel {

	private List<Car> cars = new ArrayList<>();
	
	public FleetModel() {
		super(new String[] { "ID", "PLATE", "MODEL" }, new Class<?>[] { Long.class, String.class, String.class });
		Facade.registerCarsObserver(this);
	}
	
	@Override
	public void update(Object... args) {
		cars = Facade.listCars();		
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return cars.size();
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		if (col == 0) {
			return new Long(cars.get(row).getId() );
		} else if (col == 1) {
			return cars.get(row).getPlate();
		} else {
			return cars.get(row).getModel();
		} 
	}

}
