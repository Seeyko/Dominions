package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Jardins (Gardens)
 * 
 * Vaut 1VP pour chaque 10 cartes dans votre deck (arrondi Ã  l'unitÃ© infÃ©rieure).
 */
public class Gardens extends VictoryCard {

	public Gardens(String name, int cost) {
		super(name, cost);
	}

	@Override
	public void play(Player p) {
		
	}
	
	@Override
	public int victoryValue(Player p) {
		int totalCard = p.totalCards().size();
		
		p.getGame().pause(1000, "Carte Jardin !", "\n>> Nous comptabilisons combien de carte vous possédez", ".", ".", ".");
		p.getGame().pause(1000, "Vous possèdez " + totalCard);
		p.getGame().pause(1000, "Vous remportez donc " + totalCard%10 + " points");
		return totalCard%10;
	}
}