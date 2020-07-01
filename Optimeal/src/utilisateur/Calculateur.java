package utilisateur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.ArrayList;

import divers.Recette;
import nourriture.Aliment;
import nourriture.Ingredient;
import nourriture.Plat;
import planification.Collation;
import planification.Jour;
import planification.Petit_dejeuner;
import planification.Planif_semaine;
import planification.Repas;

public class Calculateur {
	// public static final int VIDE = 0;
	private LinkedList<Aliment> aliments;
	private LinkedList<Recette> recettes;
	private LinkedList<Plat> plats;

	public Calculateur() {
		this.genererAliments();
		rechercheAliment("Agneau");
		this.plats = new LinkedList<Plat>();
		this.genererPlats();
	}

	public LinkedList<Aliment> getAliments() {
		return aliments;
	}

	public LinkedList<Recette> getRecettes() {
		return recettes;
	}

	public LinkedList<Plat> getPlats() {
		return plats;
	}

	public void genererAliments() {
		this.aliments = new LinkedList<Aliment>();
		String deb;
		String nom;
		int cal;
		try {
			BufferedReader aLire = new BufferedReader(new FileReader("Aliments.txt"));
			do {
				deb = aLire.readLine();
				if (deb != null) {
					int i = deb.lastIndexOf('	');
					nom = deb.substring(0, i).toLowerCase();
					cal = Integer.parseInt(deb.substring(i + 1)) / 100; // nombre de calories par g
					this.aliments.add(new Aliment(nom, cal));
				}
			} while (deb != null); // Tant qu’on n’a pas atteint la fin du fichier
			// On ferme le fichier
			aLire.close();
		} catch (IOException e) {
			System.out.println("Une operation sur le fichier " + "Aliments.txt" + " a leve l’exception " + e);
		}
	}

	public Aliment rechercheAliment(String nom_ali) {
		int i = 0;
		while (i < this.aliments.size() && !this.aliments.get(i).getNom().equals(nom_ali)) {
			i++;
		}
		if (i < this.aliments.size()) {
			return this.aliments.get(i);
		} else {
			System.out.println("L'aliment " + nom_ali + " n'apparait pas dans le tableau des aliments");
			return null;
		}
	}

//	public void genererRecettesUtilisateur() {
//		this.recettes = new LinkedList<Recette>();
//		String deb;
//		String nom;
//		String type;
//		int nbpersonnes;
//		Aliment ali;
//		LinkedList<Ingredient> ingredients;
//		String preparation;
//		try {
//			BufferedReader aLire = new BufferedReader(new FileReader("Aliments.txt"));
//			do {
//				deb = aLire.readLine();
//				if (deb != null) {
//					deb = aLire.readLine();
//					nom = deb;
//					deb = aLire.readLine();
//					deb = aLire.readLine();
//					deb = aLire.readLine();
//					type = deb;
//					deb = aLire.readLine();
//					deb = aLire.readLine();
//					deb = aLire.readLine();
//					nbpersonnes = Integer.parseInt(deb);
//					deb = aLire.readLine();
//					deb = aLire.readLine();
//					deb = aLire.readLine();
//					//ingredients
//					while (deb != "") {
//						String[] buff = deb.split(" ");
//						String nom_ali = "";
//						String portion = "";
//						for (int i = 1; i < buff.length; i++) {
//							nom_ali += " " + buff[i];
//						}
//						ali = this.rechercheAliment(nom_ali.substring(1));
//						for (int i = 0; i < buff[0].length(); i++) {
//							while (buff[0].charAt(i)) {
//						}
//						deb = aLire.readLine();
//					}
//				}
//			} while (deb != null); // Tant qu’on n’a pas atteint la fin du fichier
//			// On ferme le fichier
//			aLire.close();
//		} catch (IOException e) {
//			System.out.println("Une operation sur le fichier " + "Aliments.txt" + " a leve l’exception " + e);
//		}	
//	}
//	}

