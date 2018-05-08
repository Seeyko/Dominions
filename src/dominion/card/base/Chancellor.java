package dominion.card.base;
import java.util.*;

import dominion.*;
import dominion.card.*;

/**
 * Carte Chancellier (Chancellor)
 * 
 * +2 Pièces.
 * Vous pouvez immédiatement défausser votre deck.
 */
public class Chancellor extends ActionCard {

	public Chancellor() {
		super("Chancellor", 3);
	}
	
	public Chancellor(String name, int cost) {
		super(name, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Player p) {
		p.incrementMoney(2);
		String veutDefaussez;
		
		veutDefaussez = p.choose("Voulez vous defaussez tout votre deck ?",new ArrayList<String>(Arrays.asList("Oui", "Non")), false);
		
		if(veutDefaussez.equalsIgnoreCase("Oui")){
			
			/*
			 * Animation pour le defaussement du deck.
			 */
			p.getGame().pause(1000,"Defaussement du deck", ".", ".", ".");
			
			while(p.getDraw().size() > 0) {
				p.gain(p.getDraw().remove(0));
			}
		}
		
	}
}