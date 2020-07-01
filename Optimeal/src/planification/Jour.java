package planification;

import nourriture.Plat;

public class Jour {
	private Plat ptdj;
	private Plat collation;
	private Repas dejeuner;
	private Plat gouter;
	private Repas diner;

	public Jour(Plat ptdj, Plat collation, Repas dejeuner, Plat gouter, Repas diner) {
		super();
		this.ptdj = ptdj;
		this.collation = collation;
		this.dejeuner = dejeuner;
		this.gouter = gouter;
		this.diner = diner;
	}
	
	public int getCal() {
		return (int)(ptdj.getCal()+collation.getCal()+dejeuner.getCal()+gouter.getCal()+diner.getCal());
	}
	
	public Plat getPtdj() {
		return ptdj;
	}

	public Plat getCollation() {
		return collation;
	}

	public Repas getDejeuner() {
		return dejeuner;
	}

	public Plat getGouter() {
		return gouter;
	}

	public Repas getDiner() {
		return diner;
	}

	public void setQte(double cal_ptdj, double cal_collation, double cal_dej_entree, double cal_dej_plat, 
	double cal_dej_dessert, double cal_gouter, double cal_diner_entree, double cal_diner_plat, double cal_diner_dessert) {
		this.getPtdj().setQte(cal_ptdj);
		this.getCollation().setQte(cal_collation);
		this.getDejeuner().setQte(cal_dej_entree, cal_dej_plat, cal_dej_dessert);
		this.getGouter().setQte(cal_gouter);
		this.getDiner().setQte(cal_diner_entree, cal_diner_plat, cal_diner_dessert);
	}
	
	public String toString() {
		return "Petit Dejeuner : " + this.getPtdj().getNom() + "\n" + " Collation : " + this.getCollation().getNom() + "\n" + 
				" Dejeuner : " + this.getDejeuner().toString() + "\n" + " Gouter : " + this.getGouter().getNom() + "\n" +
				" Diner : " + this.getDiner().toString() + "\n";
	}
}
