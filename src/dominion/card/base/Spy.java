package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Espion (Spy)
 * 
 * +1 Carte.
 * +1 Action.
 * Tous les joueurs (vous aussi) d√©voilent la premi√®re carte de leur deck. Vous d√©cidez ensuite si chaque carte d√©voil√©e est d√©fauss√©e ou replac√©e sur son deck.
 */
public class Spy extends AttackCard {

	public Spy(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		int random;
		Player oP;
		p.drawCard();
		p.incrementActions(1);
		Scanner sc = new Scanner(System.in);
		int def_dev;
		for(int i = 0; i < p.getGame().numberOfPlayers(); i++) {
			oP = p.getGame().getPlayer(i);
			System.out.println("Joueur : " + oP.getName() + " a la carte : " + oP.totalCards().get(0));
			System.out.println("Voulez vous dÈfaussez ou remplacez cette carte ? (0 = Defaussez, 1 = Remplacer)");
			def_dev = sc.nextInt();
			if(def_dev == 0) {
				System.out.println("Carte dÈfaussÈe");
				oP.totalCards().remove(0);
			}else if(def_dev == 1) {
				System.out.println("Carte remplacÈ");
				//On remplace la carte retirÈ par une carte du stack au hasard.
				 random = (int) (Math.random() * oP.getGame().availableSupplyCards().size());
				oP.totalCards().set(0, oP.getGame().availableSupplyCards().get(random));
			}
		}
	}
}