package com.venolabs.mietwagen.ui.tables;

import javax.swing.table.AbstractTableModel;

import com.venosyd.patterns.Observer;

@SuppressWarnings("serial")
public abstract class TableModel extends AbstractTableModel implements Observer {

	private String[] columnNames;
	
	private Class<?>[] columnClasses;
	
	TableModel(String[] columnNames, Class<?>[] columnClasses) {
		this.columnClasses = columnClasses;
		this.columnNames = columnNames;
	}
	
	@Override
	public int getColumnCount() {
		return columnClasses.length;		
	}

	@Override
	public String getColumnName(int column) {
		return column < columnClasses.length ? columnNames[column] : "";
	}
	
}
