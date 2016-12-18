package com.venolabs.mietwagen.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.text.JTextComponent;

import com.venolabs.mietwagen.ui.renders.TableHeaderRenderer;
import com.venolabs.mietwagen.ui.tables.OpenRentsModel;
import com.venolabs.mietwagen.ui.tables.RentHistoryModel;

/**
 *
 * @author sergio
 */
public class RentsScreen extends javax.swing.JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static final RentsScreen INSTANCE = new RentsScreen();

    private static final String TXT_SEARCH_REPLACEMENT = "search";
    private static final String TXT_SEARCH_WARNING_REPLACEMENT = "not a search!";

    private String client = "";

    private RentsScreen() {
        initComponents();
        createGUI();
    }

    private void createGUI() {
        setMinimumSize(MainFrame.SCREENS_DIMENSION);

        tbRentHistory.setModel(new RentHistoryModel());
        tbRentHistory.setTableHeader(new JTableHeader(tbRentHistory.getColumnModel()) {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                d.height = 28;
                return d;
            }
        });
        tbRentHistory.getTableHeader().setDefaultRenderer(new TableHeaderRenderer());
        tbRentHistory.setRowHeight(30);
        tbRentHistory.setBackground(new Color(255, 253, 225));
        tbRentHistory.setSelectionBackground(new Color(255, 221, 181));
        tbRentHistory.setShowHorizontalLines(false);
        tbRentHistory.setShowVerticalLines(false);

        setColumnSizes(tbRentHistory);

        scrollRentHistoryTable.setOpaque(false);
        scrollRentHistoryTable.getViewport().setOpaque(false);

        tbOpenRents.setModel(new OpenRentsModel());
        tbOpenRents.setTableHeader(new JTableHeader(tbOpenRents.getColumnModel()) {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                d.height = 28;
                return d;
            }
        });
        tbOpenRents.getTableHeader().setDefaultRenderer(new TableHeaderRenderer());
        tbOpenRents.setRowHeight(30);
        tbOpenRents.setBackground(new Color(255, 253, 225));
        tbOpenRents.setSelectionBackground(new Color(255, 221, 181));
        tbOpenRents.setShowHorizontalLines(false);
        tbOpenRents.setShowVerticalLines(false);

        setColumnSizes(tbOpenRents);

        scrollOpenRentsTable.setOpaque(false);
        scrollOpenRentsTable.getViewport().setOpaque(false);
    }

    private void setColumnSizes(JTable table) {
        table.getColumnModel().getColumn(0).setMaxWidth(35); // ID
        table.getColumnModel().getColumn(1).setMinWidth(105); // CPF
        table.getColumnModel().getColumn(1).setMaxWidth(105); // CPF

        table.getColumnModel().getColumn(2).setMinWidth(225); // CAR
        table.getColumnModel().getColumn(2).setMaxWidth(225); // CAR

        table.getColumnModel().getColumn(3).setMinWidth(145); // PERIOD
        table.getColumnModel().getColumn(3).setMaxWidth(145); // PERIOD
    }

    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        scrollOpenRentsTable = new javax.swing.JScrollPane();
        tbOpenRents = new javax.swing.JTable();
        txtOpenRentsSearch = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        scrollRentHistoryTable = new javax.swing.JScrollPane();
        tbRentHistory = new javax.swing.JTable();
        txtRentHistorySearch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 245));
        setPreferredSize(new java.awt.Dimension(1024, 550));

        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(600, 220));

        jLabel6.setBackground(new java.awt.Color(250, 200, 1));
        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 200, 1));
        jLabel6.setText("OPEN RENTS");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 10));
        jLabel6.setIconTextGap(16);

        scrollOpenRentsTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tbOpenRents.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbOpenRents.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3"
                }
        ));
        scrollOpenRentsTable.setViewportView(tbOpenRents);

        txtOpenRentsSearch.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        txtOpenRentsSearch.setForeground(new java.awt.Color(140, 140, 140));
        txtOpenRentsSearch.setText("search");
        txtOpenRentsSearch.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 225, 225)), javax.swing.BorderFactory.createEmptyBorder(9, 9, 9, 9)));
        txtOpenRentsSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtOpenRentsSearchFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOpenRentsSearchFocusLost(evt);
            }
        });
        txtOpenRentsSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtOpenRentsSearchKeyPressed(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOpenRentsSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtOpenRentsSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(scrollOpenRentsTable, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))
                        .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(txtOpenRentsSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollOpenRentsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel4);

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(600, 490));

        scrollRentHistoryTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tbRentHistory.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbRentHistory.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3"
                }
        ));
        scrollRentHistoryTable.setViewportView(tbRentHistory);

        txtRentHistorySearch.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        txtRentHistorySearch.setForeground(new java.awt.Color(140, 140, 140));
        txtRentHistorySearch.setText("search");
        txtRentHistorySearch.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 225, 225)), javax.swing.BorderFactory.createEmptyBorder(9, 9, 9, 9)));
        txtRentHistorySearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRentHistorySearchFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRentHistorySearchFocusLost(evt);
            }
        });
        txtRentHistorySearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRentHistorySearchKeyPressed(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRentHistorySearchKeyReleased(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(250, 200, 1));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(250, 200, 1));
        jLabel7.setText("RENT HISTORY");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 10));
        jLabel7.setIconTextGap(16);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(scrollRentHistoryTable, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRentHistorySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(txtRentHistorySearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollRentHistoryTable, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(15, Short.MAX_VALUE))
        );

        add(jPanel3);
    }

    private void txtOpenRentsSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOpenRentsSearchFocusGained
        if (txtOpenRentsSearch.getText().equals(TXT_SEARCH_REPLACEMENT)
                || txtOpenRentsSearch.getText().contains(TXT_SEARCH_WARNING_REPLACEMENT)) {
            removePlaceholder(txtOpenRentsSearch);
        }
    }//GEN-LAST:event_txtOpenRentsSearchFocusGained

    private void txtOpenRentsSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOpenRentsSearchFocusLost
        if (txtOpenRentsSearch.getText().isEmpty()) {
            setPlaceholder(txtOpenRentsSearch, TXT_SEARCH_REPLACEMENT);
        }
    }//GEN-LAST:event_txtOpenRentsSearchFocusLost

    private void txtOpenRentsSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOpenRentsSearchKeyPressed
        if (evt.getKeyCode() != KeyEvent.VK_ENTER && !client.isEmpty()
                || txtOpenRentsSearch.getText().contains(TXT_SEARCH_WARNING_REPLACEMENT)) {
            client = "";
            removePlaceholder(txtOpenRentsSearch);
        }
    }//GEN-LAST:event_txtOpenRentsSearchKeyPressed

    private void txtOpenRentsSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOpenRentsSearchKeyReleased
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            String search = txtOpenRentsSearch.getText();
            if (search.matches("[a-zA-Z0-9 ]+")) {
                client = search;
                setOKStatus(txtOpenRentsSearch, client);
            } else {
                client = "";
                setRefusedStatus(txtOpenRentsSearch, TXT_SEARCH_WARNING_REPLACEMENT);
            }
        }
    }//GEN-LAST:event_txtOpenRentsSearchKeyReleased

    private void txtRentHistorySearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRentHistorySearchFocusGained
        if (txtRentHistorySearch.getText().equals(TXT_SEARCH_REPLACEMENT)
                || txtRentHistorySearch.getText().contains(TXT_SEARCH_WARNING_REPLACEMENT)) {
            removePlaceholder(txtRentHistorySearch);
        }
    }//GEN-LAST:event_txtRentHistorySearchFocusGained

    private void txtRentHistorySearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRentHistorySearchFocusLost
        if (txtRentHistorySearch.getText().isEmpty()) {
            setPlaceholder(txtRentHistorySearch, TXT_SEARCH_REPLACEMENT);
        }
    }//GEN-LAST:event_txtRentHistorySearchFocusLost

    private void txtRentHistorySearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRentHistorySearchKeyPressed
        if (evt.getKeyCode() != KeyEvent.VK_ENTER && !client.isEmpty()
                || txtRentHistorySearch.getText().contains(TXT_SEARCH_WARNING_REPLACEMENT)) {
            client = "";
            removePlaceholder(txtRentHistorySearch);
        }
    }//GEN-LAST:event_txtRentHistorySearchKeyPressed

    private void txtRentHistorySearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRentHistorySearchKeyReleased
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            String search = txtRentHistorySearch.getText();
            if (search.matches("[a-zA-Z0-9 ]+")) {
                client = search;
                setOKStatus(txtRentHistorySearch, client);
            } else {
                client = "";
                setRefusedStatus(txtRentHistorySearch, TXT_SEARCH_WARNING_REPLACEMENT);
            }
        }
    }//GEN-LAST:event_txtRentHistorySearchKeyReleased

    private void setPlaceholder(JTextComponent txtcomponent, String placeholder) {
        txtcomponent.setText(placeholder);
        txtcomponent.setFont(txtcomponent.getFont().deriveFont(Font.ITALIC));
        txtcomponent.setForeground(new Color(140, 140, 140));
    }

    private void removePlaceholder(JTextComponent txtcomponent) {
        txtcomponent.setText("");
        txtcomponent.setFont(txtcomponent.getFont().deriveFont(Font.PLAIN));
        txtcomponent.setForeground(Color.BLACK);
    }

    private void setOKStatus(JTextComponent status, String message) {
        status.setText(message);
        status.setForeground(new Color(55, 113, 200));
    }

    private void setRefusedStatus(JTextComponent status, String message) {
        status.setText(message);
        status.setForeground(Color.RED);
    }

    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane scrollOpenRentsTable;
    private javax.swing.JScrollPane scrollRentHistoryTable;
    private javax.swing.JTable tbOpenRents;
    private javax.swing.JTable tbRentHistory;
    private javax.swing.JTextField txtOpenRentsSearch;
    private javax.swing.JTextField txtRentHistorySearch;

}
