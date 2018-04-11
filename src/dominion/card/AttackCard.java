package dominion.card;
import dominion.Player;
import dominion.card.base.Moat;

/**
 * Les cartes Attaque
 * Rmq: les cartes Attaque sont toutes des cartes Action
 */
public abstract class AttackCard extends ActionCard {

	public AttackCard(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}
	
	public boolean PlayerHasMoatInHand(Player p){
			Moat moat = (Moat) p.getHand().getCard("Moat");
			if(moat != null)
			{
				return moat.devoileCarte(p);
			}
			else return false;
	}
}