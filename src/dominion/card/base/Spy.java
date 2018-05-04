package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Espion (Spy)
 * 
 * +1 Carte.
 * +1 Action.
 * Tous les joueurs (vous aussi) dévoilent la première carte de leur deck. 
 * Vous décidez ensuite si chaque carte dévoilée est défaussée ou replacée sur son deck.
 */
public class Spy extends AttackCard {

	public Spy(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		p.drawCard_AndAddInHand();
		p.incrementActions(1);
		
		int random;
		Player adversaire;
		Card carteRetirer;
		String def_dev;
		
		for(int i = 0; i < p.getGame().numberOfPlayers(); i++) {
			adversaire = p.getGame().getPlayer(i);
			carteRetirer = adversaire.drawCard();
			if(!PlayerHasMoatInHand(adversaire)){
				System.out.println("Joueur : " + adversaire.getName() + " a la carte : " + carteRetirer.getName());
				def_dev = p.choose("Voulez vous defaussez ou remplacez cette carte ?", new ArrayList<String>(Arrays.asList("Defausser", "Remplacer")), false);
				
				if(def_dev .equalsIgnoreCase("Defausser")) {
					System.out.println("Carte defausse");
					adversaire.gain(carteRetirer);
				}else if(def_dev.equalsIgnoreCase("Remplacer")) {
					System.out.println("Carte remplace");
					//On remplace la carte retire par une carte du stack au hasard.
					 random = (int) (Math.random() * (adversaire.getGame().availableSupplyCards().size()-1));
					 adversaire.getDraw().add(adversaire.getGame().availableSupplyCards().remove(random));
				}
			}
		}
	}
}