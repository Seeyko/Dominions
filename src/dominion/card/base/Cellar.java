package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Cave (Cellar)
 * 
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends ActionCard {

	public Cellar(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		
		/*String carteADeffaussez = "";
		boolean veutDeffaussez = true;
		while(veutDeffaussez == true) {
			carteADeffaussez = p.chooseCard("Choississez une carte a d�faussez", p.getGame().availableSupplyCards(), true);
			if(carteADeffaussez == "") {
				veutDeffaussez = false;
			} else {
				p.gain(carteADeffaussez);
			}
		}*/
	}
}