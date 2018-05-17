package dominion.card;
import java.util.*;

import dominion.*;

/**
 * Les cartes Trésor
 */
public abstract class TreasureCard extends Card {

	public TreasureCard(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}
	
	public abstract int treasureValue();

	public List<CardType> getTypes() {
		List<CardType> types = super.getTypes();
		types.add(CardType.Treasure);
		return types;
	}
	
	@Override
	public void play(Player p){
		p.incrementMoney(this.treasureValue());
	}
}