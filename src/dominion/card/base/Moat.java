package dominion.card.base;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import dominion.Player;
import dominion.card.ReactionCard;

/**
 * Carte Douves (Moat)
 * 
 * +2 Cartes.
 * Lorsqu’un adversaire joue une carte Attaque, vous pouvez dévoiler cette carte de votre main. Dans ce cas, l’Attaque n’a pas d’effet sur vous.
 */
public class Moat extends ReactionCard {

	public Moat() {
		super("Moat", 2);
	}
	
	public Moat(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		p.drawCard_AndAddInHand();
		p.drawCard_AndAddInHand();
	}
	
	public boolean devoileCarte(Player p){
		String answer = p.choose("Veut tu jouer ta carte Moat ?", new ArrayList<String>(Arrays.asList("Oui", "Non")), false);
		if(answer.equalsIgnoreCase("Oui")) return true;
		else return false;
	}
}