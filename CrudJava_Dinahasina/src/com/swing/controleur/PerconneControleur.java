package com.swing.controleur;

import java.sql.ResultSet;

import com.crud.model.PersonneTrans;

public class PerconneControleur {
	public void inserer(int id, String nom, String prenom, String adresse) {
		PersonneTrans p = new PersonneTrans();
		p.setId(id);
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setAdresse(adresse);
		p.insererPersonne();
	}

	public void modifier(int id, String nom, String prenom, String adresse) {
		PersonneTrans p = new PersonneTrans();
		p.setId(id);
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setAdresse(adresse);
		p.modifierPersonne();
	}

	public void supprimer(int id) {
		PersonneTrans p = new PersonneTrans();
		p.setId(id);
		p.supprimerPersonne();
	}
	
	public ResultSet insererP(int idp){
		PersonneTrans p = new PersonneTrans();
		p.setId(idp);
		return p.selectPersonne();
	}
}
