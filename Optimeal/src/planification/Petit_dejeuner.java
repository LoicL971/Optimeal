package planification;

import java.util.LinkedList;

import nourriture.Ingredient;
import nourriture.Plat;

public class Petit_dejeuner extends Plat{
	
	public Petit_dejeuner(LinkedList<Ingredient> ingredients, String nom) {
		super(nom, ingredients);
	}
}
