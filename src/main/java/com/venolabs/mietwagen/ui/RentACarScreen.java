/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venolabs.mietwagen.ui;

import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.JOptionPane;

import com.venolabs.mietwagen.Facade;
import com.venolabs.mietwagen.model.Car;
import com.venolabs.mietwagen.model.Client;
import com.venolabs.mietwagen.ui.handlers.MouseHandler;
import com.venolabs.mietwagen.util.ClickListener;
import com.venolabs.mietwagen.util.UIU;

/**
 *
 * @author sergio
 */
public class RentACarScreen extends javax.swing.JPanel {

	/** */
	private static final long serialVersionUID = 1L;

	public static final RentACarScreen INSTANCE = new RentACarScreen();

	private static final String TXT_CLIENT_REPLACEMENT = "client cpf";
	private static final String TXT_CLIENT_WARNING_REPLACEMENT = "costumer not registered!";
	private static final String TXT_CAR_PLATE_REPLACEMENT = "car plate";
	private static final String TXT_CAR_PLATE_WARNING_REPLACEMENT = "car not registered!";
	private static final String TXA_OBSERVATIONS_REPLACEMENT = "observations";

	private Client client;
	private Car car;
	private Date delivery;
	private String observations = "";
	private boolean paid;

	private String clientName = "";
	private String carName = "";

	private RentACarScreen() {
		initComponents();
		setMinimumSize(MainFrame.SCREENS_DIMENSION);
		lbSubmit.addMouseListener(new MouseHandler());
		lbSubmit.addMouseListener((ClickListener) (e) -> validateAndSubmit());
	}

	private void validateAndSubmit() {
		if (clientName.isEmpty() || carName.isEmpty()) {
			extractCar();
			extractClient();
		}

		if (client != null || car != null) {
			extractObservations();
			extractDateAndPaid();

			String response = Facade.rentACar(car, client, delivery,
					observations, paid);

			JOptionPane.showMessageDialog(MainFrame.INSTANCE, response);
		} else {
			JOptionPane.showMessageDialog(MainFrame.INSTANCE,
					"car or client not registered");
		}

		car = null;
		client = null;
		observations = "";
		delivery = null;
		paid = false;

		clientName = "";
		carName = "";

		UIU.setPlaceholder(txtCPF, TXT_CLIENT_REPLACEMENT);
		UIU.setPlaceholder(txtCarPlate, TXT_CAR_PLATE_REPLACEMENT);
		UIU.setPlaceholder(txaObservations, TXA_OBSERVATIONS_REPLACEMENT);
		ckPaid.setSelected(false);
		dpDelivery.setDate(null);
	}

	private void extractDateAndPaid() {
		delivery = dpDelivery.getDate();
		paid = ckPaid.isSelected();
	}

	private void extractObservations() {
		if (!txaObservations.getText().equals(TXA_OBSERVATIONS_REPLACEMENT))
			observations = txaObservations.getText();
	}

	private void extractClient() {
		if (txtCPF.getText().matches("[0-9]+")) {
			client = Facade.getClientByCPF(txtCPF.getText().trim());
			if (client != null) {
				clientName = client.getName();
				UIU.setOKStatus(txtCPF, clientName);
			} else {
				clientName = "";
				UIU.setRefusedStatus(txtCPF, "client not registered!");
			}
		} else {
			clientName = "";
			UIU.setRefusedStatus(txtCPF, TXT_CLIENT_WARNING_REPLACEMENT);
		}
	}

	private void extractCar() {
		if (txtCarPlate.getText().matches(
				"[A-Za-z][A-Za-z][A-Za-z]-[0-9][0-9][0-9][0-9]")) {
			car = Facade.getCar(txtCarPlate.getText().trim().toUpperCase());
			if (car != null) {
				carName = car.getModel() + " (" + car.getPlate() + ")";
				UIU.setOKStatus(txtCarPlate, carName);
			} else {
				carName = "";
				UIU.setRefusedStatus(txtCarPlate, "car not registerd!");
			}
		} else {
			carName = "";
			UIU.setRefusedStatus(txtCarPlate, TXT_CAR_PLATE_WARNING_REPLACEMENT);
		}
	}