	public void genererPlats() {
		String deb;
		try {
			BufferedReader aLire = new BufferedReader(new FileReader("recettes_aliments.txt"));
			deb = aLire.readLine();
			String[] noms_plats = deb.split("			");
			for (String string : noms_plats) {
				this.getPlats().add(new Plat(string));
			}
			deb = aLire.readLine();
			deb = aLire.readLine();
			deb = aLire.readLine();
			// ingredients
			do {
				String[] buff = deb.split("	");
				for (int i = 0; i < buff.length / 3; i++) {
					if (buff[3 * i].equals("")) {
						continue;
					} else {
						Aliment ali = this.rechercheAliment(buff[3 * i].toLowerCase());
						double qte = Double.parseDouble(buff[3 * i + 1].replace(',', '.'));
						this.getPlats().get(i).ajouterIngredient(new Ingredient(ali,
								qte));
					}
				}
				deb = aLire.readLine();
			} while (deb != null);
			aLire.close();
		} catch (IOException e) {
			System.out.println("Une operation sur le fichier " + "recette_aliments.txt" + " a leve l’exception " + e);
		}
	}

	public Planif_semaine genererPlanification(Foyer foyer) {
		//DEFINITION DES BESOINS EN CALORIES POUR CHAQUE PLAT
		double cal_ptdej = foyer.getBesoinCal() * 8. / 10 / 3;
		double cal_dej = foyer.getBesoinCal() * 8. / 10 / 3;
		double cal_diner = foyer.getBesoinCal() * 8. / 10 / 3;
		double cal_collation = foyer.getBesoinCal() / 10.;
		double cal_gouter = cal_collation;
		double cal_dej_entree = cal_dej*2/10;
		double cal_dej_plat = cal_dej*5/10;
		double cal_dej_dessert = cal_dej*3/10;
		double cal_diner_entree = cal_diner*2/10;
		double cal_diner_plat = cal_diner*5/10;
		double cal_diner_dessert = cal_diner*3/10;
		
		
		//DEFINITION DES ENTREE PLAT DESSET PTI DEJ GOUTER COLLATION
		LinkedList<Plat> entrees = plats;
		LinkedList<Plat> plats_principaux = plats;
		LinkedList<Plat> desserts = plats;
		LinkedList<Plat> collations = plats;
		LinkedList<Plat> ptidejs = plats;
		
		//VARIABLES PLATS ET JOUR
		Plat ptdej;
		Plat collation;
		Plat gouter;
		Plat dej_entree;
		Plat dej_plat;
		Plat dej_dessert;
		Plat diner_entree;
		Plat diner_plat;
		Plat diner_dessert;
		ArrayList<Jour> semaine = new ArrayList<Jour>(7);
		
		//TIRAGE DES PLATS
		for (int i = 0; i < 7; i++) {
			Random rand = new Random();
			ptdej = new Plat(ptidejs.get(rand.nextInt(ptidejs.size())));
			collation = new Plat(collations.get(rand.nextInt(collations.size())));
			gouter = new Plat(collations.get(rand.nextInt(collations.size())));
			dej_entree = new Plat(entrees.get(rand.nextInt(entrees.size())));
			dej_plat = new Plat(plats_principaux.get(rand.nextInt(plats_principaux.size())));
			dej_dessert = new Plat(desserts.get(rand.nextInt(desserts.size())));
			diner_entree = new Plat(entrees.get(rand.nextInt(entrees.size())));
			diner_plat = new Plat(plats_principaux.get(rand.nextInt(plats_principaux.size())));
			diner_dessert = new Plat(desserts.get(rand.nextInt(desserts.size())));
			Repas dej = new Repas(dej_entree, dej_plat, dej_dessert);
			Repas diner = new Repas(diner_entree, diner_plat, diner_dessert);
			semaine.add(new Jour(ptdej,collation,dej,gouter,diner));
//			System.out.println(semaine.get(i).toString());
			}
		
		Planif_semaine resu = new Planif_semaine(semaine.get(0), semaine.get(1), semaine.get(2),
				semaine.get(3), semaine.get(4), semaine.get(5), semaine.get(6));
		
		//Mise a jour des portions
		resu.setQte(cal_ptdej, cal_collation, cal_dej_entree, cal_dej_plat, cal_dej_dessert, cal_gouter, cal_diner_entree, cal_diner_plat, cal_diner_dessert);
		
		// OK !
		return resu;
	}

	public static void main(String[] args) {
		// System.out.println("Bette ou blette 33".lastIndexOf(' '));
		Calculateur calc = new Calculateur();
		Planif_semaine planif = calc.genererPlanification(new Foyer(10000));
//		System.out.println(planif.getLundi().getCollation().toString());
		Liste liste = new Liste();
		liste.ajouter(planif);
		System.out.println(planif.toString());
//		liste.getCourses();
		System.out.println(calc.rechercheAliment("agneau").getNom());
	}
}
