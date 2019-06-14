package com.crud.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.crud.conf.ConnectionDB;
import com.swing.controleur.PerconneControleur;
import com.swing.controleur.VoitureControleur;

public class MainJFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private Connection con = ConnectionDB.getConnection();
	private int personId;

	public MainJFrame() {
		initComponents();

		setPersonneTableData();
		setVoitureTableData();
		//////////// FERMER FENETRE////////////////
		this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int clickedButton = JOptionPane.showConfirmDialog(MainJFrame.this, "Voulez-vous vraiment quiter",
						"Confirmation", JOptionPane.YES_NO_OPTION);
				if (clickedButton == JOptionPane.YES_OPTION) {
					MainJFrame.this.dispose();
				}

			}
		});
	}

	private void initComponents() {

		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jPanel1 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		idTextField = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		nomTextField = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		prenomTextField = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		adresseTextField = new javax.swing.JTextField();
		jPanel3 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jPanel2 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jPanel4 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jPanel5 = new javax.swing.JPanel();
		jLabel8 = new javax.swing.JLabel();
		idTextFieldV = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		marqueTextFieldV = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		vitesseTextFieldV = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		idpTextFieldV = new javax.swing.JTextField();
		jPanel7 = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTable3 = new javax.swing.JTable();
		jPanel6 = new javax.swing.JPanel();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();

		jTable2.setModel(
				new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane2.setViewportView(jTable2);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("JAVA CRUD");
		setAlwaysOnTop(true);
		setBackground(new java.awt.Color(204, 204, 255));

		jPanel1.setBackground(new java.awt.Color(0, 204, 102));
		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Identification personne"));
		jPanel1.setLayout(new java.awt.GridLayout(4, 2, 10, 20));

		jLabel4.setText("ID personne ");
		jPanel1.add(jLabel4);
		jPanel1.add(idTextField);

		jLabel1.setText("Nom");
		jPanel1.add(jLabel1);

		jPanel1.add(nomTextField);

		jLabel2.setText("Prenom");
		jPanel1.add(jLabel2);

		jPanel1.add(prenomTextField);

		jLabel3.setText("Adresse");
		jPanel1.add(jLabel3);
		jPanel1.add(adresseTextField);

		jPanel3.setBackground(new java.awt.Color(0, 204, 102));

		jTable1.setModel(
				new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTable1MouseClicked(evt);
			}
		});

		jTable3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				jTable3MouseClicked();

			}
		});

		jScrollPane1.setViewportView(jTable1);

		jPanel2.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

		jButton1.setText("Insert");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int clickedButton = JOptionPane.showConfirmDialog(MainJFrame.this, "Voulez-vous inserer cette personne?", "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if (clickedButton == JOptionPane.YES_OPTION) {
					jButton1ActionPerformed();
				}

			}
		});
		jPanel2.add(jButton1);

		jButton2.setText("Update");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int clickedButton = JOptionPane.showConfirmDialog(MainJFrame.this, "Voulez-vous modifier cette personne?", "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if (clickedButton == JOptionPane.YES_OPTION) {
					jButton2ActionPerformed();
				}

			}
		});
		jPanel2.add(jButton2);

		jButton3.setText("Delete");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				jButton3ActionPerformed(evt);

			}
		});
		jPanel2.add(jButton3);

		jButton4.setText("Reset");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
		jPanel2.add(jButton4);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1)
						.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(jPanel2,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap(38, Short.MAX_VALUE)
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(22, 22, 22)));

		jPanel4.setBackground(new java.awt.Color(204, 255, 255));

		jLabel5.setFont(new java.awt.Font("Comic Sans MS", 3, 12));
		jLabel5.setText("Dinahasina RALAIVAO");

		jLabel6.setFont(new java.awt.Font("Comic Sans MS", 3, 12));
		jLabel6.setText("   L2 IDEV  ESTI");

		jLabel7.setFont(new java.awt.Font("Lucida Bright", 1, 14));
		jLabel7.setText("    PROJET CRUD JAVA");

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 137,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
						.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 176,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(61, 61, 61)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel4Layout.createSequentialGroup()
								.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel4Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel5.setBackground(new java.awt.Color(204, 0, 0));
		jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Identification voiture"));
		jPanel5.setLayout(new java.awt.GridLayout(4, 2, 10, 20));

		jLabel8.setText("ID voiture");
		jPanel5.add(jLabel8);
		jPanel5.add(idTextFieldV);

		jLabel9.setText("Marque");
		jPanel5.add(jLabel9);
		jPanel5.add(marqueTextFieldV);

		jLabel10.setText("Vitesse (KM/H)");
		jPanel5.add(jLabel10);
		jPanel5.add(vitesseTextFieldV);

		jLabel11.setText("ID personne");
		jPanel5.add(jLabel11);
		jPanel5.add(idpTextFieldV);

		jPanel7.setBackground(new java.awt.Color(204, 0, 0));

		jTable3.setModel(
				new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane3.setViewportView(jTable3);

		jPanel6.setBackground(new java.awt.Color(204, 0, 0));
		jPanel6.setLayout(new java.awt.GridLayout(1, 4, 10, 0));

		jButton5.setText("Insert");
		jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				jButton5();
			}
		});
		jPanel6.add(jButton5);

		jButton6.setText("Update");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int clickedButton = JOptionPane.showConfirmDialog(MainJFrame.this, "Voulez-vous modifier cette voiture?", "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if (clickedButton == JOptionPane.YES_OPTION) {
					jButton6();
				}

			}
		});
		jPanel6.add(jButton6);

		jButton7.setText("Delete");
		jButton7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int clickedButton = JOptionPane.showConfirmDialog(MainJFrame.this, "Voulez-vous supprimer cette voiture?", "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if (clickedButton == JOptionPane.YES_OPTION) {
					jButton7();
				}

			}
		});
		jPanel6.add(jButton7);

		jButton8.setText("Reset");
		jButton8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jButton8();

			}
		});
		jPanel6.add(jButton8);

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
				.addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel7Layout.createSequentialGroup().addGap(38, 38, 38)
								.addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE,
										111, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(21, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 484,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap())
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(191, 191, 191)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addComponent(
						jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(59, 59, 59)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addContainerGap(36, Short.MAX_VALUE)));

		setSize(new java.awt.Dimension(974, 619));
		setLocationRelativeTo(null);
	}

	private void jButton5() {
		int idv = Integer.parseInt(idTextFieldV.getText());
		String marque = marqueTextFieldV.getText();
		int vitesse = Integer.parseInt(vitesseTextFieldV.getText());
		int idp = Integer.parseInt(idpTextFieldV.getText());
		VoitureControleur v = new VoitureControleur();
		PerconneControleur p = new PerconneControleur();
		ResultSet res = null;

		try {
			personId = Integer.parseInt(idpTextFieldV.getText());
			int voitureId = Integer.parseInt(idTextFieldV.getText());
			res = p.insererP(personId);

			int clickedButton = JOptionPane.showConfirmDialog(MainJFrame.this, "Voulez-vous inserer cette voiture " + voitureId + " ?",
					"Confirmation", JOptionPane.YES_NO_OPTION);
			if (clickedButton != JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(MainJFrame.this, "Donn�es non inser�es");
			} else {
				if (res.next()) {
					v.insererVoitureC(idv, marque, vitesse, idp);
					JOptionPane.showMessageDialog(this, "Don�es inserer avec succ�s");
					setVoitureTableData();
					resetData();

				} else {
					JOptionPane.showMessageDialog(MainJFrame.this,
							"Aucune proprietaire, veuillez verifier ID Personne!", "Insertion impossible",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(MainJFrame.this, "Colonnes d�sordonn�es ou aucunne colonne selectionn�e",
					"Insertion impossible", JOptionPane.ERROR_MESSAGE);
		}

		/*
		 * try { VoitureControleur v = new VoitureControleur(); v.insererVoitureC(idv,
		 * marque, vitesse, idp); JOptionPane.showMessageDialog(this,
		 * "Don�es inserer avec succes");
		 * 
		 * setVoitureTableData(); resetDataVoiture(); } catch (Exception e) {
		 * System.out.println("erreur d'insertion voiture"); }
		 */
	}

	private void jButton6() {
		int idv = Integer.parseInt(idTextFieldV.getText());
		String marque = marqueTextFieldV.getText();
		int vitesse = Integer.parseInt(vitesseTextFieldV.getText());
		int idp = Integer.parseInt(idpTextFieldV.getText());
		try {
			VoitureControleur v = new VoitureControleur();
			v.modifierVoitureC(idv, marque, vitesse, idp);
			JOptionPane.showMessageDialog(this, "Don�es � jour");

			setVoitureTableData();
			resetDataVoiture();
		} catch (Exception e) {
			System.out.println("Erreur de la modification de voiture");
		}
	}

	private void jButton7() {
		int idv = Integer.parseInt(idTextFieldV.getText());
		try {
			VoitureControleur v = new VoitureControleur();
			v.suprimerVoitureC(idv);
			JOptionPane.showMessageDialog(this, "Don�es supprim�es avec succ�s");

			setVoitureTableData();
			resetData();
		} catch (Exception e) {
			System.out.println("erreur de suppression voiture");
		}
	}

	private void jButton8() {
		resetDataVoiture();
	}

	private void jButton1ActionPerformed() {// event_jButton1ActionPerformed
		int idp = Integer.parseInt(idTextField.getText());
		String nom = nomTextField.getText();
		String prenom = prenomTextField.getText();
		String adresse = adresseTextField.getText();

		try {
			PerconneControleur p = new PerconneControleur();
			p.inserer(idp, nom, prenom, adresse);
			JOptionPane.showMessageDialog(this, "Donn�es inser�es avec succ�s");
			resetData();
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			int rows = 0;
			int rowIndex = 0;
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from personne order by idp asc");
			if (rs.next()) {
				rs.last();
				rows = rs.getRow();
				rs.beforeFirst();
			}
			// System.out.println(rows);

			String[][] data = new String[rows][4];
			while (rs.next()) {
				data[rowIndex][0] = rs.getInt(1) + "";
				data[rowIndex][1] = rs.getString(2);
				data[rowIndex][2] = rs.getString(3);
				data[rowIndex][3] = rs.getString(4);
				rowIndex++;
			}

			String[] cols = { "Id", "Nom", "Prenom", "Adresse" };
			DefaultTableModel model = new DefaultTableModel(data, cols);
			jTable1.setModel(model);

			rs.close();
			stm.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erreur....");
		}
	}

	private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {// event_jTable1MouseClicked
		try {
			personId = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from personne where idp=" + personId);
			if (rs.next()) {
				idTextField.setText(rs.getString(1));
				nomTextField.setText(rs.getString(2));
				prenomTextField.setText(rs.getString(3));
				adresseTextField.setText(rs.getString(4));
			}

			rs.close();
			stm.close();
		} catch (Exception e) {
		}

	}

	private void jTable3MouseClicked() {
		try {
			personId = Integer.parseInt(jTable3.getValueAt(jTable3.getSelectedRow(), 0).toString());
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from voiture where idV=" + personId);
			if (rs.next()) {
				idTextFieldV.setText(rs.getString(1));
				marqueTextFieldV.setText(rs.getString(2));
				vitesseTextFieldV.setText(rs.getString(3));
				idpTextFieldV.setText(rs.getString(4));
			}

			rs.close();
			stm.close();
		} catch (Exception e) {
		}

	}

	private void jButton2ActionPerformed() {// GEN-FIRST:event_jButton2ActionPerformed
		int idp = Integer.parseInt(idTextField.getText() + "");
		String nom = nomTextField.getText();
		String prenom = prenomTextField.getText();
		String adresse = adresseTextField.getText();
		try {
			PerconneControleur p = new PerconneControleur();
			p.modifier(idp, nom, prenom, adresse);
			JOptionPane.showMessageDialog(this, "Donn�es � jour");
			setPersonneTableData();
			resetData();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erreur de la mise � jour");
		}
	}
	// GEN-LAST:event_jButton2ActionPerformed

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		PerconneControleur p = new PerconneControleur();
		VoitureControleur v = new VoitureControleur();

		ResultSet res;
		try {
			personId = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());

			res = v.insererV(personId);

			int clickedButton = JOptionPane.showConfirmDialog(MainJFrame.this, "Supprimer personne " + personId + " ?",
					"Confirmation", JOptionPane.YES_NO_OPTION);
			if (clickedButton != JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(MainJFrame.this, "Donn�es non supprim�es");
			} else {
				if (res.next()) {
					JOptionPane.showMessageDialog(MainJFrame.this, "Cette personne poss�de encore de(s) voiture(s)!",
							"Suppression impossible", JOptionPane.ERROR_MESSAGE);
				} else {
					p.supprimer(personId);
					setPersonneTableData();
					JOptionPane.showMessageDialog(MainJFrame.this, "Donn�es supprim�es");
				}
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(MainJFrame.this, "Colonnes d�sordonn�es ou aucunne colonne selectionn�e",
					"Suppression impossible", JOptionPane.ERROR_MESSAGE);
		}

		/*
		 * try { PerconneControleur p = new PerconneControleur(); p.supprimer(id);
		 * 
		 * JOptionPane.showMessageDialog(this, "Données supprimées avec succèes");
		 * setPersonneTableData(); resetData(); } catch (Exception e) {
		 * JOptionPane.showMessageDialog(this, "Ereur de suppression"); }
		 */
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
		resetData();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainJFrame().setVisible(true);
			}
		});
	}

	// Variables declaration
	private javax.swing.JTextField adresseTextField;
	private javax.swing.JTextField idTextField;
	private javax.swing.JTextField idTextFieldV;
	private javax.swing.JTextField idpTextFieldV;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JTable jTable3;
	private javax.swing.JTextField marqueTextFieldV;
	private javax.swing.JTextField nomTextField;
	private javax.swing.JTextField prenomTextField;
	private javax.swing.JTextField vitesseTextFieldV;
	// End of variables declaration                   

	private void resetData() {
		idTextField.setText("");
		nomTextField.setText("");
		prenomTextField.setText("");
		adresseTextField.setText("");
	}

	private void resetDataVoiture() {
		idTextFieldV.setText("");
		marqueTextFieldV.setText("");
		vitesseTextFieldV.setText("");
		idpTextFieldV.setText("");
	}

	private void setPersonneTableData() {
		try {
			int rows = 0;
			int rowIndex = 0;
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from personne order by idp asc");
			if (rs.next()) {
				rs.last();
				rows = rs.getRow();
				rs.beforeFirst();
			}
			// System.out.println(rows);

			String[][] data = new String[rows][4];
			while (rs.next()) {
				data[rowIndex][0] = rs.getInt(1) + "";
				data[rowIndex][1] = rs.getString(2);
				data[rowIndex][2] = rs.getString(3);
				data[rowIndex][3] = rs.getString(4);
				rowIndex++;
			}

			String[] cols = { "Id", "Nom", "Prenom", "Adresse" };
			DefaultTableModel model = new DefaultTableModel(data, cols);
			jTable1.setModel(model);

			rs.close();
			stm.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e);
		}
	}

	private void setVoitureTableData() {
		try {
			int rows = 0;
			int rowIndex = 0;
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from voiture order by idV asc");
			if (rs.next()) {
				rs.last();
				rows = rs.getRow();
				rs.beforeFirst();
			}
			// System.out.println(rows);

			String[][] data = new String[rows][4];
			while (rs.next()) {
				data[rowIndex][0] = rs.getInt(1) + "";
				data[rowIndex][1] = rs.getString(2);
				data[rowIndex][2] = rs.getInt(3) + "";
				data[rowIndex][3] = rs.getInt(4) + "";
				rowIndex++;
			}

			String[] cols = { "IdVoiture", "Marque", "Vitesse(km/h)", "IdPersonne" };
			DefaultTableModel model = new DefaultTableModel(data, cols);
			jTable3.setModel(model);

			rs.close();
			stm.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e);
		}
	}

}
