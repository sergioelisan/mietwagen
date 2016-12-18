package com.venolabs.mietwagen.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import com.venolabs.mietwagen.Facade;
import com.venolabs.mietwagen.model.Client;
import com.venolabs.mietwagen.ui.handlers.MouseHandler;
import com.venolabs.mietwagen.ui.renders.TableHeaderRenderer;
import com.venolabs.mietwagen.ui.tables.CostumersModel;
import com.venolabs.mietwagen.util.ClickListener;
import com.venolabs.mietwagen.util.UIU;

/**
 *
 * @author sergio
 */
public class CostumerRegistrationScreen extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final CostumerRegistrationScreen INSTANCE = new CostumerRegistrationScreen();

	private static final String TXT_CPF_REPLACEMENT = "client cpf";
	private static final String TXT_CPF_WARNING_REPLACEMENT = "cpf format incorrect!";

	private static final String TXT_NAME_REPLACEMENT = "client name";
	private static final String TXT_NAME_WARNING_REPLACEMENT = "this is not a name!";

	private String cpf = "";
	private String name = "";
	
	private boolean nameValidated = false;
	private boolean cpfValidated = false;

	@SuppressWarnings("serial")
	private CostumerRegistrationScreen() {
		initComponents();
		setMinimumSize(MainFrame.SCREENS_DIMENSION);

		lbSubmit.addMouseListener(new MouseHandler());
		lbSubmit.addMouseListener((ClickListener) (e) -> validateAndSubmit());

		tbCostumers.setModel(new CostumersModel());
		tbCostumers.setTableHeader(new JTableHeader(tbCostumers.getColumnModel()) {
			public Dimension getPreferredSize() {
				Dimension d = super.getPreferredSize();
				d.height = 28;
				return d;
			}
		});

		tbCostumers.getTableHeader().setDefaultRenderer(new TableHeaderRenderer());
		tbCostumers.setRowHeight(30);
		tbCostumers.setBackground(new Color(255, 253, 225));
		tbCostumers.setSelectionBackground(new Color(255, 221, 181));
		tbCostumers.setShowHorizontalLines(false);
		tbCostumers.setShowVerticalLines(false);
		
		setColumnSizes(tbCostumers);

		scrollTable.setOpaque(false);
		scrollTable.getViewport().setOpaque(false);
	}

	private void setColumnSizes(JTable table) {
    	table.getColumnModel().getColumn(0).setMaxWidth(35); // ID
    	table.getColumnModel().getColumn(2).setMinWidth(105); // CPF
    	table.getColumnModel().getColumn(2).setMaxWidth(105); // CPF
    }
	
	private void validateAndSubmit() {
		if (cpf.isEmpty() || name.isEmpty()) {
			extractName();
			extractCPF();
		}
		
		if (nameValidated && cpfValidated) {
			Client c = new Client();
			c.setCpf(cpf);
			c.setName(name);
			
			Facade.saveClient(c);
		} else
			JOptionPane.showMessageDialog(MainFrame.INSTANCE, 
					"Name of CPF ID not validated! Pay attention!");
		
		cpf = "";
		name = "";
		nameValidated = false;
		cpfValidated = false;
		UIU.setPlaceholder(textClientName, TXT_NAME_REPLACEMENT);
		UIU.setPlaceholder(txtCPF, TXT_CPF_REPLACEMENT);
	}

	private void txtCPFFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtCPFFocusGained
		if (txtCPF.getText().equals(TXT_CPF_REPLACEMENT)
				|| txtCPF.getText().contains(TXT_CPF_WARNING_REPLACEMENT)) {
			UIU.removePlaceholder(txtCPF);
		}
	}// GEN-LAST:event_txtCPFFocusGained

	private void txtCPFFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtCPFFocusLost
		if (txtCPF.getText().isEmpty()) {
			UIU.setPlaceholder(txtCPF, TXT_CPF_REPLACEMENT);
		}
	}// GEN-LAST:event_txtCPFFocusLost

	private void txtCPFKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtCPFKeyPressed
		txtCPFKeyReleased(evt);
	}// GEN-LAST:event_txtCPFKeyPressed

	private void txtCPFKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtCPFKeyReleased
		if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
			extractCPF();
		} else if (!cpf.isEmpty()
				|| txtCPF.getText().contains(TXT_CPF_WARNING_REPLACEMENT)) {
			cpf = "";
			UIU.removePlaceholder(txtCPF);
		}
	}// GEN-LAST:event_txtCPFKeyReleased

	private void txtCarPlateFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtCarPlateFocusGained
		if (textClientName.getText().equals(TXT_NAME_REPLACEMENT)
				|| textClientName.getText().contains(TXT_NAME_WARNING_REPLACEMENT)) {
			UIU.removePlaceholder(textClientName);
		}
	}// GEN-LAST:event_txtCarPlateFocusGained

	private void txtCarPlateFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtCarPlateFocusLost
		if (textClientName.getText().isEmpty()) {
			UIU.setPlaceholder(textClientName, TXT_NAME_REPLACEMENT);
		}
	}// GEN-LAST:event_txtCarPlateFocusLost

	private void txtCarPlateKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtCarPlateKeyPressed
		txtCarPlateKeyReleased(evt);
	}// GEN-LAST:event_txtCarPlateKeyPressed

	private void txtCarPlateKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtCarPlateKeyReleased
		if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
			extractName();
		} else if (!name.isEmpty()
				|| textClientName.getText().contains(TXT_NAME_WARNING_REPLACEMENT)) {
			name = "";
			UIU.removePlaceholder(textClientName);
		}
	}// GEN-LAST:event_txtCarPlateKeyReleased

	private void extractName() {
		if (!textClientName.getText().equals(TXT_NAME_REPLACEMENT) 
				&& textClientName.getText().matches("[A-Za-z ]*")) {
			name = textClientName.getText().trim();			
			nameValidated = UIU.setOKStatus(textClientName, name);
		} else {
			name = "";
			nameValidated = UIU.setRefusedStatus(textClientName, TXT_NAME_WARNING_REPLACEMENT);
		}
	}
	
	private void extractCPF() {
		if (txtCPF.getText().matches("[0-9]+")) {
			cpf = txtCPF.getText().trim();
			cpfValidated = UIU.setOKStatus(txtCPF, cpf);
		} else {
			cpf = "";
			cpfValidated = UIU.setRefusedStatus(txtCPF, TXT_CPF_WARNING_REPLACEMENT);
		}
	}

	private void initComponents() {

		jPanel3 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		scrollTable = new javax.swing.JScrollPane();
		tbCostumers = new javax.swing.JTable();
		jPanel2 = new javax.swing.JPanel();
		txtCPF = new javax.swing.JTextField();
		textClientName = new javax.swing.JTextField();
		lbSubmit = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();

		setBackground(new java.awt.Color(255, 255, 245));
		setPreferredSize(new java.awt.Dimension(1024, 550));

		jPanel3.setOpaque(false);
		jPanel3.setPreferredSize(new java.awt.Dimension(473, 490));

		jLabel5.setBackground(new java.awt.Color(250, 200, 1));
		jLabel5.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(250, 200, 1));
		jLabel5.setText("MIETWAGEN COSTUMERS");
		jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0,
				10, 10));
		jLabel5.setIconTextGap(16);

		scrollTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1,
				1, 1));

		tbCostumers.setBorder(javax.swing.BorderFactory
				.createEmptyBorder(1, 1, 1, 1));
		tbCostumers.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null } }, new String[] {
				"Title 1", "Title 2", "Title 3" }));
		scrollTable.setViewportView(tbCostumers);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout
				.setHorizontalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																scrollTable,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																449,
																Short.MAX_VALUE)
														.addComponent(
																jLabel5,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jLabel5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												scrollTable,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												425,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		add(jPanel3);

		jPanel2.setBackground(new java.awt.Color(245, 245, 245));
		jPanel2.setOpaque(false);
		jPanel2.setPreferredSize(new java.awt.Dimension(350, 490));

		txtCPF.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
		txtCPF.setForeground(new java.awt.Color(140, 140, 140));
		txtCPF.setText("client cpf");
		txtCPF.setBorder(javax.swing.BorderFactory.createCompoundBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						225, 225, 225)), javax.swing.BorderFactory
						.createEmptyBorder(9, 9, 9, 9)));
		txtCPF.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				txtCPFFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				txtCPFFocusLost(evt);
			}
		});
		txtCPF.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txtCPFKeyPressed(evt);
			}

			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtCPFKeyReleased(evt);
			}
		});

		textClientName.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
		textClientName.setForeground(new java.awt.Color(140, 140, 140));
		textClientName.setText("client name");
		textClientName.setBorder(javax.swing.BorderFactory.createCompoundBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						225, 225, 225)), javax.swing.BorderFactory
						.createEmptyBorder(9, 9, 9, 9)));
		textClientName.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				txtCarPlateFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				txtCarPlateFocusLost(evt);
			}
		});
		textClientName.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txtCarPlateKeyPressed(evt);
			}

			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtCarPlateKeyReleased(evt);
			}
		});

		lbSubmit.setBackground(new java.awt.Color(250, 200, 1));
		lbSubmit.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
		lbSubmit.setForeground(java.awt.Color.white);
		lbSubmit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lbSubmit.setText("add new client");
		lbSubmit.setIconTextGap(16);
		lbSubmit.setOpaque(true);

		jLabel6.setBackground(new java.awt.Color(250, 200, 1));
		jLabel6.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
		jLabel6.setForeground(new java.awt.Color(250, 200, 1));
		jLabel6.setText("ADD NEW CLIENT");
		jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0,
				10, 10));
		jLabel6.setIconTextGap(16);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																textClientName)
														.addComponent(txtCPF)
														.addComponent(
																lbSubmit,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jLabel6,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																326,
																Short.MAX_VALUE))
										.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel6,
								javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(txtCPF,
								javax.swing.GroupLayout.DEFAULT_SIZE, 45,
								Short.MAX_VALUE)
						.addGap(18, 18, 18)
						.addComponent(textClientName,
								javax.swing.GroupLayout.DEFAULT_SIZE, 45,
								Short.MAX_VALUE)
						.addGap(18, 18, 18)
						.addComponent(lbSubmit,
								javax.swing.GroupLayout.PREFERRED_SIZE, 45,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(259, 259, 259)));

		add(jPanel2);
	}

	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JLabel lbSubmit;
	private javax.swing.JScrollPane scrollTable;
	private javax.swing.JTable tbCostumers;
	private javax.swing.JTextField txtCPF;
	private javax.swing.JTextField textClientName;

}
