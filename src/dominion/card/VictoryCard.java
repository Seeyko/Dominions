package dominion.card;
import java.util.*;

import dominion.*;

/**
 * Les cartes Victoire
 */
public abstract class VictoryCard extends Card {

	public VictoryCard(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}
	public List<CardType> getTypes() {
		List<CardType> types = super.getTypes();
		types.add(CardType.Victory);
		return types;
	}
}