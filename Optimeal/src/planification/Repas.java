package planification;

import nourriture.Plat;

public class Repas {
	private Plat entree;
	private Plat plat;
	private Plat dessert;
	
	
	public Repas(Plat entree, Plat plat, Plat dessert) {
		super();
		this.entree = entree;
		this.plat = plat;
		this.dessert = dessert;
	}
	
	public double getCal() {
		return entree.getCal()+plat.getCal()+dessert.getCal();
	}
	
	public void setQte(double cal_entree, double cal_plat, double cal_dessert) {
		this.getEntree().setQte(cal_entree);
		this.getPlat().setQte(cal_plat);
		this.getDessert().setQte(cal_dessert);
	}

	public Plat getEntree() {
		return entree;
	}

	public Plat getPlat() {
		return plat;
	}

	public Plat getDessert() {
		return dessert;
	}
	
	public String toString() {
		return "Entree : " + this.getEntree().getNom() + " Plat : " + this.getPlat().getNom() + " Dessert : " + this.getDessert().getNom();
	}
}
