package nourriture;

import divers.Unite;

public class Aliment {
	private String nom;
	private int cal; //nombre de cal pour un nb donnée d'unités
	
	
	public Aliment(String nom, int cal) {
		super();
		this.nom = nom;
		this.cal = cal;
	}


	public String getNom() {
		return nom;
	}


	public int getCal() {
		return cal;
	}
	
	
}
