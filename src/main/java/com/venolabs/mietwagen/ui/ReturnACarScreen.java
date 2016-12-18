package com.venolabs.mietwagen.ui;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import com.venolabs.mietwagen.Facade;
import com.venolabs.mietwagen.model.Car;
import com.venolabs.mietwagen.ui.handlers.MouseHandler;
import com.venolabs.mietwagen.util.ClickListener;
import com.venolabs.mietwagen.util.UIU;

/**
 *
 * @author sergio
 */
public class ReturnACarScreen extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TXT_CAR_PLATE_REPLACEMENT = "car plate";
	private static final String TXT_CAR_PLATE_WARNING_REPLACEMENT = "car not registered!";

	private Car car;
	private String carName = "";

	private boolean paid = false;

	public static final ReturnACarScreen INSTANCE = new ReturnACarScreen();

	private ReturnACarScreen() {
		initComponents();

		setMinimumSize(MainFrame.SCREENS_DIMENSION);
		lbSubmit.addMouseListener(new MouseHandler());
		lbSubmit.addMouseListener((ClickListener) (e) -> validateAndSubmit());
	}

	private void validateAndSubmit() {
		if (carName.isEmpty()) {
			extractCarPlate();
		}

		if (car != null) {
			paid = ckPaid.isSelected();
			String response = Facade.returnACar(car, paid);
			JOptionPane.showMessageDialog(MainFrame.INSTANCE, response);
		} else {
			JOptionPane.showMessageDialog(MainFrame.INSTANCE, "car not registered!");
		}

		car = null;
		paid = false;

		carName = "";

		UIU.setPlaceholder(txtCarPlate, TXT_CAR_PLATE_REPLACEMENT);
		ckPaid.setSelected(false);
	}

	private void extractCarPlate() {
		if (txtCarPlate.getText().matches(
				"[A-Za-z][A-Za-z][A-Za-z]-[0-9][0-9][0-9][0-9]")) {
			car = Facade.getCar(txtCarPlate.getText().trim().toUpperCase());
			carName = car.getModel() + "(" + car.getPlate() + ")";
			UIU.setOKStatus(txtCarPlate, carName);
		} else {
			carName = "";
			UIU.setRefusedStatus(txtCarPlate, TXT_CAR_PLATE_WARNING_REPLACEMENT);
		}
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		txtCarPlate = new javax.swing.JTextField();
		ckPaid = new javax.swing.JCheckBox();
		lbSubmit = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();

		setBackground(new java.awt.Color(255, 255, 245));

		jPanel1.setBackground(new java.awt.Color(245, 245, 245));
		jPanel1.setOpaque(false);
		jPanel1.setPreferredSize(new java.awt.Dimension(350, 490));

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
		lbSubmit.setText("return a car");
		lbSubmit.setIconTextGap(16);
		lbSubmit.setOpaque(true);

		jLabel5.setBackground(new java.awt.Color(250, 200, 1));
		jLabel5.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(250, 200, 1));
		jLabel5.setText("RETURN A CAR");
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
														.addComponent(
																lbSubmit,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																ckPaid,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jLabel5,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																326,
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
												txtCarPlate,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												45, Short.MAX_VALUE)
										.addGap(18, 18, 18)
										.addComponent(
												ckPaid,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												35,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												278, Short.MAX_VALUE)
										.addComponent(
												lbSubmit,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												42,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));

		add(jPanel1);
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
		if (!carName.isEmpty()
				|| txtCarPlate.getText().contains(
						TXT_CAR_PLATE_WARNING_REPLACEMENT)) {
			carName = "";
			UIU.removePlaceholder(txtCarPlate);
		}
	}// GEN-LAST:event_txtCarPlateKeyPressed

	private void txtCarPlateKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtCarPlateKeyReleased
		if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
			extractCarPlate();
		}
	}// GEN-LAST:event_txtCarPlateKeyReleased

	private javax.swing.JCheckBox ckPaid;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel lbSubmit;
	private javax.swing.JTextField txtCarPlate;

}
