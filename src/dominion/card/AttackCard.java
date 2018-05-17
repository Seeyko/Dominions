package dominion.card;
import java.util.List;

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
		Card moat;	
		for(int i = 0; i < p.getHand().size(); i++){
			moat = p.getHand().get(i);
			if(moat instanceof Moat)
			{
				return ((Moat)moat).devoileCarte(p);
			}
		}
		return false;
	}
	public List<CardType> getTypes() {
		List<CardType> types = super.getTypes();
		types.add(CardType.Attack);
		return types;
	}
}