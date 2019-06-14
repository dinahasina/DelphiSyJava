package com.crud.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.crud.conf.ConnectionDB;

public class PersonneTrans extends Personne {

	Connection con = ConnectionDB.getConnection();

	public PersonneTrans() {

	}

	public void insererPersonne() {
		try {
			String insPers = "insert into personne(idp, nom, prenom, adresse) values (?, ?, ?, ?)";
			PreparedStatement inserPers = con.prepareStatement(insPers);
			inserPers.setInt(1, getId());
			inserPers.setString(2, getNom());
			inserPers.setString(3, getPrenom());
			inserPers.setString(4, getAdresse());
			inserPers.execute();
		} catch (Exception e) {
			System.out.println("erreeeeuuuurrrrr");
		}
	}

	public void modifierPersonne() {
		try {
			String insPers = "update personne set idp =?, nom=?, prenom=?, adresse=? where idp=?";
			PreparedStatement inserPers = con.prepareStatement(insPers);
			inserPers.setInt(1, getId());
			inserPers.setString(2, getNom());
			inserPers.setString(3, getPrenom());
			inserPers.setString(4, getAdresse());
			inserPers.setInt(5, getId());
			inserPers.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void supprimerPersonne() {
		try {
			String suppPersonne = "delete from personne where idp = ?";
			PreparedStatement supp = con.prepareStatement(suppPersonne);
			supp.setInt(1, getId());
			supp.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ResultSet selectPersonne() {
		ResultSet result = null;
		try {
			String req = "SELECT * FROM personne WHERE idp = ?";
			PreparedStatement stmt = con.prepareStatement(req);
			stmt.setInt(1, getId());
			result = stmt.executeQuery();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

}
