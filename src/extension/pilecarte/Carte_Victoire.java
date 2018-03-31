package extension.pilecarte;

import java.util.List;

import dominion.card.CardList;
import dominion.card.base.Village;
import dominion.card.common.Copper;
import dominion.card.common.Curse;
import dominion.card.common.Duchy;
import dominion.card.common.Estate;
import dominion.card.common.Gold;
import dominion.card.common.Province;
import dominion.card.common.Silver;

public class Carte_Victoire extends CardList{
	
	/*
	 * - 60 Copper
	 * - 40 Silver
	 * - 30 Gold
	 * - 8 (si 2 joueurs) ou 12 (si 3 ou 4 joueurs) Estate, Duchy et Province 
	 * - 10 * (n-1) Curse où n est le nombre de joueurs dans la partie
	 */
	public Carte_Victoire(int nbPlayer){
		super();
		if(nbPlayer == 2) {
			for(int i = 0; i < 14; i++) {
				this.add(new Province());
				this.add(new Duchy());
				this.add(new Estate());
			}
		}else {
			for(int i = 0; i < 12; i++) {
				this.add(new Province());
				this.add(new Duchy());
				this.add(new Estate());
			}
		}
	}
}