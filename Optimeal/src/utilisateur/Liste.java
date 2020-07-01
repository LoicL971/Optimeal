package utilisateur;

import java.util.LinkedList;

import nourriture.Ingredient;
import nourriture.Plat;
import planification.Jour;
import planification.Planif_semaine;
import planification.Repas;

public class Liste {
	private LinkedList<Ingredient> liste;

	public Liste() {
		this.liste = new LinkedList<Ingredient>();
	}

	public LinkedList<Ingredient> getListe() {
		return liste;
	}

	public void ajouter(Plat plat) {
		for (Ingredient ingredient : plat.getIngredients()) {
			boolean resu = true;
			for (Ingredient ingredient2 : liste) {
				if (ingredient2.getAliment() == ingredient.getAliment()) {
					ingredient2.setQte(ingredient2.getQte() + ingredient.getQte());
					resu = false;
				}
//				if (ingredient.getAliment().getNom().equals("carottes")) {
//					System.out.println("a ajouter " + ingredient.getQte());
//					System.out.println("qte carottes " + ingredient2.getQte());
//				}
			}
			if (resu) {
				liste.add(new Ingredient(ingredient));
			}
		}
	}
	
	public void ajouter(Repas repas) {
		this.ajouter(repas.getEntree());
		this.ajouter(repas.getPlat());
		this.ajouter(repas.getDessert());
	}
	
	public void ajouter(Jour jour) {
		this.ajouter(jour.getPtdj());
		this.ajouter(jour.getCollation());
		this.ajouter(jour.getDejeuner());
		this.ajouter(jour.getGouter());
		this.ajouter(jour.getDiner());
	}
	
	public void ajouter(Planif_semaine planif) {
		this.ajouter(planif.getLundi());
		this.ajouter(planif.getMardi());
		this.ajouter(planif.getMercredi());
		this.ajouter(planif.getJeudi());
		this.ajouter(planif.getVendredi());
		this.ajouter(planif.getSamedi());
		this.ajouter(planif.getDimanche());
	}
	
	public void getCourses() {
		for (Ingredient ingredient : liste) {
			System.out.println("-"+ (int)ingredient.getQte() +"g" +" " + ingredient.getAliment().getNom());
		}
	}
	
	public int getCal() {
		int resu = 0;
		for (Ingredient ingredient : liste) {
			resu += ingredient.getCal();
		}
		return resu;
	}
}
