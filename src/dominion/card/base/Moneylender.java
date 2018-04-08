package dominion.card.base;
import dominion.Player;
import dominion.card.ActionCard;
import dominion.card.Card;
import dominion.card.common.Copper;

/**
 * Carte Prêteur sur gages (Moneylender)
 * 
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends ActionCard {

	public Moneylender(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		if(p.getHand().remove("Copper") != null) {
			p.incrementMoney(3);
			p.getDiscard().add(new Copper());
		}
	}
}