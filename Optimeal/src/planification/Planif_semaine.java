package planification;

public class Planif_semaine {
	private Jour lundi;
	private Jour mardi;
	private Jour mercredi;
	private Jour jeudi;
	private Jour vendredi;
	private Jour samedi;
	private Jour dimanche;
	
	
	public Planif_semaine(Jour lundi, Jour mardi, Jour mercredi, Jour jeudi, Jour vendredi, Jour samedi,
			Jour dimanche) {
		super();
		this.lundi = lundi;
		this.mardi = mardi;
		this.mercredi = mercredi;
		this.jeudi = jeudi;
		this.vendredi = vendredi;
		this.samedi = samedi;
		this.dimanche = dimanche;
	}
	
	public int getCal() {
		return lundi.getCal()+mardi.getCal()+mercredi.getCal()+jeudi.getCal()+vendredi.getCal()+samedi.getCal()+dimanche.getCal();
	}

	public Jour getLundi() {
		return lundi;
	}

	public Jour getMardi() {
		return mardi;
	}

	public Jour getMercredi() {
		return mercredi;
	}

	public Jour getJeudi() {
		return jeudi;
	}

	public Jour getVendredi() {
		return vendredi;
	}

	public Jour getSamedi() {
		return samedi;
	}

	public Jour getDimanche() {
		return dimanche;
	}
	
	public void setQte(double cal_ptdj, double cal_collation, double cal_dej_entree, double cal_dej_plat, 
	double cal_dej_dessert, double cal_gouter, double cal_diner_entree, double cal_diner_plat, double cal_diner_dessert) {
		this.getLundi().setQte(cal_ptdj, cal_collation, cal_dej_entree, cal_dej_plat, cal_dej_dessert, cal_gouter,
				cal_diner_entree, cal_diner_plat, cal_diner_dessert);
		this.getMardi().setQte(cal_ptdj, cal_collation, cal_dej_entree, cal_dej_plat, cal_dej_dessert, cal_gouter,
				cal_diner_entree, cal_diner_plat, cal_diner_dessert);
		this.getMercredi().setQte(cal_ptdj, cal_collation, cal_dej_entree, cal_dej_plat, cal_dej_dessert, cal_gouter,
				cal_diner_entree, cal_diner_plat, cal_diner_dessert);
		this.getJeudi().setQte(cal_ptdj, cal_collation, cal_dej_entree, cal_dej_plat, cal_dej_dessert, cal_gouter,
				cal_diner_entree, cal_diner_plat, cal_diner_dessert);
		this.getVendredi().setQte(cal_ptdj, cal_collation, cal_dej_entree, cal_dej_plat, cal_dej_dessert, cal_gouter,
				cal_diner_entree, cal_diner_plat, cal_diner_dessert);
		this.getSamedi().setQte(cal_ptdj, cal_collation, cal_dej_entree, cal_dej_plat, cal_dej_dessert, cal_gouter,
				cal_diner_entree, cal_diner_plat, cal_diner_dessert);
		this.getDimanche().setQte(cal_ptdj, cal_collation, cal_dej_entree, cal_dej_plat, cal_dej_dessert, cal_gouter,
				cal_diner_entree, cal_diner_plat, cal_diner_dessert);
	}
	
	public String toString() {
		return "Lundi : " + this.getLundi().toString() + "\n"+ " Mardi : " + this.getMardi().toString() + "\n" +
				" Mercredi : " + this.getMercredi().toString() + "\n" + " Jeudi : " + this.getJeudi().toString() + "\n" +
				" Vendredi : " + this.getVendredi().toString() + "\n" + " Samedi : " + this.getSamedi().toString() + "\n" +
				" Dimanche : " + this.getDimanche().toString();
	}
}
