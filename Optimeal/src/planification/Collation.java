package planification;

import java.util.LinkedList;

import nourriture.Ingredient;
import nourriture.Plat;

public class Collation extends Plat {
	private String nom;
	
	public Collation(LinkedList<Ingredient> ingredients, String nom) {
		super(nom, ingredients);
	}
}
