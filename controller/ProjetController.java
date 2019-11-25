package projet.controller;

import projet.model.*;
import projet.view.ProjetVue;

public class ProjetController {
	Cliqueur model;
	ProjetVue vue;
	
	public ProjetController(Cliqueur model) {
		this.model = model;
	}
	
	public void incremente() {
		model.add();
		
	}
	
	public void bonusUn() {
		model.bonusUn();
	}
	
	public void bonusDeux() {
		model.bonusDeux();
	}
	public void bonusTrois() {
		model.bonusTrois();
	}
	
	public void addView(ProjetVue vue) {
		this.vue = vue;
	}
}
