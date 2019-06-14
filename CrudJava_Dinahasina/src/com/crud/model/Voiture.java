package com.crud.model;

public class Voiture {
	public int getIdv() {
		return idv;
	}
	public void setIdv(int idv) {
		this.idv = idv;
	}
	public int getIdp() {
		return idp;
	}
	public void setIdp(int idp) {
		this.idp = idp;
	}
	public int getVitesse() {
		return vitesse;
	}
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	private int idv , idp, vitesse;
	private String marque;
	
	
}
