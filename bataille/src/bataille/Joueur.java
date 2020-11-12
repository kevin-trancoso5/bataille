package bataille;

import java.util.List;

public class Joueur {
	
	public String nom;
	public List<Carte> cartes;
    public int score;
	
    //---------------CONSTRUCTEUR
	public Joueur(String nom, List<Carte> cartes) {
		this.nom = nom;
		this.cartes = cartes;
		this.score = cartes.size();
	}

	//---------------METHODE POUR OBTENIR LA CARTE A L'INDEX N
	Carte getCard(int n) {
		return cartes.get(n);
	}
	
	//---------------METHODE POUR AJOUTER UNE LISTE DE CARTE AU PAQUET
	void addCard(Carte[] win) {
		for (int i=0;i<win.length;i++) {
			cartes.add(win[i]);
			score++;
		}
	}
	//---------------METHODE POUR RETIRER UNE LISTE DE CARTE AU PAQUET
	void removeCard(Carte[] win) {
		for (int i=0;i<win.length;i++) {
			cartes.remove(win[i]);
			score--;
		}
	}
}