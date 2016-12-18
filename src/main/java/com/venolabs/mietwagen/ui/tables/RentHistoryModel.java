package com.venolabs.mietwagen.ui.tables;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import com.venolabs.mietwagen.Facade;
import com.venolabs.mietwagen.model.Car;
import com.venolabs.mietwagen.model.Rent;

@SuppressWarnings("serial")
public class RentHistoryModel extends TableModel {

	protected List<Rent> rents = new ArrayList<>();

	public RentHistoryModel() {
		super(new String[] { "ID", "CPF", "CAR", "PERIOD", "PAID" }, new Class<?>[] { Long.class, String.class,
				String.class, String.class, String.class });
		Facade.registerRentsObserver(this);
	}

	@Override
	public void update(Object... args) {
		rents = Facade.listRents();
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return rents.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		if (col == 0) {
			return new Long(rents.get(row).getId());
		} else if (col == 1) {
			return rents.get(row).getClient().getCpf();
		} else if (col == 2) {
			Car car = rents.get(row).getCar();
			return car.getModel() + " (" + car.getPlate() + ")";
		} else if (col == 3) {
			DateFormat sdf = DateFormat.getDateInstance(DateFormat.SHORT);
			return sdf.format(rents.get(row).getStart()) + " to " + sdf.format(rents.get(row).getDelivery());
		} else {
			return rents.get(row).isPaid() ? "paid" : "not paid";
		}
	}
	
}
