package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Espion (Spy)
 * 
 * +1 Carte.
 * +1 Action.
 * Tous les joueurs (vous aussi) dévoilent la première carte de leur deck. Vous décidez ensuite si chaque carte dévoilée est défaussée ou replacée sur son deck.
 */
public class Spy extends AttackCard {

	public Spy(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		int random;
		Player adversaire;
		p.drawCard_AndAddInHand();
		p.incrementActions(1);
		Scanner sc = new Scanner(System.in);
		int def_dev;
		for(int i = 0; i < p.getGame().numberOfPlayers(); i++) {
			adversaire = p.getGame().getPlayer(i);
			
			if(!PlayerHasMoatInHand(adversaire)){
				System.out.println("Joueur : " + adversaire.getName() + " a la carte : " + adversaire.totalCards().get(0));
				System.out.println("Voulez vous defaussez ou remplacez cette carte ? (0 = Defaussez, 1 = Remplacer)");
				def_dev = sc.nextInt();
				if(def_dev == 0) {
					System.out.println("Carte d�fauss�e");
					adversaire.totalCards().remove(0);
				}else if(def_dev == 1) {
					System.out.println("Carte remplac�");
					//On remplace la carte retir� par une carte du stack au hasard.
					 random = (int) (Math.random() * (adversaire.getGame().availableSupplyCards().size()-1));
					 adversaire.totalCards().set(0, adversaire.getGame().availableSupplyCards().get(random));
				}
			}
		}
	}
}