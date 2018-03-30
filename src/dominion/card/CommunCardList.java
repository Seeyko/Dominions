package dominion.card;

import java.util.List;

import dominion.card.common.Copper;
import dominion.card.common.Curse;
import dominion.card.common.Duchy;
import dominion.card.common.Estate;
import dominion.card.common.Gold;
import dominion.card.common.Province;
import dominion.card.common.Silver;

public class CommunCardList extends CardList{
	
	/*
	 * - 60 Copper
	 * - 40 Silver
	 * - 30 Gold
	 * - 8 (si 2 joueurs) ou 12 (si 3 ou 4 joueurs) Estate, Duchy et Province 
	 * - 10 * (n-1) Curse où n est le nombre de joueurs dans la partie
	 */
	public CommunCardList(int nbPlayer){
		super();
		for(int i = 0; i < 60; i++){
			this.add(new Copper());
			if(i < (10 *(nbPlayer -1))){
				this.add(new Curse());
			}
			if(i <  8 && nbPlayer == 2){
				this.add(new Duchy());
				this.add(new Estate());
				this.add(new Province());
			}else if(i < 12 && nbPlayer > 2){
				this.add(new Duchy());
				this.add(new Estate());
				this.add(new Province());
			}else if(i < 30){
				this.add(new Gold());
			}else if(i < 40){
				this.add(new Silver());
			}
		}
		this.shuffle();
	}

	
}
