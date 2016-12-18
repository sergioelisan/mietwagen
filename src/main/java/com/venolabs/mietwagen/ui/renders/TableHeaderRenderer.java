package com.venolabs.mietwagen.ui.renders;

/*
 * @(#)TableHeaderRenderer.java	18/10/2013 - 15:28:04
 *
 * Copyright 2013 USTO.RE
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;


/**
 * @author <a href="mailto:sergiolisan@gmail.com">Sergio Lisan</a>
 */
public class TableHeaderRenderer extends JLabel implements TableCellRenderer {
	 
    private static final long serialVersionUID = -5471868823482199440L;

	public TableHeaderRenderer() {
        setFont(new Font("SansSerif", Font.PLAIN, 12));
        setOpaque(true);
        setBackground(new Color(250,200,1));
        setForeground(Color.WHITE);
        setSize(new Dimension(getSize().width, getSize().height + 5 ) );
        
        Border matte = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color (255,249,0));
        Border compound = new CompoundBorder(matte, new EmptyBorder(new Insets(0, 6, 0, 6) ) );        
        setBorder(compound);
    }
     
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }
 
}
