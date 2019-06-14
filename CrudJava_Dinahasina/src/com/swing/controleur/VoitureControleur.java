package com.swing.controleur;

import java.sql.ResultSet;

import com.crud.model.VoitureTrans;

public class VoitureControleur {
	
	public void insererVoitureC(int idv,String marque, int vitesse, int idp) {
		VoitureTrans v = new VoitureTrans();
		v.setIdv(idv);
		v.setMarque(marque);
		v.setVitesse(vitesse);
		v.setIdp(idp);
		v.inserVoiture();
	}
	
	public void modifierVoitureC(int idv,String marque, int vitesse, int idp) {
		VoitureTrans vm = new VoitureTrans();
		vm.setIdv(idv);
		vm.setMarque(marque);
		vm.setVitesse(vitesse);
		vm.setIdp(idp);
		vm.modifierVoiture();
	}
	public void suprimerVoitureC(int idv) {
		VoitureTrans vm = new VoitureTrans();
		vm.setIdv(idv);
		vm.supprimerVoiture();
	}
	
	public ResultSet insererV(int idp){
		VoitureTrans vi = new VoitureTrans();
		vi.setIdp(idp);
		return vi.selectVoiture();
	}
}
