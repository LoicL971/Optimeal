package divers;

import java.util.LinkedList;

import nourriture.Ingredient;
import nourriture.Plat;

public class Recette extends Plat{
	private String type;
	private int nbpersonnes;
	private LinkedList<Ingredient> ingredients;
	private String preparation;
	
	
	public Recette(LinkedList<Ingredient> ingredients, String nom, String preparation, int nbpersonnes, String type) {
		super(nom, ingredients);
		this.ingredients = ingredients;
		this.preparation = preparation;
		this.nbpersonnes = nbpersonnes;
		this.type = type;
	}
	

	
}
