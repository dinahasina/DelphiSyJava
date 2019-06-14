package com.crud.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.crud.conf.ConnectionDB;

public class VoitureTrans extends Voiture {
	Connection con = ConnectionDB.getConnection();
	
	public VoitureTrans() {
		
	}
	
	public void inserVoiture() {
		try {
			String insRequete= "insert into voiture(idV, marque, vitesse, idP) values (?, ?, ?, ?)";
			PreparedStatement stmv = con.prepareStatement(insRequete);
			stmv.setInt(1, getIdv());
			stmv.setString(2, getMarque());
			stmv.setInt(3, getVitesse());
			stmv.setInt(4, getIdp());
			stmv.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void modifierVoiture() {
		try {
			String modRequete= "update voiture set idV=?, marque=?, vitesse=?, idP=? where idV=?";
			PreparedStatement stmv = con.prepareStatement(modRequete);
			stmv.setInt(1, getIdv());
			stmv.setString(2, getMarque());
			stmv.setInt(3, getVitesse());
			stmv.setInt(4, getIdp());
			stmv.setInt(5, getIdv());
			stmv.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void supprimerVoiture() {
		try {
			String modRequete= "delete from voiture where idV=?";
			PreparedStatement stmv = con.prepareStatement(modRequete);
			stmv.setInt(1, getIdv());
			stmv.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ResultSet selectVoiture() {
		ResultSet result = null;
		try {
			String req = "SELECT v.idp, v.marque, p.idP FROM voiture v INNER JOIN personne p ON p.idp = v.idP WHERE v.idP = ?";
			PreparedStatement stmt = con.prepareStatement(req);
			stmt.setInt(1, getIdp());
			result = stmt.executeQuery();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