	private void txtCPFFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtCPFFocusGained
		if (txtCPF.getText().equals(TXT_CLIENT_REPLACEMENT)
				|| txtCPF.getText().contains(TXT_CLIENT_WARNING_REPLACEMENT)) {
			UIU.removePlaceholder(txtCPF);
		}
	}// GEN-LAST:event_txtCPFFocusGained

	private void txtCPFFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtCPFFocusLost
		if (txtCPF.getText().isEmpty()) {
			UIU.setPlaceholder(txtCPF, TXT_CLIENT_REPLACEMENT);
		}
	}// GEN-LAST:event_txtCPFFocusLost

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

	private void txtCPFKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtCPFKeyReleased
		if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
			extractClient();
		} else if (!clientName.isEmpty()
				|| txtCPF.getText().contains(TXT_CLIENT_REPLACEMENT)) {
			clientName = "";
			UIU.removePlaceholder(txtCPF);
		}
	}// GEN-LAST:event_txtCPFKeyReleased

	private void txtCarPlateKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtCarPlateKeyReleased
		if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
			extractCar();
		} else if (!carName.isEmpty()
				|| txtCarPlate.getText().contains(TXT_CAR_PLATE_REPLACEMENT)) {
			carName = "";
			UIU.removePlaceholder(txtCarPlate);
		}
	}// GEN-LAST:event_txtCarPlateKeyReleased

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

	private void txtCPFKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtCPFKeyPressed
		if (!clientName.isEmpty()
				|| txtCPF.getText().contains(TXT_CLIENT_WARNING_REPLACEMENT)) {
			clientName = "";
			UIU.removePlaceholder(txtCPF);
		}
	}// GEN-LAST:event_txtCPFKeyPressed

	private void txtCarPlateKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtCarPlateKeyPressed
		if (!carName.isEmpty()
				|| txtCarPlate.getText().contains(
						TXT_CAR_PLATE_WARNING_REPLACEMENT)) {
			carName = "";
			UIU.removePlaceholder(txtCarPlate);
		}
	}// GEN-LAST:event_txtCarPlateKeyPressed

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		txtCPF = new javax.swing.JTextField();
		txtCarPlate = new javax.swing.JTextField();
		dpDelivery = new org.jdesktop.swingx.JXDatePicker();
		jScrollPane1 = new javax.swing.JScrollPane();
		txaObservations = new javax.swing.JTextArea();
		ckPaid = new javax.swing.JCheckBox();
		lbSubmit = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();

		setBackground(new java.awt.Color(255, 255, 245));
		setPreferredSize(new java.awt.Dimension(1024, 550));

		jPanel1.setBackground(new java.awt.Color(245, 245, 245));
		jPanel1.setOpaque(false);
		jPanel1.setPreferredSize(new java.awt.Dimension(350, 490));

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

		ckPaid.setBackground(java.awt.Color.white);
		ckPaid.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
		ckPaid.setForeground(new java.awt.Color(140, 140, 140));
		ckPaid.setText("paid?");
		ckPaid.setBorder(javax.swing.BorderFactory.createCompoundBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(
						200, 200, 200)), javax.swing.BorderFactory
						.createEmptyBorder(5, 5, 5, 5)));
		ckPaid.setOpaque(false);

		lbSubmit.setBackground(new java.awt.Color(250, 200, 1));
		lbSubmit.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
		lbSubmit.setForeground(java.awt.Color.white);
		lbSubmit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lbSubmit.setText("rent a car");
		lbSubmit.setIconTextGap(16);
		lbSubmit.setOpaque(true);

		jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
		jLabel1.setText("delivery day");

		jLabel5.setBackground(new java.awt.Color(250, 200, 1));
		jLabel5.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(250, 200, 1));
		jLabel5.setText("RENT A CAR");
		jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0,
				10, 10));
		jLabel5.setIconTextGap(16);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																txtCarPlate)
														.addComponent(txtCPF)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																326,
																Short.MAX_VALUE)
														.addComponent(
																lbSubmit,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel1)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				dpDelivery,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addComponent(
																ckPaid,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jLabel5,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jLabel5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(
												txtCPF,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												45, Short.MAX_VALUE)
										.addGap(18, 18, 18)
										.addComponent(
												txtCarPlate,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												45, Short.MAX_VALUE)
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																dpDelivery,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																30,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel1))
										.addGap(18, 18, 18)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												132,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												ckPaid,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												35,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												23, Short.MAX_VALUE)
										.addComponent(
												lbSubmit,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												42,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));

		jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { txtCPF, txtCarPlate });

		add(jPanel1);
	}

	private javax.swing.JCheckBox ckPaid;
	private org.jdesktop.swingx.JXDatePicker dpDelivery;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lbSubmit;
	private javax.swing.JTextArea txaObservations;
	private javax.swing.JTextField txtCPF;
	private javax.swing.JTextField txtCarPlate;

}
