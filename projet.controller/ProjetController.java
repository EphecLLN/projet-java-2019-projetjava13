package projet.controller;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import projet.model.Bonus;
import projet.model.Cliqueur;
import projet.view.ProjetGUI;
import projet.view.ProjetVue;

public class ProjetController {
	Bonus model;
	ProjetVue vue;
	
	public ProjetController(Bonus model) {
		this.model = model;
	}
	
	public void incremente() {
		model.add();
		model.text();
		vue.actualise();
	}
	
	public void bonusUn() {
		model.bonusUn();
		model.text();
		vue.actualise();
	}
	
	public void bonusDeux() {
		model.bonusDeux();
		model.text();
		vue.actualise();
	}
	public void bonusTrois() {
		model.bonusTrois();
		model.text();
		vue.actualise();
	}
	public void bonusQuatre() {
		model.bonusQuatre();
		model.text();
		vue.actualise();
	}
	public void enregistre() {
		model.enregistre();
		model.text();
		vue.actualise();
	}
	
	public void resultats() {
		model.Collection();
		model.text();
		vue.actualise();
	}
	
	public void addView(ProjetVue vue) {
		this.vue = vue;
	}
	
	
}
