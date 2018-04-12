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
		Scanner sc = new Scanner(System.in);
		Card carteRetirer;
		int def_dev;
		
		for(int i = 0; i < p.getGame().numberOfPlayers(); i++) {
			adversaire = p.getGame().getPlayer(i);
			carteRetirer = adversaire.drawCard();
			if(!PlayerHasMoatInHand(adversaire)){
				System.out.println("Joueur : " + adversaire.getName() + " a la carte : " + carteRetirer.getName());
				System.out.println("Voulez vous defaussez ou remplacez cette carte ? (0 = Defaussez, 1 = Remplacer)");
				def_dev = sc.nextInt();
				
				if(def_dev == 0) {
					System.out.println("Carte defausse");
					adversaire.gain(carteRetirer);
				}else if(def_dev == 1) {
					System.out.println("Carte remplace");
					//On remplace la carte retire par une carte du stack au hasard.
					 random = (int) (Math.random() * (adversaire.getGame().availableSupplyCards().size()-1));
					 adversaire.getDraw().add(adversaire.getGame().availableSupplyCards().remove(random));
				}
			}
		}
	}
}