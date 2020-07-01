package nourriture;

import java.util.LinkedList;

public class Plat {
	private String nom;
	private LinkedList<Ingredient> ingredients;

	public Plat(String nom,LinkedList<Ingredient> ingredients) {
		super();
		this.nom = nom;
		this.ingredients = ingredients;
	}
	
	public Plat(Plat plat) {
		this.nom = plat.getNom();
		this.ingredients = new LinkedList<Ingredient>();
		for (Ingredient ingredient : plat.getIngredients()) {
			this.ingredients.add(new Ingredient(ingredient.getAliment(),100));
		}
	}
	
	public Plat(String nom) {
		super();
		this.nom = nom;
		this.ingredients = new LinkedList<Ingredient>();
	}

	public double getCal() {
		double resu = 0;
		for (Ingredient ingredient : ingredients) {
			resu += ingredient.getCal();
		}
		return resu;
	}
	
	public LinkedList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void ajouterIngredient(Ingredient ingredient) {
		this.getIngredients().add(ingredient);
	}

	public String getNom() {
		return nom;
	}

	public boolean contains(Aliment aliment) {
		return this.ingredients.contains(aliment);
	}

	public String toString() {
		String resu = "";
		for (Ingredient ingredient : ingredients) {
			resu += " " + ingredient.toString();
		}
		return resu.substring(1);
	}
	
	public void setQte(double cal) {
		double mult = cal/this.getCal();
		for (Ingredient ingredient : ingredients) {
			ingredient.setQte(ingredient.getQte()*mult);
		}
	}
}