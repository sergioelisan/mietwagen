package com.venolabs.mietwagen.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import com.venolabs.mietwagen.Facade;
import com.venolabs.mietwagen.model.Car;
import com.venolabs.mietwagen.ui.handlers.MouseHandler;
import com.venolabs.mietwagen.ui.renders.TableHeaderRenderer;
import com.venolabs.mietwagen.ui.tables.FleetModel;
import com.venolabs.mietwagen.util.ClickListener;
import com.venolabs.mietwagen.util.UIU;

/**
 *
 * @author sergio
 */
public class CarRegistrationScreen extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final CarRegistrationScreen INSTANCE = new CarRegistrationScreen();

	private static final String TXT_CAR_PLATE_REPLACEMENT = "car plate";
	private static final String TXT_CAR_PLATE_WARNING_REPLACEMENT = "this is not a car plate!";

	private static final String TXT_CAR_MODEL_REPLACEMENT = "car model";
	private static final String TXT_CAR_MODEL_WARNING_REPLACEMENT = "this is not a car model!";

	private static final String TXA_OBSERVATIONS_REPLACEMENT = "observations";

	private String model = "";
	private String plate = "";
	private String observations = "";

	private boolean modelValidated = false;
	private boolean plateValidated = false;

	@SuppressWarnings("serial")
	private CarRegistrationScreen() {
		initComponents();
		setMinimumSize(MainFrame.SCREENS_DIMENSION);

		lbSubmit.addMouseListener(new MouseHandler());
		lbSubmit.addMouseListener((ClickListener) (e) -> validateAndSubmit());

		tbCars.setModel(new FleetModel());
		tbCars.setTableHeader(new JTableHeader(tbCars.getColumnModel()) {
			public Dimension getPreferredSize() {
				Dimension d = super.getPreferredSize();
				d.height = 28;
				return d;
			}
		});
		tbCars.getTableHeader().setDefaultRenderer(new TableHeaderRenderer());
		tbCars.setRowHeight(30);
		tbCars.setBackground(new Color(255, 253, 225));
		tbCars.setSelectionBackground(new Color(255, 221, 181));
		tbCars.setShowHorizontalLines(false);
		tbCars.setShowVerticalLines(false);

		setColumnSizes(tbCars);
		
		scrollTable.setOpaque(false);
		scrollTable.getViewport().setOpaque(false);
	}
	
	private void setColumnSizes(JTable table) {
    	table.getColumnModel().getColumn(0).setMaxWidth(35); // ID
    	
    	table.getColumnModel().getColumn(1).setMinWidth(80); // CPF
    	table.getColumnModel().getColumn(1).setMaxWidth(80); // CPF
    }

	private void validateAndSubmit() {
		if (model.isEmpty() || plate.isEmpty()) {
			extractCarModel();
			extractCarPlate();
		}

		String obs = txaObservations.getText();
		observations = obs.equals(TXA_OBSERVATIONS_REPLACEMENT) ? "" : obs;
		
		if (modelValidated && plateValidated) {
			Car c = new Car();
			c.setPlate(plate);
			c.setModel(model);
			c.setObservations(observations);

			Facade.saveCar(c);
		} else
			JOptionPane.showMessageDialog(MainFrame.INSTANCE,
					"Name of CPF ID not validated! Pay attention!");

		model = "";
		plate = "";
		observations = "";
		modelValidated = false;
		plateValidated = false;

		UIU.setPlaceholder(txtCarPlate, TXT_CAR_PLATE_REPLACEMENT);
		UIU.setPlaceholder(txtCarModel, TXT_CAR_MODEL_REPLACEMENT);
		UIU.setPlaceholder(txaObservations, TXA_OBSERVATIONS_REPLACEMENT);
	}

	private void txtCarPlateFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtCarPlateFocusGained
		if (txtCarPlate.getText().equals(TXT_CAR_PLATE_REPLACEMENT)
				|| txtCarPlate.getText().contains(
						TXT_CAR_PLATE_WARNING_REPLACEMENT)) {
			UIU.removePlaceholder(txtCarPlate);
		}
	}// GEN-LAST:event_txtCarPlateFocusGained

	private void txtCarPlateFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtCarPlateFocusLost
		if (txtCarPlate.getText().isEmpty()) {
			UIU.setPlaceholder(txtCarPlate, TXT_CAR_PLATE_REPLACEMENT);
		}
	}// GEN-LAST:event_txtCarPlateFocusLost

	private void txtCarPlateKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtCarPlateKeyPressed
		txtCarPlateKeyReleased(evt);
	}// GEN-LAST:event_txtCarPlateKeyPressed

	private void txtCarPlateKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtCarPlateKeyReleased
		if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
			extractCarPlate();
		} else if (!plate.isEmpty()
				|| txtCarPlate.getText().contains(
						TXT_CAR_PLATE_WARNING_REPLACEMENT)) {
			plate = "";
			UIU.removePlaceholder(txtCarPlate);
		}
	}// GEN-LAST:event_txtCarPlateKeyReleased

	private void txtCarModelFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtCarModelFocusGained
		if (txtCarModel.getText().equals(TXT_CAR_MODEL_REPLACEMENT)
				|| txtCarModel.getText().contains(
						TXT_CAR_MODEL_WARNING_REPLACEMENT)) {
			UIU.removePlaceholder(txtCarModel);
		}
	}// GEN-LAST:event_txtCarModelFocusGained

	private void txtCarModelFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtCarModelFocusLost
		if (txtCarModel.getText().isEmpty()) {
			UIU.setPlaceholder(txtCarModel, TXT_CAR_MODEL_REPLACEMENT);
		}
	}// GEN-LAST:event_txtCarModelFocusLost

	private void txtCarModelKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtCarModelKeyPressed
		txtCarModelKeyReleased(evt);
	}// GEN-LAST:event_txtCarModelKeyPressed

	private void txtCarModelKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtCarModelKeyReleased
		if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
			extractCarModel();
		} else if (!model.isEmpty()
				|| txtCarModel.getText().contains(
						TXT_CAR_MODEL_WARNING_REPLACEMENT)) {
			model = "";
			UIU.removePlaceholder(txtCarModel);
		}
	}// GEN-LAST:event_txtCarModelKeyReleased

	private void txaObservationsFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txaObservationsFocusGained
		if (txaObservations.getText().equals(TXA_OBSERVATIONS_REPLACEMENT)) {
			UIU.removePlaceholder(txaObservations);
		}
	}// GEN-LAST:event_txaObservationsFocusGained

	private void txaObservationsFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txaObservationsFocusLost
		if (txaObservations.getText().isEmpty()) {
			UIU.setPlaceholder(txaObservations, TXA_OBSERVATIONS_REPLACEMENT);
		}
	}// GEN-LAST:event_txaObservationsFocusLost

	private void extractCarModel() {
		if (!txtCarModel.getText().equals(TXT_CAR_MODEL_REPLACEMENT) && 
				txtCarModel.getText().matches("[A-Za-z0-9 ]*")) {
			model = txtCarModel.getText().trim();
			modelValidated = UIU.setOKStatus(txtCarModel, model);
		} else {
			model = "";
			modelValidated = UIU.setRefusedStatus(txtCarModel, TXT_CAR_MODEL_WARNING_REPLACEMENT);
		}
	}

	private void extractCarPlate() {
		if (txtCarPlate.getText().matches(
				"[A-Za-z][A-Za-z][A-Za-z]-[0-9][0-9][0-9][0-9]")) {
			plate = txtCarPlate.getText().trim().toUpperCase();
			plateValidated = UIU.setOKStatus(txtCarPlate, plate);
		} else {
			plate = "";
			plateValidated = UIU.setRefusedStatus(txtCarPlate, TXT_CAR_PLATE_WARNING_REPLACEMENT);
		}
	}

	private void initComponents() {

		jPanel3 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		scrollTable = new javax.swing.JScrollPane();
		tbCars = new javax.swing.JTable();
		jPanel2 = new javax.swing.JPanel();
		txtCarPlate = new javax.swing.JTextField();
		txtCarModel = new javax.swing.JTextField();
		lbSubmit = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		txaObservations = new javax.swing.JTextArea();

		setBackground(new java.awt.Color(255, 255, 245));
		setPreferredSize(new java.awt.Dimension(1024, 550));

		jPanel3.setOpaque(false);
		jPanel3.setPreferredSize(new java.awt.Dimension(473, 490));

		jLabel5.setBackground(new java.awt.Color(250, 200, 1));
		jLabel5.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(250, 200, 1));
		jLabel5.setText("MIETWAGEN CAR FLEET");
		jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0,
				10, 10));
		jLabel5.setIconTextGap(16);

		scrollTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1,
				1, 1));

		tbCars.setBorder(javax.swing.BorderFactory
				.createEmptyBorder(1, 1, 1, 1));
		tbCars.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null } }, new String[] {
				"Title 1", "Title 2", "Title 3" }));
		scrollTable.setViewportView(tbCars);

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

		txtCarPlate.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
		txtCarPlate.setForeground(new java.awt.Color(140, 140, 140));
		txtCarPlate.setText("car plate");
		txtCarPlate.setBorder(javax.swing.BorderFactory.createCompoundBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						225, 225, 225)), javax.swing.BorderFactory
						.createEmptyBorder(9, 9, 9, 9)));
		txtCarPlate.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				txtCarPlateFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				txtCarPlateFocusLost(evt);
			}
		});
		txtCarPlate.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txtCarPlateKeyPressed(evt);
			}

			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtCarPlateKeyReleased(evt);
			}
		});

		txtCarModel.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
		txtCarModel.setForeground(new java.awt.Color(140, 140, 140));
		txtCarModel.setText("car model");
		txtCarModel.setBorder(javax.swing.BorderFactory.createCompoundBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						225, 225, 225)), javax.swing.BorderFactory
						.createEmptyBorder(9, 9, 9, 9)));
		txtCarModel.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				txtCarModelFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				txtCarModelFocusLost(evt);
			}
		});
		txtCarModel.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				txtCarModelKeyPressed(evt);
			}

			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtCarModelKeyReleased(evt);
			}
		});

		lbSubmit.setBackground(new java.awt.Color(250, 200, 1));
		lbSubmit.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
		lbSubmit.setForeground(java.awt.Color.white);
		lbSubmit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lbSubmit.setText("add new car");
		lbSubmit.setIconTextGap(16);
		lbSubmit.setOpaque(true);

		jLabel6.setBackground(new java.awt.Color(250, 200, 1));
		jLabel6.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
		jLabel6.setForeground(new java.awt.Color(250, 200, 1));
		jLabel6.setText("ADD NEW CAR");
		jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0,
				10, 10));
		jLabel6.setIconTextGap(16);

		txaObservations.setColumns(20);
		txaObservations.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
		txaObservations.setForeground(new java.awt.Color(140, 140, 140));
		txaObservations.setLineWrap(true);
		txaObservations.setRows(5);
		txaObservations.setText("observations");
		txaObservations
				.setBorder(javax.swing.BorderFactory.createCompoundBorder(
						javax.swing.BorderFactory
								.createLineBorder(new java.awt.Color(225, 225,
										225)), javax.swing.BorderFactory
								.createEmptyBorder(9, 9, 9, 9)));
		txaObservations.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				txaObservationsFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				txaObservationsFocusLost(evt);
			}
		});
		jScrollPane1.setViewportView(txaObservations);

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
																txtCarModel)
														.addComponent(
																txtCarPlate)
														.addComponent(
																lbSubmit,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jLabel6,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																326,
																Short.MAX_VALUE)
														.addComponent(
																jScrollPane1,
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
						.addComponent(txtCarPlate,
								javax.swing.GroupLayout.PREFERRED_SIZE, 45,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(txtCarModel,
								javax.swing.GroupLayout.PREFERRED_SIZE, 45,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 132,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(lbSubmit,
								javax.swing.GroupLayout.PREFERRED_SIZE, 45,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(109, Short.MAX_VALUE)));

		add(jPanel2);
	}

	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lbSubmit;
	private javax.swing.JScrollPane scrollTable;
	private javax.swing.JTable tbCars;
	private javax.swing.JTextArea txaObservations;
	private javax.swing.JTextField txtCarModel;
	private javax.swing.JTextField txtCarPlate;

}
