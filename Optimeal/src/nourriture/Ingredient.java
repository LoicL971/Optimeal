package nourriture;

public class Ingredient {
	private Aliment aliment;
	private double qte;
	
	
	public Ingredient(Aliment aliment, double qte) {
		super();
		this.aliment = aliment;
		this.qte = qte;
	}
	
	public Ingredient(Ingredient ingredient) {
		super();
		this.aliment = ingredient.getAliment();
		this.qte = ingredient.getQte();
	}
	
	public Aliment getAliment() {
		return aliment;
	}
	
	public double getQte() {
		return qte;
	}

	public void setQte(double qte) {
		this.qte = qte;
	}

	public double getCal() {
		return this.getQte()*this.getAliment().getCal();
	}
	
	public String toString() {
		return this.getAliment().getNom();
	}
}
