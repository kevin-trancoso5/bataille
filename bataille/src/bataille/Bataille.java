package bataille;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bataille {

	public static void main(String[] args) {
		
		//---------------GENERATION DES CARTES
		List<Carte> cartes = new ArrayList<Carte>();
		List<Carte> cartes_j1 = new ArrayList<Carte>();
		List<Carte> cartes_j2 = new ArrayList<Carte>();
		cartes = generateCards();
		
		//---------------DISTRIBUTION DES CARTES
		for (int i=0;i<26;i++) {
			cartes_j1.add(cartes.get(i));
			cartes_j2.add(cartes.get(i+26));
		}
		
		//---------------CREATION DES JOUEURS
		Scanner in = new Scanner(System.in);
		System.out.println("Saisir le nom du joueur 1:");
		Joueur j1 = new Joueur(in.nextLine(), cartes_j1);
		System.out.println("Saisir le nom du joueur 2:");
		Joueur j2 = new Joueur(in.nextLine(), cartes_j2);
		in.close();
		
		
		//---------------DEROULEMENT DU JEU
		int n;
		while (j1.cartes.size() != 0 && j2.cartes.size() != 0) {
			n=0;
			jeu(n,j1,j2);
			System.out.println("\n"+j1.nom + " = " + j1.score + " | " + j2.score + " = " + j2.nom + "\n");
		}
		
		//---------------AFFICHAGE DU VAINQUEUR
		if (j2.score == 0) System.out.println(j1.nom + " a gagné");
		else System.out.println(j2.nom + " a gagné");
		
				

				

	}
	
	//---------------METHODE DE GENERATION DE CARTES
	static List<Carte> generateCards(){
		List<Carte> cartes = new ArrayList<Carte>();
		for (int j=0;j<4;j++) {
			for (int i=0;i<13;i++) {
				switch(j) {
				case 0 : cartes.add(new Carte("Pique",Integer.toString(i+1)));break;
				case 1 : cartes.add(new Carte("Coeur",Integer.toString(i+1)));break;
				case 2 : cartes.add(new Carte("Trefle",Integer.toString(i+1)));break;
				case 3 : cartes.add(new Carte("Carreau",Integer.toString(i+1)));break;
				}
			}
		}
		Collections.shuffle(cartes); //Melange
		return cartes;
	}
	
	//---------------METHODE DE GESTION DE LA PARTIE
	static void jeu (int n, Joueur j1, Joueur j2) {
		Carte card1 = j1.getCard(n);
		Carte card2 = j2.getCard(n);
		System.out.println(card1.getValue()+ " de " +card1.getSigne() + " vs "+card2.getValue()+ " de " +card2.getSigne());
		switch(card1.compareCard(card2)) {
			case 0: {
				Carte[] win = new Carte[n+1];
				Carte[] lose = new Carte[n+1];
				for(int i=0;i<=n;i++) {
					win[i]=j2.getCard(i);
					lose[i]=j1.getCard(i);
				}
				j1.addCard(win); 
				j1.removeCard(lose);
				j1.addCard(lose);
				j2.removeCard(win); 
				break;
				}
			case 1: {
				Carte[] win = new Carte[n+1];
				Carte[] lose = new Carte[n+1];
				for(int i=0;i<=n;i++) {
					win[i]=j1.getCard(i);
					lose[i]=j2.getCard(i);
				}
				j2.addCard(win); 
				j2.removeCard(lose);
				j2.addCard(lose);
				j1.removeCard(win); 
				break;
				}
			case 2: {
				if (j1.cartes.size()<=n+2) {
					Carte[] win = new Carte[j1.cartes.size()];
					for(int i=0;i<j1.cartes.size();i++) {
						win[i]=j1.getCard(i);
					}
					j2.addCard(win);
					j1.removeCard(win);
				}
				else if (j2.cartes.size()<=n+2) {
					Carte[] win = new Carte[j2.cartes.size()];
					for(int i=0;i<j2.cartes.size();i++) {
						win[i]=j2.getCard(i);
					}
					j1.addCard(win);
					j2.removeCard(win);
				}
				else {
					jeu(n+2,j1,j2);
				}
			}

		} 
	}

}