package extension;

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

public class Carte_Commune extends CardList{
	
	/*
	 * - 60 Copper
	 * - 40 Silver
	 * - 30 Gold
	 * - 8 (si 2 joueurs) ou 12 (si 3 ou 4 joueurs) Estate, Duchy et Province 
	 * - 10 * (n-1) Curse où n est le nombre de joueurs dans la partie
	 */
	public Carte_Commune(int nbPlayer){
		super();
		for(int i = 0; i < 60; i++){
			this.add(new Village("Salut", 10));
			if(i < (10 *(nbPlayer -1))){
				this.add(new Curse());
			}
			if(i <  8 && nbPlayer == 2){
				this.add(new Duchy());
				this.add(new Estate());
				this.add(new Province());
			} if(i < 12 && nbPlayer > 2){
				this.add(new Duchy());
				this.add(new Estate());
				this.add(new Province());
			} if(i < 30){
				this.add(new Gold());
			} if(i < 40){
				this.add(new Silver());
			}
		}
		System.out.println(this.size());
	}

	
}
