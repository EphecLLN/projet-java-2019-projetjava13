package projet.view;

import java.util.Observer;

import projet.model.*;
import projet.controller.*;

public abstract class ProjetVue implements Observer{
	
	protected Cliqueur model;
	protected ProjetController controller;
	
	ProjetVue(Cliqueur model,
			ProjetController controller) {
		this.model = model;
		this.controller = controller;
		model.addObserver(this);
	}

	public abstract void affiche(String string) ;
}