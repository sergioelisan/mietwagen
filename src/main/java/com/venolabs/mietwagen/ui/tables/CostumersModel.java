package com.venolabs.mietwagen.ui.tables;

import java.util.ArrayList;
import java.util.List;

import com.venolabs.mietwagen.Facade;
import com.venolabs.mietwagen.model.Client;

@SuppressWarnings("serial")
public class CostumersModel extends TableModel {

	private List<Client> clients = new ArrayList<>();

	public CostumersModel() {
		super(new String[] { "ID", "NAME", "CPF ID" }, new Class<?>[] { Long.class, String.class, String.class });
		Facade.registerClientsObserver(this);
	}

	@Override
	public void update(Object... args) {
		clients = Facade.listClients();
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return clients.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		if (col == 0) {
			return new Long(clients.get(row).getId());
		} else if (col == 1) {
			return clients.get(row).getName();
		} else {
			return clients.get(row).getCpf();
		}
	}

}
