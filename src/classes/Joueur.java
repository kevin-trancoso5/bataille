package classes;

import java.util.List;

public class Joueur {
	
	public String nom;
	public List<Carte> cartes;
    public int score;
	
	public Joueur(String nom, List<Carte> cartes) {
		this.nom = nom;
		this.cartes = cartes;
		this.score = cartes.size();
	}

	Carte getCard(int n) {
		return cartes.get(n);
	}
	
	void addCard(Carte[] win) {
		for (int i=0;i<win.length;i++) {
			cartes.add(win[i]);
			score++;
		}
	}
	
	void removeCard(Carte[] win) {
		for (int i=0;i<win.length;i++) {
			cartes.remove(win[i]);
			score--;
		}
	}
	
	

}
