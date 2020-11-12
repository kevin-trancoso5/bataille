package bataille;

public class Carte {

	public String signe;
	public String valeur;
	
	//---------------CONSTRUCTEUR
	public Carte(String signe, String valeur) {
		this.signe=signe;
		this.valeur=valeur;
	}

	//---------------METHODE DE COMPARAISON DE CARTE
	int compareCard(Carte otherCard) {
		int otherValue=Integer.parseInt(otherCard.valeur);
		int ourValue=Integer.parseInt(valeur);
		if (ourValue>otherValue) return 0; //joueur1 gagne
		else if (ourValue<otherValue) return 1; //joueur2 gagne
		else return 2; //égalité
	}
	
	//---------------METHODE POUR OBTENIR LE SIGNE (UTF-8 pas supporté sur console apparement)
	String getSigne() {
		switch (signe) {
//		case "Trefle": return ("♣");
//		case "Pique": return ("♠");
//		case "Carreau": return ("♦");
//		case "Coeur": return ("♥");
		case "Trefle": return ("Trefle");
		case "Pique": return ("Pique");
		case "Carreau": return ("Carreau");
		case "Coeur": return ("Coeur");
		default: return ("error");
		}
		
	}
	
	//---------------METHODE POUR OBTENIR LA VALEUR DE LA CARTE
	String getValue() {
		switch (valeur) {
		case "1": return ("2");
		case "2": return ("3");
		case "3": return ("4");
		case "4": return ("5");
		case "5": return ("6");
		case "6": return ("7");
		case "7": return ("8");
		case "8": return ("9");
		case "9": return ("10");
		case "10": return ("Valet");
		case "11": return ("Dame");
		case "12": return ("Roi");
		case "13": return ("As");
		default: return("error");
		}
	}
	
}